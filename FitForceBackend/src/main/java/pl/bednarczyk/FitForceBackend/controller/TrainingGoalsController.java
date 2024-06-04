package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.dto.TrainingGoalsDTO;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.service.TrainingGoalsService;

import java.util.List;

@RestController
@RequestMapping("api/v1/training-goals")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainingGoalsController {

    private final TrainingGoalsService trainingGoalsService;

    public TrainingGoalsController(TrainingGoalsService trainingGoalsService) {
        this.trainingGoalsService = trainingGoalsService;
    }

    @PostMapping("/add")
    public ResponseEntity<TrainingGoals> addTrainingGoals(@RequestBody TrainingGoalsDTO trainingGoalsDTO) {
        TrainingGoals trainingGoals = new TrainingGoals();
        trainingGoals.setDate(String.valueOf(trainingGoalsDTO.getDate()));
        trainingGoals.setWeightLossGoal(trainingGoalsDTO.getWeightLossGoal());
        trainingGoals.setMuscleGainGoal(trainingGoalsDTO.getMuscleGainGoal());
        trainingGoals.setIncreaseSpeed(trainingGoalsDTO.getIncreaseSpeed());
        trainingGoals.setIncreaseAcceleration(trainingGoalsDTO.getIncreaseAcceleration());
        trainingGoals.setWaistLossGoal(trainingGoalsDTO.getWaistLossGoal());
        trainingGoals.setHipLossGoal(trainingGoalsDTO.getHipLossGoal());
        trainingGoals.setChestLossGoal(trainingGoalsDTO.getChestLossGoal());
        trainingGoals.setArmLossGoal(trainingGoalsDTO.getArmLossGoal());
        trainingGoals.setCaloriesBurned(trainingGoalsDTO.getCaloriesBurned());
        trainingGoals.setTrainingId(trainingGoalsDTO.getTrainingId());
        trainingGoals.setUserId(trainingGoalsDTO.getUserId());
        TrainingGoals savedTrainingGoals = trainingGoalsService.save(trainingGoals);
        return ResponseEntity.ok(savedTrainingGoals);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TrainingGoals>> getAllTrainingGoals() {
        List<TrainingGoals> trainingGoals = trainingGoalsService.getAllTrainingGoals();
        return ResponseEntity.ok(trainingGoals);
    }

}