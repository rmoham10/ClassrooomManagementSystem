package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {
}
