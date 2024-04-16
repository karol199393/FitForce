package pl.bednarczyk.FitForceBackend.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "trainings")
@RequiredArgsConstructor
public class Trainings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainings_seq_gen")
    @SequenceGenerator(name="trainings_seq_gen", sequenceName = "trainings_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "level")
    private String level;
    @Column(name = "duration")
    private String duration;
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "exercises")
    private String exercises;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "trainer")
    private String trainer;
    @Column(name = "category")
    private String category;
    @Column(name = "calories")
    private String calories;
    @Column(name = "comments")
    private String comments;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "location")
    private String location;
    @Column(name = "price")
    private String price;
    @Column(name = "status")
    private String status;
    @Column(name = "participants")
    private String participants;
    @Column(name = "maxParticipants")
    private String maxParticipants;
    @Column(name = "rating")
    private String rating;
    @Column(name = "reviews")
    private String reviews;
    @Column(name = "trainerId")
    private String trainerId;
    @Column(name = "quality")
    private String quality;
    @Column(name = "progress")
    private String progress;
    @ManyToOne
    @JoinColumn(name = "training_goal_id") // Ustawienie kolumny, która mapuje relację
    private TrainingGoals trainingGoal; // Dodanie właściwości trainingGoal

}
