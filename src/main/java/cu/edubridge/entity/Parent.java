package cu.edubridge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cu.edubridge.entity.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "parent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Parent extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, name = "phone_no")
    private String phoneNo;
    @Column(nullable = true)
    private String image;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<Student> students;
}
