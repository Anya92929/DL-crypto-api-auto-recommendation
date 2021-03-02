package com.jackhenry.godough.core.model;

public class CardActionStatus implements GoDoughType {
    private String message;
    private boolean wasSuccessful;

    public String getMessage() {
        return this.message;
    }

    public boolean isWasSuccessful() {
        return this.wasSuccessful;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setWasSuccessful(boolean z) {
        this.wasSuccessful = z;
    }
}
