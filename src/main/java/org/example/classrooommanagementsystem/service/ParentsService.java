package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Parents;
import org.example.classrooommanagementsystem.entity.Students;
import org.example.classrooommanagementsystem.repository.ParentsRepository;
import org.example.classrooommanagementsystem.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentsService {

    @Autowired
    private ParentsRepository parentsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    // Create a new parent
    public Parents createParent(Parents parent) {
        return parentsRepository.save(parent);
    }

    // Assign a student to a parent
    public void assignStudentToParent(Long parentId, Long studentId) {
        Parents parent = parentsRepository.findById(parentId)
            .orElseThrow(() -> new IllegalArgumentException("Parent not found with ID: " + parentId));

        Students student = studentsRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        student.setParent(parent.getUser());
        studentsRepository.save(student);
    }

    // Get a parent by user username
    public Optional<Parents> getParentByUsername(String username) {
        return parentsRepository.findByUserUsername(username);
    }
}
