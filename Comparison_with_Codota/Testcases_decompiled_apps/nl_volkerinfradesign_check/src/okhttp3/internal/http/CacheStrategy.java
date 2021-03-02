package okhttp3.internal.http;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.time.DateUtils;
import p010uk.p011co.senab.photoview.IPhotoView;

public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    private CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public static boolean isCacheable(Response response, Request request) {
        switch (response.code()) {
            case IPhotoView.DEFAULT_ZOOM_DURATION /*200*/:
            case 203:
            case 204:
            case 300:
            case 301:
            case StatusLine.HTTP_PERM_REDIRECT /*308*/:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            case 302:
            case StatusLine.HTTP_TEMP_REDIRECT /*307*/:
                if (response.header("Expires") == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            default:
                return false;
        }
        return !response.cacheControl().noStore() && !request.cacheControl().noStore();
    }

    public static class Factory {

        /* renamed from: a */
        final long f6154a;

        /* renamed from: b */
        final Request f6155b;

        /* renamed from: c */
        final Response f6156c;

        /* renamed from: d */
        private Date f6157d;

        /* renamed from: e */
        private String f6158e;

        /* renamed from: f */
        private Date f6159f;

        /* renamed from: g */
        private String f6160g;

        /* renamed from: h */
        private Date f6161h;

        /* renamed from: i */
        private long f6162i;

        /* renamed from: j */
        private long f6163j;

        /* renamed from: k */
        private String f6164k;

        /* renamed from: l */
        private int f6165l = -1;

        public Factory(long j, Request request, Response response) {
            this.f6154a = j;
            this.f6155b = request;
            this.f6156c = response;
            if (response != null) {
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.f6157d = HttpDate.parse(value);
                        this.f6158e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.f6161h = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f6159f = HttpDate.parse(value);
                        this.f6160g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.f6164k = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.f6165l = HeaderParser.parseSeconds(value, -1);
                    } else if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(name)) {
                        this.f6162i = Long.parseLong(value);
                    } else if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(name)) {
                        this.f6163j = Long.parseLong(value);
                    }
                }
            }
        }

        public CacheStrategy get() {
            CacheStrategy a = m6816a();
            if (a.networkRequest == null || !this.f6155b.cacheControl().onlyIfCached()) {
                return a;
            }
            return new CacheStrategy((Request) null, (Response) null);
        }

        /* renamed from: a */
        private CacheStrategy m6816a() {
            long j;
            long j2 = 0;
            if (this.f6156c == null) {
                return new CacheStrategy(this.f6155b, (Response) null);
            }
            if (this.f6155b.isHttps() && this.f6156c.handshake() == null) {
                return new CacheStrategy(this.f6155b, (Response) null);
            }
            if (!CacheStrategy.isCacheable(this.f6156c, this.f6155b)) {
                return new CacheStrategy(this.f6155b, (Response) null);
            }
            CacheControl cacheControl = this.f6155b.cacheControl();
            if (cacheControl.noCache() || m6817a(this.f6155b)) {
                return new CacheStrategy(this.f6155b, (Response) null);
            }
            long c = m6819c();
            long b = m6818b();
            if (cacheControl.maxAgeSeconds() != -1) {
                b = Math.min(b, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            if (cacheControl.minFreshSeconds() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds());
            } else {
                j = 0;
            }
            CacheControl cacheControl2 = this.f6156c.cacheControl();
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (cacheControl2.noCache() || c + j >= j2 + b) {
                Request.Builder newBuilder = this.f6155b.newBuilder();
                if (this.f6164k != null) {
                    newBuilder.header("If-None-Match", this.f6164k);
                } else if (this.f6159f != null) {
                    newBuilder.header("If-Modified-Since", this.f6160g);
                } else if (this.f6157d != null) {
                    newBuilder.header("If-Modified-Since", this.f6158e);
                }
                Request build = newBuilder.build();
                if (m6817a(build)) {
                    return new CacheStrategy(build, this.f6156c);
                }
                return new CacheStrategy(build, (Response) null);
            }
            Response.Builder newBuilder2 = this.f6156c.newBuilder();
            if (j + c >= b) {
                newBuilder2.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (c > DateUtils.MILLIS_PER_DAY && m6820d()) {
                newBuilder2.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new CacheStrategy((Request) null, newBuilder2.build());
        }

        /* renamed from: b */
        private long m6818b() {
            CacheControl cacheControl = this.f6156c.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            if (this.f6161h != null) {
                long time = this.f6161h.getTime() - (this.f6157d != null ? this.f6157d.getTime() : this.f6163j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.f6159f == null || this.f6156c.request().url().query() != null) {
                return 0;
            } else {
                long time2 = (this.f6157d != null ? this.f6157d.getTime() : this.f6162i) - this.f6159f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        /* renamed from: c */
        private long m6819c() {
            long j = 0;
            if (this.f6157d != null) {
                j = Math.max(0, this.f6163j - this.f6157d.getTime());
            }
            if (this.f6165l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f6165l));
            }
            return j + (this.f6163j - this.f6162i) + (this.f6154a - this.f6163j);
        }

        /* renamed from: d */
        private boolean m6820d() {
            return this.f6156c.cacheControl().maxAgeSeconds() == -1 && this.f6161h == null;
        }

        /* renamed from: a */
        private static boolean m6817a(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }
}
