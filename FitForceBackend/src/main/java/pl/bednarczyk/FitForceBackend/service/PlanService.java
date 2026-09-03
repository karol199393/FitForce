package pl.bednarczyk.FitForceBackend.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.*;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.*;
import java.util.List;
@Service
public class PlanService {
    private final WorkoutPlanRepository plans; private final ExerciseRepository exercises;
    public PlanService(WorkoutPlanRepository plans, ExerciseRepository exercises) { this.plans = plans; this.exercises = exercises; }
    @Transactional(readOnly = true) public List<PlanResponse> all(User u) { return plans.findAllByUserIdOrderByCreatedAtDesc(u.getId()).stream().map(PlanResponse::from).toList(); }
    @Transactional(readOnly = true) public PlanResponse one(Long id, User u) { return PlanResponse.from(require(id, u)); }
    @Transactional public PlanResponse create(PlanRequest r, User u) { WorkoutPlan p = new WorkoutPlan(); p.setUser(u); apply(p, r); return PlanResponse.from(plans.save(p)); }
    @Transactional public PlanResponse update(Long id, PlanRequest r, User u) { WorkoutPlan p = require(id, u); apply(p, r); return PlanResponse.from(plans.save(p)); }
    @Transactional public void delete(Long id, User u) { plans.delete(require(id, u)); }
    public WorkoutPlan require(Long id, User u) { return plans.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono planu")); }
    private void apply(WorkoutPlan p, PlanRequest r) {
        p.setName(r.name()); p.setDescription(r.description()); p.getExercises().clear();
        if (r.exercises() != null) r.exercises().forEach(i -> { WorkoutPlanExercise link = new WorkoutPlanExercise(); link.setPlan(p);
            link.setExercise(exercises.findById(i.exerciseId()).orElseThrow(() -> new NotFoundException("Nie znaleziono ćwiczenia " + i.exerciseId())));
            link.setPosition(i.position()); link.setTargetSets(i.targetSets()); link.setTargetReps(i.targetReps()); link.setRestSeconds(i.restSeconds()); link.setTargetRpe(i.targetRpe()); link.setTargetRir(i.targetRir()); p.getExercises().add(link); });
    }
}
