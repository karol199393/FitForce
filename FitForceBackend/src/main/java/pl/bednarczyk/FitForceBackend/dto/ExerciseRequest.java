package pl.bednarczyk.FitForceBackend.dto;
import jakarta.validation.constraints.NotBlank;
public record ExerciseRequest(@NotBlank String name, String description, @NotBlank String muscleGroup, String equipment) {}
