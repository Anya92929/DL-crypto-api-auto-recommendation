package org.scribe.builder.api;

import org.scribe.model.Token;

public class DropBoxApi extends DefaultApi10a {
    public String getAccessTokenEndpoint() {
        return "https://api.dropbox.com/0/oauth/access_token";
    }

    public String getAuthorizationUrl(Token requestToken) {
        return "https://www.dropbox.com/0/oauth/authorize?oauth_token=" + requestToken.getToken();
    }

    public String getRequestTokenEndpoint() {
        return "https://api.dropbox.com/0/oauth/request_token";
    }
}
