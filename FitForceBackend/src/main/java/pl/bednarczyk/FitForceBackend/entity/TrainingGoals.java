package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "training_goals")
@Data
public class TrainingGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "weight_loss_goal")
    private Double weightLossGoal;
    @Column(name = "muscle_gain_goal")
    private Double muscleGainGoal;
    @Column(name = "increaseSpeed_goal")
    private Double increaseSpeed;
    @Column(name = "increaseAcceleration")
    private Double increaseAcceleration;

}
