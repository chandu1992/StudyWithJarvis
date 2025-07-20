package com.jarvisworkshop.StudyWithJarvis.repositories;

import com.jarvisworkshop.StudyWithJarvis.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepo extends JpaRepository<Subject,Long> {
    Optional<Subject> findByName(String subject);
}
