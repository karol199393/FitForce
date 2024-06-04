package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;
import pl.bednarczyk.FitForceBackend.entity.TrainingGoals;
import pl.bednarczyk.FitForceBackend.repository.TraningGoalsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TrainingGoalsService {
    private final TraningGoalsRepository trainingGoalsRepository;

    private final List<Double> weightMeasurements = new ArrayList<>();
    private final List<Double> waistMeasurements = new ArrayList<>();
    private final List<Double> hipMeasurements = new ArrayList<>();
    private final List<Double> chestMeasurements = new ArrayList<>();
    private final List<Double> armMeasurements = new ArrayList<>();
    private final List<Integer> calories = new ArrayList<>();

    // Mapa przechowująca pomiary wagowe
    private final HashMap<String, Double> weightMeasurementsMap = new HashMap<>();

    // Mapa przechowująca pomiary obwodów ciała
    private final HashMap<String, Double> bodyMeasurements = new HashMap<>();

    public TrainingGoalsService(TraningGoalsRepository traningGoalsRepository) {
        this.trainingGoalsRepository = traningGoalsRepository;
    }

    // CRUD operations
    public TrainingGoals createTrainingGoal(TrainingGoals trainingGoal) {
        return trainingGoalsRepository.save(trainingGoal);
    }

    public List<TrainingGoals> getAllTrainingGoals() {
        return trainingGoalsRepository.findAll();
    }

    public TrainingGoals getTrainingGoalById(Long id) {
        return trainingGoalsRepository.findById(id).orElse(null);
    }

    public TrainingGoals updateTrainingGoal(Long id, TrainingGoals trainingGoalDetails) {
        return trainingGoalsRepository.save(trainingGoalDetails);
    }

    public void deleteTrainingGoal(Long id) {
        trainingGoalsRepository.deleteById(id);
    }

    // Measurement methods
    public void addWeightMeasurement(Double weight) {
        weightMeasurements.add(weight);
    }

    public void addWaistMeasurement(Double waist) {
        waistMeasurements.add(waist);
    }

    public void addHipMeasurement(Double hip) {
        hipMeasurements.add(hip);
    }

    public void addChestMeasurement(Double chest) {
        chestMeasurements.add(chest);
    }

    public void addArmMeasurement(Double arm) {
        armMeasurements.add(arm);
    }

    public void addCalories(Integer caloriesBurned) {
        calories.add(caloriesBurned);
    }

    // Goal calculation methods
    public Double calculateWeightLossGoal(Double currentWeight, Double targetWeight) {
        return currentWeight - targetWeight;
    }

    public Double calculateMuscleGainGoal(Double currentMuscleMass, Double targetMuscleMass) {
        return targetMuscleMass - currentMuscleMass;
    }

    public Double calculateIncreaseSpeedGoal(Double currentSpeed, Double targetSpeed) {
        return targetSpeed - currentSpeed;
    }

    public Double calculateIncreaseAccelerationGoal(Double currentAcceleration, Double targetAcceleration) {
        return targetAcceleration - currentAcceleration;
    }

    public Double calculateBMI(Double weight, Double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Wzrost musi być większy od 0.");
        }
        return weight / (height * height);
    }

    // Monthly goal calculation methods
    public double calculateWeightLossGoal() {
        return calculateMonthlyGoal(weightMeasurements);
    }

    public double calculateWaistLossGoal() {
        return calculateMonthlyGoal(waistMeasurements);
    }

    public double calculateHipLossGoal() {
        return calculateMonthlyGoal(hipMeasurements);
    }

    public double calculateChestLossGoal() {
        return calculateMonthlyGoal(chestMeasurements);
    }

    public double calculateArmLossGoal() {
        return calculateMonthlyGoal(armMeasurements);
    }

    public double calculateCalories() {
        int totalCalories = 0;
        for (int calorie : calories) {
            totalCalories += calorie;
        }
        return totalCalories / 12.0; // Zakładamy, że miesiąc ma 4 tygodnie i prowadzimy dziennik żywieniowy 2 razy w tygodniu
    }

    private double calculateMonthlyGoal(List<Double> measurements) {
        double totalLoss = 0.0;
        if (!measurements.isEmpty()) {
            double initialMeasurement = measurements.get(0);
            double latestMeasurement = measurements.get(measurements.size() - 1);
            totalLoss = initialMeasurement - latestMeasurement;
        }
        return totalLoss / 12;
    }

    public TrainingGoals save(TrainingGoals trainingGoals) {
        return trainingGoalsRepository.save(trainingGoals);
    }
}