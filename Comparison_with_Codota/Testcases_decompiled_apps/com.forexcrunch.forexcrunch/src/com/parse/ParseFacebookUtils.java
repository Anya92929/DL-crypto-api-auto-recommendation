package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.Session;
import com.facebook.android.Facebook;
import com.parse.auth.FacebookAuthenticationProvider;
import com.parse.auth.ParseAuthenticationProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class ParseFacebookUtils {
    private static boolean isInitialized;
    /* access modifiers changed from: private */
    public static FacebookAuthenticationProvider provider;

    private ParseFacebookUtils() {
    }

    @Deprecated
    public static Facebook getFacebook() {
        if (provider != null) {
            return provider.getFacebook();
        }
        throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getFacebook()");
    }

    public static Session getSession() {
        if (provider != null) {
            return provider.getSession();
        }
        throw new IllegalStateException("You must initialize ParseFacebookUtils before calling getSession()");
    }

    public static boolean isLinked(ParseUser user) {
        return user.getLinkedServiceNames().contains("facebook");
    }

    public static void initialize(String appId) {
        if (Parse.applicationContext == null) {
            throw new IllegalStateException("You must call Parse.initialize() before calling ParseFacebookUtils.initialize()");
        }
        provider = new FacebookAuthenticationProvider(Parse.applicationContext, appId);
        ParseUser.registerAuthenticationProvider(provider);
        isInitialized = true;
    }

    private static void checkInitialization() {
        if (!isInitialized) {
            throw new IllegalStateException("You must call ParseFacebookUtils.initialize() before using ParseFacebookUtils");
        }
    }

    public static void unlink(ParseUser user) throws ParseException {
        checkInitialization();
        Parse.waitForTask(user.unlinkFromAsync("facebook"));
    }

    public static void unlinkInBackground(ParseUser user) {
        unlinkInBackground((ParseUser) null);
    }

    public static void unlinkInBackground(ParseUser user, SaveCallback callback) {
        checkInitialization();
        Parse.callbackOnMainThreadAsync(user.unlinkFromAsync("facebook"), callback);
    }

    public static void link(ParseUser user, String facebookId, String accessToken, Date expirationDate) {
        link(user, facebookId, accessToken, expirationDate, (SaveCallback) null);
    }

    public static void link(ParseUser user, String facebookId, String accessToken, Date expirationDate, SaveCallback callback) {
        checkInitialization();
        try {
            Parse.callbackOnMainThreadAsync(user.linkWithAsync(provider.getAuthType(), provider.getAuthData(facebookId, accessToken, expirationDate)), callback);
        } catch (JSONException e) {
            if (callback != null) {
                callback.internalDone((Void) null, new ParseException(e));
            }
        }
    }

    public static void link(ParseUser user, Collection<String> permissions, Activity activity, int activityCode, SaveCallback callback) {
        checkInitialization();
        provider.setActivity(activity);
        provider.setActivityCode(activityCode);
        if (permissions == null) {
            permissions = Collections.emptyList();
        }
        provider.setPermissions(permissions);
        Parse.callbackOnMainThreadAsync(user.linkWithAsync(provider.getAuthType()), callback, true);
    }

    public static void link(ParseUser user, Collection<String> permissions, Activity activity, SaveCallback callback) {
        link(user, permissions, activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, callback);
    }

    public static void link(ParseUser user, Collection<String> permissions, Activity activity, int activityCode) {
        link(user, permissions, activity, activityCode, (SaveCallback) null);
    }

    public static void link(ParseUser user, Collection<String> permissions, Activity activity) {
        link(user, permissions, activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, (SaveCallback) null);
    }

    public static void link(ParseUser user, Activity activity, int activityCode, SaveCallback callback) {
        link(user, (Collection<String>) Collections.emptyList(), activity, activityCode, callback);
    }

    public static void link(ParseUser user, Activity activity, SaveCallback callback) {
        link(user, (Collection<String>) Collections.emptyList(), activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, callback);
    }

    public static void link(ParseUser user, Activity activity, int activityCode) {
        link(user, (Collection<String>) Collections.emptyList(), activity, activityCode, (SaveCallback) null);
    }

    public static void link(ParseUser user, Activity activity) {
        link(user, (Collection<String>) Collections.emptyList(), activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, (SaveCallback) null);
    }

    public static void logIn(String facebookId, String accessToken, Date expirationDate, LogInCallback callback) {
        checkInitialization();
        try {
            Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType(), provider.getAuthData(facebookId, accessToken, expirationDate)), callback);
        } catch (JSONException e) {
            if (callback != null) {
                callback.internalDone((ParseUser) null, new ParseException(e));
            }
        }
    }

    public static void logIn(Collection<String> permissions, Activity activity, int activityCode, LogInCallback callback) {
        checkInitialization();
        provider.setActivity(activity);
        provider.setActivityCode(activityCode);
        if (permissions == null) {
            permissions = Collections.emptyList();
        }
        provider.setPermissions(permissions);
        Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType()), callback, true);
    }

    public static void logIn(Activity activity, int activityCode, LogInCallback callback) {
        logIn((Collection<String>) Collections.emptyList(), activity, activityCode, callback);
    }

    public static void logIn(Collection<String> permissions, Activity activity, LogInCallback callback) {
        logIn(permissions, activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, callback);
    }

    public static void logIn(Activity activity, LogInCallback callback) {
        logIn((Collection<String>) Collections.emptyList(), activity, (int) FacebookAuthenticationProvider.DEFAULT_AUTH_ACTIVITY_CODE, callback);
    }

    public static void finishAuthentication(int requestCode, int resultCode, Intent data) {
        if (provider != null) {
            provider.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static void saveLatestSessionData(ParseUser user, SaveCallback callback) {
        checkInitialization();
        if (!isLinked(user)) {
            throw new IllegalStateException("The user must already be linked to Facebook.");
        }
        link(user, provider.getUserId(), getSession().getAccessToken(), getSession().getExpirationDate(), callback);
    }

    public static void saveLatestSessionData(ParseUser user) {
        saveLatestSessionData(user, (SaveCallback) null);
    }

    @Deprecated
    public static boolean shouldExtendAccessToken(ParseUser user) {
        return user != null && isLinked(user) && getFacebook().shouldExtendAccessToken();
    }

    @Deprecated
    public static void extendAccessToken(final ParseUser user, Context context, final SaveCallback callback) {
        checkInitialization();
        provider.extendAccessToken(context, new ParseAuthenticationProvider.ParseAuthenticationCallback() {
            public void onSuccess(JSONObject authData) {
                Parse.callbackOnMainThreadAsync(ParseUser.this.linkWithAsync(ParseFacebookUtils.provider.getAuthType(), authData), callback, true);
            }

            public void onError(Throwable error) {
                if (callback != null) {
                    callback.internalDone((Void) null, new ParseException(error));
                }
            }

            public void onCancel() {
                if (callback != null) {
                    callback.internalDone((Void) null, (ParseException) null);
                }
            }
        });
    }

    @Deprecated
    public static boolean extendAccessTokenIfNeeded(ParseUser user, Context context, SaveCallback callback) {
        if (!shouldExtendAccessToken(user)) {
            return false;
        }
        extendAccessToken(user, context, callback);
        return true;
    }

    public static final class Permissions {
        private Permissions() {
        }

        public static final class User {
            public static final String ABOUT_ME = "user_about_me";
            public static final String ACTIVITIES = "user_activities";
            public static final String BIRTHDAY = "user_birthday";
            public static final String CHECKINS = "user_checkins";
            public static final String EDUCATION_HISTORY = "user_education_history";
            public static final String EMAIL = "email";
            public static final String EVENTS = "user_events";
            public static final String GROUPS = "user_groups";
            public static final String HOMETOWN = "user_hometown";
            public static final String INTERESTS = "user_interests";
            public static final String LIKES = "user_likes";
            public static final String LOCATION = "user_location";
            public static final String NOTES = "user_notes";
            public static final String ONLINE_PRESENCE = "user_online_presence";
            public static final String PHOTOS = "user_photos";
            public static final String QUESTIONS = "user_questions";
            public static final String RELATIONSHIPS = "user_relationships";
            public static final String RELATIONSHIP_DETAILS = "user_relationship_details";
            public static final String RELIGION_POLITICS = "user_religion_politics";
            public static final String STATUS = "user_status";
            public static final String VIDEOS = "user_videos";
            public static final String WEBSITE = "user_website";
            public static final String WORK_HISTORY = "user_work_history";

            private User() {
            }
        }

        public static final class Friends {
            public static final String ABOUT_ME = "friends_about_me";
            public static final String ACTIVITIES = "friends_activities";
            public static final String BIRTHDAY = "friends_birthday";
            public static final String CHECKINS = "friends_checkins";
            public static final String EDUCATION_HISTORY = "friends_education_history";
            public static final String EVENTS = "friends_events";
            public static final String GROUPS = "friends_groups";
            public static final String HOMETOWN = "friends_hometown";
            public static final String INTERESTS = "friends_interests";
            public static final String LIKES = "friends_likes";
            public static final String LOCATION = "friends_location";
            public static final String NOTES = "friends_notes";
            public static final String ONLINE_PRESENCE = "friends_online_presence";
            public static final String PHOTOS = "friends_photos";
            public static final String QUESTIONS = "friends_questions";
            public static final String RELATIONSHIPS = "friends_relationships";
            public static final String RELATIONSHIP_DETAILS = "friends_relationship_details";
            public static final String RELIGION_POLITICS = "friends_religion_politics";
            public static final String STATUS = "friends_status";
            public static final String VIDEOS = "friends_videos";
            public static final String WEBSITE = "friends_website";
            public static final String WORK_HISTORY = "friends_work_history";

            private Friends() {
            }
        }

        public static final class Extended {
            public static final String ADS_MANAGEMENT = "ads_management";
            public static final String CREATE_EVENT = "create_event";
            public static final String MANAGE_FRIEND_LISTS = "manage_friendlists";
            public static final String MANAGE_NOTIFICATIONS = "manage_notifications";
            public static final String OFFLINE_ACCESS = "offline_access";
            public static final String PUBLISH_ACTIONS = "publish_actions";
            public static final String PUBLISH_CHECKINS = "publish_checkins";
            public static final String PUBLISH_STREAM = "publish_stream";
            public static final String READ_FRIEND_LISTS = "read_friendlists";
            public static final String READ_INSIGHTS = "read_insights";
            public static final String READ_MAILBOX = "read_mailbox";
            public static final String READ_REQUESTS = "read_requests";
            public static final String READ_STREAM = "read_stream";
            public static final String RSVP_EVENT = "rsvp_event";
            public static final String XMPP_LOGIN = "xmpp_login";

            private Extended() {
            }
        }

        public static final class Page {
            public static final String MANAGE_PAGES = "manage_pages";

            private Page() {
            }
        }
    }
}
