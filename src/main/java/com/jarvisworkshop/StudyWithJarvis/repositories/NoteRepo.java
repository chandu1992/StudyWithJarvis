package com.jarvisworkshop.StudyWithJarvis.repositories;

import com.jarvisworkshop.StudyWithJarvis.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Long> {
}