package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Attendance")
@Getter
@Setter
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceID;

    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Courses course;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String status;
}
