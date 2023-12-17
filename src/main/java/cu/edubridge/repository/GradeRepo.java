package cu.edubridge.repository;

import cu.edubridge.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GradeRepo extends JpaRepository<Grade, Long> {
    Grade findByGrade(String grade);
}
