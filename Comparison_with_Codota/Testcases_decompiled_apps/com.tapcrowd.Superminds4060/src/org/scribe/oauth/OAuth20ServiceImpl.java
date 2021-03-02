package org.scribe.oauth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

public class OAuth20ServiceImpl implements OAuthService {
    private static final String VERSION = "2.0";
    private final DefaultApi20 api;
    private final OAuthConfig config;

    public OAuth20ServiceImpl(DefaultApi20 api2, OAuthConfig config2) {
        this.api = api2;
        this.config = config2;
    }

    public Token getAccessToken(Token requestToken, Verifier verifier) {
        OAuthRequest request = new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint());
        request.addQuerystringParameter(OAuthConstants.CLIENT_ID, this.config.getApiKey());
        request.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, this.config.getApiSecret());
        request.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue());
        request.addQuerystringParameter(OAuthConstants.REDIRECT_URI, this.config.getCallback());
        if (this.config.hasScope()) {
            request.addQuerystringParameter(OAuthConstants.SCOPE, this.config.getScope());
        }
        return this.api.getAccessTokenExtractor().extract(request.send().getBody());
    }

    public Token getRequestToken() {
        throw new UnsupportedOperationException("Unsupported operation, please use 'getAuthorizationUrl' and redirect your users there");
    }

    public String getVersion() {
        return VERSION;
    }

    public void signRequest(Token accessToken, OAuthRequest request) {
        request.addQuerystringParameter("access_token", accessToken.getToken());
    }

    public String getAuthorizationUrl(Token requestToken) {
        return this.api.getAuthorizationUrl(this.config);
    }
}
