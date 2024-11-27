package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;

    @ManyToOne
    @JoinColumn(name = "classID", nullable = false)
    private Classes classes;

    @OneToOne
    @JoinColumn(name = "userID", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "parentID", nullable = false)
    private Users parent;
}
