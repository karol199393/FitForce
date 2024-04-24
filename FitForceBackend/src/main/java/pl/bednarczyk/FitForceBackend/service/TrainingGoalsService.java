package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.repository.TraningGoalsRepository;

import java.util.HashMap;

@Service
public class TrainingGoalsService {
    private TraningGoalsRepository trainingGoalsRepository;

    // Mapa przechowująca pomiary wagowe
    private HashMap<String, Double> weightMeasurements = new HashMap<>();

    // Mapa przechowująca pomiary obwodów ciała
    private HashMap<String, Double> bodyMeasurements = new HashMap<>();

    public TrainingGoalsService(TraningGoalsRepository traningGoalsRepository) {
        this.trainingGoalsRepository = trainingGoalsRepository;
    }

    public TrainingGoals createTrainingGoal(TrainingGoals trainingGoal) {
        return trainingGoalsRepository.save(trainingGoal);
    }

    public Object getAllTrainingGoals() {
        return trainingGoalsRepository.findAll();
    }

    public Object getTrainingGoalById(Long id) {
        return trainingGoalsRepository.findById(id).orElse(null);
    }

    public Object updateTrainingGoal(Long id, TrainingGoals trainingGoalDetails) {
        return trainingGoalsRepository.save(trainingGoalDetails);
    }

    public void deleteTrainingGoal(Long id) {
        trainingGoalsRepository.deleteById(id);
    }

    //Metoda obliczająca cel redukcji wagi
    public Double calculateWeightLossGoal(Double currentWeight, Double targetWeight) {
        return currentWeight - targetWeight;
    }

    //Metoda obliczająca cel zwiększenia masy mięśniowej
    public Double calculateMuscleGainGoal(Double currentMuscleMass, Double targetMuscleMass) {
        return targetMuscleMass - currentMuscleMass;
    }

    //Metoda obliczająca cel zwiększenia prędkości
    public Double calculateIncreaseSpeedGoal(Double currentSpeed, Double targetSpeed) {
        return targetSpeed - currentSpeed;
    }

    //Metoda obliczająca cel zwiększenia przyspieszenia
    public Double calculateIncreaseAccelerationGoal(Double currentAcceleration, Double targetAcceleration) {
        return targetAcceleration - currentAcceleration;
    }

    //Metoda obliczająca BMI
    public Double calculateBMI(Double weight, Double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Wzrost musi być większy od 0.");
        }
        return weight / (height * height);
    }

}
