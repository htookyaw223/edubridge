package cu.edubridge.service.impl;

import cu.edubridge.dto.request.StudentReqDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Parent;
import cu.edubridge.entity.Student;
import cu.edubridge.exception.CustomErrorException;
import cu.edubridge.repository.ParentRepo;
import cu.edubridge.repository.StudentRepo;
import cu.edubridge.service.StudentService;
import cu.edubridge.validations.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public StudentResDto saveStudent(StudentReqDto dto) {
        Optional<Parent> parent = parentRepo.findById(dto.getParentId());
        if (parent.isEmpty()) {
            throw new CustomErrorException(ErrorCode.PARENT_NOT_FOUND);
        }
        log.info("Date of birth {}", dto.getDateOfBirth());
        Student student = new Student(dto.getName(),dto.getNrcNo(), dto.getDateOfBirth(),null, parent.get());
        studentRepo.save(student);
        return new StudentResDto(student.getId(), student.getName(), student.getNrc(), student.getDateOfBirth(), student.getImage(), student.getParent());
    }
}
