package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementsRepository extends JpaRepository<Announcements, Long> {
}
