package com.jarvisworkshop.StudyWithJarvis.controllers;

import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.DataNotFoundException;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.InternalServerError;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.UnauthorizedException;
import com.jarvisworkshop.StudyWithJarvis.services.UploadNotesService;
import com.jarvisworkshop.StudyWithJarvis.services.UserRegisterationService;
import com.jarvisworkshop.StudyWithJarvis.utilities.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/note")
public class NoteController {

    @Value("${token}")
    private String token;

    @Autowired
    private UploadNotesService uploadNotesService;

    @PostMapping("/createNote")
    public ResponseEntity<Object> createNoteWithImages(
            @RequestParam String subject,
            @RequestParam String topic,
            @RequestParam String heading,
            @RequestParam String content,
            @RequestBody MultipartFile[] images,
            @RequestHeader String token

    ){
        if (!token.equals(this.token)) {
            System.out.println("Token is invalid");
            throw new UnauthorizedException("You are unauthorized to access the requested API");
        }

        try{

            String notesSatus = uploadNotesService.uploadNotes(subject,topic,heading,content,images);
            ResponseHandler<String> response= new ResponseHandler<>(notesSatus,200,"Reuest was successful", LocalDateTime.now());
            return new ResponseEntity(response, HttpStatus.OK);

        }catch(DataNotFoundException e){
            throw new DataNotFoundException(e.getMessage());
        }
        catch (Exception e){
            throw new InternalServerError(e.getMessage());
        }
    }
}
