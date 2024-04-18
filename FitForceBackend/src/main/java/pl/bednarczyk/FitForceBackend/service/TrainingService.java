package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.Training;
import pl.bednarczyk.FitForceBackend.repository.TrainingsRepository;

import java.util.List;

@Service
public class TrainingService {
    TrainingsRepository TrainingsRepository;
    public TrainingService(TrainingsRepository TrainingsRepository) {
        this.TrainingsRepository = TrainingsRepository;
    }
    public List<Training> getAllTrainings() {
        return TrainingsRepository.findAll();
    }
    public Object getTrainingById(Long id) {
        return TrainingsRepository.findById(id).orElse(null);
    }
    public Training addTraining(Training training) {
        return TrainingsRepository.save(training);
    }
    public Object updateTraining(Long id, Training trainingDetails) {
        return TrainingsRepository.save(trainingDetails);
    }
    public void deleteTraining(Long id) {
        TrainingsRepository.deleteById(id);
    }





}
