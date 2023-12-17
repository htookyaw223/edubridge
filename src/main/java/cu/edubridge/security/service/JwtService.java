package cu.edubridge.security.service;


import cu.edubridge.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    User extractUser(String token);

    String generateToken(User user, UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}