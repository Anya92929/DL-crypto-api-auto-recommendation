package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultOAuthProvider extends AbstractOAuthProvider {
    private static final long serialVersionUID = 1;

    public DefaultOAuthProvider(String requestTokenEndpointUrl, String accessTokenEndpointUrl, String authorizationWebsiteUrl) {
        super(requestTokenEndpointUrl, accessTokenEndpointUrl, authorizationWebsiteUrl);
    }

    /* access modifiers changed from: protected */
    public HttpRequest createRequest(String endpointUrl) throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(endpointUrl).openConnection();
        connection.setRequestMethod("POST");
        connection.setAllowUserInteraction(false);
        connection.setRequestProperty("Content-Length", "0");
        return new HttpURLConnectionRequestAdapter(connection);
    }

    /* access modifiers changed from: protected */
    public HttpResponse sendRequest(HttpRequest request) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) request.unwrap();
        connection.connect();
        return new HttpURLConnectionResponseAdapter(connection);
    }

    /* access modifiers changed from: protected */
    public void closeConnection(HttpRequest request, HttpResponse response) {
        HttpURLConnection connection = (HttpURLConnection) request.unwrap();
        if (connection != null) {
            connection.disconnect();
        }
    }
}
