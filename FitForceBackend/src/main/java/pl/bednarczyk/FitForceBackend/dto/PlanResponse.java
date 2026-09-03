package pl.bednarczyk.FitForceBackend.dto;
import pl.bednarczyk.FitForceBackend.entity.WorkoutPlan;
import java.util.List;
public record PlanResponse(Long id, String name, String description, List<Item> exercises) {
    public record Item(Long id, ExerciseResponse exercise, Integer position, Integer targetSets,
                       Integer targetReps, Integer restSeconds, Double targetRpe, Integer targetRir) {}
    public static PlanResponse from(WorkoutPlan plan) {
        return new PlanResponse(plan.getId(), plan.getName(), plan.getDescription(), plan.getExercises().stream()
                .map(i -> new Item(i.getId(), ExerciseResponse.from(i.getExercise()), i.getPosition(), i.getTargetSets(),
                        i.getTargetReps(), i.getRestSeconds(), i.getTargetRpe(), i.getTargetRir())).toList());
    }
}
