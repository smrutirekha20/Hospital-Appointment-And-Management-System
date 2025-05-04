package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.DoctorNotFoundException;
import com.hams.hamsvc.exception.EmailAlreadyExistsException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoctorExceptionHandler {
    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleDoctor(DoctorNotFoundException ex){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Doctor not found");
    }
}
