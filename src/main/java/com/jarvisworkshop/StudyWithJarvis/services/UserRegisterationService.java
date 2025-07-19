package com.jarvisworkshop.StudyWithJarvis.services;

import com.jarvisworkshop.StudyWithJarvis.dto.UserRegistrationDto;
import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;

import java.util.List;

public interface UserRegisterationService {
    UserRegistration saveUserData(UserRegistrationDto userRegistration);

    List<UserRegistration> getRegisterUsersData();
}
