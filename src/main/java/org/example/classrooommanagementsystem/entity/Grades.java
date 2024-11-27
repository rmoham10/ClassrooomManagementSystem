package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Grades")
@Getter
@Setter
@NoArgsConstructor
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeID;

    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Courses course;

    @Column(nullable = false)
    private int marks;

    @Column(nullable = false)
    private String gradeType;

    @Column(nullable = false)
    private LocalDate gradeDate = LocalDate.now();
}
