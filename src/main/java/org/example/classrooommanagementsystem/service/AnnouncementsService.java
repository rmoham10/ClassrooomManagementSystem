package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Announcements;
import org.example.classrooommanagementsystem.repository.AnnouncementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementsService {
    private final AnnouncementsRepository announcementRepository;

    @Autowired
    public AnnouncementsService(AnnouncementsRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public List<Announcements> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Optional<Announcements> getAnnouncementById(Long announcementId) {
        return announcementRepository.findById(announcementId);
    }

    public Announcements createAnnouncement(Announcements announcement) {
        return announcementRepository.save(announcement);
    }


}
