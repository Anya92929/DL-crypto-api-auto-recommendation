package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public final class Request {
    /* access modifiers changed from: private */
    public final RequestBody body;
    private volatile CacheControl cacheControl;
    /* access modifiers changed from: private */
    public final Headers headers;
    /* access modifiers changed from: private */
    public final String method;
    /* access modifiers changed from: private */
    public final Object tag;
    private volatile URI uri;
    /* access modifiers changed from: private */
    public volatile URL url;
    /* access modifiers changed from: private */
    public final String urlString;

    private Request(Builder builder) {
        Object obj;
        this.urlString = builder.urlString;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        if (builder.tag != null) {
            obj = builder.tag;
        } else {
            obj = this;
        }
        this.tag = obj;
        this.url = builder.url;
    }

    public URL url() {
        try {
            URL result = this.url;
            if (result != null) {
                return result;
            }
            URL result2 = new URL(this.urlString);
            this.url = result2;
            return result2;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL: " + this.urlString, e);
        }
    }

    public URI uri() throws IOException {
        try {
            URI result = this.uri;
            if (result != null) {
                return result;
            }
            URI result2 = Platform.get().toUriLenient(url());
            this.uri = result2;
            return result2;
        } catch (URISyntaxException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String urlString() {
        return this.urlString;
    }

    public String method() {
        return this.method;
    }

    public Headers headers() {
        return this.headers;
    }

    public String header(String name) {
        return this.headers.get(name);
    }

    public List<String> headers(String name) {
        return this.headers.values(name);
    }

    public RequestBody body() {
        return this.body;
    }

    public Object tag() {
        return this.tag;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public CacheControl cacheControl() {
        CacheControl result = this.cacheControl;
        if (result != null) {
            return result;
        }
        CacheControl result2 = CacheControl.parse(this.headers);
        this.cacheControl = result2;
        return result2;
    }

    public boolean isHttps() {
        return url().getProtocol().equals("https");
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.urlString + ", tag=" + (this.tag != this ? this.tag : null) + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public RequestBody body;
        /* access modifiers changed from: private */
        public Headers.Builder headers;
        /* access modifiers changed from: private */
        public String method;
        /* access modifiers changed from: private */
        public Object tag;
        /* access modifiers changed from: private */
        public URL url;
        /* access modifiers changed from: private */
        public String urlString;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        private Builder(Request request) {
            this.urlString = request.urlString;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }

        public Builder url(String url2) {
            if (url2 == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.urlString = url2;
            this.url = null;
            return this;
        }

        public Builder url(URL url2) {
            if (url2 == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = url2;
            this.urlString = url2.toString();
            return this;
        }

        public Builder header(String name, String value) {
            this.headers.set(name, value);
            return this;
        }

        public Builder addHeader(String name, String value) {
            this.headers.add(name, value);
            return this;
        }

        public Builder removeHeader(String name) {
            this.headers.removeAll(name);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String value = cacheControl.toString();
            if (value.isEmpty()) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", value);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder post(RequestBody body2) {
            return method("POST", body2);
        }

        public Builder delete(RequestBody body2) {
            return method("DELETE", body2);
        }

        public Builder delete() {
            return method("DELETE", (RequestBody) null);
        }

        public Builder put(RequestBody body2) {
            return method("PUT", body2);
        }

        public Builder patch(RequestBody body2) {
            return method("PATCH", body2);
        }

        public Builder method(String method2, RequestBody body2) {
            if (method2 == null || method2.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (body2 == null || HttpMethod.permitsRequestBody(method2)) {
                if (body2 == null && HttpMethod.permitsRequestBody(method2)) {
                    body2 = RequestBody.create((MediaType) null, Util.EMPTY_BYTE_ARRAY);
                }
                this.method = method2;
                this.body = body2;
                return this;
            } else {
                throw new IllegalArgumentException("method " + method2 + " must not have a request body.");
            }
        }

        public Builder tag(Object tag2) {
            this.tag = tag2;
            return this;
        }

        public Request build() {
            if (this.urlString != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
