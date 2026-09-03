package pl.bednarczyk.FitForceBackend.dto;
import java.math.BigDecimal;
public record StatisticsResponse(long workoutsThisWeek, BigDecimal weeklyVolume,
                                 MeasurementResponse latestMeasurement, WorkoutResponse lastWorkout) {}
