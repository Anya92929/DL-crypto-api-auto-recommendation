package org.scribe.model;

import java.io.OutputStream;

public class OAuthConfig {
    private final String apiKey;
    private final String apiSecret;
    private final String callback;
    private final OutputStream debugStream;
    private final String scope;
    private final SignatureType signatureType;

    public OAuthConfig(String key, String secret) {
        this(key, secret, (String) null, (SignatureType) null, (String) null, (OutputStream) null);
    }

    public OAuthConfig(String key, String secret, String callback2, SignatureType type, String scope2, OutputStream stream) {
        this.apiKey = key;
        this.apiSecret = secret;
        this.callback = callback2;
        this.signatureType = type;
        this.scope = scope2;
        this.debugStream = stream;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public String getCallback() {
        return this.callback;
    }

    public SignatureType getSignatureType() {
        return this.signatureType;
    }

    public String getScope() {
        return this.scope;
    }

    public boolean hasScope() {
        return this.scope != null;
    }

    public void log(String message) {
        if (this.debugStream != null) {
            try {
                this.debugStream.write((message + "\n").getBytes("UTF8"));
            } catch (Exception e) {
            }
        }
    }
}
