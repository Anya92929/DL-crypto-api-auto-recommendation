package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

public class KaixinApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://api.kaixin001.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "http://api.kaixin001.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://api.kaixin001.com/oauth/request_token";

    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, new Object[]{requestToken.getToken()});
    }

    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }
}
