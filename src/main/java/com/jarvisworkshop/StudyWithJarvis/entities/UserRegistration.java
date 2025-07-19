package com.jarvisworkshop.StudyWithJarvis.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="tbl_users_info")
@Data // combines @Getter @Setter @ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO
    private Long id ;
    private String fullName;
    private String email;
    private String mobileNo;
    private String gender;
    private String username;
    private String password;
    private String role;
    private String profilePiture;
    private Boolean userActive;
    private String subcriptionStatus;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

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

    public Boolean getUserActive() {
        return userActive;
    }

    public String getSubcriptionStatus() {
        return subcriptionStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setProfilePiture(String profilePiture) {
        this.profilePiture = profilePiture;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public void setSubcriptionStatus(String subcriptionStatus) {
        this.subcriptionStatus = subcriptionStatus;
    }


}
