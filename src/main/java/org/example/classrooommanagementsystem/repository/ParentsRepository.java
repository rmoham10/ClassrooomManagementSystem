package org.example.classrooommanagementsystem.repository;

import org.example.classrooommanagementsystem.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentsRepository extends JpaRepository<Parents, Long> {
    Optional<Parents> findByUserUsername(String username); // Find parent by associated user's username
}
