package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.signature.OAuthMessageSigner;
import com.parse.signpost.signature.SigningStrategy;
import java.io.Serializable;

public interface OAuthConsumer extends Serializable {
    String getConsumerKey();

    String getConsumerSecret();

    HttpParameters getRequestParameters();

    String getToken();

    String getTokenSecret();

    void setAdditionalParameters(HttpParameters httpParameters);

    void setMessageSigner(OAuthMessageSigner oAuthMessageSigner);

    void setSendEmptyTokens(boolean z);

    void setSigningStrategy(SigningStrategy signingStrategy);

    void setTokenWithSecret(String str, String str2);

    HttpRequest sign(HttpRequest httpRequest) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;

    HttpRequest sign(Object obj) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;

    String sign(String str) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;
}
