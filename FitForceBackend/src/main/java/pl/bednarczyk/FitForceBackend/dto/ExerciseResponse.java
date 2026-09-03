package pl.bednarczyk.FitForceBackend.dto;
import pl.bednarczyk.FitForceBackend.entity.Exercises;
public record ExerciseResponse(Long id, String name, String description, String muscleGroup, String equipment) {
    public static ExerciseResponse from(Exercises e) { return new ExerciseResponse(e.getId(), e.getName(), e.getDescription(), e.getMuscleGroup(), e.getEquipment()); }
}
