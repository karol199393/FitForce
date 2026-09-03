package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name = "fitness_goals") @Getter @Setter @NoArgsConstructor
public class FitnessGoal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "user_id") private User user;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private GoalType type;
    @Column(nullable = false) private String name;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal startValue;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal targetValue;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal currentValue;
    private LocalDate deadline;
    @Column(nullable = false) private boolean completed;
}
