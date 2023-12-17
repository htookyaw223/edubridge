package cu.edubridge.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class StudentReqDto {
    private Long parentId;
    private String name;
    private String nrcNo;
    private String image;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
}
