package org.scribe.builder.api;

import org.scribe.model.Token;

public class LinkedInApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authorize?oauth_token=%s";

    public String getAccessTokenEndpoint() {
        return "https://api.linkedin.com/uas/oauth/accessToken";
    }

    public String getRequestTokenEndpoint() {
        return "https://api.linkedin.com/uas/oauth/requestToken";
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, new Object[]{requestToken.getToken()});
    }
}
