package pl.bednarczyk.FitForceBackend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.BodyMeasurement;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.BodyMeasurementRepository;
import pl.bednarczyk.FitForceBackend.service.CurrentUserService;
import java.util.List;
@RestController @RequestMapping("/api/v1/measurements")
public class MeasurementController {
    private final BodyMeasurementRepository measurements; private final CurrentUserService current;
    public MeasurementController(BodyMeasurementRepository measurements, CurrentUserService current) { this.measurements = measurements; this.current = current; }
    @GetMapping List<MeasurementResponse> all(Authentication a) { return measurements.findAllByUserIdOrderByMeasuredAtDesc(current.require(a).getId()).stream().map(MeasurementResponse::from).toList(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) MeasurementResponse create(@Valid @RequestBody MeasurementRequest r, Authentication a) { BodyMeasurement m = new BodyMeasurement(); m.setUser(current.require(a)); return MeasurementResponse.from(measurements.save(apply(m, r))); }
    @PatchMapping("/{id}") MeasurementResponse update(@PathVariable Long id, @Valid @RequestBody MeasurementRequest r, Authentication a) { var u = current.require(a); BodyMeasurement m = measurements.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono pomiaru")); return MeasurementResponse.from(measurements.save(apply(m, r))); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) void delete(@PathVariable Long id, Authentication a) { var u = current.require(a); BodyMeasurement m = measurements.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono pomiaru")); measurements.delete(m); }
    private BodyMeasurement apply(BodyMeasurement m, MeasurementRequest r) { m.setMeasuredAt(r.measuredAt()); m.setWeight(r.weight()); m.setWaist(r.waist()); m.setChest(r.chest()); m.setHips(r.hips()); m.setArm(r.arm()); m.setBodyFatPercentage(r.bodyFatPercentage()); return m; }
}
