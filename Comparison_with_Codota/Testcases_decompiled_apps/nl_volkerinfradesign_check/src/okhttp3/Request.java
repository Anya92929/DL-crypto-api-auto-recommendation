package okhttp3;

import java.net.URL;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HttpUrl f5904a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f5905b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Headers f5906c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final RequestBody f5907d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f5908e;

    /* renamed from: f */
    private volatile CacheControl f5909f;

    private Request(Builder builder) {
        Object obj;
        this.f5904a = builder.f5910a;
        this.f5905b = builder.f5911b;
        this.f5906c = builder.f5912c.build();
        this.f5907d = builder.f5913d;
        if (builder.f5914e != null) {
            obj = builder.f5914e;
        } else {
            obj = this;
        }
        this.f5908e = obj;
    }

    public HttpUrl url() {
        return this.f5904a;
    }

    public String method() {
        return this.f5905b;
    }

    public Headers headers() {
        return this.f5906c;
    }

    public String header(String str) {
        return this.f5906c.get(str);
    }

    public List<String> headers(String str) {
        return this.f5906c.values(str);
    }

    public RequestBody body() {
        return this.f5907d;
    }

    public Object tag() {
        return this.f5908e;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f5909f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f5906c);
        this.f5909f = parse;
        return parse;
    }

    public boolean isHttps() {
        return this.f5904a.isHttps();
    }

    public String toString() {
        return "Request{method=" + this.f5905b + ", url=" + this.f5904a + ", tag=" + (this.f5908e != this ? this.f5908e : null) + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public HttpUrl f5910a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f5911b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Headers.Builder f5912c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public RequestBody f5913d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Object f5914e;

        public Builder() {
            this.f5911b = "GET";
            this.f5912c = new Headers.Builder();
        }

        private Builder(Request request) {
            this.f5910a = request.f5904a;
            this.f5911b = request.f5905b;
            this.f5913d = request.f5907d;
            this.f5914e = request.f5908e;
            this.f5912c = request.f5906c.newBuilder();
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f5910a = httpUrl;
            return this;
        }

        public Builder url(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                return url(parse);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url == null");
            }
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl != null) {
                return url(httpUrl);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        public Builder header(String str, String str2) {
            this.f5912c.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.f5912c.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.f5912c.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f5912c = headers.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder delete() {
            return delete(RequestBody.create((MediaType) null, new byte[0]));
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.f5911b = str;
                this.f5913d = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public Builder tag(Object obj) {
            this.f5914e = obj;
            return this;
        }

        public Request build() {
            if (this.f5910a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
