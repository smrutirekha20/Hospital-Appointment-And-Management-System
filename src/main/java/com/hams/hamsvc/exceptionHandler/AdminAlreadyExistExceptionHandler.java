package com.hams.hamsvc.exceptionHandler;

import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class AdminAlreadyExistExceptionHandler {
   private AppResponseBuilder appResponseBuilder;
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleEmailExists(AdminNotFoundException ex){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin Id is not exist");
    }
}
