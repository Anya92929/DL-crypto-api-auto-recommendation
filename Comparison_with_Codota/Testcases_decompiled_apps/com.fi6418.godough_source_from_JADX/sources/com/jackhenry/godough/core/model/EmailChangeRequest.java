package com.jackhenry.godough.core.model;

public class EmailChangeRequest {
    private String customerEmail;
    private String requestToken;

    public EmailChangeRequest(String str) {
        this.customerEmail = str;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setCustomerEmail(String str) {
        this.customerEmail = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
