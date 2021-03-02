package com.jackhenry.godough.core.model;

public class ACHStatus implements GoDoughType {
    private String confirmationNumber;
    private String message;
    private boolean wasBatchInitiated;

    public ACHStatus() {
    }

    public ACHStatus(boolean z, String str, String str2) {
        this.wasBatchInitiated = z;
        this.message = str;
        this.confirmationNumber = str2;
    }

    public String getConfirmationNumber() {
        return this.confirmationNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isWasBatchInitiated() {
        return this.wasBatchInitiated;
    }

    public void setConfirmationNumber(String str) {
        this.confirmationNumber = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setWasBatchInitiated(boolean z) {
        this.wasBatchInitiated = z;
    }
}
