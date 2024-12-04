package com.employeeservice.exception;

public class EmployeeAlreadyExist extends RuntimeException  {
    String message;

    public EmployeeAlreadyExist(String message) {
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
