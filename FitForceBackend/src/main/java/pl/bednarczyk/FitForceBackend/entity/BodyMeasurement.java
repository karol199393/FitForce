package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name = "body_measurements") @Getter @Setter @NoArgsConstructor
public class BodyMeasurement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "user_id") private User user;
    @Column(nullable = false) private LocalDate measuredAt;
    @Column(precision = 8, scale = 2) private BigDecimal weight;
    @Column(precision = 8, scale = 2) private BigDecimal waist;
    @Column(precision = 8, scale = 2) private BigDecimal chest;
    @Column(precision = 8, scale = 2) private BigDecimal hips;
    @Column(precision = 8, scale = 2) private BigDecimal arm;
    @Column(precision = 5, scale = 2) private BigDecimal bodyFatPercentage;
}
