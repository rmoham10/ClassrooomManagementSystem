package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Enrollments;
import org.example.classrooommanagementsystem.repository.EnrollmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentsService {
    private final EnrollmentsRepository enrollmentRepository;

    @Autowired
    public EnrollmentsService(EnrollmentsRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollments> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollments> getEnrollmentById(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId);
    }

    public Enrollments createEnrollment(Enrollments enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
