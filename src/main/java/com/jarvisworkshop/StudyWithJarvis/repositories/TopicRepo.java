package com.jarvisworkshop.StudyWithJarvis.repositories;

import com.jarvisworkshop.StudyWithJarvis.entities.Subject;
import com.jarvisworkshop.StudyWithJarvis.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepo extends JpaRepository<Topic,Long> {
    Optional<Topic> findByTopicNameAndSubject(String topic, Subject subjectData);
}
