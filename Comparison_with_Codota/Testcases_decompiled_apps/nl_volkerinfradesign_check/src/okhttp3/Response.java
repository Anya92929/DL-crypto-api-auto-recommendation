package okhttp3;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSource;

public final class Response {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Request f5923a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Protocol f5924b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f5925c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f5926d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handshake f5927e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Headers f5928f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ResponseBody f5929g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Response f5930h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Response f5931i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Response f5932j;

    /* renamed from: k */
    private volatile CacheControl f5933k;

    private Response(Builder builder) {
        this.f5923a = builder.f5934a;
        this.f5924b = builder.f5935b;
        this.f5925c = builder.f5936c;
        this.f5926d = builder.f5937d;
        this.f5927e = builder.f5938e;
        this.f5928f = builder.f5939f.build();
        this.f5929g = builder.f5940g;
        this.f5930h = builder.f5941h;
        this.f5931i = builder.f5942i;
        this.f5932j = builder.f5943j;
    }

    public Request request() {
        return this.f5923a;
    }

    public Protocol protocol() {
        return this.f5924b;
    }

    public int code() {
        return this.f5925c;
    }

    public boolean isSuccessful() {
        return this.f5925c >= 200 && this.f5925c < 300;
    }

    public String message() {
        return this.f5926d;
    }

    public Handshake handshake() {
        return this.f5927e;
    }

    public List<String> headers(String str) {
        return this.f5928f.values(str);
    }

    public String header(String str) {
        return header(str, (String) null);
    }

    public String header(String str, String str2) {
        String str3 = this.f5928f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f5928f;
    }

    public ResponseBody peekBody(long j) throws IOException {
        Buffer buffer;
        BufferedSource source = this.f5929g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
        } else {
            buffer = clone;
        }
        return ResponseBody.create(this.f5929g.contentType(), buffer.size(), buffer);
    }

    public ResponseBody body() {
        return this.f5929g;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public boolean isRedirect() {
        switch (this.f5925c) {
            case 300:
            case 301:
            case 302:
            case 303:
            case StatusLine.HTTP_TEMP_REDIRECT /*307*/:
            case StatusLine.HTTP_PERM_REDIRECT /*308*/:
                return true;
            default:
                return false;
        }
    }

    public Response networkResponse() {
        return this.f5930h;
    }

    public Response cacheResponse() {
        return this.f5931i;
    }

    public Response priorResponse() {
        return this.f5932j;
    }

    public List<Challenge> challenges() {
        String str;
        if (this.f5925c == 401) {
            str = "WWW-Authenticate";
        } else if (this.f5925c != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return OkHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f5933k;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f5928f);
        this.f5933k = parse;
        return parse;
    }

    public String toString() {
        return "Response{protocol=" + this.f5924b + ", code=" + this.f5925c + ", message=" + this.f5926d + ", url=" + this.f5923a.url() + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Request f5934a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Protocol f5935b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f5936c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f5937d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Handshake f5938e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Headers.Builder f5939f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public ResponseBody f5940g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Response f5941h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Response f5942i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public Response f5943j;

        public Builder() {
            this.f5936c = -1;
            this.f5939f = new Headers.Builder();
        }

        private Builder(Response response) {
            this.f5936c = -1;
            this.f5934a = response.f5923a;
            this.f5935b = response.f5924b;
            this.f5936c = response.f5925c;
            this.f5937d = response.f5926d;
            this.f5938e = response.f5927e;
            this.f5939f = response.f5928f.newBuilder();
            this.f5940g = response.f5929g;
            this.f5941h = response.f5930h;
            this.f5942i = response.f5931i;
            this.f5943j = response.f5932j;
        }

        public Builder request(Request request) {
            this.f5934a = request;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.f5935b = protocol;
            return this;
        }

        public Builder code(int i) {
            this.f5936c = i;
            return this;
        }

        public Builder message(String str) {
            this.f5937d = str;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            this.f5938e = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.f5939f.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.f5939f.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.f5939f.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f5939f = headers.newBuilder();
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.f5940g = responseBody;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                m6614a("networkResponse", response);
            }
            this.f5941h = response;
            return this;
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                m6614a("cacheResponse", response);
            }
            this.f5942i = response;
            return this;
        }

        /* renamed from: a */
        private void m6614a(String str, Response response) {
            if (response.f5929g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f5930h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f5931i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f5932j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                m6615a(response);
            }
            this.f5943j = response;
            return this;
        }

        /* renamed from: a */
        private void m6615a(Response response) {
            if (response.f5929g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Response build() {
            if (this.f5934a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5935b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5936c >= 0) {
                return new Response(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.f5936c);
            }
        }
    }
}
