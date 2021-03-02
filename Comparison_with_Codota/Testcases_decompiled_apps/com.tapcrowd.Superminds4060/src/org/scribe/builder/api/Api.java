package org.scribe.builder.api;

import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuthService;

public interface Api {
    OAuthService createService(OAuthConfig oAuthConfig);
}
