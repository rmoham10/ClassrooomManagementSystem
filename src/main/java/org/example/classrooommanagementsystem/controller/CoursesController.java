package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Courses;
import org.example.classrooommanagementsystem.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CoursesService courseService;

    @Autowired
    public CoursesController(CoursesService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        Optional<Courses> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        Courses savedCourse = courseService.createCourse(course);

        return ResponseEntity.ok(savedCourse);
    }
}
