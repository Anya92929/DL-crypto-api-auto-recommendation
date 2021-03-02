package org.scribe.builder.api;

import org.scribe.model.Token;

public class NeteaseWeibooApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://api.t.163.com/oauth/access_token";
    private static final String AUTHENTICATE_URL = "http://api.t.163.com/oauth/authenticate?oauth_token=%s";
    private static final String AUTHORIZE_URL = "http://api.t.163.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://api.t.163.com/oauth/request_token";

    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, new Object[]{requestToken.getToken()});
    }

    public String getAuthenticateUrl(Token requestToken) {
        return String.format(AUTHENTICATE_URL, new Object[]{requestToken.getToken()});
    }
}
