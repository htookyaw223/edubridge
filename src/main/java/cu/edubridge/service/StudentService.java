package cu.edubridge.service;

import cu.edubridge.dto.request.StudentReqDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public StudentResDto saveStudent(StudentReqDto dto);

}
