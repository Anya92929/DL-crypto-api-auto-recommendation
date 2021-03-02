package com.parse.signpost.commonshttp;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestAdapter implements HttpRequest {
    private HttpEntity entity;
    private HttpUriRequest request;

    public HttpRequestAdapter(HttpUriRequest request2) {
        this.request = request2;
        if (request2 instanceof HttpEntityEnclosingRequest) {
            this.entity = ((HttpEntityEnclosingRequest) request2).getEntity();
        }
    }

    public String getMethod() {
        return this.request.getRequestLine().getMethod();
    }

    public String getRequestUrl() {
        return this.request.getURI().toString();
    }

    public void setRequestUrl(String url) {
        throw new RuntimeException(new UnsupportedOperationException());
    }

    public String getHeader(String name) {
        Header header = this.request.getFirstHeader(name);
        if (header == null) {
            return null;
        }
        return header.getValue();
    }

    public void setHeader(String name, String value) {
        this.request.setHeader(name, value);
    }

    public Map<String, String> getAllHeaders() {
        Header[] origHeaders = this.request.getAllHeaders();
        HashMap<String, String> headers = new HashMap<>();
        for (Header h : origHeaders) {
            headers.put(h.getName(), h.getValue());
        }
        return headers;
    }

    public String getContentType() {
        Header header;
        if (this.entity == null || (header = this.entity.getContentType()) == null) {
            return null;
        }
        return header.getValue();
    }

    public InputStream getMessagePayload() throws IOException {
        if (this.entity == null) {
            return null;
        }
        return this.entity.getContent();
    }

    public Object unwrap() {
        return this.request;
    }
}
