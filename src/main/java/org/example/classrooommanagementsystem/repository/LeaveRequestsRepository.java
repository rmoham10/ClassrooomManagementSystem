package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.LeaveRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestsRepository extends JpaRepository<LeaveRequests, Long> {
}
