package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.TokenExtractor20Impl;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.oauth.OAuthService;

public abstract class DefaultApi20 implements Api {
    public abstract String getAccessTokenEndpoint();

    public abstract String getAuthorizationUrl(OAuthConfig oAuthConfig);

    public AccessTokenExtractor getAccessTokenExtractor() {
        return new TokenExtractor20Impl();
    }

    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    public OAuthService createService(OAuthConfig config) {
        return new OAuth20ServiceImpl(this, config);
    }
}
