package com.jarvisworkshop.StudyWithJarvis.services;

import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadNotesService {

    String uploadNotes(String subject, String topic, String heading, String content, MultipartFile[] images);
}
