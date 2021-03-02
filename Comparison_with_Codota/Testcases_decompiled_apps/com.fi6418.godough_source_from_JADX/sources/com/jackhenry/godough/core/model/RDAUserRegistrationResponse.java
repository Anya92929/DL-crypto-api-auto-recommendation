package com.jackhenry.godough.core.model;

public class RDAUserRegistrationResponse implements GoDoughType, RDAUserStatusCodes {
    private String Status;
    private String message;
    private boolean success;
    private RDAVelocity velocity;

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.Status;
    }

    public RDAVelocity getVelocity() {
        return this.velocity;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.Status = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setVelocity(RDAVelocity rDAVelocity) {
        this.velocity = rDAVelocity;
    }
}
