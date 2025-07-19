package com.jarvisworkshop.StudyWithJarvis.services.implementations;

import com.jarvisworkshop.StudyWithJarvis.services.UploadNotesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadNotesServiceImpl implements UploadNotesService {

    @Transactional
    @Override
    public String uploadNotes(String subject, String topic, String heading, String content, MultipartFile[] images) {
        return null;
    }
}
