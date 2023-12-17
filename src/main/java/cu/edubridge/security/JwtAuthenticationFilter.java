package cu.edubridge.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cu.edubridge.config.CustomUserDetails;
import cu.edubridge.entity.User;
import cu.edubridge.exception.CustomErrorException;
import cu.edubridge.exception.ServerErrorException;
import cu.edubridge.handlers.ErrorResponseFormat;
import cu.edubridge.security.service.JwtService;
import cu.edubridge.service.UserService;
import cu.edubridge.validations.ErrorCode;
import io.jsonwebtoken.JwtException;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
   @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userEmail;

            if (ObjectUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
                throw new CustomErrorException(ErrorCode.INVALID_TOKEN);
            }
            jwt = authHeader.substring(7);
            if (jwtService.isTokenExpired(jwt)) {
                throw new CustomErrorException(ErrorCode.INVALID_TOKEN);
            }
            User user = jwtService.extractUser(jwt);
            if (!ObjectUtils.isEmpty(user)
                    && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.getRole());
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    context.setAuthentication(authToken);
                    SecurityContextHolder.setContext(context);
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            filterChain.doFilter(request, response);
        }
    }
}