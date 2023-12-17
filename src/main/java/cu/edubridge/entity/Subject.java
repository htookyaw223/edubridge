package cu.edubridge.entity;

import cu.edubridge.entity.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Subject extends BaseEntity {
    @Column(nullable = false, name = "subject_name")
    private String subjectName;
}
