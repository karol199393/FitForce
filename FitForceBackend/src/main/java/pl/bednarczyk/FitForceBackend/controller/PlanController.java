package pl.bednarczyk.FitForceBackend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.service.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/plans")
public class PlanController {
    private final PlanService plans; private final CurrentUserService current;
    public PlanController(PlanService plans, CurrentUserService current) { this.plans = plans; this.current = current; }
    @GetMapping List<PlanResponse> all(Authentication a) { return plans.all(current.require(a)); }
    @GetMapping("/{id}") PlanResponse one(@PathVariable Long id, Authentication a) { return plans.one(id, current.require(a)); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) PlanResponse create(@Valid @RequestBody PlanRequest r, Authentication a) { return plans.create(r, current.require(a)); }
    @PatchMapping("/{id}") PlanResponse update(@PathVariable Long id, @Valid @RequestBody PlanRequest r, Authentication a) { return plans.update(id, r, current.require(a)); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) void delete(@PathVariable Long id, Authentication a) { plans.delete(id, current.require(a)); }
}
