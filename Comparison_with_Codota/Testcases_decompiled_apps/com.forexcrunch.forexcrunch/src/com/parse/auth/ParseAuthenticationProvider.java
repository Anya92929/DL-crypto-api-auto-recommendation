package com.parse.auth;

import org.json.JSONObject;

public interface ParseAuthenticationProvider {

    public interface ParseAuthenticationCallback {
        void onCancel();

        void onError(Throwable th);

        void onSuccess(JSONObject jSONObject);
    }

    void authenticate(ParseAuthenticationCallback parseAuthenticationCallback);

    void cancel();

    void deauthenticate();

    String getAuthType();

    boolean restoreAuthentication(JSONObject jSONObject);
}
