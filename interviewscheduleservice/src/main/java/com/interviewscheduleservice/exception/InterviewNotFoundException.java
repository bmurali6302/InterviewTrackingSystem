package com.interviewscheduleservice.exception;

public class InterviewNotFoundException extends RuntimeException{
    String message;

    public InterviewNotFoundException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
