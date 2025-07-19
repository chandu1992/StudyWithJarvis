package com.jarvisworkshop.StudyWithJarvis.services.implementations;

import com.jarvisworkshop.StudyWithJarvis.dto.UserRegistrationDto;
import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.DataNotFoundException;
import com.jarvisworkshop.StudyWithJarvis.repositories.UserRegisterationRepo;
import com.jarvisworkshop.StudyWithJarvis.services.UserRegisterationService;
import com.jarvisworkshop.StudyWithJarvis.utilities.ResponseHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegisterationService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRegisterationRepo userRegisterationRepo;
    @Override
    public UserRegistration saveUserData(UserRegistrationDto userRegistrationDto) {

        UserRegistration user = new UserRegistration();

        user.setUserActive(userRegistrationDto.getIsActive());
        user.setEmail(userRegistrationDto.getEmail());
        user.setGender(userRegistrationDto.getGender());
        user.setRole(userRegistrationDto.getRole());
        user.setFullName(userRegistrationDto.getFullName());
        user.setPassword(userRegistrationDto.getPassword());
        user.setMobileNo(userRegistrationDto.getMobileNo());
        user.setSubcriptionStatus(userRegistrationDto.getSubcriptionStatus());
        user.setProfilePiture(userRegistrationDto.getProfilePiture());
        user.setUsername(userRegistrationDto.getUsername());

        return userRegisterationRepo.save(user);
    }

    @Override
    public List<UserRegistration> getRegisterUsersData() {
        return Optional.of(userRegisterationRepo.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new DataNotFoundException("Users not found"));

    }
}
