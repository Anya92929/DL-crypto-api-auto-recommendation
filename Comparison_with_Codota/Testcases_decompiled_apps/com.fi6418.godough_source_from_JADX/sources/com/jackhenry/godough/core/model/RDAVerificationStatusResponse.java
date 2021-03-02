package com.jackhenry.godough.core.model;

public class RDAVerificationStatusResponse implements GoDoughType, RDAUserStatusCodes {
    String message;
    String status;
    RDAVelocity velocity;

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public RDAVelocity getVelocity() {
        return this.velocity;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setVelocity(RDAVelocity rDAVelocity) {
        this.velocity = rDAVelocity;
    }
}
