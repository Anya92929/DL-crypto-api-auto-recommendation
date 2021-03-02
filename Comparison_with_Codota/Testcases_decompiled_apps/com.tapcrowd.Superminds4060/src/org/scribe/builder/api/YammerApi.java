package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.services.PlaintextSignatureService;
import org.scribe.services.SignatureService;

public class YammerApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "'https://www.yammer.com/oauth/authorize?oauth_token=%s'";

    public String getRequestTokenEndpoint() {
        return "https://www.yammer.com/oauth/request_token";
    }

    public String getAccessTokenEndpoint() {
        return "https://www.yammer.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZATION_URL, new Object[]{requestToken.getToken()});
    }

    public SignatureService getSignatureService() {
        return new PlaintextSignatureService();
    }
}
