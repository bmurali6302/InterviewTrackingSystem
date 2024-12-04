package com.panelmemberservice.exception;

public class EmployeeIdNotFound  extends RuntimeException{
    String message;

    public EmployeeIdNotFound(String message) {

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
