package cu.edubridge.controller;

import cu.edubridge.dto.request.ParentReqDto;
import cu.edubridge.entity.Parent;
import cu.edubridge.service.FileService;
import cu.edubridge.service.ParentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/public/parent")
@Validated
public class ParentController {

    @Autowired
    private ParentService parentService;
    @Autowired
    private FileService fileService;

    @PostMapping("")
    public Parent  saveParent(@Valid @RequestBody ParentReqDto parent, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return parentService.saveParent(parent);
    }
    @PostMapping("/upload")
    public String uploadImg(@RequestParam("file") MultipartFile file) {
       return fileService.store(file);
    }

}
