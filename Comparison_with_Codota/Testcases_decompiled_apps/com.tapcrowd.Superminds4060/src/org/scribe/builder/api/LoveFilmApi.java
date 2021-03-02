package org.scribe.builder.api;

import org.scribe.model.Token;

public class LoveFilmApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://openapi.lovefilm.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://www.lovefilm.com/activate?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://openapi.lovefilm.com/oauth/request_token";

    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, new Object[]{requestToken.getToken()});
    }
}
