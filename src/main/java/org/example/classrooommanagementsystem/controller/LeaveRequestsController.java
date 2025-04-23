package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.LeaveRequests;
import org.example.classrooommanagementsystem.service.LeaveRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestsController {
    private final LeaveRequestsService leaveRequestService;

    @Autowired
    public LeaveRequestsController(LeaveRequestsService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    // Get all leave requests
    @GetMapping
    public ResponseEntity<List<LeaveRequests>> getAllLeaveRequests() {
        List<LeaveRequests> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return ResponseEntity.ok(leaveRequests);
    }

    // Get leave request by ID
    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequests> getLeaveRequestById(@PathVariable Long id) {
        Optional<LeaveRequests> leaveRequest = leaveRequestService.getLeaveRequestById(id);
        return leaveRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create leave request (Parent submission)
    @PostMapping
    public ResponseEntity<LeaveRequests> createLeaveRequest(@RequestBody LeaveRequests leaveRequest, Principal principal) {
        try {
            LeaveRequests savedLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest, principal.getName());
            return ResponseEntity.ok(savedLeaveRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update leave request status (Admin approval/rejection)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateLeaveRequestStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String status = body.get("status");
            leaveRequestService.updateLeaveRequestStatus(id, status);
            return ResponseEntity.ok("Leave request updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
