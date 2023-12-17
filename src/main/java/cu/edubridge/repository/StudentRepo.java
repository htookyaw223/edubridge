package cu.edubridge.repository;

import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Parent;
import cu.edubridge.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("SELECT new cu.edubridge.dto.response.StudentResDto(" +
            "s.id,s.name, s.nrc,s.dateOfBirth, s.image, s.parent" +
            ") FROM Student s WHERE s.parent =:parent ")
    List<StudentResDto> findAllByParent(Parent parent);
}
