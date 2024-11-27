package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {
}
