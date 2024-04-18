package pl.bednarczyk.FitForceBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bednarczyk.FitForceBackend.entity.Trainings;
import pl.bednarczyk.FitForceBackend.service.TrainingService;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
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
    public ResponseEntity<List<Trainings>> getAllTrainings() {
        List<Trainings> trainings = (List<Trainings>) trainingsService.getAllTrainings();
        return new ResponseEntity<>(trainings,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Object getTrainingById(Long id) {
        return trainingsService.getTrainingById(id);
    }


}
