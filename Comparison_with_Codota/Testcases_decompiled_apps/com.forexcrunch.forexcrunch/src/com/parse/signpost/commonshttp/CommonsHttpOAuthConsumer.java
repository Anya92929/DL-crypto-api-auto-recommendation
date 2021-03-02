package com.parse.signpost.commonshttp;

import com.parse.signpost.AbstractOAuthConsumer;
import com.parse.signpost.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class CommonsHttpOAuthConsumer extends AbstractOAuthConsumer {
    private static final long serialVersionUID = 1;

    public CommonsHttpOAuthConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /* access modifiers changed from: protected */
    public HttpRequest wrap(Object request) {
        if (request instanceof org.apache.http.HttpRequest) {
            return new HttpRequestAdapter((HttpUriRequest) request);
        }
        throw new IllegalArgumentException("This consumer expects requests of type " + org.apache.http.HttpRequest.class.getCanonicalName());
    }
}
