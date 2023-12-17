package cu.edubridge.service.impl;

import cu.edubridge.dto.request.StudentGradeReqDto;
import cu.edubridge.dto.response.StudentGradeResDto;
import cu.edubridge.entity.Grade;
import cu.edubridge.repository.GradeRepo;
import cu.edubridge.repository.StudentGradeRepo;
import cu.edubridge.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGradeServiceImpl  implements StudentGradeService {

    @Autowired
    private StudentGradeRepo studentGradeRepo;
    @Autowired
    private GradeRepo gradeRepo;
    @Override
    public List<StudentGradeResDto> getStudentsByGradeAndYear(StudentGradeReqDto dto) {
        Grade grade = gradeRepo.findByGrade(dto.getGrade());
        return studentGradeRepo.findAllByGradeAndAcademicYear(grade, dto.getAcademicYear());
    }
}
