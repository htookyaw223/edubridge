package cu.edubridge.service.impl;

import cu.edubridge.config.CustomUserDetails;
import cu.edubridge.constants.UserRole;
import cu.edubridge.dto.request.LoginReqDto;
import cu.edubridge.dto.request.UserRequestDto;
import cu.edubridge.dto.response.LoginResDto;
import cu.edubridge.dto.response.UserResponseDto;
import cu.edubridge.entity.User;
import cu.edubridge.exception.CustomErrorException;
import cu.edubridge.repository.UserRepo;
import cu.edubridge.security.service.JwtService;
import cu.edubridge.service.AuthenticationService;
import cu.edubridge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepo authenticationRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    UserService userDetailsService;

    @Override
    public User findByUserName(String username) {
        return authenticationRepo.findByUsername(username).get();
    }


    @Override
    public UserResponseDto signUp(UserRequestDto userRequestDto) {
        if (!userRequestDto.getPassword().equals(userRequestDto.getConfirmPassword())) {
           throw new CustomErrorException("Passwords do not match ", HttpStatus.BAD_REQUEST);
        }
        User user = new User(userRequestDto.getEmail(), passwordEncoder.encode(userRequestDto.getPassword()),userRequestDto.getUsername(), UserRole.ADMIN.toString());

        User saveUser = authenticationRepo.save(user);
        return new UserResponseDto(saveUser.getEmail(), saveUser.getUsername());
    }

    @Override
    public LoginResDto signin(LoginReqDto request) {
        User user = authenticationRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        System.out.println("here here 1");
        System.out.println("here here 2");
        // Create userDetails from the retrieved user information
        UserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.getRole());
        user.setPassword(null);
        // Generate a JWT token using userDetails
        String jwt = jwtService.generateToken(user , userDetails);
        System.out.println("jwt");
        return new LoginResDto("request.getEmail()",request.getUsername(), jwt);
    }
}
