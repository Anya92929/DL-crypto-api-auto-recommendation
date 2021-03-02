package com.parse.signpost.commonshttp;

import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;

public class HttpResponseAdapter implements HttpResponse {
    private org.apache.http.HttpResponse response;

    public HttpResponseAdapter(org.apache.http.HttpResponse response2) {
        this.response = response2;
    }

    public InputStream getContent() throws IOException {
        return this.response.getEntity().getContent();
    }

    public int getStatusCode() throws IOException {
        return this.response.getStatusLine().getStatusCode();
    }

    public String getReasonPhrase() throws Exception {
        return this.response.getStatusLine().getReasonPhrase();
    }

    public Object unwrap() {
        return this.response;
    }
}
