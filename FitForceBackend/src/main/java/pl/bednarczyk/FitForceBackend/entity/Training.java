package pl.bednarczyk.FitForceBackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Exercises> exercises;

    public Training(String name) {
        this.name = name;
    }
}

