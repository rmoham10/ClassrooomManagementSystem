package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Announcements;
import org.example.classrooommanagementsystem.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementsController {
    private final AnnouncementsService announcementService;

    @Autowired
    public AnnouncementsController(AnnouncementsService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<List<Announcements>> getAllAnnouncements() {
        List<Announcements> announcements = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Announcements> getAnnouncementById(@PathVariable Long id) {
        Optional<Announcements> announcement = announcementService.getAnnouncementById(id);
        return announcement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Announcements> createAnnouncement(@RequestBody Announcements announcement) {
        Announcements savedAnnouncement = announcementService.createAnnouncement(announcement);
        return ResponseEntity.ok(savedAnnouncement);
    }

}
