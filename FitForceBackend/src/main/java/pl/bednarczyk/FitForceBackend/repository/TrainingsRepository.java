package pl.bednarczyk.FitForceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.Training;

public interface TrainingsRepository extends JpaRepository<Training, Long> {
}
