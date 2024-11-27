package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Attendance;
import org.example.classrooommanagementsystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }

    public Attendance createAttendanceRecord(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
