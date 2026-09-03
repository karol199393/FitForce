package pl.bednarczyk.FitForceBackend.controller;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.WorkoutStatus;
import pl.bednarczyk.FitForceBackend.repository.*;
import pl.bednarczyk.FitForceBackend.service.CurrentUserService;
import java.math.BigDecimal;
import java.time.*;
@RestController @RequestMapping("/api/v1/statistics")
public class StatisticsController {
    private final WorkoutSessionRepository sessions; private final BodyMeasurementRepository measurements; private final CurrentUserService current;
    public StatisticsController(WorkoutSessionRepository sessions, BodyMeasurementRepository measurements, CurrentUserService current) { this.sessions = sessions; this.measurements = measurements; this.current = current; }
    @GetMapping @Transactional(readOnly = true) StatisticsResponse statistics(Authentication a) {
        var u = current.require(a); ZoneId zone = ZoneId.systemDefault(); LocalDate today = LocalDate.now(zone);
        Instant from = today.with(java.time.temporal.TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay(zone).toInstant();
        Instant to = from.plus(7, java.time.temporal.ChronoUnit.DAYS);
        var history = sessions.findAllByUserIdAndStatusOrderByStartedAtDesc(u.getId(), WorkoutStatus.COMPLETED);
        BigDecimal volume = history.stream().filter(s -> !s.getStartedAt().isBefore(from) && s.getStartedAt().isBefore(to)).flatMap(s -> s.getSets().stream())
                .filter(set -> set.isCompleted()).map(set -> set.getWeight().multiply(BigDecimal.valueOf(set.getRepetitions()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        var ms = measurements.findAllByUserIdOrderByMeasuredAtDesc(u.getId());
        return new StatisticsResponse(sessions.countByUserIdAndStatusAndStartedAtBetween(u.getId(), WorkoutStatus.COMPLETED, from, to), volume,
                ms.isEmpty() ? null : MeasurementResponse.from(ms.get(0)), history.isEmpty() ? null : WorkoutResponse.from(history.get(0)));
    }
}
