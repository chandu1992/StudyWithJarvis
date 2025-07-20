package com.jarvisworkshop.StudyWithJarvis.services.implementations;

import com.jarvisworkshop.StudyWithJarvis.entities.Note;
import com.jarvisworkshop.StudyWithJarvis.entities.Screenshot;
import com.jarvisworkshop.StudyWithJarvis.entities.Subject;
import com.jarvisworkshop.StudyWithJarvis.entities.Topic;
import com.jarvisworkshop.StudyWithJarvis.repositories.NoteRepo;
import com.jarvisworkshop.StudyWithJarvis.repositories.ScreenshotRepo;
import com.jarvisworkshop.StudyWithJarvis.repositories.SubjectRepo;
import com.jarvisworkshop.StudyWithJarvis.repositories.TopicRepo;
import com.jarvisworkshop.StudyWithJarvis.services.UploadNotesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadNotesServiceImpl implements UploadNotesService {

    @Value("${project.image}")
    private String path;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private ScreenshotRepo screenshotRepo;

    @Transactional
    @Override
    public String uploadNotes(String subject, String topic, String heading, String content, MultipartFile[] images) {

        // Create or find subject
        Subject subjectData = subjectRepo.findByName(subject)
                .orElseGet(() -> subjectRepo.save(new Subject(subject, new ArrayList<>())));

        // Create or find topics
        Topic topicData = topicRepo.findByTopicNameAndSubject(topic, subjectData)
                .orElseGet(() -> {
                    Topic topicIs = new Topic();
                    topicIs.setTopicName(topic);
                    topicIs.setSubject(subjectData);
                    return topicRepo.save(topicIs);
                });

        // Create note
        Note note = new Note();
        note.setHeading(heading);
        note.setContent(content);
        note.setTopic(topicData);
        noteRepo.save(note);

        // Handle screenshots
        List<Screenshot> screenshotList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            Screenshot screenshot = new Screenshot();
            MultipartFile file = images[i];

            String name = file.getOriginalFilename();
            String filePath = path + File.separator + name;
            File f = new File(path);
            screenshot.setImageUrl(filePath);

            if(!f.exists()) {
                f.mkdir();
            }

            try {
                Files.copy(file.getInputStream(), Paths.get(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


//            screenshotList.add(screenshot);

            screenshot.setNote(note);
//            note.setScreenshots(screenshotList);
            screenshotRepo.save(screenshot);

        }

        return "not has been save successfully";
    }
}
