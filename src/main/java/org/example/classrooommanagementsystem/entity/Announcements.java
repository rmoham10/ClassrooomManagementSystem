package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Announcements")
@Getter
@Setter
@NoArgsConstructor
public class Announcements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementID;

    @ManyToOne
    @JoinColumn(name = "adminID", nullable = false)
    private Users admin;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
