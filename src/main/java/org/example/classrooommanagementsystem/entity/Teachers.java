package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Teachers")
@Getter
@Setter
@NoArgsConstructor
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherID;

    @OneToOne
    @JoinColumn(name = "userID", nullable = false)
    private Users user;
}
