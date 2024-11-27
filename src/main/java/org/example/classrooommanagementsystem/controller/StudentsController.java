package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Students;
import org.example.classrooommanagementsystem.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentsService studentService;

    @Autowired
    public StudentsController(StudentsService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long id) {
        Optional<Students> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        Students savedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
}
