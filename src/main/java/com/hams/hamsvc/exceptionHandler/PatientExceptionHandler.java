package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.PatientNotFoundException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientExceptionHandler {
    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handlePatientException(PatientNotFoundException ex){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"Patient not found with the given ID");
    }
}
