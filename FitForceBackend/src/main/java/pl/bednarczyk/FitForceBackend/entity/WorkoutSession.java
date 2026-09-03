package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "workout_sessions") @Getter @Setter @NoArgsConstructor
public class WorkoutSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "user_id") private User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plan_id") private WorkoutPlan plan;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private Instant startedAt = Instant.now();
    private Instant finishedAt;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private WorkoutStatus status = WorkoutStatus.ACTIVE;
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC") private List<ExerciseSet> sets = new ArrayList<>();
}
