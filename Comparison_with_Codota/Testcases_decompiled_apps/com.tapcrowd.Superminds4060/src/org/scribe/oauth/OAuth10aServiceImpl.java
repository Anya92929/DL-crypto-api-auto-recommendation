package org.scribe.oauth;

import java.util.Map;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.utils.MapUtils;

public class OAuth10aServiceImpl implements OAuthService {
    private static final String VERSION = "1.0";
    private DefaultApi10a api;
    private OAuthConfig config;

    public OAuth10aServiceImpl(DefaultApi10a api2, OAuthConfig config2) {
        this.api = api2;
        this.config = config2;
    }

    public Token getRequestToken() {
        this.config.log("obtaining request token from " + this.api.getRequestTokenEndpoint());
        OAuthRequest request = new OAuthRequest(this.api.getRequestTokenVerb(), this.api.getRequestTokenEndpoint());
        this.config.log("setting oauth_callback to " + this.config.getCallback());
        request.addOAuthParameter(OAuthConstants.CALLBACK, this.config.getCallback());
        addOAuthParams(request, OAuthConstants.EMPTY_TOKEN);
        appendSignature(request);
        this.config.log("sending request...");
        Response response = request.send();
        String body = response.getBody();
        this.config.log("response status code: " + response.getCode());
        this.config.log("response body: " + body);
        return this.api.getRequestTokenExtractor().extract(body);
    }

    private void addOAuthParams(OAuthRequest request, Token token) {
        request.addOAuthParameter(OAuthConstants.TIMESTAMP, this.api.getTimestampService().getTimestampInSeconds());
        request.addOAuthParameter(OAuthConstants.NONCE, this.api.getTimestampService().getNonce());
        request.addOAuthParameter(OAuthConstants.CONSUMER_KEY, this.config.getApiKey());
        request.addOAuthParameter(OAuthConstants.SIGN_METHOD, this.api.getSignatureService().getSignatureMethod());
        request.addOAuthParameter(OAuthConstants.VERSION, getVersion());
        if (this.config.hasScope()) {
            request.addOAuthParameter(OAuthConstants.SCOPE, this.config.getScope());
        }
        request.addOAuthParameter(OAuthConstants.SIGNATURE, getSignature(request, token));
        this.config.log("appended additional OAuth parameters: " + MapUtils.toString(request.getOauthParameters()));
    }

    public Token getAccessToken(Token requestToken, Verifier verifier) {
        this.config.log("obtaining access token from " + this.api.getAccessTokenEndpoint());
        OAuthRequest request = new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint());
        request.addOAuthParameter("oauth_token", requestToken.getToken());
        request.addOAuthParameter("oauth_verifier", verifier.getValue());
        this.config.log("setting token to: " + requestToken + " and verifier to: " + verifier);
        addOAuthParams(request, requestToken);
        appendSignature(request);
        return this.api.getAccessTokenExtractor().extract(request.send().getBody());
    }

    public void signRequest(Token token, OAuthRequest request) {
        this.config.log("signing request: " + request.getCompleteUrl());
        request.addOAuthParameter("oauth_token", token.getToken());
        this.config.log("setting token to: " + token);
        addOAuthParams(request, token);
        appendSignature(request);
    }

    public String getVersion() {
        return VERSION;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return this.api.getAuthorizationUrl(requestToken);
    }

    private String getSignature(OAuthRequest request, Token token) {
        this.config.log("generating signature...");
        String baseString = this.api.getBaseStringExtractor().extract(request);
        String signature = this.api.getSignatureService().getSignature(baseString, this.config.getApiSecret(), token.getSecret());
        this.config.log("base string is: " + baseString);
        this.config.log("signature is: " + signature);
        return signature;
    }

    private void appendSignature(OAuthRequest request) {
        switch (this.config.getSignatureType()) {
            case Header:
                this.config.log("using Http Header signature");
                request.addHeader(OAuthConstants.HEADER, this.api.getHeaderExtractor().extract(request));
                return;
            case QueryString:
                this.config.log("using Querystring signature");
                for (Map.Entry<String, String> entry : request.getOauthParameters().entrySet()) {
                    request.addQuerystringParameter(entry.getKey(), entry.getValue());
                }
                return;
            default:
                return;
        }
    }
}
