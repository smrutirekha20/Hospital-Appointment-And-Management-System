package com.hams.hamsvc.exceptionHandler;
import com.hams.hamsvc.exception.UserNameNotFoundException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserNotFoundExceptionHandler {

    private AppResponseBuilder appResponseBuilder;
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundException(UserNameNotFoundException ex){
        return appResponseBuilder.error(HttpStatus.CONFLICT, ex.getMessage(), "User not found");
    }

}
