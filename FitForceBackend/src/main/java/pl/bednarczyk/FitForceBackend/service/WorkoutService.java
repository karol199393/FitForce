package pl.bednarczyk.FitForceBackend.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.*;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.*;
import java.time.Instant;
import java.util.List;
@Service
public class WorkoutService {
    private final WorkoutSessionRepository sessions; private final ExerciseSetRepository sets;
    private final ExerciseRepository exercises; private final WorkoutPlanRepository plans;
    public WorkoutService(WorkoutSessionRepository sessions, ExerciseSetRepository sets, ExerciseRepository exercises, WorkoutPlanRepository plans) {
        this.sessions = sessions; this.sets = sets; this.exercises = exercises; this.plans = plans;
    }
    @Transactional public WorkoutResponse start(StartWorkoutRequest r, User u) {
        WorkoutSession s = new WorkoutSession(); s.setUser(u);
        if (r.planId() != null) { WorkoutPlan p = plans.findByIdAndUserId(r.planId(), u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono planu")); s.setPlan(p); s.setName(r.name() == null || r.name().isBlank() ? p.getName() : r.name()); }
        else { if (r.name() == null || r.name().isBlank()) throw new IllegalArgumentException("Nazwa treningu jest wymagana bez planu"); s.setName(r.name()); }
        return WorkoutResponse.from(sessions.save(s));
    }
    @Transactional(readOnly = true) public WorkoutResponse one(Long id, User u) { return WorkoutResponse.from(require(id, u)); }
    @Transactional(readOnly = true) public List<WorkoutResponse> history(User u) { return sessions.findAllByUserIdAndStatusOrderByStartedAtDesc(u.getId(), WorkoutStatus.COMPLETED).stream().map(WorkoutResponse::from).toList(); }
    @Transactional public WorkoutResponse addSet(Long id, SetRequest r, User u) { WorkoutSession s = active(id, u); ExerciseSet set = new ExerciseSet(); set.setSession(s); apply(set, r); s.getSets().add(set); sessions.save(s); return WorkoutResponse.from(s); }
    @Transactional public WorkoutResponse updateSet(Long sessionId, Long setId, SetRequest r, User u) { WorkoutSession s = active(sessionId, u); ExerciseSet set = sets.findByIdAndSessionId(setId, s.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono serii")); apply(set, r); sets.save(set); return WorkoutResponse.from(s); }
    @Transactional public WorkoutResponse deleteSet(Long sessionId, Long setId, User u) { WorkoutSession s = active(sessionId, u); ExerciseSet set = sets.findByIdAndSessionId(setId, s.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono serii")); s.getSets().remove(set); sets.delete(set); return WorkoutResponse.from(s); }
    @Transactional public WorkoutResponse finish(Long id, User u) { WorkoutSession s = active(id, u); s.setStatus(WorkoutStatus.COMPLETED); s.setFinishedAt(Instant.now()); return WorkoutResponse.from(sessions.save(s)); }
    @Transactional public void cancel(Long id, User u) { WorkoutSession s = require(id, u); s.setStatus(WorkoutStatus.CANCELLED); s.setFinishedAt(Instant.now()); sessions.save(s); }
    private void apply(ExerciseSet set, SetRequest r) { set.setExercise(exercises.findById(r.exerciseId()).orElseThrow(() -> new NotFoundException("Nie znaleziono ćwiczenia"))); set.setSetNumber(r.setNumber()); set.setWeight(r.weight()); set.setRepetitions(r.repetitions()); set.setRpe(r.rpe()); set.setRir(r.rir()); set.setCompleted(r.completed()); }
    private WorkoutSession active(Long id, User u) { WorkoutSession s = require(id, u); if (s.getStatus() != WorkoutStatus.ACTIVE) throw new IllegalStateException("Trening nie jest aktywny"); return s; }
    private WorkoutSession require(Long id, User u) { return sessions.findByIdAndUserId(id, u.getId()).orElseThrow(() -> new NotFoundException("Nie znaleziono treningu")); }
}
