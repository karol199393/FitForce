package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "trainings")
@RequiredArgsConstructor
@AllArgsConstructor
public class Trainings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainings_seq_gen")
    @SequenceGenerator(name = "trainings_seq_gen", sequenceName = "trainings_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public Trainings(String name) {
        this.name = name;
    }
}

