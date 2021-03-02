package org.scribe.model;

import java.io.Serializable;

public class Token implements Serializable {
    private static final long serialVersionUID = 715000866082812683L;
    private final String rawResponse;
    private final String secret;
    private final String token;

    public Token(String token2, String secret2) {
        this(token2, secret2, (String) null);
    }

    public Token(String token2, String secret2, String rawResponse2) {
        this.token = token2;
        this.secret = secret2;
        this.rawResponse = rawResponse2;
    }

    public String getToken() {
        return this.token;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getRawResponse() {
        if (this.rawResponse != null) {
            return this.rawResponse;
        }
        throw new IllegalStateException("This token object was not constructed by scribe and does not have a rawResponse");
    }

    public String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.token, this.secret});
    }
}
