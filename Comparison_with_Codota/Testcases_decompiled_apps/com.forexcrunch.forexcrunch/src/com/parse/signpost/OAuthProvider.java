package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import java.io.Serializable;
import java.util.Map;

public interface OAuthProvider extends Serializable {
    String getAccessTokenEndpointUrl();

    String getAuthorizationWebsiteUrl();

    @Deprecated
    Map<String, String> getRequestHeaders();

    String getRequestTokenEndpointUrl();

    HttpParameters getResponseParameters();

    boolean isOAuth10a();

    void removeListener(OAuthProviderListener oAuthProviderListener);

    void retrieveAccessToken(OAuthConsumer oAuthConsumer, String str) throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;

    String retrieveRequestToken(OAuthConsumer oAuthConsumer, String str) throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;

    void setListener(OAuthProviderListener oAuthProviderListener);

    void setOAuth10a(boolean z);

    @Deprecated
    void setRequestHeader(String str, String str2);

    void setResponseParameters(HttpParameters httpParameters);
}
