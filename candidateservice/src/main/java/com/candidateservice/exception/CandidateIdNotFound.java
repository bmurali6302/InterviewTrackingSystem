package com.candidateservice.exception;

public class CandidateIdNotFound extends RuntimeException{
    String message;

    public CandidateIdNotFound(String message) {

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
