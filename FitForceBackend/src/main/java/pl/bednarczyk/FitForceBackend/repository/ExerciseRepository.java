package pl.bednarczyk.FitForceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bednarczyk.FitForceBackend.entity.Exercises;

public interface ExerciseRepository extends JpaRepository<Exercises, Long> {
}
