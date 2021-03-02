package com.jackhenry.godough.core.model;

public class SelfEnrollmentRequest implements GoDoughType {
    private int carrierId;
    private boolean isReceivingTextMessages;
    private String phoneNumber;
    private String requestToken;

    public int getCarrierId() {
        return this.carrierId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public boolean isReceivingTextMessages() {
        return this.isReceivingTextMessages;
    }

    public void setCarrierId(int i) {
        this.carrierId = i;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setReceivingTextMessages(boolean z) {
        this.isReceivingTextMessages = z;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
