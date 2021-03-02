package org.scribe.oauth;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

public interface OAuthService {
    Token getAccessToken(Token token, Verifier verifier);

    String getAuthorizationUrl(Token token);

    Token getRequestToken();

    String getVersion();

    void signRequest(Token token, OAuthRequest oAuthRequest);
}
