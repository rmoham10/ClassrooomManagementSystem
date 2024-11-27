package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
