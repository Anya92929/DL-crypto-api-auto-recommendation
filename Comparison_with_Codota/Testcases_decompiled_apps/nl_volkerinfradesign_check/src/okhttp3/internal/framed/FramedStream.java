package okhttp3.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {

    /* renamed from: d */
    static final /* synthetic */ boolean f6090d = (!FramedStream.class.desiredAssertionStatus());

    /* renamed from: a */
    long f6091a = 0;

    /* renamed from: b */
    long f6092b;

    /* renamed from: c */
    final C1798a f6093c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f6094e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final FramedConnection f6095f;

    /* renamed from: g */
    private final List<Header> f6096g;

    /* renamed from: h */
    private List<Header> f6097h;

    /* renamed from: i */
    private final C1799b f6098i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C1800c f6099j = new C1800c();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C1800c f6100k = new C1800c();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ErrorCode f6101l = null;

    FramedStream(int i, FramedConnection framedConnection, boolean z, boolean z2, List<Header> list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f6094e = i;
            this.f6095f = framedConnection;
            this.f6092b = (long) framedConnection.f6031f.mo11078f(65536);
            this.f6098i = new C1799b((long) framedConnection.f6030e.mo11078f(65536));
            this.f6093c = new C1798a();
            boolean unused = this.f6098i.f6113g = z2;
            boolean unused2 = this.f6093c.f6106e = z;
            this.f6096g = list;
        }
    }

    public int getId() {
        return this.f6094e;
    }

    public synchronized boolean isOpen() {
        boolean z = false;
        synchronized (this) {
            if (this.f6101l == null) {
                if ((!this.f6098i.f6113g && !this.f6098i.f6112f) || ((!this.f6093c.f6106e && !this.f6093c.f6105d) || this.f6097h == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isLocallyInitiated() {
        boolean z;
        if ((this.f6094e & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        return this.f6095f.f6027b == z;
    }

    public FramedConnection getConnection() {
        return this.f6095f;
    }

    public List<Header> getRequestHeaders() {
        return this.f6096g;
    }

    public synchronized List<Header> getResponseHeaders() throws IOException {
        this.f6099j.enter();
        while (this.f6097h == null && this.f6101l == null) {
            try {
                m6738d();
            } catch (Throwable th) {
                this.f6099j.mo11041a();
                throw th;
            }
        }
        this.f6099j.mo11041a();
        if (this.f6097h != null) {
        } else {
            throw new IOException("stream was reset: " + this.f6101l);
        }
        return this.f6097h;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.f6101l;
    }

    public void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = true;
        if (f6090d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (list == null) {
                    throw new NullPointerException("responseHeaders == null");
                } else if (this.f6097h != null) {
                    throw new IllegalStateException("reply already sent");
                } else {
                    this.f6097h = list;
                    if (!z) {
                        boolean unused = this.f6093c.f6106e = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            this.f6095f.mo10995a(this.f6094e, z2, list);
            if (z2) {
                this.f6095f.flush();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Timeout readTimeout() {
        return this.f6099j;
    }

    public Timeout writeTimeout() {
        return this.f6100k;
    }

    public Source getSource() {
        return this.f6098i;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.f6097h == null && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f6093c;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (m6734b(errorCode)) {
            this.f6095f.mo10998b(this.f6094e, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (m6734b(errorCode)) {
            this.f6095f.mo10994a(this.f6094e, errorCode);
        }
    }

    /* renamed from: b */
    private boolean m6734b(ErrorCode errorCode) {
        if (f6090d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f6101l != null) {
                    return false;
                }
                if (this.f6098i.f6113g && this.f6093c.f6106e) {
                    return false;
                }
                this.f6101l = errorCode;
                notifyAll();
                this.f6095f.mo10997b(this.f6094e);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11023a(List<Header> list, HeadersMode headersMode) {
        if (f6090d || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean z = true;
            synchronized (this) {
                if (this.f6097h == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f6097h = list;
                        z = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f6097h);
                    arrayList.addAll(list);
                    this.f6097h = arrayList;
                }
            }
            if (errorCode != null) {
                closeLater(errorCode);
            } else if (!z) {
                this.f6095f.mo10997b(this.f6094e);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11025a(BufferedSource bufferedSource, int i) throws IOException {
        if (f6090d || !Thread.holdsLock(this)) {
            this.f6098i.mo11040a(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11021a() {
        boolean isOpen;
        if (f6090d || !Thread.holdsLock(this)) {
            synchronized (this) {
                boolean unused = this.f6098i.f6113g = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.f6095f.mo10997b(this.f6094e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo11024a(ErrorCode errorCode) {
        if (this.f6101l == null) {
            this.f6101l = errorCode;
            notifyAll();
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedStream$b */
    final class C1799b implements Source {

        /* renamed from: a */
        static final /* synthetic */ boolean f6107a = (!FramedStream.class.desiredAssertionStatus());

        /* renamed from: c */
        private final Buffer f6109c;

        /* renamed from: d */
        private final Buffer f6110d;

        /* renamed from: e */
        private final long f6111e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f6112f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f6113g;

        private C1799b(long j) {
            this.f6109c = new Buffer();
            this.f6110d = new Buffer();
            this.f6111e = j;
        }

        public long read(Buffer buffer, long j) throws IOException {
            long read;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (FramedStream.this) {
                m6752a();
                m6755b();
                if (this.f6110d.size() == 0) {
                    read = -1;
                } else {
                    read = this.f6110d.read(buffer, Math.min(j, this.f6110d.size()));
                    FramedStream.this.f6091a += read;
                    if (FramedStream.this.f6091a >= ((long) (FramedStream.this.f6095f.f6030e.mo11078f(65536) / 2))) {
                        FramedStream.this.f6095f.mo10993a(FramedStream.this.f6094e, FramedStream.this.f6091a);
                        FramedStream.this.f6091a = 0;
                    }
                    synchronized (FramedStream.this.f6095f) {
                        FramedStream.this.f6095f.f6028c += read;
                        if (FramedStream.this.f6095f.f6028c >= ((long) (FramedStream.this.f6095f.f6030e.mo11078f(65536) / 2))) {
                            FramedStream.this.f6095f.mo10993a(0, FramedStream.this.f6095f.f6028c);
                            FramedStream.this.f6095f.f6028c = 0;
                        }
                    }
                }
            }
            return read;
        }

        /* renamed from: a */
        private void m6752a() throws IOException {
            FramedStream.this.f6099j.enter();
            while (this.f6110d.size() == 0 && !this.f6113g && !this.f6112f && FramedStream.this.f6101l == null) {
                try {
                    FramedStream.this.m6738d();
                } finally {
                    FramedStream.this.f6099j.mo11041a();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11040a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f6107a || !Thread.holdsLock(FramedStream.this)) {
                while (j > 0) {
                    synchronized (FramedStream.this) {
                        z = this.f6113g;
                        z2 = this.f6110d.size() + j > this.f6111e;
                    }
                    if (z2) {
                        bufferedSource.skip(j);
                        FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f6109c, j);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        j -= read;
                        synchronized (FramedStream.this) {
                            if (this.f6110d.size() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            this.f6110d.writeAll(this.f6109c);
                            if (z3) {
                                FramedStream.this.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return FramedStream.this.f6099j;
        }

        public void close() throws IOException {
            synchronized (FramedStream.this) {
                this.f6112f = true;
                this.f6110d.clear();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.m6733b();
        }

        /* renamed from: b */
        private void m6755b() throws IOException {
            if (this.f6112f) {
                throw new IOException("stream closed");
            } else if (FramedStream.this.f6101l != null) {
                throw new IOException("stream was reset: " + FramedStream.this.f6101l);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6733b() throws IOException {
        boolean z;
        boolean isOpen;
        if (f6090d || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f6098i.f6113g && this.f6098i.f6112f && (this.f6093c.f6106e || this.f6093c.f6105d);
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL);
            } else if (!isOpen) {
                this.f6095f.mo10997b(this.f6094e);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedStream$a */
    final class C1798a implements Sink {

        /* renamed from: a */
        static final /* synthetic */ boolean f6102a = (!FramedStream.class.desiredAssertionStatus());

        /* renamed from: c */
        private final Buffer f6104c = new Buffer();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f6105d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f6106e;

        C1798a() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (f6102a || !Thread.holdsLock(FramedStream.this)) {
                this.f6104c.write(buffer, j);
                while (this.f6104c.size() >= 16384) {
                    m6748a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        private void m6748a(boolean z) throws IOException {
            long min;
            synchronized (FramedStream.this) {
                FramedStream.this.f6100k.enter();
                while (FramedStream.this.f6092b <= 0 && !this.f6106e && !this.f6105d && FramedStream.this.f6101l == null) {
                    try {
                        FramedStream.this.m6738d();
                    } catch (Throwable th) {
                        FramedStream.this.f6100k.mo11041a();
                        throw th;
                    }
                }
                FramedStream.this.f6100k.mo11041a();
                FramedStream.this.m6736c();
                min = Math.min(FramedStream.this.f6092b, this.f6104c.size());
                FramedStream.this.f6092b -= min;
            }
            FramedStream.this.f6100k.enter();
            try {
                FramedStream.this.f6095f.writeData(FramedStream.this.f6094e, z && min == this.f6104c.size(), this.f6104c, min);
            } finally {
                FramedStream.this.f6100k.mo11041a();
            }
        }

        public void flush() throws IOException {
            if (f6102a || !Thread.holdsLock(FramedStream.this)) {
                synchronized (FramedStream.this) {
                    FramedStream.this.m6736c();
                }
                while (this.f6104c.size() > 0) {
                    m6748a(false);
                    FramedStream.this.f6095f.flush();
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return FramedStream.this.f6100k;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r6.f6103b.f6093c.f6106e != false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            if (r6.f6104c.size() <= 0) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r6.f6104c.size() <= 0) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
            m6748a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            okhttp3.internal.framed.FramedStream.m6731a(r6.f6103b).writeData(okhttp3.internal.framed.FramedStream.m6732b(r6.f6103b), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
            r1 = r6.f6103b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r6.f6105d = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
            okhttp3.internal.framed.FramedStream.m6731a(r6.f6103b).flush();
            okhttp3.internal.framed.FramedStream.m6740f(r6.f6103b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r6 = this;
                r4 = 0
                r2 = 1
                boolean r0 = f6102a
                if (r0 != 0) goto L_0x0015
                okhttp3.internal.framed.FramedStream r0 = okhttp3.internal.framed.FramedStream.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 == 0) goto L_0x0015
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0015:
                okhttp3.internal.framed.FramedStream r1 = okhttp3.internal.framed.FramedStream.this
                monitor-enter(r1)
                boolean r0 = r6.f6105d     // Catch:{ all -> 0x003f }
                if (r0 == 0) goto L_0x001e
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
            L_0x001d:
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                okhttp3.internal.framed.FramedStream r0 = okhttp3.internal.framed.FramedStream.this
                okhttp3.internal.framed.FramedStream$a r0 = r0.f6093c
                boolean r0 = r0.f6106e
                if (r0 != 0) goto L_0x0052
                okio.Buffer r0 = r6.f6104c
                long r0 = r0.size()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0042
            L_0x0031:
                okio.Buffer r0 = r6.f6104c
                long r0 = r0.size()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0052
                r6.m6748a((boolean) r2)
                goto L_0x0031
            L_0x003f:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                throw r0
            L_0x0042:
                okhttp3.internal.framed.FramedStream r0 = okhttp3.internal.framed.FramedStream.this
                okhttp3.internal.framed.FramedConnection r0 = r0.f6095f
                okhttp3.internal.framed.FramedStream r1 = okhttp3.internal.framed.FramedStream.this
                int r1 = r1.f6094e
                r3 = 0
                r0.writeData(r1, r2, r3, r4)
            L_0x0052:
                okhttp3.internal.framed.FramedStream r1 = okhttp3.internal.framed.FramedStream.this
                monitor-enter(r1)
                r0 = 1
                r6.f6105d = r0     // Catch:{ all -> 0x0068 }
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                okhttp3.internal.framed.FramedStream r0 = okhttp3.internal.framed.FramedStream.this
                okhttp3.internal.framed.FramedConnection r0 = r0.f6095f
                r0.flush()
                okhttp3.internal.framed.FramedStream r0 = okhttp3.internal.framed.FramedStream.this
                r0.m6733b()
                goto L_0x001d
            L_0x0068:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedStream.C1798a.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11022a(long j) {
        this.f6092b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6736c() throws IOException {
        if (this.f6093c.f6105d) {
            throw new IOException("stream closed");
        } else if (this.f6093c.f6106e) {
            throw new IOException("stream finished");
        } else if (this.f6101l != null) {
            throw new IOException("stream was reset: " + this.f6101l);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6738d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedStream$c */
    class C1800c extends AsyncTimeout {
        C1800c() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: a */
        public void mo11041a() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }
    }
}
