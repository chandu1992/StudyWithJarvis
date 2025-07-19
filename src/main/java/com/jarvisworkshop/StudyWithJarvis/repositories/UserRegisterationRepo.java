package com.jarvisworkshop.StudyWithJarvis.repositories;

import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterationRepo extends JpaRepository<UserRegistration,Long> {
}
