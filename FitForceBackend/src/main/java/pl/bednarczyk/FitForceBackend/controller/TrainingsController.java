package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.entity.Training;
import pl.bednarczyk.FitForceBackend.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/trainings")
@CrossOrigin(origins = "http://localhost:65322")
public class TrainingsController {
    private TrainingService trainingsService;
    public TrainingsController(TrainingService trainingsService) {
        this.trainingsService = trainingsService;
    }
    @GetMapping("/getAllTrainings")
    public ResponseEntity<List<Training>> getAllTrainings() {
        List<Training> trainings = (List<Training>) trainingsService.getAllTrainings();
        return new ResponseEntity<>(trainings,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Object getTrainingById(Long id) {
        return trainingsService.getTrainingById(id);
    }


}
