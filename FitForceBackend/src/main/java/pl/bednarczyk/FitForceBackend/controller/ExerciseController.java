package pl.bednarczyk.FitForceBackend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.*;
import pl.bednarczyk.FitForceBackend.entity.Exercises;
import pl.bednarczyk.FitForceBackend.exception.NotFoundException;
import pl.bednarczyk.FitForceBackend.repository.ExerciseRepository;
import java.util.List;
@RestController @RequestMapping("/api/v1/exercises")
public class ExerciseController {
    private final ExerciseRepository exercises;
    public ExerciseController(ExerciseRepository exercises) { this.exercises = exercises; }
    @GetMapping List<ExerciseResponse> all() { return exercises.findAll().stream().map(ExerciseResponse::from).toList(); }
    @GetMapping("/{id}") ExerciseResponse one(@PathVariable Long id) { return ExerciseResponse.from(require(id)); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) @PreAuthorize("hasAnyRole('ADMIN','TRAINER')")
    ExerciseResponse create(@Valid @RequestBody ExerciseRequest r) { return ExerciseResponse.from(save(new Exercises(), r)); }
    @PatchMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN','TRAINER')")
    ExerciseResponse update(@PathVariable Long id, @Valid @RequestBody ExerciseRequest r) { return ExerciseResponse.from(save(require(id), r)); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable Long id) { exercises.delete(require(id)); }
    private Exercises save(Exercises e, ExerciseRequest r) { e.setName(r.name()); e.setDescription(r.description()); e.setMuscleGroup(r.muscleGroup()); e.setEquipment(r.equipment()); return exercises.save(e); }
    private Exercises require(Long id) { return exercises.findById(id).orElseThrow(() -> new NotFoundException("Nie znaleziono ćwiczenia")); }
}
