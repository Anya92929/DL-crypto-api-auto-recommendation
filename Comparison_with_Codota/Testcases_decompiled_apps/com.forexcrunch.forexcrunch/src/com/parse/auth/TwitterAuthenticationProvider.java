package com.parse.auth;

import android.content.Context;
import com.parse.auth.ParseAuthenticationProvider;
import com.parse.internal.AsyncCallback;
import com.parse.twitter.Twitter;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterAuthenticationProvider implements ParseAuthenticationProvider {
    private static final String AUTH_TOKEN_KEY = "auth_token";
    private static final String AUTH_TOKEN_SECRET_KEY = "auth_token_secret";
    private static final String CONSUMER_KEY_KEY = "consumer_key";
    private static final String CONSUMER_SECRET_KEY = "consumer_secret";
    private static final String ID_KEY = "id";
    private static final String SCREEN_NAME_KEY = "screen_name";
    private WeakReference<Context> baseContext;
    /* access modifiers changed from: private */
    public ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
    /* access modifiers changed from: private */
    public final Twitter twitter;

    public TwitterAuthenticationProvider(Twitter twitter2) {
        this.twitter = twitter2;
    }

    public void authenticate(final ParseAuthenticationProvider.ParseAuthenticationCallback callback) {
        if (this.currentOperationCallback != null) {
            cancel();
        }
        this.currentOperationCallback = callback;
        Context context = this.baseContext == null ? null : (Context) this.baseContext.get();
        if (context == null) {
            throw new IllegalStateException("Context must be non-null for Twitter authentication to proceed.");
        }
        this.twitter.authorize(context, new AsyncCallback() {
            public void onCancel() {
                TwitterAuthenticationProvider.this.handleCancel(callback);
            }

            public void onFailure(Throwable error) {
                if (TwitterAuthenticationProvider.this.currentOperationCallback == callback) {
                    try {
                        callback.onError(error);
                    } finally {
                        TwitterAuthenticationProvider.this.currentOperationCallback = null;
                    }
                }
            }

            public void onSuccess(Object result) {
                if (TwitterAuthenticationProvider.this.currentOperationCallback == callback) {
                    try {
                        callback.onSuccess(TwitterAuthenticationProvider.this.getAuthData(TwitterAuthenticationProvider.this.twitter.getUserId(), TwitterAuthenticationProvider.this.twitter.getScreenName(), TwitterAuthenticationProvider.this.twitter.getAuthToken(), TwitterAuthenticationProvider.this.twitter.getAuthTokenSecret()));
                    } catch (JSONException e) {
                        callback.onError(e);
                    } finally {
                        TwitterAuthenticationProvider.this.currentOperationCallback = null;
                    }
                }
            }
        });
    }

    public JSONObject getAuthData(String userId, String screenName, String authToken, String authTokenSecret) throws JSONException {
        JSONObject authData = new JSONObject();
        authData.put(AUTH_TOKEN_KEY, authToken);
        authData.put(AUTH_TOKEN_SECRET_KEY, authTokenSecret);
        authData.put(ID_KEY, userId);
        authData.put(SCREEN_NAME_KEY, screenName);
        authData.put(CONSUMER_KEY_KEY, this.twitter.getConsumerKey());
        authData.put(CONSUMER_SECRET_KEY, this.twitter.getConsumerSecret());
        return authData;
    }

    public void cancel() {
        handleCancel(this.currentOperationCallback);
    }

    public void deauthenticate() {
        this.twitter.setAuthToken((String) null);
        this.twitter.setAuthTokenSecret((String) null);
        this.twitter.setScreenName((String) null);
        this.twitter.setUserId((String) null);
    }

    public String getAuthType() {
        return "twitter";
    }

    public Twitter getTwitter() {
        return this.twitter;
    }

    /* access modifiers changed from: private */
    public void handleCancel(ParseAuthenticationProvider.ParseAuthenticationCallback callback) {
        if (this.currentOperationCallback == callback && callback != null) {
            try {
                callback.onCancel();
            } finally {
                this.currentOperationCallback = null;
            }
        }
    }

    public boolean restoreAuthentication(JSONObject authData) {
        if (authData == null) {
            this.twitter.setAuthToken((String) null);
            this.twitter.setAuthTokenSecret((String) null);
            this.twitter.setScreenName((String) null);
            this.twitter.setUserId((String) null);
            return true;
        }
        try {
            this.twitter.setAuthToken(authData.getString(AUTH_TOKEN_KEY));
            this.twitter.setAuthTokenSecret(authData.getString(AUTH_TOKEN_SECRET_KEY));
            this.twitter.setUserId(authData.getString(ID_KEY));
            this.twitter.setScreenName(authData.getString(SCREEN_NAME_KEY));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setContext(Context context) {
        this.baseContext = new WeakReference<>(context);
    }
}
