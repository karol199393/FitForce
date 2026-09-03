package pl.bednarczyk.FitForceBackend.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.bednarczyk.FitForceBackend.entity.GoalType;
import java.math.BigDecimal;
import java.time.LocalDate;
public record GoalRequest(@NotNull GoalType type, @NotBlank String name, @NotNull BigDecimal startValue,
                          @NotNull BigDecimal targetValue, @NotNull BigDecimal currentValue,
                          LocalDate deadline, boolean completed) {}
