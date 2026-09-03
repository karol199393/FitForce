package pl.bednarczyk.FitForceBackend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.FitnessGoal;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.FitnessGoalRepository;
import pl.bednarczyk.FitForceBackend.service.CurrentUserService;
import java.util.List;
@RestController @RequestMapping("/api/v1/goals")
public class GoalController {
    private final FitnessGoalRepository goals; private final CurrentUserService current;
    public GoalController(FitnessGoalRepository goals, CurrentUserService current) { this.goals = goals; this.current = current; }
    @GetMapping List<GoalResponse> all(Authentication a) { return goals.findAllByUserIdOrderByCompletedAscDeadlineAsc(current.require(a).getId()).stream().map(GoalResponse::from).toList(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) GoalResponse create(@Valid @RequestBody GoalRequest r, Authentication a) { FitnessGoal g = new FitnessGoal(); g.setUser(current.require(a)); return GoalResponse.from(goals.save(apply(g, r))); }
    @PatchMapping("/{id}") GoalResponse update(@PathVariable Long id, @Valid @RequestBody GoalRequest r, Authentication a) { var u = current.require(a); FitnessGoal g = goals.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono celu")); return GoalResponse.from(goals.save(apply(g, r))); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) void delete(@PathVariable Long id, Authentication a) { var u = current.require(a); FitnessGoal g = goals.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono celu")); goals.delete(g); }
    private FitnessGoal apply(FitnessGoal g, GoalRequest r) { g.setType(r.type()); g.setName(r.name()); g.setStartValue(r.startValue()); g.setTargetValue(r.targetValue()); g.setCurrentValue(r.currentValue()); g.setDeadline(r.deadline()); g.setCompleted(r.completed()); return g; }
}
