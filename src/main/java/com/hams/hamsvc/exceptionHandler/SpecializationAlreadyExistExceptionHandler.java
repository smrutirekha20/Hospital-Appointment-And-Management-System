package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.DuplicateSpecializationException;
import com.hams.hamsvc.exception.SpecializationNotFoundException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpecializationAlreadyExistExceptionHandler {
    @Autowired
    private AppResponseBuilder appResponseBuilder;
    @ExceptionHandler({SpecializationNotFoundException.class, DuplicateSpecializationException.class})
    public ResponseEntity<ErrorStructure<String>> handleSpecializationException(SpecializationNotFoundException ex){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Required Specialization is already present");
    }
}
