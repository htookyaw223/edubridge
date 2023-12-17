package cu.edubridge.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Data
public class BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
    @CreationTimestamp
    @JsonIgnore
    @Column(name="created_date")
    private Timestamp createdDate;

    @Version
    @JsonIgnore
    @Column(name="last_updated_date")
    private Timestamp lastUpdatedDate;
	
}
