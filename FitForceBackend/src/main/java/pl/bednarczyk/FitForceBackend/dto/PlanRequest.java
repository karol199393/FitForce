package pl.bednarczyk.FitForceBackend.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
public record PlanRequest(@NotBlank String name, String description, @Valid List<PlanExerciseRequest> exercises) {
    public record PlanExerciseRequest(@NotNull Long exerciseId, @NotNull @Min(0) Integer position,
                                      @Min(1) Integer targetSets, @Min(1) Integer targetReps,
                                      @Min(0) Integer restSeconds, Double targetRpe, Integer targetRir) {}
}
