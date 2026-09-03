package pl.bednarczyk.FitForceBackend.dto;
import pl.bednarczyk.FitForceBackend.entity.WorkoutSession;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
public record WorkoutResponse(Long id, Long planId, String name, Instant startedAt, Instant finishedAt,
                              String status, BigDecimal totalVolume, List<SetItem> sets) {
    public record SetItem(Long id, ExerciseResponse exercise, Integer setNumber, BigDecimal weight,
                          Integer repetitions, Double rpe, Integer rir, boolean completed) {}
    public static WorkoutResponse from(WorkoutSession session) {
        var sets = session.getSets().stream().map(s -> new SetItem(s.getId(), ExerciseResponse.from(s.getExercise()),
                s.getSetNumber(), s.getWeight(), s.getRepetitions(), s.getRpe(), s.getRir(), s.isCompleted())).toList();
        BigDecimal volume = session.getSets().stream().filter(s -> s.isCompleted())
                .map(s -> s.getWeight().multiply(BigDecimal.valueOf(s.getRepetitions())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new WorkoutResponse(session.getId(), session.getPlan() == null ? null : session.getPlan().getId(),
                session.getName(), session.getStartedAt(), session.getFinishedAt(), session.getStatus().name(), volume, sets);
    }
}
