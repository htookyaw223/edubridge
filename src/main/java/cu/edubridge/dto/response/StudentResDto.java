package cu.edubridge.dto.response;

import cu.edubridge.entity.Parent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class StudentResDto {
    private long id;
    private String name;
    private String nrcNo;
    private Date dateOfBirth;
    private String image;
    private Parent parent;
}
