package com.parse;

import com.parse.auth.AnonymousAuthenticationProvider;
import org.json.JSONException;

public final class ParseAnonymousUtils {
    static final String ANONYMOUS_AUTH_TYPE = "anonymous";
    private static AnonymousAuthenticationProvider provider;

    private ParseAnonymousUtils() {
    }

    static {
        initialize();
    }

    private static void initialize() {
        if (provider == null) {
            provider = new AnonymousAuthenticationProvider();
            ParseUser.registerAuthenticationProvider(provider);
        }
    }

    public static boolean isLinked(ParseUser user) {
        return user.getLinkedServiceNames().contains(ANONYMOUS_AUTH_TYPE);
    }

    public static void logIn(LogInCallback callback) {
        Parse.callbackOnMainThreadAsync(ParseUser.logInWithAsync(provider.getAuthType()), callback);
    }

    static void lazyLogIn() {
        try {
            ParseUser.logInLazyUser(provider.getAuthType(), provider.getAuthData());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
