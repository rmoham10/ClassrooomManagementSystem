package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Enrollments")
@Getter
@Setter
@NoArgsConstructor
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentID;

    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Courses course;
}
