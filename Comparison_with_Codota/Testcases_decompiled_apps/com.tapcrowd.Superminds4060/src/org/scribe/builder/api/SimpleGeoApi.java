package org.scribe.builder.api;

import org.scribe.model.Token;

public class SimpleGeoApi extends DefaultApi10a {
    private static final String ENDPOINT = "these are not used since SimpleGeo uses 2 legged OAuth";

    public String getRequestTokenEndpoint() {
        return ENDPOINT;
    }

    public String getAccessTokenEndpoint() {
        return ENDPOINT;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return ENDPOINT;
    }
}
