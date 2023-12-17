package cu.edubridge.controller;

import cu.edubridge.dto.request.LoginReqDto;
import cu.edubridge.dto.request.UserRequestDto;
import cu.edubridge.dto.response.LoginResDto;
import cu.edubridge.dto.response.UserResponseDto;
import cu.edubridge.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/public/admin/register")
    public @ResponseBody UserResponseDto signUp(@RequestBody UserRequestDto userRequestDto) {
        return authenticationService.signUp(userRequestDto);
    }

    @PostMapping("/public/login")
    public @ResponseBody LoginResDto signIn(@RequestBody LoginReqDto dto) {
        return authenticationService.signin(dto);
    }
}
