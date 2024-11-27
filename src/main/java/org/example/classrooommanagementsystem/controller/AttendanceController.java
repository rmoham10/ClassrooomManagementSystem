package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Attendance;
import org.example.classrooommanagementsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendanceRecords() {
        List<Attendance> attendanceRecords = attendanceService.getAllAttendanceRecords();
        return ResponseEntity.ok(attendanceRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(id);
        return attendance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Attendance> createAttendanceRecord(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.createAttendanceRecord(attendance);
        return ResponseEntity.ok(savedAttendance);
    }
}
