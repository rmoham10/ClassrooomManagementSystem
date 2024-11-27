package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
