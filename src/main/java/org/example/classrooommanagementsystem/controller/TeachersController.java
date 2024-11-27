package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Teachers;
import org.example.classrooommanagementsystem.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeachersController {
    private final TeachersService teacherService;

    @Autowired
    public TeachersController(TeachersService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teachers>> getAllTeachers() {
        List<Teachers> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getTeacherById(@PathVariable Long id) {
        Optional<Teachers> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teachers> createTeacher(@RequestBody Teachers teacher) {
        Teachers savedTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(savedTeacher);
    }
}
