package pl.bednarczyk.FitForceBackend.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightLossGoal {
    private List<Double> weightMeasurements = new ArrayList<>();
    private List<Double> waistMeasurements = new ArrayList<>();
    private List<Double> hipMeasurements = new ArrayList<>();
    private List<Double> chestMeasurements = new ArrayList<>();
    private List<Double> armMeasurements = new ArrayList<>();
    private List<Integer> calories = new ArrayList<>();

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

    public double calculateWeightLossGoal() {
        double totalWeightLoss = 0.0;
        if (!weightMeasurements.isEmpty()) {
            double initialWeight = weightMeasurements.get(0);
            double latestWeight = weightMeasurements.get(weightMeasurements.size() - 1);
            totalWeightLoss = initialWeight - latestWeight;
        }
        return totalWeightLoss / 4;

    }

    public double calculateWaistLossGoal() {
        double totalWaistLoss = 0.0;
        if (!waistMeasurements.isEmpty()) {
            double initialWaist = waistMeasurements.get(0);
            double latestWaist = waistMeasurements.get(waistMeasurements.size() - 1);
            totalWaistLoss = initialWaist - latestWaist;
        }
        return totalWaistLoss / 4;
    }

    public double calculateHipLossGoal() {
        double totalHipLoss = 0.0;
        if (!hipMeasurements.isEmpty()) {
            double initialHip = hipMeasurements.get(0);
            double latestHip = hipMeasurements.get(hipMeasurements.size() - 1);
            totalHipLoss = initialHip - latestHip;
        }
        return totalHipLoss / 4;
    }

    public double calculateChestLossGoal() {
        double totalChestLoss = 0.0;
        if (!chestMeasurements.isEmpty()) {
            double initialChest = chestMeasurements.get(0);
            double latestChest = chestMeasurements.get(chestMeasurements.size() - 1);
            totalChestLoss = initialChest - latestChest;
        }
        return totalChestLoss / 4;
    }

    public double calculateArmLossGoal() {
        double totalArmLoss = 0.0;
        if (!armMeasurements.isEmpty()) {
            double initialArm = armMeasurements.get(0);
            double latestArm = armMeasurements.get(armMeasurements.size() - 1);
            totalArmLoss = initialArm - latestArm;
        }
        return totalArmLoss / 4;
    }

    public double calculateCalories() {
        int totalCalories = 0;
        for (int calories : calories) {
            totalCalories += calories;
        }
        return totalCalories / 8; // Zakładamy, że miesiąc ma 4 tygodnie i prowadzimy dziennik żywieniowy 2 razy w tygodniu

    }
}
