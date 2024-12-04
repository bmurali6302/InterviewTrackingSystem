package com.panelmemberservice.globalhandler;

import com.panelmemberservice.exception.EmployeeIdNotFound;
import com.panelmemberservice.exception.PanelTypeMisMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    ApiError apiError = new ApiError();
    @ExceptionHandler({EmployeeIdNotFound.class, PanelTypeMisMatchException.class})
    public ResponseEntity<?> handleExceptions(Exception e){
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        apiError.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}