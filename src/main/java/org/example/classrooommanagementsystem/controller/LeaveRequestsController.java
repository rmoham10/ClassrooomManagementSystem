package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.LeaveRequests;
import org.example.classrooommanagementsystem.service.LeaveRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestsController {
    private final LeaveRequestsService leaveRequestService;

    @Autowired
    public LeaveRequestsController(LeaveRequestsService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequests>> getAllLeaveRequests() {
        List<LeaveRequests> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return ResponseEntity.ok(leaveRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequests> getLeaveRequestById(@PathVariable Long id) {
        Optional<LeaveRequests> leaveRequest = leaveRequestService.getLeaveRequestById(id);
        return leaveRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LeaveRequests> createLeaveRequest(@RequestBody LeaveRequests leaveRequest) {
        LeaveRequests savedLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
        return ResponseEntity.ok(savedLeaveRequest);
    }
}
