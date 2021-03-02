package com.parse.signpost.basic;

import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpURLConnectionResponseAdapter implements HttpResponse {
    private HttpURLConnection connection;

    public HttpURLConnectionResponseAdapter(HttpURLConnection connection2) {
        this.connection = connection2;
    }

    public InputStream getContent() throws IOException {
        return this.connection.getInputStream();
    }

    public int getStatusCode() throws IOException {
        return this.connection.getResponseCode();
    }

    public String getReasonPhrase() throws Exception {
        return this.connection.getResponseMessage();
    }

    public Object unwrap() {
        return this.connection;
    }
}
