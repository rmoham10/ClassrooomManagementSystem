package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
}
