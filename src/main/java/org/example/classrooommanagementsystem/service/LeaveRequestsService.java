package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.LeaveRequests;
import org.example.classrooommanagementsystem.entity.Parents;
import org.example.classrooommanagementsystem.entity.Students;
import org.example.classrooommanagementsystem.repository.LeaveRequestsRepository;
import org.example.classrooommanagementsystem.repository.ParentsRepository;
import org.example.classrooommanagementsystem.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestsService {
    private final LeaveRequestsRepository leaveRequestRepository;
    private final ParentsRepository parentsRepository;
    private final StudentsRepository studentsRepository;

    @Autowired
    public LeaveRequestsService(LeaveRequestsRepository leaveRequestRepository,
                                ParentsRepository parentsRepository,
                                StudentsRepository studentsRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.parentsRepository = parentsRepository;
        this.studentsRepository = studentsRepository;
    }

    // Get all leave requests
    public List<LeaveRequests> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Get leave request by ID
    public Optional<LeaveRequests> getLeaveRequestById(Long leaveRequestId) {
        return leaveRequestRepository.findById(leaveRequestId);
    }

    // Create leave request and link to parent and student
    public LeaveRequests createLeaveRequest(LeaveRequests leaveRequest, String username) {
        Parents parent = parentsRepository.findByUserUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("Parent not found"));

        leaveRequest.setParent(parent);

        // Assuming parent has one child for simplicity
        Students student = parent.getStudents().get(0);
        leaveRequest.setStudent(student);

        leaveRequest.setStatus("Pending");
        leaveRequest.setCreatedAt(LocalDateTime.now());
        return leaveRequestRepository.save(leaveRequest);
    }

    // Update leave request status
    public void updateLeaveRequestStatus(Long id, String status) {
        LeaveRequests leaveRequest = leaveRequestRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Leave request not found"));

        leaveRequest.setStatus(status);
        if ("Approved".equalsIgnoreCase(status)) {
            leaveRequest.setApprovedAt(LocalDateTime.now());
        }
        leaveRequestRepository.save(leaveRequest);
    }
}
