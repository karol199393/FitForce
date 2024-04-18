package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.Trainings;
import pl.bednarczyk.FitForceBackend.repository.TrainingsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {
    TrainingsRepository TrainingsRepository;
    public TrainingService(TrainingsRepository TrainingsRepository) {
        this.TrainingsRepository = TrainingsRepository;
    }
    public List<Trainings> getAllTrainings() {
        return TrainingsRepository.findAll();
    }
    public Object getTrainingById(Long id) {
        return TrainingsRepository.findById(id).orElse(null);
    }
    public Trainings addTraining(Trainings training) {
        return TrainingsRepository.save(training);
    }
    public Object updateTraining(Long id, Trainings trainingDetails) {
        return TrainingsRepository.save(trainingDetails);
    }
    public void deleteTraining(Long id) {
        TrainingsRepository.deleteById(id);
    }





}
