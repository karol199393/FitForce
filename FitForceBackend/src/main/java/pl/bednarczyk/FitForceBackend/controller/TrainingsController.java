package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bednarczyk.FitForceBackend.service.TrainingService;

import java.time.LocalDate;

@RestController
@RequestMapping("/trainings")
public class TrainingsController {
    private TrainingService trainingsService;
    public TrainingsController(TrainingService trainingsService) {
        this.trainingsService = trainingsService;
    }
    @GetMapping("/getAllTrainings")
    public Object getAllTrainings() {
        return trainingsService.getAllTrainings();
    }
    @GetMapping("/{id}")
    public Object getTrainingById(Long id) {
        return trainingsService.getTrainingById(id);
    }
    public int getTrainingProgress(@PathVariable Long trainingId) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 4, 31);
        return trainingsService.calculateTrainingProgress(trainingId, startDate, endDate);
    }

}
