package org.example.classrooommanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Parents")
@Getter
@Setter
@NoArgsConstructor
public class Parents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentID;

    @OneToOne
    @JoinColumn(name = "userID", nullable = false)
    private Users user; // Links to the Users table

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Students> students; // List of associated children
}
