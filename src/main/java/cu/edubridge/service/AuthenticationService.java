package cu.edubridge.service;

import cu.edubridge.dto.request.LoginReqDto;
import cu.edubridge.dto.request.UserRequestDto;
import cu.edubridge.dto.response.LoginResDto;
import cu.edubridge.dto.response.UserResponseDto;
import cu.edubridge.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    public User findByUserName(String username);

    UserResponseDto signUp(UserRequestDto userRequestDto);

    LoginResDto signin(LoginReqDto request);
}
