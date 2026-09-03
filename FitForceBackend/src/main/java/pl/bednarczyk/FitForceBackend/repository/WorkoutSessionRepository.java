package pl.bednarczyk.FitForceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.WorkoutSession;
import pl.bednarczyk.FitForceBackend.entity.WorkoutStatus;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {
    Optional<WorkoutSession> findByIdAndUserId(Long id, Long userId);
    List<WorkoutSession> findAllByUserIdAndStatusOrderByStartedAtDesc(Long userId, WorkoutStatus status);
    long countByUserIdAndStatusAndStartedAtBetween(Long userId, WorkoutStatus status, Instant from, Instant to);
}
