package com.jarvisworkshop.StudyWithJarvis.controllers;

import com.jarvisworkshop.StudyWithJarvis.dto.UserRegistrationDto;
import com.jarvisworkshop.StudyWithJarvis.entities.UserRegistration;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.DataNotFoundException;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.InternalServerError;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.UnauthorizedException;
import com.jarvisworkshop.StudyWithJarvis.services.UserRegisterationService;
import com.jarvisworkshop.StudyWithJarvis.utilities.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Value("${token}")
    private String token;
    @Autowired
    private UserRegisterationService userRegisterationService;

    @PostMapping("/registration")
    public ResponseEntity<Object> enrollUser(@Valid @RequestBody UserRegistrationDto userRegistration, @RequestHeader String token) {

        if (!token.equals(this.token)) {
            System.out.println("Token is invalid");
            throw new UnauthorizedException("You are unauthorized to access the requested API");
        }

        try{
                UserRegistration user = userRegisterationService.saveUserData(userRegistration);
                ResponseHandler<UserRegistration>  response= new ResponseHandler<>(user,200,"Reuest was successful", LocalDateTime.now());
                return new ResponseEntity(response, HttpStatus.OK);

        }catch (Exception e){
            throw new InternalServerError(e.getMessage());
        }

    }

    @GetMapping("/getUsersData")
    public ResponseEntity<Object> getAllUsersData(@RequestHeader String token){
        if (!token.equals(this.token)) {
            System.out.println("Token is invalid");
            throw new UnauthorizedException("You are unauthorized to access the requested API");
        }

        try{
            List<UserRegistration> users = userRegisterationService.getRegisterUsersData();
            ResponseHandler<List<UserRegistration>>  response= new ResponseHandler<>(users,200,"Reuest was successful", LocalDateTime.now());
            return new ResponseEntity(response, HttpStatus.OK);

        }catch(DataNotFoundException e){
            throw new DataNotFoundException(e.getMessage());
        }
        catch (Exception e){
            throw new InternalServerError(e.getMessage());
        }
    }

}
