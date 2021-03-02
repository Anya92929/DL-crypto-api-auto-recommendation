package com.parse.auth;

import com.parse.auth.ParseAuthenticationProvider;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class AnonymousAuthenticationProvider implements ParseAuthenticationProvider {
    public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback callback) {
        try {
            callback.onSuccess(getAuthData());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getAuthData() throws JSONException {
        JSONObject authData = new JSONObject();
        authData.put("id", UUID.randomUUID());
        return authData;
    }

    public void deauthenticate() {
    }

    public boolean restoreAuthentication(JSONObject authData) {
        return true;
    }

    public void cancel() {
    }

    public String getAuthType() {
        return "anonymous";
    }
}
