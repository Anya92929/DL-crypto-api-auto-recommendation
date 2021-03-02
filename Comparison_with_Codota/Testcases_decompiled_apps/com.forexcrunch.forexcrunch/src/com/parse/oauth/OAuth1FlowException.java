package com.parse.oauth;

public class OAuth1FlowException extends Exception {
    private static final long serialVersionUID = 4272662026279290823L;
    private final String description;
    private final int errorCode;
    private final String failingUrl;

    public OAuth1FlowException(int errorCode2, String description2, String failingUrl2) {
        super(String.format("OAuth Flow Error %d: Url: %s Description: %s", new Object[]{Integer.valueOf(errorCode2), failingUrl2, description2}));
        this.errorCode = errorCode2;
        this.description = description2;
        this.failingUrl = failingUrl2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }
}
