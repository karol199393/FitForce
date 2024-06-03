package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.service.TrainingGoalsService;

@RestController
@RequestMapping("api/v1/training-goals")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainingGoalsController {
    private TrainingGoalsService traininggoalsservice;

    public TrainingGoalsController(TrainingGoalsService traininggoalsservice) {
        this.traininggoalsservice = traininggoalsservice;
    }

    public TrainingGoals createTrainingGoal(@RequestBody TrainingGoals trainingGoal) {
        return traininggoalsservice.createTrainingGoal(trainingGoal);
    }

    @PostMapping("/addweight")
    public ResponseEntity<Double> addWeightMeasurement(@RequestBody Double weight) {
        traininggoalsservice.addWeightMeasurement(weight);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addwaist")
    public ResponseEntity<Double> addWaistMeasurement(@RequestBody Double waist) {
        traininggoalsservice.addWaistMeasurement(waist);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addhip")
    public ResponseEntity<Double> addHipMeasurement(@RequestBody Double hip) {
        traininggoalsservice.addHipMeasurement(hip);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addchest")
    public ResponseEntity<Double> addChestMeasurement(@RequestBody Double chest) {
        traininggoalsservice.addChestMeasurement(chest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addarm")
    public ResponseEntity<Double> addArmMeasurement(@RequestBody Double arm) {
        traininggoalsservice.addArmMeasurement(arm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addcalories")
    public ResponseEntity<Integer> addCalories(@RequestBody Integer caloriesBurned) {
        traininggoalsservice.addCalories(caloriesBurned);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/weight-loss-goal")
    public ResponseEntity<Double> calculateWeightLossGoal() {
        double goal = traininggoalsservice.calculateWeightLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/waist-loss-goal")
    public ResponseEntity<Double> calculateWaistLossGoal() {
        double goal = traininggoalsservice.calculateWaistLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/hip-loss-goal")
    public ResponseEntity<Double> calculateHipLossGoal() {
        double goal = traininggoalsservice.calculateHipLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/chest-loss-goal")
    public ResponseEntity<Double> calculateChestLossGoal() {
        double goal = traininggoalsservice.calculateChestLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/arm-loss-goal")
    public ResponseEntity<Double> calculateArmLossGoal() {
        double goal = traininggoalsservice.calculateArmLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/calories")
    public ResponseEntity<Double> calculateCalories() {
        double totalCalories = traininggoalsservice.calculateCalories();
        return ResponseEntity.ok(totalCalories);
    }
}
