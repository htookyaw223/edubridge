package cu.edubridge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TestController {

    @GetMapping("/home")
    private String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("hello "+authentication.getName());
        return  "Hello world";
    }

//    @GetMapping("/home")
//    private String testPrivate() {
//        return  "Private world";
//    }

    @GetMapping("/public/test")
    public ResponseEntity<String> testPost() {
       return ResponseEntity.ok("Health check request successful");
    }
}
