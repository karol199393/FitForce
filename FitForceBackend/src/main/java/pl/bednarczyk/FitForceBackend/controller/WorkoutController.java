package pl.bednarczyk.FitForceBackend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.service.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/workout-sessions")
public class WorkoutController {
    private final WorkoutService workouts; private final CurrentUserService current;
    public WorkoutController(WorkoutService workouts, CurrentUserService current) { this.workouts = workouts; this.current = current; }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) WorkoutResponse start(@RequestBody StartWorkoutRequest r, Authentication a) { return workouts.start(r, current.require(a)); }
    @GetMapping("/{id}") WorkoutResponse one(@PathVariable Long id, Authentication a) { return workouts.one(id, current.require(a)); }
    @GetMapping("/history") List<WorkoutResponse> history(Authentication a) { return workouts.history(current.require(a)); }
    @PostMapping("/{id}/sets") @ResponseStatus(HttpStatus.CREATED) WorkoutResponse addSet(@PathVariable Long id, @Valid @RequestBody SetRequest r, Authentication a) { return workouts.addSet(id, r, current.require(a)); }
    @PatchMapping("/{id}/sets/{setId}") WorkoutResponse updateSet(@PathVariable Long id, @PathVariable Long setId, @Valid @RequestBody SetRequest r, Authentication a) { return workouts.updateSet(id, setId, r, current.require(a)); }
    @DeleteMapping("/{id}/sets/{setId}") WorkoutResponse deleteSet(@PathVariable Long id, @PathVariable Long setId, Authentication a) { return workouts.deleteSet(id, setId, current.require(a)); }
    @PostMapping("/{id}/finish") WorkoutResponse finish(@PathVariable Long id, Authentication a) { return workouts.finish(id, current.require(a)); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) void cancel(@PathVariable Long id, Authentication a) { workouts.cancel(id, current.require(a)); }
}
