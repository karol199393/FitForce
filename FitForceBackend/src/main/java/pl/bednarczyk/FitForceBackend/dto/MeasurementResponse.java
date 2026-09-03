package pl.bednarczyk.FitForceBackend.dto;
import pl.bednarczyk.FitForceBackend.entity.BodyMeasurement;
import java.math.BigDecimal;
import java.time.LocalDate;
public record MeasurementResponse(Long id, LocalDate measuredAt, BigDecimal weight, BigDecimal waist,
                                  BigDecimal chest, BigDecimal hips, BigDecimal arm, BigDecimal bodyFatPercentage) {
    public static MeasurementResponse from(BodyMeasurement m) { return new MeasurementResponse(m.getId(), m.getMeasuredAt(),
            m.getWeight(), m.getWaist(), m.getChest(), m.getHips(), m.getArm(), m.getBodyFatPercentage()); }
}
