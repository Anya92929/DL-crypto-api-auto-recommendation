package com.jackhenry.godough.core.model;

public class RDARegistrationTermsResponse implements GoDoughType {
    private String message;
    private boolean showRegistrationMessage = false;
    private boolean success;
    private boolean tAndCCollect = false;
    private RDAVerificationStatusResponse velocity;

    public String getMessage() {
        return this.message;
    }

    public RDAVerificationStatusResponse getRdaUserStatusResponse() {
        return this.velocity;
    }

    public boolean isShowRegistrationMessage() {
        return this.showRegistrationMessage;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isTandCCollect() {
        return this.tAndCCollect;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRdaUserStatusResponse(RDAVerificationStatusResponse rDAVerificationStatusResponse) {
        this.velocity = rDAVerificationStatusResponse;
    }

    public void setShowRegistrationMessage(boolean z) {
        this.showRegistrationMessage = z;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTandCCollect(boolean z) {
        this.tAndCCollect = z;
    }
}
