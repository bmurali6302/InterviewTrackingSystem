package com.candidateservice.globalhandler;
import com.candidateservice.exception.CandidateAlreadyRegistred;
import com.candidateservice.exception.CandidateIdNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    ApiError apiError = new ApiError();
    @ExceptionHandler({CandidateAlreadyRegistred.class})
    public ResponseEntity<?> handleException(Exception ex) {
        apiError.setStatus(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        apiError.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }
    @ExceptionHandler({CandidateIdNotFound.class})
    public ResponseEntity<?> handleExceptions(Exception e){
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        apiError.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}