package cu.edubridge.service;

import cu.edubridge.dto.request.StudentGradeReqDto;
import cu.edubridge.dto.response.StudentGradeResDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentGradeService {
   public List<StudentGradeResDto> getStudentsByGradeAndYear(StudentGradeReqDto dto);
}
