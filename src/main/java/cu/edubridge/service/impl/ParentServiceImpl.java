package cu.edubridge.service.impl;

import cu.edubridge.dto.request.ParentReqDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Parent;
import cu.edubridge.exception.ServerErrorException;
import cu.edubridge.repository.ParentRepo;
import cu.edubridge.repository.StudentRepo;
import cu.edubridge.service.ParentService;
import cu.edubridge.validations.ErrorCode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Parent saveParent(@Valid ParentReqDto parentReqDto) {
        try {
            Parent p = new Parent(parentReqDto.getName(), parentReqDto.getAddress(), parentReqDto.getPhone(), parentReqDto.getImage(), null);
            parentRepo.save(p);
            return p;
        } catch (Exception e) {
            throw new ServerErrorException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public List<StudentResDto> getStudentsByParent(long parentId) {
        Optional<Parent> parent = parentRepo.findById(parentId);
        if (parent.isEmpty()) {
            throw new ServerErrorException(ErrorCode.PARENT_NOT_FOUND.getValue(), ErrorCode.PARENT_NOT_FOUND.getStatus());
        }
        return studentRepo.findAllByParent(parent.get());
    }

}
