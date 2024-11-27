package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Students;
import org.example.classrooommanagementsystem.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    private final StudentsRepository studentRepository;

    @Autowired
    public StudentsService(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Students> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Students createStudent(Students student) {
        return studentRepository.save(student);
    }
}
