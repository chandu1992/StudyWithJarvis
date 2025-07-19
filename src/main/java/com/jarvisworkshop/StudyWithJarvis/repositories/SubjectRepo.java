package com.jarvisworkshop.StudyWithJarvis.repositories;

import com.jarvisworkshop.StudyWithJarvis.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Long> {
}
