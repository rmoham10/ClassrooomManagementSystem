package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Parents;
import org.example.classrooommanagementsystem.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
public class ParentsController {

    @Autowired
    private ParentsService parentsService;

    // Create a parent
    @PostMapping("/create")
    public ResponseEntity<?> createParent(@RequestBody Parents parent) {
        try {
            Parents savedParent = parentsService.createParent(parent);
            return ResponseEntity.ok(savedParent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Assign a student to a parent
    @PostMapping("/assign-student")
    public ResponseEntity<?> assignStudentToParent(@RequestParam Long parentId, @RequestParam Long studentId) {
        try {
            parentsService.assignStudentToParent(parentId, studentId);
            return ResponseEntity.ok("Student assigned to parent successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get a parent by username
    @GetMapping("/by-username")
    public ResponseEntity<?> getParentByUsername(@RequestParam String username) {
        Optional<Parents> parent = parentsService.getParentByUsername(username);
        return parent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
