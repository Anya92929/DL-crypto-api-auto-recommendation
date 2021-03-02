package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.BaseStringExtractor;
import org.scribe.extractors.BaseStringExtractorImpl;
import org.scribe.extractors.HeaderExtractor;
import org.scribe.extractors.HeaderExtractorImpl;
import org.scribe.extractors.RequestTokenExtractor;
import org.scribe.extractors.TokenExtractorImpl;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuth10aServiceImpl;
import org.scribe.oauth.OAuthService;
import org.scribe.services.HMACSha1SignatureService;
import org.scribe.services.SignatureService;
import org.scribe.services.TimestampService;
import org.scribe.services.TimestampServiceImpl;

public abstract class DefaultApi10a implements Api {
    public abstract String getAccessTokenEndpoint();

    public abstract String getAuthorizationUrl(Token token);

    public abstract String getRequestTokenEndpoint();

    public AccessTokenExtractor getAccessTokenExtractor() {
        return new TokenExtractorImpl();
    }

    public BaseStringExtractor getBaseStringExtractor() {
        return new BaseStringExtractorImpl();
    }

    public HeaderExtractor getHeaderExtractor() {
        return new HeaderExtractorImpl();
    }

    public RequestTokenExtractor getRequestTokenExtractor() {
        return new TokenExtractorImpl();
    }

    public SignatureService getSignatureService() {
        return new HMACSha1SignatureService();
    }

    public TimestampService getTimestampService() {
        return new TimestampServiceImpl();
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public Verb getRequestTokenVerb() {
        return Verb.POST;
    }

    public OAuthService createService(OAuthConfig config) {
        return new OAuth10aServiceImpl(this, config);
    }
}
