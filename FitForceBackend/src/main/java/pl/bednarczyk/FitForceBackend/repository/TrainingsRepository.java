package pl.bednarczyk.FitForceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.Trainings;

public interface TrainingsRepository extends JpaRepository<Trainings,Long> {
}
