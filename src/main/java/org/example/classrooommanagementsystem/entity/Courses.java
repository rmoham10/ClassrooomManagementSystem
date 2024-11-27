package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    @Column(nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "teacherID", nullable = false)
    private Users teacher;

    @ManyToOne
    @JoinColumn(name = "classID", nullable = false)
    private Classes classes;
}
