package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Enrollments;
import org.example.classrooommanagementsystem.service.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentsController {
    private final EnrollmentsService enrollmentService;

    @Autowired
    public EnrollmentsController(EnrollmentsService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollments>> getAllEnrollments() {
        List<Enrollments> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollments> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollments> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrollments> createEnrollment(@RequestBody Enrollments enrollment) {
        Enrollments savedEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.ok(savedEnrollment);
    }
}
