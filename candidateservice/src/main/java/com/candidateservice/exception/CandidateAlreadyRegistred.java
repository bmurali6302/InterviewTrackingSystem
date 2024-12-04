package com.candidateservice.exception;

public class CandidateAlreadyRegistred extends RuntimeException{
    String message;

    public CandidateAlreadyRegistred(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
