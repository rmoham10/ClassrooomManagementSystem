package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Grades;
import org.example.classrooommanagementsystem.repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {
    private final GradesRepository gradeRepository;

    @Autowired
    public GradesService(GradesRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grades> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grades> getGradeById(Long gradeId) {
        return gradeRepository.findById(gradeId);
    }

    public Grades createGrade(Grades grade) {
        return gradeRepository.save(grade);
    }
}
