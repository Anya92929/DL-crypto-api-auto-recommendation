package com.parse;

import android.content.Context;
import com.parse.auth.TwitterAuthenticationProvider;
import com.parse.twitter.Twitter;
import org.json.JSONException;

public final class ParseTwitterUtils {
    private static boolean isInitialized;
    private static TwitterAuthenticationProvider provider;
    private static Twitter twitter;

    private static TwitterAuthenticationProvider getAuthenticationProvider() {
        if (provider == null) {
            provider = new TwitterAuthenticationProvider(getTwitter());
        }
        return provider;
    }

    public static Twitter getTwitter() {
        if (twitter == null) {
            twitter = new Twitter("", "");
        }
        return twitter;
    }

    public static void initialize(String consumerKey, String consumerSecret) {
        getTwitter().setConsumerKey(consumerKey);
        getTwitter().setConsumerSecret(consumerSecret);
        ParseUser.registerAuthenticationProvider(getAuthenticationProvider());
        isInitialized = true;
    }

    private static void checkInitialization() {
        if (!isInitialized) {
            throw new IllegalStateException("You must call ParseTwitterUtils.initialize() before using ParseTwitterUtils");
        }
    }

    public static boolean isLinked(ParseUser user) {
        return user.getLinkedServiceNames().contains(getAuthenticationProvider().getAuthType());
    }

    public static void link(ParseUser user, Context context) {
        link(user, context, (SaveCallback) null);
    }

    public static void link(ParseUser user, Context context, SaveCallback callback) {
        checkInitialization();
        getAuthenticationProvider().setContext(context);
        Parse.callbackOnMainThreadAsync(user.linkWithAsync(getAuthenticationProvider().getAuthType()), callback, true);
    }

    public static void link(ParseUser user, String twitterId, String screenName, String authToken, String authTokenSecret) {
        link(user, twitterId, screenName, authToken, authTokenSecret, (SaveCallback) null);
    }

    public static void link(ParseUser user, String twitterId, String screenName, String authToken, String authTokenSecret, SaveCallback callback) {
        checkInitialization();
        try {
            Parse.callbackOnMainThreadAsync(user.linkWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(twitterId, screenName, authToken, authTokenSecret)), callback);
        } catch (JSONException e) {
            if (callback != null) {
                callback.internalDone((Void) null, new ParseException(e));
            }
        }
    }

    public static void logIn(String twitterId, String screenName, String authToken, String authTokenSecret, LogInCallback callback) {
        checkInitialization();
        try {
            Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(twitterId, screenName, authToken, authTokenSecret)), callback);
        } catch (JSONException e) {
            if (callback != null) {
                callback.internalDone((ParseUser) null, new ParseException(e));
            }
        }
    }

    public static void logIn(Context context, LogInCallback callback) {
        checkInitialization();
        getAuthenticationProvider().setContext(context);
        Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType()), callback, true);
    }

    public static void unlink(ParseUser user) throws ParseException {
        checkInitialization();
        Parse.waitForTask(user.unlinkFromAsync(getAuthenticationProvider().getAuthType()));
    }

    public static void unlinkInBackground(ParseUser user) {
        unlinkInBackground(user, (SaveCallback) null);
    }

    public static void unlinkInBackground(ParseUser user, SaveCallback callback) {
        checkInitialization();
        Parse.callbackOnMainThreadAsync(user.unlinkFromAsync(getAuthenticationProvider().getAuthType()), callback);
    }

    private ParseTwitterUtils() {
    }
}
