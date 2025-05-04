package com.hams.hamsvc.exceptionHandler;
import com.hams.hamsvc.exception.NoSuchSlotAvailableException;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class SlotNotAvailableExceptionHandler {
    @Autowired
    private AppResponseBuilder appResponseBuilder;
    @ExceptionHandler(NoSuchSlotAvailableException.class)
    public ResponseEntity<ErrorStructure<String>> handleSlotNotAvailable(NoSuchSlotAvailableException ex){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Slot not available in this time");
    }
}
