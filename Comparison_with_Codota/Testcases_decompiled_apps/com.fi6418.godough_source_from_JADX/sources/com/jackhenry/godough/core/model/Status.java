package com.jackhenry.godough.core.model;

public class Status implements GoDoughType {
    private String confirmationNumber;
    private String message;

    public Status(String str) {
        this.message = str;
    }

    public String getConfirmationNumber() {
        return this.confirmationNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public void setConfirmationNumber(String str) {
        this.confirmationNumber = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
