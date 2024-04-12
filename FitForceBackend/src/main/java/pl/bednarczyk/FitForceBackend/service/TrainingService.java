package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.Trainings;
import pl.bednarczyk.FitForceBackend.repository.TrainingsRepository;

import java.time.LocalDate;

@Service
public class TrainingService {
    TrainingsRepository TrainingsRepository;
    public TrainingService(TrainingsRepository TrainingsRepository) {
        this.TrainingsRepository = TrainingsRepository;
    }
    public Object getAllTrainings() {
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
    public int calculateTrainingProgress(Long trainingId, LocalDate startDate, LocalDate endDate) {
        Trainings training = TrainingsRepository.findById(trainingId).orElseThrow(() -> new IllegalArgumentException("Training not found"));
        // Tu możemy dodać logikę obliczania postępu na podstawie daty rozpoczęcia i zakończenia treningu oraz innych czynników
        // W tym przykładzie załóżmy, że postęp jest równy 50% jeśli data dzisiejsza jest połową między datą rozpoczęcia a datą zakończenia
        LocalDate today = LocalDate.now();
        long daysBetweenStartAndToday = startDate.until(today).getDays();
        long totalDays = startDate.until(endDate).getDays();
        int progress = (int) ((double) daysBetweenStartAndToday / totalDays * 100);

        return progress;
    }




}
