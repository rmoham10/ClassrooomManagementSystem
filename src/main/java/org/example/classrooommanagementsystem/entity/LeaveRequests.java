package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "LeaveRequests")
@Getter
@Setter
@NoArgsConstructor
public class LeaveRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveRequestID;

    @ManyToOne
    @JoinColumn(name = "parentID", nullable = false)
    private Users parent;

    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    private Students student;

    @Column(nullable = false)
    private String leaveDetails;

    @Column(nullable = false)
    private LocalDate leaveDate;

    @Column(nullable = false)
    private String status = "Pending";

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime approvedAt;
}
