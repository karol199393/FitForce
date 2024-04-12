package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.service.TrainingGoalsService;

@RestController
@RequestMapping("/training-goals")
public class TrainingGoalsController {
    private TrainingGoalsService trainingGoalsService;

    public TrainingGoalsController(TrainingGoalsService trainingGoalsService){
        this.trainingGoalsService = trainingGoalsService;
    }

    public TrainingGoals createTrainingGoal(@RequestBody TrainingGoals trainingGoal){
        return trainingGoalsService.createTrainingGoal(trainingGoal);
    }
}
