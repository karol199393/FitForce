package pl.bednarczyk.FitForceBackend.dto;
import pl.bednarczyk.FitForceBackend.entity.FitnessGoal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
public record GoalResponse(Long id, String type, String name, BigDecimal startValue, BigDecimal targetValue,
                           BigDecimal currentValue, LocalDate deadline, boolean completed, BigDecimal progressPercent) {
    public static GoalResponse from(FitnessGoal g) {
        BigDecimal range = g.getTargetValue().subtract(g.getStartValue());
        BigDecimal progress = range.signum() == 0 ? BigDecimal.valueOf(100) :
                g.getCurrentValue().subtract(g.getStartValue()).divide(range, 4, RoundingMode.HALF_UP)
                        .multiply(BigDecimal.valueOf(100)).max(BigDecimal.ZERO).min(BigDecimal.valueOf(100));
        return new GoalResponse(g.getId(), g.getType().name(), g.getName(), g.getStartValue(), g.getTargetValue(),
                g.getCurrentValue(), g.getDeadline(), g.isCompleted(), progress.setScale(1, RoundingMode.HALF_UP));
    }
}
