package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

public class PlainTextMessageSigner extends OAuthMessageSigner {
    public String getSignatureMethod() {
        return "PLAINTEXT";
    }

    public String sign(HttpRequest request, HttpParameters requestParams) throws OAuthMessageSignerException {
        return String.valueOf(OAuth.percentEncode(getConsumerSecret())) + '&' + OAuth.percentEncode(getTokenSecret());
    }
}
