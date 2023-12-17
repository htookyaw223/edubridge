package cu.edubridge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cu.edubridge.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Student extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "nrc_no")
    private String nrc;
    @Column(nullable = false, name = "date_of_birth")
    private Date dateOfBirth;
    @Column(nullable = true)
    private String image;

    @JoinColumn(nullable = false, name = "parent_id")
    @ManyToOne
    @JsonIgnore
    private Parent parent;
}
