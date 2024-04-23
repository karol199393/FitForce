package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainings")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Training(String name) {
        this.name = name;
    }
}

