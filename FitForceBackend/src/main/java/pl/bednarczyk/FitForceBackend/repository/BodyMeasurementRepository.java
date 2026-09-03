package pl.bednarczyk.FitForceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.BodyMeasurement;
import java.util.List;
import java.util.Optional;
public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
    List<BodyMeasurement> findAllByUserIdOrderByMeasuredAtDesc(Long userId);
    Optional<BodyMeasurement> findByIdAndUserId(Long id, Long userId);
}
