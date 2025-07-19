package com.jarvisworkshop.StudyWithJarvis.exception_handler;


import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.DataNotFoundException;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.InternalServerError;
import com.jarvisworkshop.StudyWithJarvis.exception_handler.exception.UnauthorizedException;
import com.jarvisworkshop.StudyWithJarvis.utilities.ResponseHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        ResponseHandler<Map<String, String>> response = new ResponseHandler<>(errors, 400, "Bad req", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InternalServerError.class)
    protected ResponseEntity<Object> handleInternalServerError(InternalServerError ex, WebRequest request) {
        ResponseHandler<String> response = new ResponseHandler<>(null, 500, "Internal server error :"+ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> dataNotFound(DataNotFoundException ex, WebRequest request) {
        ResponseHandler<String> response = new ResponseHandler<>(null, 404, "Data Not Found : "+ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> dataNotFound(UnauthorizedException ex, WebRequest request) {
        ResponseHandler<String> response = new ResponseHandler<>(null, 401,"Unauthorized : "+ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}
