package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.SpecializationDeletionException;
import com.hams.hamsvc.exception.SpecializationNotFoundException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpecializationDeletionExceptionHandler {

    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(SpecializationDeletionException.class)
    public ResponseEntity<ErrorStructure<String>> handleSpecializationDeletionException(SpecializationDeletionException ex){
        return appResponseBuilder.error(HttpStatus.CONFLICT, ex.getMessage(), "Failed to delete specialization because it is assigned to one or more doctors");
    }
}
