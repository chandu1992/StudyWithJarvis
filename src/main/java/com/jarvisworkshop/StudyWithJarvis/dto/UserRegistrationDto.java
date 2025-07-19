package com.jarvisworkshop.StudyWithJarvis.dto;

import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UserRegistrationDto {

    @NotNull(message = "Name is mandatory")
    private String fullName;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "\\d{10}",message = "Phone number should be 10 digits")
    private String mobileNo;
    @NotBlank
    private String gender;
    @Size(min=6, message = "Password must be at least 8 characters")
    private String username;
    @Size(min=8, message = "Password must be at least 8 characters")
    private String password;
    private String role;
    @NotBlank
    private String profilePiture;

    @NotNull(message = "isActive is required")
    private Boolean isActive;

    @NotBlank
    private String subcriptionStatus;

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getProfilePiture() {
        return profilePiture;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getSubcriptionStatus() {
        return subcriptionStatus;
    }
}
