package com.jackhenry.godough.core.model;

public class RDARegistrationTermsRequest implements GoDoughType {
    private String RequestToken;

    public String getRequestToken() {
        return this.RequestToken;
    }

    public void setRequestToken(String str) {
        this.RequestToken = str;
    }
}
