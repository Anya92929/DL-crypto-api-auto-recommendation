package okhttp3.internal.http;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.p008io.RealConnection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.commons.p009io.IOUtils;

public final class Http1xStream implements HttpStream {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final StreamAllocation f6166a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final BufferedSource f6167b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BufferedSink f6168c;

    /* renamed from: d */
    private HttpEngine f6169d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f6170e = 0;

    public Http1xStream(StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f6166a = streamAllocation;
        this.f6167b = bufferedSource;
        this.f6168c = bufferedSink;
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.f6169d = httpEngine;
    }

    public Sink createRequestBody(Request request, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void cancel() {
        RealConnection connection = this.f6166a.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        this.f6169d.writingRequestHeaders();
        writeRequest(request.headers(), RequestLine.m6853a(request, this.f6169d.getConnection().route().proxy().type()));
    }

    public Response.Builder readResponseHeaders() throws IOException {
        return readResponse();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer(m6823a(response)));
    }

    /* renamed from: a */
    private Source m6823a(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return newFixedLengthSource(0);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return newChunkedSource(this.f6169d);
        }
        long contentLength = OkHeaders.contentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(contentLength);
        }
        return newUnknownLengthSource();
    }

    public boolean isClosed() {
        return this.f6170e == 6;
    }

    public void finishRequest() throws IOException {
        this.f6168c.flush();
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.f6170e != 0) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6168c.writeUtf8(str).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.f6168c.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.f6168c.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.f6170e = 1;
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder headers;
        if (this.f6170e == 1 || this.f6170e == 3) {
            do {
                try {
                    parse = StatusLine.parse(this.f6167b.readUtf8LineStrict());
                    headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f6166a);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (parse.code == 100);
            this.f6170e = 4;
            return headers;
        }
        throw new IllegalStateException("state: " + this.f6170e);
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.f6167b.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readUtf8LineStrict);
        }
    }

    public Sink newChunkedSink() {
        if (this.f6170e != 1) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6170e = 2;
        return new C1811b();
    }

    public Sink newFixedLengthSink(long j) {
        if (this.f6170e != 1) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6170e = 2;
        return new C1813d(j);
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.f6170e != 1) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6170e = 3;
        retryableSink.writeToSocket(this.f6168c);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.f6170e != 4) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6170e = 5;
        return new C1814e(j);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.f6170e != 4) {
            throw new IllegalStateException("state: " + this.f6170e);
        }
        this.f6170e = 5;
        return new C1812c(httpEngine);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.f6170e != 4) {
            throw new IllegalStateException("state: " + this.f6170e);
        } else if (this.f6166a == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.f6170e = 5;
            this.f6166a.noNewStreams();
            return new C1815f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6825a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$d */
    final class C1813d implements Sink {

        /* renamed from: b */
        private final ForwardingTimeout f6182b;

        /* renamed from: c */
        private boolean f6183c;

        /* renamed from: d */
        private long f6184d;

        private C1813d(long j) {
            this.f6182b = new ForwardingTimeout(Http1xStream.this.f6168c.timeout());
            this.f6184d = j;
        }

        public Timeout timeout() {
            return this.f6182b;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.f6183c) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0, j);
            if (j > this.f6184d) {
                throw new ProtocolException("expected " + this.f6184d + " bytes but received " + j);
            }
            Http1xStream.this.f6168c.write(buffer, j);
            this.f6184d -= j;
        }

        public void flush() throws IOException {
            if (!this.f6183c) {
                Http1xStream.this.f6168c.flush();
            }
        }

        public void close() throws IOException {
            if (!this.f6183c) {
                this.f6183c = true;
                if (this.f6184d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                Http1xStream.this.m6825a(this.f6182b);
                int unused = Http1xStream.this.f6170e = 3;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$b */
    final class C1811b implements Sink {

        /* renamed from: b */
        private final ForwardingTimeout f6175b;

        /* renamed from: c */
        private boolean f6176c;

        private C1811b() {
            this.f6175b = new ForwardingTimeout(Http1xStream.this.f6168c.timeout());
        }

        public Timeout timeout() {
            return this.f6175b;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.f6176c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1xStream.this.f6168c.writeHexadecimalUnsignedLong(j);
                Http1xStream.this.f6168c.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
                Http1xStream.this.f6168c.write(buffer, j);
                Http1xStream.this.f6168c.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f6176c) {
                Http1xStream.this.f6168c.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f6176c) {
                this.f6176c = true;
                Http1xStream.this.f6168c.writeUtf8("0\r\n\r\n");
                Http1xStream.this.m6825a(this.f6175b);
                int unused = Http1xStream.this.f6170e = 3;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$a */
    abstract class C1810a implements Source {

        /* renamed from: a */
        protected final ForwardingTimeout f6171a;

        /* renamed from: b */
        protected boolean f6172b;

        private C1810a() {
            this.f6171a = new ForwardingTimeout(Http1xStream.this.f6167b.timeout());
        }

        public Timeout timeout() {
            return this.f6171a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo11102a(boolean z) throws IOException {
            if (Http1xStream.this.f6170e != 6) {
                if (Http1xStream.this.f6170e != 5) {
                    throw new IllegalStateException("state: " + Http1xStream.this.f6170e);
                }
                Http1xStream.this.m6825a(this.f6171a);
                int unused = Http1xStream.this.f6170e = 6;
                if (Http1xStream.this.f6166a != null) {
                    Http1xStream.this.f6166a.streamFinished(!z, Http1xStream.this);
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$e */
    class C1814e extends C1810a {

        /* renamed from: e */
        private long f6186e;

        public C1814e(long j) throws IOException {
            super();
            this.f6186e = j;
            if (this.f6186e == 0) {
                mo11102a(true);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f6172b) {
                throw new IllegalStateException("closed");
            } else if (this.f6186e == 0) {
                return -1;
            } else {
                long read = Http1xStream.this.f6167b.read(buffer, Math.min(this.f6186e, j));
                if (read == -1) {
                    mo11102a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f6186e -= read;
                if (this.f6186e == 0) {
                    mo11102a(true);
                }
                return read;
            }
        }

        public void close() throws IOException {
            if (!this.f6172b) {
                if (this.f6186e != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    mo11102a(false);
                }
                this.f6172b = true;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$c */
    class C1812c extends C1810a {

        /* renamed from: e */
        private long f6178e = -1;

        /* renamed from: f */
        private boolean f6179f = true;

        /* renamed from: g */
        private final HttpEngine f6180g;

        C1812c(HttpEngine httpEngine) throws IOException {
            super();
            this.f6180g = httpEngine;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f6172b) {
                throw new IllegalStateException("closed");
            } else if (!this.f6179f) {
                return -1;
            } else {
                if (this.f6178e == 0 || this.f6178e == -1) {
                    m6830a();
                    if (!this.f6179f) {
                        return -1;
                    }
                }
                long read = Http1xStream.this.f6167b.read(buffer, Math.min(j, this.f6178e));
                if (read == -1) {
                    mo11102a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f6178e -= read;
                return read;
            }
        }

        /* renamed from: a */
        private void m6830a() throws IOException {
            if (this.f6178e != -1) {
                Http1xStream.this.f6167b.readUtf8LineStrict();
            }
            try {
                this.f6178e = Http1xStream.this.f6167b.readHexadecimalUnsignedLong();
                String trim = Http1xStream.this.f6167b.readUtf8LineStrict().trim();
                if (this.f6178e < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6178e + trim + "\"");
                } else if (this.f6178e == 0) {
                    this.f6179f = false;
                    this.f6180g.receiveHeaders(Http1xStream.this.readHeaders());
                    mo11102a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f6172b) {
                if (this.f6179f && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    mo11102a(false);
                }
                this.f6172b = true;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.Http1xStream$f */
    class C1815f extends C1810a {

        /* renamed from: e */
        private boolean f6188e;

        private C1815f() {
            super();
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f6172b) {
                throw new IllegalStateException("closed");
            } else if (this.f6188e) {
                return -1;
            } else {
                long read = Http1xStream.this.f6167b.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.f6188e = true;
                mo11102a(true);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.f6172b) {
                if (!this.f6188e) {
                    mo11102a(false);
                }
                this.f6172b = true;
            }
        }
    }
}
