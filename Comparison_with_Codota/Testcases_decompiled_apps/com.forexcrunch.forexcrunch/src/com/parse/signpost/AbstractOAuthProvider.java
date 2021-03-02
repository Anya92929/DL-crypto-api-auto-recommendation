package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractOAuthProvider implements OAuthProvider {
    private static final long serialVersionUID = 1;
    private String accessTokenEndpointUrl;
    private String authorizationWebsiteUrl;
    private Map<String, String> defaultHeaders = new HashMap();
    private boolean isOAuth10a;
    private transient OAuthProviderListener listener;
    private String requestTokenEndpointUrl;
    private HttpParameters responseParameters = new HttpParameters();

    /* access modifiers changed from: protected */
    public abstract HttpRequest createRequest(String str) throws Exception;

    /* access modifiers changed from: protected */
    public abstract HttpResponse sendRequest(HttpRequest httpRequest) throws Exception;

    public AbstractOAuthProvider(String requestTokenEndpointUrl2, String accessTokenEndpointUrl2, String authorizationWebsiteUrl2) {
        this.requestTokenEndpointUrl = requestTokenEndpointUrl2;
        this.accessTokenEndpointUrl = accessTokenEndpointUrl2;
        this.authorizationWebsiteUrl = authorizationWebsiteUrl2;
    }

    public String retrieveRequestToken(OAuthConsumer consumer, String callbackUrl) throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException {
        consumer.setTokenWithSecret((String) null, (String) null);
        retrieveToken(consumer, this.requestTokenEndpointUrl, OAuth.OAUTH_CALLBACK, callbackUrl);
        String callbackConfirmed = this.responseParameters.getFirst(OAuth.OAUTH_CALLBACK_CONFIRMED);
        this.responseParameters.remove((Object) OAuth.OAUTH_CALLBACK_CONFIRMED);
        this.isOAuth10a = Boolean.TRUE.toString().equals(callbackConfirmed);
        if (this.isOAuth10a) {
            return OAuth.addQueryParameters(this.authorizationWebsiteUrl, OAuth.OAUTH_TOKEN, consumer.getToken());
        }
        return OAuth.addQueryParameters(this.authorizationWebsiteUrl, OAuth.OAUTH_TOKEN, consumer.getToken(), OAuth.OAUTH_CALLBACK, callbackUrl);
    }

    public void retrieveAccessToken(OAuthConsumer consumer, String oauthVerifier) throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException {
        if (consumer.getToken() == null || consumer.getTokenSecret() == null) {
            throw new OAuthExpectationFailedException("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
        } else if (!this.isOAuth10a || oauthVerifier == null) {
            retrieveToken(consumer, this.accessTokenEndpointUrl, new String[0]);
        } else {
            retrieveToken(consumer, this.accessTokenEndpointUrl, OAuth.OAUTH_VERIFIER, oauthVerifier);
        }
    }

    /* access modifiers changed from: protected */
    public void retrieveToken(OAuthConsumer consumer, String endpointUrl, String... additionalParameters) throws OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException, OAuthExpectationFailedException {
        Map<String, String> defaultHeaders2 = getRequestHeaders();
        if (consumer.getConsumerKey() == null || consumer.getConsumerSecret() == null) {
            throw new OAuthExpectationFailedException("Consumer key or secret not set");
        }
        HttpRequest request = null;
        HttpResponse response = null;
        try {
            request = createRequest(endpointUrl);
            for (String header : defaultHeaders2.keySet()) {
                request.setHeader(header, defaultHeaders2.get(header));
            }
            if (additionalParameters != null) {
                HttpParameters httpParams = new HttpParameters();
                httpParams.putAll(additionalParameters, true);
                consumer.setAdditionalParameters(httpParams);
            }
            if (this.listener != null) {
                this.listener.prepareRequest(request);
            }
            consumer.sign(request);
            if (this.listener != null) {
                this.listener.prepareSubmission(request);
            }
            response = sendRequest(request);
            int statusCode = response.getStatusCode();
            boolean requestHandled = false;
            if (this.listener != null) {
                requestHandled = this.listener.onResponseReceived(request, response);
            }
            if (requestHandled) {
                try {
                    closeConnection(request, response);
                } catch (Exception e) {
                    throw new OAuthCommunicationException(e);
                }
            } else {
                if (statusCode >= 300) {
                    handleUnexpectedResponse(statusCode, response);
                }
                HttpParameters responseParams = OAuth.decodeForm(response.getContent());
                String token = responseParams.getFirst(OAuth.OAUTH_TOKEN);
                String secret = responseParams.getFirst(OAuth.OAUTH_TOKEN_SECRET);
                responseParams.remove((Object) OAuth.OAUTH_TOKEN);
                responseParams.remove((Object) OAuth.OAUTH_TOKEN_SECRET);
                setResponseParameters(responseParams);
                if (token == null || secret == null) {
                    throw new OAuthExpectationFailedException("Request token or token secret not set in server reply. The service provider you use is probably buggy.");
                }
                consumer.setTokenWithSecret(token, secret);
                try {
                    closeConnection(request, response);
                } catch (Exception e2) {
                    throw new OAuthCommunicationException(e2);
                }
            }
        } catch (OAuthNotAuthorizedException e3) {
            throw e3;
        } catch (OAuthExpectationFailedException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new OAuthCommunicationException(e5);
        } catch (Throwable th) {
            try {
                closeConnection(request, response);
                throw th;
            } catch (Exception e6) {
                throw new OAuthCommunicationException(e6);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handleUnexpectedResponse(int statusCode, HttpResponse response) throws Exception {
        if (response != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getContent()), 8192);
            StringBuilder responseBody = new StringBuilder();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                responseBody.append(line);
            }
            switch (statusCode) {
                case 401:
                    throw new OAuthNotAuthorizedException(responseBody.toString());
                default:
                    throw new OAuthCommunicationException("Service provider responded in error: " + statusCode + " (" + response.getReasonPhrase() + ")", responseBody.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void closeConnection(HttpRequest request, HttpResponse response) throws Exception {
    }

    public HttpParameters getResponseParameters() {
        return this.responseParameters;
    }

    /* access modifiers changed from: protected */
    public String getResponseParameter(String key) {
        return this.responseParameters.getFirst(key);
    }

    public void setResponseParameters(HttpParameters parameters) {
        this.responseParameters = parameters;
    }

    public void setOAuth10a(boolean isOAuth10aProvider) {
        this.isOAuth10a = isOAuth10aProvider;
    }

    public boolean isOAuth10a() {
        return this.isOAuth10a;
    }

    public String getRequestTokenEndpointUrl() {
        return this.requestTokenEndpointUrl;
    }

    public String getAccessTokenEndpointUrl() {
        return this.accessTokenEndpointUrl;
    }

    public String getAuthorizationWebsiteUrl() {
        return this.authorizationWebsiteUrl;
    }

    public void setRequestHeader(String header, String value) {
        this.defaultHeaders.put(header, value);
    }

    public Map<String, String> getRequestHeaders() {
        return this.defaultHeaders;
    }

    public void setListener(OAuthProviderListener listener2) {
        this.listener = listener2;
    }

    public void removeListener(OAuthProviderListener listener2) {
        this.listener = null;
    }
}
