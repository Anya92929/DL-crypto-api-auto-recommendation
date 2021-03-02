package com.jackhenry.godough.core.model;

public class AbstractResponse {
    private String message;
    private boolean success;

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
