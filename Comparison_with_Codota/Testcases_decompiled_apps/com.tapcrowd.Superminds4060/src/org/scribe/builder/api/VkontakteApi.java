package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class VkontakteApi extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://api.vkontakte.ru/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = String.format("%s&scope=%%s", new Object[]{AUTHORIZE_URL});

    public String getAccessTokenEndpoint() {
        return "https://api.vkontakte.ru/oauth/access_token";
    }

    public String getAuthorizationUrl(OAuthConfig config) {
        Preconditions.checkValidUrl(config.getCallback(), "Valid url is required for a callback. Vkontakte does not support OOB");
        if (config.hasScope()) {
            return String.format(SCOPED_AUTHORIZE_URL, new Object[]{config.getApiKey(), OAuthEncoder.encode(config.getCallback()), OAuthEncoder.encode(config.getScope())});
        }
        return String.format(AUTHORIZE_URL, new Object[]{config.getApiKey(), OAuthEncoder.encode(config.getCallback())});
    }

    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }
}
