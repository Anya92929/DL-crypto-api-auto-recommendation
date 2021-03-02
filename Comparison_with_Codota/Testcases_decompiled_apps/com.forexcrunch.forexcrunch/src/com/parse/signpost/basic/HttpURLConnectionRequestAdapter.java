package com.parse.signpost.basic;

import com.parse.entity.mime.MIME;
import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionRequestAdapter implements HttpRequest {
    protected HttpURLConnection connection;

    public HttpURLConnectionRequestAdapter(HttpURLConnection connection2) {
        this.connection = connection2;
    }

    public String getMethod() {
        return this.connection.getRequestMethod();
    }

    public String getRequestUrl() {
        return this.connection.getURL().toExternalForm();
    }

    public void setRequestUrl(String url) {
    }

    public void setHeader(String name, String value) {
        this.connection.setRequestProperty(name, value);
    }

    public String getHeader(String name) {
        return this.connection.getRequestProperty(name);
    }

    public Map<String, String> getAllHeaders() {
        Map<String, List<String>> origHeaders = this.connection.getRequestProperties();
        Map<String, String> headers = new HashMap<>(origHeaders.size());
        for (String name : origHeaders.keySet()) {
            List<String> values = origHeaders.get(name);
            if (!values.isEmpty()) {
                headers.put(name, values.get(0));
            }
        }
        return headers;
    }

    public InputStream getMessagePayload() throws IOException {
        return null;
    }

    public String getContentType() {
        return this.connection.getRequestProperty(MIME.CONTENT_TYPE);
    }

    public HttpURLConnection unwrap() {
        return this.connection;
    }
}
