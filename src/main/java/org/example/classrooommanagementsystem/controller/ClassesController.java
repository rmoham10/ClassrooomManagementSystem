package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Classes;
import org.example.classrooommanagementsystem.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {
    private final ClassesService classRoomService;

    @Autowired
    public ClassesController(ClassesService classesService) {
        this.classRoomService = classesService;
    }

    @GetMapping
    public ResponseEntity<List<Classes>> getAllClasses() {
        List<Classes> classes = classRoomService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classes> getClassById(@PathVariable Long id) {
        Optional<Classes> classRoom = classRoomService.getClassById(id);
        return classRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Classes> createClass(@RequestBody Classes classRoom) {
        Classes savedClass = classRoomService.createClass(classRoom);
        return ResponseEntity.ok(savedClass);
    }
}
