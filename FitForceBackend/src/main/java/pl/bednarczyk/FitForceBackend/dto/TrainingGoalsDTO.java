package pl.bednarczyk.FitForceBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TrainingGoalsDTO {
    private Double weightLossGoal;
    private Double muscleGainGoal;
    private Double increaseSpeed;
    private Double increaseAcceleration;
    private Double waistLossGoal;
    private Double hipLossGoal;
    private Double chestLossGoal;
    private Double armLossGoal;
    private Integer caloriesBurned;
    private Integer trainingId;
    private Long userId;
    private Date date;

    // Getters and setters...
}