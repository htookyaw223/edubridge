package cu.edubridge.repository;

import cu.edubridge.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ParentRepo extends JpaRepository<Parent, Long> {
}
