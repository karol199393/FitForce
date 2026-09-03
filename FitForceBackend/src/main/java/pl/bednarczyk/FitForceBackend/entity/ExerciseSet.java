package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity @Table(name = "exercise_sets") @Getter @Setter @NoArgsConstructor
public class ExerciseSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "session_id") private WorkoutSession session;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "exercise_id") private Exercises exercise;
    @Column(nullable = false) private Integer setNumber;
    @Column(nullable = false, precision = 8, scale = 2) private BigDecimal weight;
    @Column(nullable = false) private Integer repetitions;
    private Double rpe;
    private Integer rir;
    @Column(nullable = false) private boolean completed;
}
