package pl.bednarczyk.FitForceBackend.unitTest;

import org.junit.jupiter.api.Test;
import pl.bednarczyk.FitForceBackend.dto.GoalResponse;
import pl.bednarczyk.FitForceBackend.entity.FitnessGoal;
import pl.bednarczyk.FitForceBackend.entity.GoalType;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class GoalResponseTests {
    @Test
    void calculatesProgressBetweenStartAndTarget() {
        FitnessGoal goal = new FitnessGoal();
        goal.setId(1L); goal.setType(GoalType.WEIGHT); goal.setName("Cel");
        goal.setStartValue(new BigDecimal("100")); goal.setTargetValue(new BigDecimal("80"));
        goal.setCurrentValue(new BigDecimal("90"));
        assertThat(GoalResponse.from(goal).progressPercent()).isEqualByComparingTo("50.0");
    }
}
