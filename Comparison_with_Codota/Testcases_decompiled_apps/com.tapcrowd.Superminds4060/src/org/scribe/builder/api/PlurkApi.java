package org.scribe.builder.api;

import org.scribe.model.Token;

public class PlurkApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://www.plurk.com/OAuth/access_token";
    private static final String AUTHORIZATION_URL = "http://www.plurk.com/OAuth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://www.plurk.com/OAuth/request_token";

    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZATION_URL, new Object[]{requestToken.getToken()});
    }

    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    public class Mobile extends PlurkApi {
        private static final String AUTHORIZATION_URL = "http://www.plurk.com/m/authorize?oauth_token=%s";

        public Mobile() {
        }

        public String getAuthorizationUrl(Token requestToken) {
            return String.format(AUTHORIZATION_URL, new Object[]{requestToken.getToken()});
        }
    }
}
