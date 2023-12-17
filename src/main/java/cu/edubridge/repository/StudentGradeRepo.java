package cu.edubridge.repository;

import cu.edubridge.dto.response.StudentGradeResDto;
import cu.edubridge.dto.response.StudentResDto;
import cu.edubridge.entity.Grade;
import cu.edubridge.entity.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentGradeRepo extends JpaRepository<StudentGrade, Long> {

    @Query("SELECT new cu.edubridge.dto.response.StudentGradeResDto(" +
            "s" +
            ") FROM StudentGrade s WHERE s.grade =:grade AND s.academicYear=:academicYear ")
    List<StudentGradeResDto> findAllByGradeAndAcademicYear(Grade grade, String academicYear);
}
