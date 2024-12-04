package com.employeeservice.globalhandler;

import com.employeeservice.exception.EmployeeIdNotFound;
import com.employeeservice.exception.EmployeeAlreadyExist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice

public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler {
    ApiError apiError = new ApiError();
    @ExceptionHandler({EmployeeIdNotFound.class,EmployeeAlreadyExist.class})

    public ResponseEntity<?> handleExceptions(Exception e){
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        apiError.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
