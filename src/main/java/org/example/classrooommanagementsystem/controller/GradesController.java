package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Grades;
import org.example.classrooommanagementsystem.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradesController {
    private final GradesService gradeService;

    @Autowired
    public GradesController(GradesService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<Grades>> getAllGrades() {
        List<Grades> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grades> getGradeById(@PathVariable Long id) {
        Optional<Grades> grade = gradeService.getGradeById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Grades> createGrade(@RequestBody Grades grade) {
        Grades savedGrade = gradeService.createGrade(grade);
        return ResponseEntity.ok(savedGrade);
    }
}
