package cu.edubridge.controller;

import cu.edubridge.dto.request.StudentReqDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.service.ParentService;
import cu.edubridge.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ParentService parentService;

    @PostMapping("")
    public StudentResDto saveStudent(@RequestBody StudentReqDto dto) {
        return studentService.saveStudent(dto);
    }

    @PostMapping("/all/{parent_id}")
    public List<StudentResDto> getStudentListByParent(@RequestParam("parent_id") long parentId) {

        return parentService.getStudentsByParent(parentId);
    }

}
