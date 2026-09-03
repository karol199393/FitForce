package pl.bednarczyk.FitForceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.WorkoutPlan;
import java.util.List;
import java.util.Optional;
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findAllByUserIdOrderByCreatedAtDesc(Long userId);
    Optional<WorkoutPlan> findByIdAndUserId(Long id, Long userId);
}
