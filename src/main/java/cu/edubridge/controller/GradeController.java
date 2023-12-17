package cu.edubridge.controller;

import cu.edubridge.dto.request.StudentGradeReqDto;
import cu.edubridge.dto.response.StudentGradeResDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/grade")
public class GradeController {

    @Autowired
    private StudentGradeService studentGradeService;

    @PostMapping("/students")
    public List<StudentGradeResDto> getStudentsByGradeAndYear(@RequestBody StudentGradeReqDto dto) {
        return studentGradeService.getStudentsByGradeAndYear(dto);
    }

}
