package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

public class GoogleApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=%s";

    public String getAccessTokenEndpoint() {
        return "https://www.google.com/accounts/OAuthGetAccessToken";
    }

    public String getRequestTokenEndpoint() {
        return "https://www.google.com/accounts/OAuthGetRequestToken";
    }

    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZATION_URL, new Object[]{requestToken.getToken()});
    }
}
