package com.panelmemberservice.exception;

public class PanelTypeMisMatchException  extends RuntimeException  {
    public PanelTypeMisMatchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;


}
