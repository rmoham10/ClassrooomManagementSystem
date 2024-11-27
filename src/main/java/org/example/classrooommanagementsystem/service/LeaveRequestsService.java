package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.LeaveRequests;
import org.example.classrooommanagementsystem.repository.LeaveRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestsService {
    private final LeaveRequestsRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestsService(LeaveRequestsRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public List<LeaveRequests> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequests> getLeaveRequestById(Long leaveRequestId) {
        return leaveRequestRepository.findById(leaveRequestId);
    }

    public LeaveRequests createLeaveRequest(LeaveRequests leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }
}
