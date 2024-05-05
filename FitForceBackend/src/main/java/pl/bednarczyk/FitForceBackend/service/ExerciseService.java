package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.Exercises;
import pl.bednarczyk.FitForceBackend.entity.Training;
import pl.bednarczyk.FitForceBackend.repository.ExerciseRepository;
import pl.bednarczyk.FitForceBackend.repository.TrainingsRepository;

import java.util.List;

@Service
public class ExerciseService {
    public ExerciseRepository exerciseRepository;
    public TrainingsRepository trainingRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void deleteExerciseById(Long id) {
        exerciseRepository.deleteById(id);
    }

    public Exercises addExercise(Exercises exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercises getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public Exercises updateExercise(Long id, Exercises exerciseDetails) {
        return exerciseRepository.save(exerciseDetails);
    }
    public Exercises assignExerciseToTraining(Long exerciseId, Long trainingId) {
        Exercises exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found"));
        exercise.setTraining(training);
        return exerciseRepository.save(exercise);
    }

    public List<Exercises> getAllExercises() {
        return exerciseRepository.findAll();
    }



}
