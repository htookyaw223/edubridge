package cu.edubridge.entity;

import cu.edubridge.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Entity
@Table(name = "student_grade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class StudentGrade extends BaseEntity {

    @ManyToOne
    @JoinColumn(nullable = false, name = "student_id")
    private Student student;

    @Column(nullable = false, name = "academic_year")
    private String academicYear;

    @ManyToOne
    @JoinColumn(nullable = false, name = "grade_id")
    private Grade grade;

    @Column(nullable = false, name = "roll_no")
    private long rollNo;
}
