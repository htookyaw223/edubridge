package cu.edubridge.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import cu.edubridge.entity.StudentGrade;
import lombok.Data;

import java.util.Date;

@Data
public class StudentGradeResDto {
    private String name;
    private String nrcNo;
    private String image;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private String rollNo;

    public StudentGradeResDto(StudentGrade studentGrade) {
        this.name = studentGrade.getStudent().getName();
        this.nrcNo = studentGrade.getStudent().getNrc();
        this.image = studentGrade.getStudent().getImage();
        this.dateOfBirth = studentGrade.getStudent().getDateOfBirth();
        this.rollNo = studentGrade.getRollNo() + "";
    }
}
