package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.repository.TraningGoalsRepository;

@Service
public class TrainingGoalsService {
    private TraningGoalsRepository trainingGoalsRepository;

    public TrainingGoalsService(TraningGoalsRepository traningGoalsRepository){
        this.trainingGoalsRepository = trainingGoalsRepository;
    }
    public TrainingGoals createTrainingGoal(TrainingGoals trainingGoal)
    {
        return trainingGoalsRepository.save(trainingGoal);
    }
}
