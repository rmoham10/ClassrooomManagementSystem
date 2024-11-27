package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Courses;
import org.example.classrooommanagementsystem.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    private final CoursesRepository courseRepository;

    @Autowired
    public CoursesService(CoursesRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Courses> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }
}
