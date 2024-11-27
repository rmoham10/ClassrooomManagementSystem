package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Notifications;
import org.example.classrooommanagementsystem.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationsService {
    private final NotificationsRepository notificationRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notifications> getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public Notifications createNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }
}
