package pl.bednarczyk.FitForceBackend.dto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
public record SetRequest(@NotNull Long exerciseId, @NotNull @Min(1) Integer setNumber,
                         @NotNull @DecimalMin("0.0") BigDecimal weight,
                         @NotNull @Min(1) Integer repetitions, Double rpe, Integer rir, boolean completed) {}
