package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Notifications;
import org.example.classrooommanagementsystem.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {
    private final NotificationsService notificationService;

    @Autowired
    public NotificationsController(NotificationsService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<Notifications>> getAllNotifications() {
        List<Notifications> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationById(@PathVariable Long id) {
        Optional<Notifications> notification = notificationService.getNotificationById(id);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notifications> createNotification(@RequestBody Notifications notification) {
        Notifications savedNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(savedNotification);
    }
}
