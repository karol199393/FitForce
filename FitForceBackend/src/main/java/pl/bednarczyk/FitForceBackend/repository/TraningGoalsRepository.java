package pl.bednarczyk.FitForceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;

public interface TraningGoalsRepository extends JpaRepository<TrainingGoals, Long> {
}
