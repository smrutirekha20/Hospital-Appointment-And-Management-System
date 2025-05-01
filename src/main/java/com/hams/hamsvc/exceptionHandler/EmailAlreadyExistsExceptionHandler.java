package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.EmailAlreadyExistsException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class EmailAlreadyExistsExceptionHandler {
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorStructure<String>> handleEmailExists(EmailAlreadyExistsException ex){
        return appResponseBuilder.error(HttpStatus.CONFLICT, ex.getMessage(), "Email already registered");
    }
}
