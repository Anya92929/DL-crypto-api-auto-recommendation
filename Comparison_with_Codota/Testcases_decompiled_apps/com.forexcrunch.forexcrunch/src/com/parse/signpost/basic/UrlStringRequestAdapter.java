package com.parse.signpost.basic;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class UrlStringRequestAdapter implements HttpRequest {
    private String url;

    public UrlStringRequestAdapter(String url2) {
        this.url = url2;
    }

    public String getMethod() {
        return "GET";
    }

    public String getRequestUrl() {
        return this.url;
    }

    public void setRequestUrl(String url2) {
        this.url = url2;
    }

    public void setHeader(String name, String value) {
    }

    public String getHeader(String name) {
        return null;
    }

    public Map<String, String> getAllHeaders() {
        return Collections.emptyMap();
    }

    public InputStream getMessagePayload() throws IOException {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public Object unwrap() {
        return this.url;
    }
}
