package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Classes;
import org.example.classrooommanagementsystem.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {
    private final ClassesRepository classRoomRepository;

    @Autowired
    public ClassesService(ClassesRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public List<Classes> getAllClasses() {
        return classRoomRepository.findAll();
    }

    public Optional<Classes> getClassById(Long classId) {
        return classRoomRepository.findById(classId);
    }

    public Classes createClass(Classes classRoom) {
        return classRoomRepository.save(classRoom);
    }
}
