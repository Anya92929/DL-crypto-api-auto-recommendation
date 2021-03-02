package com.parse.signpost;

import com.parse.signpost.basic.UrlStringRequestAdapter;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.signature.AuthorizationHeaderSigningStrategy;
import com.parse.signpost.signature.HmacSha1MessageSigner;
import com.parse.signpost.signature.OAuthMessageSigner;
import com.parse.signpost.signature.QueryStringSigningStrategy;
import com.parse.signpost.signature.SigningStrategy;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;

public abstract class AbstractOAuthConsumer implements OAuthConsumer {
    private static final long serialVersionUID = 1;
    private HttpParameters additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private OAuthMessageSigner messageSigner;
    private HttpParameters requestParameters;
    private boolean sendEmptyTokens;
    private SigningStrategy signingStrategy;
    private String token;

    /* access modifiers changed from: protected */
    public abstract HttpRequest wrap(Object obj);

    public AbstractOAuthConsumer(String consumerKey2, String consumerSecret2) {
        this.consumerKey = consumerKey2;
        this.consumerSecret = consumerSecret2;
        setMessageSigner(new HmacSha1MessageSigner());
        setSigningStrategy(new AuthorizationHeaderSigningStrategy());
    }

    public void setMessageSigner(OAuthMessageSigner messageSigner2) {
        this.messageSigner = messageSigner2;
        messageSigner2.setConsumerSecret(this.consumerSecret);
    }

    public void setSigningStrategy(SigningStrategy signingStrategy2) {
        this.signingStrategy = signingStrategy2;
    }

    public void setAdditionalParameters(HttpParameters additionalParameters2) {
        this.additionalParameters = additionalParameters2;
    }

    public HttpRequest sign(HttpRequest request) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        if (this.consumerKey == null) {
            throw new OAuthExpectationFailedException("consumer key not set");
        } else if (this.consumerSecret == null) {
            throw new OAuthExpectationFailedException("consumer secret not set");
        } else {
            this.requestParameters = new HttpParameters();
            try {
                if (this.additionalParameters != null) {
                    this.requestParameters.putAll((Map<? extends String, ? extends SortedSet<String>>) this.additionalParameters, false);
                }
                collectHeaderParameters(request, this.requestParameters);
                collectQueryParameters(request, this.requestParameters);
                collectBodyParameters(request, this.requestParameters);
                completeOAuthParameters(this.requestParameters);
                this.requestParameters.remove((Object) OAuth.OAUTH_SIGNATURE);
                String signature = this.messageSigner.sign(request, this.requestParameters);
                OAuth.debugOut("signature", signature);
                this.signingStrategy.writeSignature(signature, request, this.requestParameters);
                OAuth.debugOut("Auth header", request.getHeader(OAuth.HTTP_AUTHORIZATION_HEADER));
                OAuth.debugOut("Request URL", request.getRequestUrl());
                return request;
            } catch (IOException e) {
                throw new OAuthCommunicationException(e);
            }
        }
    }

    public HttpRequest sign(Object request) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        return sign(wrap(request));
    }

    public String sign(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        HttpRequest request = new UrlStringRequestAdapter(url);
        SigningStrategy oldStrategy = this.signingStrategy;
        this.signingStrategy = new QueryStringSigningStrategy();
        sign(request);
        this.signingStrategy = oldStrategy;
        return request.getRequestUrl();
    }

    public void setTokenWithSecret(String token2, String tokenSecret) {
        this.token = token2;
        this.messageSigner.setTokenSecret(tokenSecret);
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.messageSigner.getTokenSecret();
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    /* access modifiers changed from: protected */
    public void completeOAuthParameters(HttpParameters out) {
        if (!out.containsKey(OAuth.OAUTH_CONSUMER_KEY)) {
            out.put(OAuth.OAUTH_CONSUMER_KEY, this.consumerKey, true);
        }
        if (!out.containsKey(OAuth.OAUTH_SIGNATURE_METHOD)) {
            out.put(OAuth.OAUTH_SIGNATURE_METHOD, this.messageSigner.getSignatureMethod(), true);
        }
        if (!out.containsKey(OAuth.OAUTH_TIMESTAMP)) {
            out.put(OAuth.OAUTH_TIMESTAMP, generateTimestamp(), true);
        }
        if (!out.containsKey(OAuth.OAUTH_NONCE)) {
            out.put(OAuth.OAUTH_NONCE, generateNonce(), true);
        }
        if (!out.containsKey(OAuth.OAUTH_VERSION)) {
            out.put(OAuth.OAUTH_VERSION, OAuth.VERSION_1_0, true);
        }
        if (out.containsKey(OAuth.OAUTH_TOKEN)) {
            return;
        }
        if ((this.token != null && !this.token.equals("")) || this.sendEmptyTokens) {
            out.put(OAuth.OAUTH_TOKEN, this.token, true);
        }
    }

    public HttpParameters getRequestParameters() {
        return this.requestParameters;
    }

    public void setSendEmptyTokens(boolean enable) {
        this.sendEmptyTokens = enable;
    }

    /* access modifiers changed from: protected */
    public void collectHeaderParameters(HttpRequest request, HttpParameters out) {
        out.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.oauthHeaderToParamsMap(request.getHeader(OAuth.HTTP_AUTHORIZATION_HEADER)), false);
    }

    /* access modifiers changed from: protected */
    public void collectBodyParameters(HttpRequest request, HttpParameters out) throws IOException {
        String contentType = request.getContentType();
        if (contentType != null && contentType.startsWith(OAuth.FORM_ENCODED)) {
            out.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.decodeForm(request.getMessagePayload()), true);
        }
    }

    /* access modifiers changed from: protected */
    public void collectQueryParameters(HttpRequest request, HttpParameters out) {
        String url = request.getRequestUrl();
        int q = url.indexOf(63);
        if (q >= 0) {
            out.putAll((Map<? extends String, ? extends SortedSet<String>>) OAuth.decodeForm(url.substring(q + 1)), true);
        }
    }

    /* access modifiers changed from: protected */
    public String generateTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /* access modifiers changed from: protected */
    public String generateNonce() {
        return Long.toString(new Random().nextLong());
    }
}
