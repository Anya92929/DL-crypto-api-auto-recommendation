package com.jackhenry.godough.core.model;

public class ErrorMessage implements GoDoughType {
    private boolean isBlocked;
    private String message;

    public String getMessage() {
        return this.message;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
