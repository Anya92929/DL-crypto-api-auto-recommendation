package com.parse.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.TokenCachingStrategy;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.parse.ParseException;
import com.parse.auth.ParseAuthenticationProvider;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAuthenticationProvider implements ParseAuthenticationProvider {
    private static final String AUTH_TYPE_NAME = "facebook";
    public static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
    private int activityCode;
    private Context applicationContext;
    private String applicationId;
    private WeakReference<Activity> baseActivity;
    /* access modifiers changed from: private */
    public ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
    private SessionDefaultAudience defaultAudience;
    private Facebook facebook;
    private Collection<String> permissions;
    private final DateFormat preciseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    private Session session;
    /* access modifiers changed from: private */
    public String userId;

    public FacebookAuthenticationProvider(Context context, String applicationId2) {
        this.preciseDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.activityCode = DEFAULT_AUTH_ACTIVITY_CODE;
        this.applicationId = applicationId2;
        if (context != null) {
            this.applicationContext = context.getApplicationContext();
        }
        if (applicationId2 != null) {
            this.facebook = new Facebook(applicationId2);
        }
    }

    @Deprecated
    public synchronized void extendAccessToken(Context context, ParseAuthenticationProvider.ParseAuthenticationCallback callback) {
        if (this.currentOperationCallback != null) {
            cancel();
        }
        this.currentOperationCallback = callback;
        if (!this.facebook.extendAccessToken(context, new Facebook.ServiceListener() {
            public void onComplete(Bundle values) {
                FacebookAuthenticationProvider.this.handleSuccess(FacebookAuthenticationProvider.this.userId);
            }

            public void onFacebookError(FacebookError e) {
                FacebookAuthenticationProvider.this.handleError(e);
            }

            public void onError(Error e) {
                FacebookAuthenticationProvider.this.handleError(e);
            }
        })) {
            handleCancel();
        }
    }

    public synchronized void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback callback) {
        if (this.currentOperationCallback != null) {
            cancel();
        }
        this.currentOperationCallback = callback;
        Activity activity = this.baseActivity == null ? null : (Activity) this.baseActivity.get();
        if (activity == null) {
            throw new IllegalStateException("Activity must be non-null for Facebook authentication to proceed.");
        }
        int activityCode2 = this.activityCode;
        this.session = new Session.Builder(activity).setApplicationId(this.applicationId).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(activity)).build();
        Session.OpenRequest openRequest = new Session.OpenRequest(activity);
        openRequest.setRequestCode(activityCode2);
        if (this.defaultAudience != null) {
            openRequest.setDefaultAudience(this.defaultAudience);
        }
        if (this.permissions != null) {
            openRequest.setPermissions(new ArrayList(this.permissions));
        }
        openRequest.setCallback(new Session.StatusCallback() {
            public void call(Session session, SessionState state, Exception exception) {
                if (state != SessionState.OPENING) {
                    if (state.isOpened()) {
                        if (FacebookAuthenticationProvider.this.currentOperationCallback != null) {
                            Request meRequest = Request.newGraphPathRequest(session, "me", new Request.Callback() {
                                public void onCompleted(Response response) {
                                    if (response.getError() == null) {
                                        FacebookAuthenticationProvider.this.handleSuccess((String) response.getGraphObject().getProperty("id"));
                                    } else if (response.getError().getException() != null) {
                                        FacebookAuthenticationProvider.this.handleError(response.getError().getException());
                                    } else {
                                        FacebookAuthenticationProvider.this.handleError(new ParseException(-1, "An error occurred while fetching the Facebook user's identity."));
                                    }
                                }
                            });
                            meRequest.getParameters().putString("fields", "id");
                            meRequest.executeAsync();
                        }
                    } else if (exception != null) {
                        FacebookAuthenticationProvider.this.handleError(exception);
                    } else {
                        FacebookAuthenticationProvider.this.handleCancel();
                    }
                }
            }
        });
        this.session.openForRead(openRequest);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Activity activity = (Activity) this.baseActivity.get();
        if (activity != null) {
            this.session.onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    public synchronized void cancel() {
        handleCancel();
    }

    public int getActivityCode() {
        return this.activityCode;
    }

    public String getAuthType() {
        return AUTH_TYPE_NAME;
    }

    public Facebook getFacebook() {
        return this.facebook;
    }

    public Session getSession() {
        return this.session;
    }

    /* access modifiers changed from: private */
    public void handleCancel() {
        if (this.currentOperationCallback != null) {
            try {
                this.currentOperationCallback.onCancel();
            } finally {
                this.currentOperationCallback = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleError(Throwable error) {
        if (this.currentOperationCallback != null) {
            try {
                this.currentOperationCallback.onError(error);
            } finally {
                this.currentOperationCallback = null;
            }
        }
    }

    public JSONObject getAuthData(String id, String accessToken, Date expiration) throws JSONException {
        JSONObject authData = new JSONObject();
        authData.put("id", id);
        authData.put("access_token", accessToken);
        authData.put("expiration_date", this.preciseDateFormat.format(expiration));
        return authData;
    }

    /* access modifiers changed from: private */
    public void handleSuccess(String userId2) {
        if (this.currentOperationCallback != null) {
            this.userId = userId2;
            try {
                try {
                    this.currentOperationCallback.onSuccess(getAuthData(userId2, this.session.getAccessToken(), this.session.getExpirationDate()));
                } finally {
                    this.currentOperationCallback = null;
                }
            } catch (JSONException e) {
                handleError(e);
            }
        }
    }

    public synchronized void setActivity(Activity activity) {
        this.baseActivity = new WeakReference<>(activity);
    }

    public synchronized void setActivityCode(int activityCode2) {
        this.activityCode = activityCode2;
    }

    public synchronized void setPermissions(Collection<String> permissions2) {
        this.permissions = permissions2;
    }

    public boolean restoreAuthentication(JSONObject authData) {
        if (authData == null) {
            if (this.facebook != null) {
                this.facebook.setAccessExpires(0);
                this.facebook.setAccessToken((String) null);
            }
            this.session = null;
            return true;
        }
        try {
            String accessToken = authData.getString("access_token");
            Date expirationDate = this.preciseDateFormat.parse(authData.getString("expiration_date"));
            if (this.facebook != null) {
                this.facebook.setAccessToken(accessToken);
                this.facebook.setAccessExpires(expirationDate.getTime());
            }
            TokenCachingStrategy tcs = new SharedPreferencesTokenCachingStrategy(this.applicationContext);
            Bundle data = tcs.load();
            TokenCachingStrategy.putToken(data, authData.getString("access_token"));
            TokenCachingStrategy.putExpirationDate(data, expirationDate);
            tcs.save(data);
            Session newSession = new Session.Builder(this.applicationContext).setApplicationId(this.applicationId).setTokenCachingStrategy(tcs).build();
            if (newSession.getState() == SessionState.CREATED_TOKEN_LOADED) {
                newSession.openForRead((Session.OpenRequest) null);
                this.session = newSession;
                Session.setActiveSession(this.session);
                return true;
            }
            this.session = null;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deauthenticate() {
        restoreAuthentication((JSONObject) null);
    }

    public String getUserId() {
        return this.userId;
    }
}
