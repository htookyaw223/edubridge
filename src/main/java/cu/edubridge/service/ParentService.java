package cu.edubridge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import cu.edubridge.dto.request.ParentReqDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Parent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ParentService {
    public Parent saveParent(ParentReqDto parentReqDto) ;

    List<StudentResDto> getStudentsByParent(long parentId);
}
