package pl.bednarczyk.FitForceBackend.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
public record MeasurementRequest(@NotNull LocalDate measuredAt, @Positive BigDecimal weight,
                                 @Positive BigDecimal waist, @Positive BigDecimal chest,
                                 @Positive BigDecimal hips, @Positive BigDecimal arm,
                                 @Positive BigDecimal bodyFatPercentage) {}
