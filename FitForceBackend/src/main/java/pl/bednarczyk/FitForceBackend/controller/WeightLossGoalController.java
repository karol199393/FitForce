package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.service.WeightLossGoal;

@RestController
@RequestMapping("/api/weight-loss-goal")
public class WeightLossGoalController {

    private final WeightLossGoal weightLossGoal;

    @Autowired
    public WeightLossGoalController(WeightLossGoal weightLossGoal) {
        this.weightLossGoal = weightLossGoal;
    }

    @PostMapping("/weight")
    public ResponseEntity<Double> addWeightMeasurement(@RequestBody Double weight) {
        weightLossGoal.addWeightMeasurement(weight);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/waist")
    public ResponseEntity<Double> addWaistMeasurement(@RequestBody Double waist) {
        weightLossGoal.addWaistMeasurement(waist);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/hip")
    public ResponseEntity<Double> addHipMeasurement(@RequestBody Double hip) {
        weightLossGoal.addHipMeasurement(hip);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/chest")
    public ResponseEntity<Double> addChestMeasurement(@RequestBody Double chest) {
        weightLossGoal.addChestMeasurement(chest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/arm")
    public ResponseEntity<Double> addArmMeasurement(@RequestBody Double arm) {
        weightLossGoal.addArmMeasurement(arm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/calories")
    public ResponseEntity<Integer> addCalories(@RequestBody Integer caloriesBurned) {
        weightLossGoal.addCalories(caloriesBurned);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/weight-loss-goal")
    public ResponseEntity<Double> calculateWeightLossGoal() {
        double goal = weightLossGoal.calculateWeightLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/waist-loss-goal")
    public ResponseEntity<Double> calculateWaistLossGoal() {
        double goal = weightLossGoal.calculateWaistLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/hip-loss-goal")
    public ResponseEntity<Double> calculateHipLossGoal() {
        double goal = weightLossGoal.calculateHipLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/chest-loss-goal")
    public ResponseEntity<Double> calculateChestLossGoal() {
        double goal = weightLossGoal.calculateChestLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/arm-loss-goal")
    public ResponseEntity<Double> calculateArmLossGoal() {
        double goal = weightLossGoal.calculateArmLossGoal();
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/calories")
    public ResponseEntity<Double> calculateCalories() {
        double totalCalories = weightLossGoal.calculateCalories();
        return ResponseEntity.ok(totalCalories);
    }
}
