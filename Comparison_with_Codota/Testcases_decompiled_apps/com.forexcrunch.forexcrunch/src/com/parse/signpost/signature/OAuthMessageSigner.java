package com.parse.signpost.signature;

import com.parse.codec.binary.Base64;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class OAuthMessageSigner implements Serializable {
    private static final long serialVersionUID = 4445779788786131202L;
    private transient Base64 base64 = new Base64();
    private String consumerSecret;
    private String tokenSecret;

    public abstract String getSignatureMethod();

    public abstract String sign(HttpRequest httpRequest, HttpParameters httpParameters) throws OAuthMessageSignerException;

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public void setConsumerSecret(String consumerSecret2) {
        this.consumerSecret = consumerSecret2;
    }

    public void setTokenSecret(String tokenSecret2) {
        this.tokenSecret = tokenSecret2;
    }

    /* access modifiers changed from: protected */
    public byte[] decodeBase64(String s) {
        return this.base64.decode(s.getBytes());
    }

    /* access modifiers changed from: protected */
    public String base64Encode(byte[] b) {
        return new String(this.base64.encode(b));
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.base64 = new Base64();
    }
}
