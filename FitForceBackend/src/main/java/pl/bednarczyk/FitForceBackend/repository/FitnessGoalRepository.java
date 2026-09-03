package pl.bednarczyk.FitForceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.FitnessGoal;
import java.util.List;
import java.util.Optional;
public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {
    List<FitnessGoal> findAllByUserIdOrderByCompletedAscDeadlineAsc(Long userId);
    Optional<FitnessGoal> findByIdAndUserId(Long id, Long userId);
}
