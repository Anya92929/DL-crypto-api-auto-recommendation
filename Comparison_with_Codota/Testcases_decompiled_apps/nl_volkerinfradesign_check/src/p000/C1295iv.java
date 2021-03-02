package p000;

import android.support.p001v4.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okio.Sink;

/* renamed from: iv */
public final class C1295iv implements Call {

    /* renamed from: a */
    volatile boolean f4513a;

    /* renamed from: b */
    Request f4514b;

    /* renamed from: c */
    public HttpEngine f4515c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final OkHttpClient f4516d;

    /* renamed from: e */
    private boolean f4517e;

    public C1295iv(OkHttpClient okHttpClient, Request request) {
        this.f4516d = okHttpClient;
        this.f4514b = request;
    }

    public Request request() {
        return this.f4514b;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.f4517e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f4517e = true;
        }
        try {
            this.f4516d.dispatcher().mo10647a(this);
            Response a = m5623a(false);
            if (a != null) {
                return a;
            }
            throw new IOException("Canceled");
        } finally {
            this.f4516d.dispatcher().mo10648a((Call) this);
        }
    }

    public void enqueue(Callback callback) {
        mo8688a(callback, false);
    }

    /* renamed from: a */
    public void mo8688a(Callback callback, boolean z) {
        synchronized (this) {
            if (this.f4517e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f4517e = true;
        }
        this.f4516d.dispatcher().mo10646a(new C1298b(callback, z));
    }

    public void cancel() {
        this.f4513a = true;
        if (this.f4515c != null) {
            this.f4515c.cancel();
        }
    }

    public synchronized boolean isExecuted() {
        return this.f4517e;
    }

    public boolean isCanceled() {
        return this.f4513a;
    }

    /* renamed from: iv$b */
    public final class C1298b extends NamedRunnable {

        /* renamed from: b */
        private final Callback f4523b;

        /* renamed from: c */
        private final boolean f4524c;

        private C1298b(Callback callback, boolean z) {
            super("OkHttp %s", C1295iv.this.f4514b.url().toString());
            this.f4523b = callback;
            this.f4524c = z;
        }

        /* renamed from: a */
        public String mo8698a() {
            return C1295iv.this.f4514b.url().host();
        }

        /* renamed from: b */
        public void mo8699b() {
            C1295iv.this.cancel();
        }

        /* renamed from: c */
        public C1295iv mo8700c() {
            return C1295iv.this;
        }

        /* access modifiers changed from: protected */
        public void execute() {
            boolean z = true;
            try {
                Response a = C1295iv.this.m5623a(this.f4524c);
                if (C1295iv.this.f4513a) {
                    try {
                        this.f4523b.onFailure(C1295iv.this, new IOException("Canceled"));
                    } catch (IOException e) {
                        e = e;
                    }
                } else {
                    this.f4523b.onResponse(C1295iv.this, a);
                }
                C1295iv.this.f4516d.dispatcher().mo10649b(this);
            } catch (IOException e2) {
                e = e2;
                z = false;
                if (z) {
                    try {
                        Internal.logger.log(Level.INFO, "Callback failure for " + C1295iv.this.m5620a(), e);
                    } catch (Throwable th) {
                        C1295iv.this.f4516d.dispatcher().mo10649b(this);
                        throw th;
                    }
                } else {
                    this.f4523b.onFailure(C1295iv.this, e);
                }
                C1295iv.this.f4516d.dispatcher().mo10649b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5620a() {
        return (this.f4513a ? "canceled call" : NotificationCompat.CATEGORY_CALL) + " to " + this.f4514b.url().resolve("/...");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Response m5623a(boolean z) throws IOException {
        return new C1297a(0, this.f4514b, z).proceed(this.f4514b);
    }

    /* renamed from: iv$a */
    class C1297a implements Interceptor.Chain {

        /* renamed from: b */
        private final int f4519b;

        /* renamed from: c */
        private final Request f4520c;

        /* renamed from: d */
        private final boolean f4521d;

        C1297a(int i, Request request, boolean z) {
            this.f4519b = i;
            this.f4520c = request;
            this.f4521d = z;
        }

        public Connection connection() {
            return null;
        }

        public Request request() {
            return this.f4520c;
        }

        public Response proceed(Request request) throws IOException {
            if (this.f4519b >= C1295iv.this.f4516d.interceptors().size()) {
                return C1295iv.this.mo8687a(request, this.f4521d);
            }
            C1297a aVar = new C1297a(this.f4519b + 1, request, this.f4521d);
            Interceptor interceptor = C1295iv.this.f4516d.interceptors().get(this.f4519b);
            Response intercept = interceptor.intercept(aVar);
            if (intercept != null) {
                return intercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo8687a(Request request, boolean z) throws IOException {
        Request request2;
        boolean z2;
        RequestBody body = request.body();
        if (body != null) {
            Request.Builder newBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
            request2 = newBuilder.build();
        } else {
            request2 = request;
        }
        this.f4515c = new HttpEngine(this.f4516d, request2, false, false, z, (StreamAllocation) null, (RetryableSink) null, (Response) null);
        int i = 0;
        while (!this.f4513a) {
            try {
                this.f4515c.sendRequest();
                this.f4515c.readResponse();
                Response response = this.f4515c.getResponse();
                Request followUpRequest = this.f4515c.followUpRequest();
                if (followUpRequest == null) {
                    if (!z) {
                        this.f4515c.releaseStreamAllocation();
                    }
                    return response;
                }
                StreamAllocation close = this.f4515c.close();
                int i2 = i + 1;
                if (i2 > 20) {
                    close.release();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (!this.f4515c.sameConnection(followUpRequest.url())) {
                    close.release();
                    close = null;
                }
                this.f4515c = new HttpEngine(this.f4516d, followUpRequest, false, false, z, close, (RetryableSink) null, response);
                i = i2;
            } catch (RequestException e) {
                throw e.getCause();
            } catch (RouteException e2) {
                HttpEngine recover = this.f4515c.recover(e2.getLastConnectException(), (Sink) null);
                if (recover != null) {
                    z2 = false;
                    this.f4515c = recover;
                } else {
                    throw e2.getLastConnectException();
                }
            } catch (IOException e3) {
                HttpEngine recover2 = this.f4515c.recover(e3, (Sink) null);
                if (recover2 != null) {
                    z2 = false;
                    this.f4515c = recover2;
                } else {
                    throw e3;
                }
            } catch (Throwable th) {
                th = th;
            }
        }
        this.f4515c.releaseStreamAllocation();
        throw new IOException("Canceled");
        if (z2) {
            this.f4515c.close().release();
        }
        throw th;
    }
}
