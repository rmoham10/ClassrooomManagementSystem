package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Teachers;
import org.example.classrooommanagementsystem.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {
    private final TeachersRepository teacherRepository;

    @Autowired
    public TeachersService(TeachersRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teachers> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teachers> getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);
    }

    public Teachers createTeacher(Teachers teacher) {
        return teacherRepository.save(teacher);
    }
}
