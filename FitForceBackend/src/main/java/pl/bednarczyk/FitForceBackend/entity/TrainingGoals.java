package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "training_goals")
@Data
@Getter
@Setter
public class TrainingGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "weight_loss_goal")
    private Double weightLossGoal;
    @Column(name = "muscle_gain_goal")
    private Double muscleGainGoal;
    @Column(name = "increaseSpeed_goal")
    private Double increaseSpeed;
    @Column(name = "increaseAcceleration")
    private Double increaseAcceleration;
    @Column(name = "waist_loss_goal")
    private Double waistLossGoal;
    @Column(name = "hip_loss_goal")
    private Double hipLossGoal;
    @Column(name = "chest_loss_goal")
    private Double chestLossGoal;
    @Column(name = "arm_loss_goal")
    private Double armLossGoal;
    @Column(name = "calories_burned")
    private Integer caloriesBurned;
    @Column(name = "training_id")
    private Integer trainingId;
    @Column(name = "user_id")
    private Long userId;
}
