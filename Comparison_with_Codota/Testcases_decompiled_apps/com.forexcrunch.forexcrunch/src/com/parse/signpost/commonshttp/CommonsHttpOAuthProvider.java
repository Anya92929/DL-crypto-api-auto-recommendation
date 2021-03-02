package com.parse.signpost.commonshttp;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class CommonsHttpOAuthProvider extends AbstractOAuthProvider {
    private static final long serialVersionUID = 1;
    private transient HttpClient httpClient;

    public CommonsHttpOAuthProvider(String requestTokenEndpointUrl, String accessTokenEndpointUrl, String authorizationWebsiteUrl) {
        super(requestTokenEndpointUrl, accessTokenEndpointUrl, authorizationWebsiteUrl);
        this.httpClient = new DefaultHttpClient();
    }

    public CommonsHttpOAuthProvider(String requestTokenEndpointUrl, String accessTokenEndpointUrl, String authorizationWebsiteUrl, HttpClient httpClient2) {
        super(requestTokenEndpointUrl, accessTokenEndpointUrl, authorizationWebsiteUrl);
        this.httpClient = httpClient2;
    }

    public void setHttpClient(HttpClient httpClient2) {
        this.httpClient = httpClient2;
    }

    /* access modifiers changed from: protected */
    public HttpRequest createRequest(String endpointUrl) throws Exception {
        return new HttpRequestAdapter(new HttpPost(endpointUrl));
    }

    /* access modifiers changed from: protected */
    public HttpResponse sendRequest(HttpRequest request) throws Exception {
        return new HttpResponseAdapter(this.httpClient.execute((HttpUriRequest) request.unwrap()));
    }

    /* access modifiers changed from: protected */
    public void closeConnection(HttpRequest request, HttpResponse response) throws Exception {
        HttpEntity entity;
        if (response != null && (entity = ((org.apache.http.HttpResponse) response.unwrap()).getEntity()) != null) {
            try {
                entity.consumeContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
