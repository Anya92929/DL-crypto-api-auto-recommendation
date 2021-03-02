package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthConsumer;
import com.parse.signpost.http.HttpRequest;
import java.net.HttpURLConnection;

public class DefaultOAuthConsumer extends AbstractOAuthConsumer {
    private static final long serialVersionUID = 1;

    public DefaultOAuthConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /* access modifiers changed from: protected */
    public HttpRequest wrap(Object request) {
        if (request instanceof HttpURLConnection) {
            return new HttpURLConnectionRequestAdapter((HttpURLConnection) request);
        }
        throw new IllegalArgumentException("The default consumer expects requests of type java.net.HttpURLConnection");
    }
}
