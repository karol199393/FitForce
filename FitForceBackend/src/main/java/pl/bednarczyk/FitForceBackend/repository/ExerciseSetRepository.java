package pl.bednarczyk.FitForceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.ExerciseSet;
import java.util.Optional;
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
    Optional<ExerciseSet> findByIdAndSessionId(Long id, Long sessionId);
}
