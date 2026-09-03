package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "workout_plan_exercises") @Getter @Setter @NoArgsConstructor
public class WorkoutPlanExercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "plan_id") private WorkoutPlan plan;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "exercise_id") private Exercises exercise;
    @Column(nullable = false) private Integer position;
    private Integer targetSets;
    private Integer targetReps;
    private Integer restSeconds;
    private Double targetRpe;
    private Integer targetRir;
}
