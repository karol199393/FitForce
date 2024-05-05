package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.entity.Exercises;
import pl.bednarczyk.FitForceBackend.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public ResponseEntity<List<Exercises>> getAllExercises() {
        List<Exercises> exercises = exerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
    @PostMapping("/addExercise")
    public ResponseEntity<Exercises> addExercise(@RequestBody Exercises exercise) {
        Exercises newExercises = exerciseService.addExercise(exercise);
        return new ResponseEntity<>(newExercises,HttpStatus.CREATED);
    }

    @PostMapping("/exercises/{exerciseId}/assign/{trainingId}")
    public ResponseEntity<Exercises> assignExerciseToTraining(@PathVariable Long exerciseId, @PathVariable Long trainingId) {
        Exercises exercise = exerciseService.assignExerciseToTraining(exerciseId, trainingId);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @GetMapping("/exercises/{id}")
    public Exercises getExerciseById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/exercises/{id}")
    public void deleteExerciseById(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
    }

    @PutMapping("/exercises/{id}")
    public ResponseEntity<Exercises> updateExercise(@PathVariable Long id, @RequestBody Exercises exerciseDetails) {
        Exercises updatedExercise = exerciseService.updateExercise(id, exerciseDetails);
        return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
    }

}
