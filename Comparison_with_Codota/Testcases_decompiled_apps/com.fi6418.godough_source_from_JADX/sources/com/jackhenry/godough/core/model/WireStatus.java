package com.jackhenry.godough.core.model;

public class WireStatus implements GoDoughType {
    private String confirmationNumber;
    private String message;
    private boolean successful;

    public WireStatus() {
    }

    public WireStatus(boolean z, String str, String str2) {
        this.successful = z;
        this.message = str;
        this.confirmationNumber = str2;
    }

    public String getConfirmationNumber() {
        return this.confirmationNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccessful() {
        return this.successful;
    }

    public void setConfirmationNumber(String str) {
        this.confirmationNumber = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccessful(boolean z) {
        this.successful = z;
    }
}
