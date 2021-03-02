package okhttp3.internal.framed;

import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.view.ViewCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.framed.FrameReader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection implements Closeable {

    /* renamed from: k */
    static final /* synthetic */ boolean f6024k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final ExecutorService f6025l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));

    /* renamed from: a */
    final Protocol f6026a;

    /* renamed from: b */
    final boolean f6027b;

    /* renamed from: c */
    long f6028c;

    /* renamed from: d */
    long f6029d;

    /* renamed from: e */
    Settings f6030e;

    /* renamed from: f */
    final Settings f6031f;

    /* renamed from: g */
    final Variant f6032g;

    /* renamed from: h */
    final Socket f6033h;

    /* renamed from: i */
    final FrameWriter f6034i;

    /* renamed from: j */
    final C1793a f6035j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Listener f6036m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Map<Integer, FramedStream> f6037n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final String f6038o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f6039p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f6040q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f6041r;

    /* renamed from: s */
    private long f6042s;

    /* renamed from: t */
    private final ExecutorService f6043t;

    /* renamed from: u */
    private Map<Integer, Ping> f6044u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final PushObserver f6045v;

    /* renamed from: w */
    private int f6046w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f6047x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final Set<Integer> f6048y;

    static {
        boolean z;
        if (!FramedConnection.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        f6024k = z;
    }

    private FramedConnection(Builder builder) throws IOException {
        int i = 2;
        this.f6037n = new HashMap();
        this.f6042s = System.nanoTime();
        this.f6028c = 0;
        this.f6030e = new Settings();
        this.f6031f = new Settings();
        this.f6047x = false;
        this.f6048y = new LinkedHashSet();
        this.f6026a = builder.f6080f;
        this.f6045v = builder.f6081g;
        this.f6027b = builder.f6082h;
        this.f6036m = builder.f6079e;
        this.f6040q = builder.f6082h ? 1 : 2;
        if (builder.f6082h && this.f6026a == Protocol.HTTP_2) {
            this.f6040q += 2;
        }
        this.f6046w = builder.f6082h ? 1 : i;
        if (builder.f6082h) {
            this.f6030e.mo11068a(7, 0, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        this.f6038o = builder.f6076b;
        if (this.f6026a == Protocol.HTTP_2) {
            this.f6032g = new Http2();
            this.f6043t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[]{this.f6038o}), true));
            this.f6031f.mo11068a(7, 0, SupportMenu.USER_MASK);
            this.f6031f.mo11068a(5, 0, 16384);
        } else if (this.f6026a == Protocol.SPDY_3) {
            this.f6032g = new Spdy3();
            this.f6043t = null;
        } else {
            throw new AssertionError(this.f6026a);
        }
        this.f6029d = (long) this.f6031f.mo11078f(65536);
        this.f6033h = builder.f6075a;
        this.f6034i = this.f6032g.newWriter(builder.f6078d, this.f6027b);
        this.f6035j = new C1793a(this.f6032g.newReader(builder.f6077c, this.f6027b));
        new Thread(this.f6035j).start();
    }

    public Protocol getProtocol() {
        return this.f6026a;
    }

    public synchronized int openStreamCount() {
        return this.f6037n.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized FramedStream mo10992a(int i) {
        return this.f6037n.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized FramedStream mo10997b(int i) {
        FramedStream remove;
        remove = this.f6037n.remove(Integer.valueOf(i));
        if (remove != null && this.f6037n.isEmpty()) {
            m6695a(true);
        }
        notifyAll();
        return remove;
    }

    /* renamed from: a */
    private synchronized void m6695a(boolean z) {
        this.f6042s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    public synchronized boolean isIdle() {
        return this.f6042s != Long.MAX_VALUE;
    }

    public synchronized int maxConcurrentStreams() {
        return this.f6031f.mo11076d(Integer.MAX_VALUE);
    }

    public synchronized long getIdleStartTimeNs() {
        return this.f6042s;
    }

    public FramedStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.f6027b) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.f6026a == Protocol.HTTP_2) {
            return m6684a(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    public FramedStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return m6684a(0, list, z, z2);
    }

    /* renamed from: a */
    private FramedStream m6684a(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        int i2;
        FramedStream framedStream;
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        synchronized (this.f6034i) {
            synchronized (this) {
                if (this.f6041r) {
                    throw new IOException("shutdown");
                }
                i2 = this.f6040q;
                this.f6040q += 2;
                framedStream = new FramedStream(i2, this, z4, z3, list);
                if (framedStream.isOpen()) {
                    this.f6037n.put(Integer.valueOf(i2), framedStream);
                    m6695a(false);
                }
            }
            if (i == 0) {
                this.f6034i.synStream(z4, z3, i2, i, list);
            } else if (this.f6027b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.f6034i.pushPromise(i, i2, list);
            }
        }
        if (!z) {
            this.f6034i.flush();
        }
        return framedStream;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10995a(int i, boolean z, List<Header> list) throws IOException {
        this.f6034i.synReply(z, i, list);
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        boolean z2;
        if (j == 0) {
            this.f6034i.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.f6029d <= 0) {
                    try {
                        if (!this.f6037n.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f6029d), this.f6034i.maxDataLength());
                this.f6029d -= (long) min;
            }
            j -= (long) min;
            FrameWriter frameWriter = this.f6034i;
            if (!z || j != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            frameWriter.data(z2, i, buffer, min);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10996a(long j) {
        this.f6029d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10994a(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        f6025l.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f6038o, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    FramedConnection.this.mo10998b(i2, errorCode2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10998b(int i, ErrorCode errorCode) throws IOException {
        this.f6034i.rstStream(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10993a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f6025l.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f6038o, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    FramedConnection.this.f6034i.windowUpdate(i2, j2);
                } catch (IOException e) {
                }
            }
        });
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.f6041r) {
                throw new IOException("shutdown");
            }
            i = this.f6046w;
            this.f6046w += 2;
            if (this.f6044u == null) {
                this.f6044u = new HashMap();
            }
            this.f6044u.put(Integer.valueOf(i), ping);
        }
        m6701b(false, i, 1330343787, ping);
        return ping;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6696a(boolean z, int i, int i2, Ping ping) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final Ping ping2 = ping;
        f6025l.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f6038o, Integer.valueOf(i), Integer.valueOf(i2)}) {
            public void execute() {
                try {
                    FramedConnection.this.m6701b(z2, i3, i4, ping2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6701b(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.f6034i) {
            if (ping != null) {
                ping.mo11059a();
            }
            this.f6034i.ping(z, i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized Ping m6705c(int i) {
        return this.f6044u != null ? this.f6044u.remove(Integer.valueOf(i)) : null;
    }

    public void flush() throws IOException {
        this.f6034i.flush();
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.f6034i) {
            synchronized (this) {
                if (!this.f6041r) {
                    this.f6041r = true;
                    int i = this.f6039p;
                    this.f6034i.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() throws IOException {
        m6688a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6688a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException iOException;
        FramedStream[] framedStreamArr;
        Ping[] pingArr;
        if (f6024k || !Thread.holdsLock(this)) {
            try {
                shutdown(errorCode);
                iOException = null;
            } catch (IOException e) {
                iOException = e;
            }
            synchronized (this) {
                if (!this.f6037n.isEmpty()) {
                    this.f6037n.clear();
                    m6695a(false);
                    framedStreamArr = (FramedStream[]) this.f6037n.values().toArray(new FramedStream[this.f6037n.size()]);
                } else {
                    framedStreamArr = null;
                }
                if (this.f6044u != null) {
                    this.f6044u = null;
                    pingArr = (Ping[]) this.f6044u.values().toArray(new Ping[this.f6044u.size()]);
                } else {
                    pingArr = null;
                }
            }
            if (framedStreamArr != null) {
                IOException iOException2 = iOException;
                for (FramedStream close : framedStreamArr) {
                    try {
                        close.close(errorCode2);
                    } catch (IOException e2) {
                        if (iOException2 != null) {
                            iOException2 = e2;
                        }
                    }
                }
                iOException = iOException2;
            }
            if (pingArr != null) {
                for (Ping c : pingArr) {
                    c.mo11061c();
                }
            }
            try {
                this.f6034i.close();
                e = iOException;
            } catch (IOException e3) {
                e = e3;
                if (iOException != null) {
                    e = iOException;
                }
            }
            try {
                this.f6033h.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    public void sendConnectionPreface() throws IOException {
        this.f6034i.connectionPreface();
        this.f6034i.settings(this.f6030e);
        int f = this.f6030e.mo11078f(65536);
        if (f != 65536) {
            this.f6034i.windowUpdate(0, (long) (f - 65536));
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.f6034i) {
            synchronized (this) {
                if (this.f6041r) {
                    throw new IOException("shutdown");
                }
                this.f6030e.mo11070a(settings);
                this.f6034i.settings(settings);
            }
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Socket f6075a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f6076b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public BufferedSource f6077c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public BufferedSink f6078d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Listener f6079e = Listener.REFUSE_INCOMING_STREAMS;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Protocol f6080f = Protocol.SPDY_3;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public PushObserver f6081g = PushObserver.CANCEL;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f6082h;

        public Builder(boolean z) throws IOException {
            this.f6082h = z;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f6075a = socket;
            this.f6076b = str;
            this.f6077c = bufferedSource;
            this.f6078d = bufferedSink;
            return this;
        }

        public Builder listener(Listener listener) {
            this.f6079e = listener;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.f6080f = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.f6081g = pushObserver;
            return this;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this);
        }
    }

    /* renamed from: okhttp3.internal.framed.FramedConnection$a */
    class C1793a extends NamedRunnable implements FrameReader.Handler {

        /* renamed from: a */
        final FrameReader f6083a;

        private C1793a(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.this.f6038o);
            this.f6083a = frameReader;
        }

        /* access modifiers changed from: protected */
        public void execute() {
            ErrorCode errorCode;
            Throwable th;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                if (!FramedConnection.this.f6027b) {
                    this.f6083a.readConnectionPreface();
                }
                do {
                } while (this.f6083a.nextFrame(this));
                try {
                    FramedConnection.this.m6688a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                Util.closeQuietly((Closeable) this.f6083a);
            } catch (IOException e2) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    FramedConnection.this.m6688a(errorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                Util.closeQuietly((Closeable) this.f6083a);
            } catch (Throwable th2) {
                th = th2;
                FramedConnection.this.m6688a(errorCode, errorCode3);
                Util.closeQuietly((Closeable) this.f6083a);
                throw th;
            }
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (FramedConnection.this.m6709d(i)) {
                FramedConnection.this.m6687a(i, bufferedSource, i2, z);
                return;
            }
            FramedStream a = FramedConnection.this.mo10992a(i);
            if (a == null) {
                FramedConnection.this.mo10994a(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip((long) i2);
                return;
            }
            a.mo11025a(bufferedSource, i2);
            if (z) {
                a.mo11021a();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0092, code lost:
            if (r14.failIfStreamPresent() == false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
            r0.closeLater(okhttp3.internal.framed.ErrorCode.PROTOCOL_ERROR);
            r8.f6084b.mo10997b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a0, code lost:
            r0.mo11023a(r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a5, code lost:
            r0.mo11021a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r9, boolean r10, int r11, int r12, java.util.List<okhttp3.internal.framed.Header> r13, okhttp3.internal.framed.HeadersMode r14) {
            /*
                r8 = this;
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this
                boolean r0 = r0.m6709d((int) r11)
                if (r0 == 0) goto L_0x000e
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this
                r0.m6686a((int) r11, (java.util.List<okhttp3.internal.framed.Header>) r13, (boolean) r10)
            L_0x000d:
                return
            L_0x000e:
                okhttp3.internal.framed.FramedConnection r6 = okhttp3.internal.framed.FramedConnection.this
                monitor-enter(r6)
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                boolean r0 = r0.f6041r     // Catch:{ all -> 0x001b }
                if (r0 == 0) goto L_0x001e
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x001b:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                throw r0
            L_0x001e:
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.FramedStream r0 = r0.mo10992a((int) r11)     // Catch:{ all -> 0x001b }
                if (r0 != 0) goto L_0x008d
                boolean r0 = r14.failIfStreamAbsent()     // Catch:{ all -> 0x001b }
                if (r0 == 0) goto L_0x0035
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.ErrorCode r1 = okhttp3.internal.framed.ErrorCode.INVALID_STREAM     // Catch:{ all -> 0x001b }
                r0.mo10994a((int) r11, (okhttp3.internal.framed.ErrorCode) r1)     // Catch:{ all -> 0x001b }
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x0035:
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                int r0 = r0.f6039p     // Catch:{ all -> 0x001b }
                if (r11 > r0) goto L_0x003f
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x003f:
                int r0 = r11 % 2
                okhttp3.internal.framed.FramedConnection r1 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                int r1 = r1.f6040q     // Catch:{ all -> 0x001b }
                int r1 = r1 % 2
                if (r0 != r1) goto L_0x004d
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x004d:
                okhttp3.internal.framed.FramedStream r0 = new okhttp3.internal.framed.FramedStream     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.FramedConnection r2 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                r1 = r11
                r3 = r9
                r4 = r10
                r5 = r13
                r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.FramedConnection r1 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                int unused = r1.f6039p = r11     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.FramedConnection r1 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                java.util.Map r1 = r1.f6037n     // Catch:{ all -> 0x001b }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x001b }
                r1.put(r2, r0)     // Catch:{ all -> 0x001b }
                java.util.concurrent.ExecutorService r1 = okhttp3.internal.framed.FramedConnection.f6025l     // Catch:{ all -> 0x001b }
                okhttp3.internal.framed.FramedConnection$a$1 r2 = new okhttp3.internal.framed.FramedConnection$a$1     // Catch:{ all -> 0x001b }
                java.lang.String r3 = "OkHttp %s stream %d"
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x001b }
                r5 = 0
                okhttp3.internal.framed.FramedConnection r7 = okhttp3.internal.framed.FramedConnection.this     // Catch:{ all -> 0x001b }
                java.lang.String r7 = r7.f6038o     // Catch:{ all -> 0x001b }
                r4[r5] = r7     // Catch:{ all -> 0x001b }
                r5 = 1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x001b }
                r4[r5] = r7     // Catch:{ all -> 0x001b }
                r2.<init>(r3, r4, r0)     // Catch:{ all -> 0x001b }
                r1.execute(r2)     // Catch:{ all -> 0x001b }
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x008d:
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                boolean r1 = r14.failIfStreamPresent()
                if (r1 == 0) goto L_0x00a0
                okhttp3.internal.framed.ErrorCode r1 = okhttp3.internal.framed.ErrorCode.PROTOCOL_ERROR
                r0.closeLater(r1)
                okhttp3.internal.framed.FramedConnection r0 = okhttp3.internal.framed.FramedConnection.this
                r0.mo10997b((int) r11)
                goto L_0x000d
            L_0x00a0:
                r0.mo11023a((java.util.List<okhttp3.internal.framed.Header>) r13, (okhttp3.internal.framed.HeadersMode) r14)
                if (r10 == 0) goto L_0x000d
                r0.mo11021a()
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.FramedConnection.C1793a.headers(boolean, boolean, int, int, java.util.List, okhttp3.internal.framed.HeadersMode):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (FramedConnection.this.m6709d(i)) {
                FramedConnection.this.m6707c(i, errorCode);
                return;
            }
            FramedStream b = FramedConnection.this.mo10997b(i);
            if (b != null) {
                b.mo11024a(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            FramedStream[] framedStreamArr;
            long j;
            synchronized (FramedConnection.this) {
                int f = FramedConnection.this.f6031f.mo11078f(65536);
                if (z) {
                    FramedConnection.this.f6031f.mo11069a();
                }
                FramedConnection.this.f6031f.mo11070a(settings);
                if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
                    m6730a(settings);
                }
                int f2 = FramedConnection.this.f6031f.mo11078f(65536);
                if (f2 == -1 || f2 == f) {
                    framedStreamArr = null;
                    j = 0;
                } else {
                    long j2 = (long) (f2 - f);
                    if (!FramedConnection.this.f6047x) {
                        FramedConnection.this.mo10996a(j2);
                        boolean unused = FramedConnection.this.f6047x = true;
                    }
                    if (!FramedConnection.this.f6037n.isEmpty()) {
                        j = j2;
                        framedStreamArr = (FramedStream[]) FramedConnection.this.f6037n.values().toArray(new FramedStream[FramedConnection.this.f6037n.size()]);
                    } else {
                        j = j2;
                        framedStreamArr = null;
                    }
                }
                FramedConnection.f6025l.execute(new NamedRunnable("OkHttp %s settings", FramedConnection.this.f6038o) {
                    public void execute() {
                        FramedConnection.this.f6036m.onSettings(FramedConnection.this);
                    }
                });
            }
            if (framedStreamArr != null && j != 0) {
                for (FramedStream framedStream : framedStreamArr) {
                    synchronized (framedStream) {
                        framedStream.mo11022a(j);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m6730a(final Settings settings) {
            FramedConnection.f6025l.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.f6038o}) {
                public void execute() {
                    try {
                        FramedConnection.this.f6034i.ackSettings(settings);
                    } catch (IOException e) {
                    }
                }
            });
        }

        public void ackSettings() {
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                Ping c = FramedConnection.this.m6705c(i);
                if (c != null) {
                    c.mo11060b();
                    return;
                }
                return;
            }
            FramedConnection.this.m6696a(true, i, i2, (Ping) null);
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] framedStreamArr;
            if (byteString.size() > 0) {
            }
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.this.f6037n.values().toArray(new FramedStream[FramedConnection.this.f6037n.size()]);
                boolean unused = FramedConnection.this.f6041r = true;
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.getId() > i && framedStream.isLocallyInitiated()) {
                    framedStream.mo11024a(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.mo10997b(framedStream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection.this.f6029d += j;
                    FramedConnection.this.notifyAll();
                }
                return;
            }
            FramedStream a = FramedConnection.this.mo10992a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo11022a(j);
                }
            }
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            FramedConnection.this.m6685a(i2, list);
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m6709d(int i) {
        return this.f6026a == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6685a(int i, List<Header> list) {
        synchronized (this) {
            if (this.f6048y.contains(Integer.valueOf(i))) {
                mo10994a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f6048y.add(Integer.valueOf(i));
            final int i2 = i;
            final List<Header> list2 = list;
            this.f6043t.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f6038o, Integer.valueOf(i)}) {
                public void execute() {
                    if (FramedConnection.this.f6045v.onRequest(i2, list2)) {
                        try {
                            FramedConnection.this.f6034i.rstStream(i2, ErrorCode.CANCEL);
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.f6048y.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6686a(int i, List<Header> list, boolean z) {
        final int i2 = i;
        final List<Header> list2 = list;
        final boolean z2 = z;
        this.f6043t.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f6038o, Integer.valueOf(i)}) {
            public void execute() {
                boolean onHeaders = FramedConnection.this.f6045v.onHeaders(i2, list2, z2);
                if (onHeaders) {
                    try {
                        FramedConnection.this.f6034i.rstStream(i2, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (onHeaders || z2) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.this.f6048y.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6687a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        bufferedSource.require((long) i2);
        bufferedSource.read(buffer, (long) i2);
        if (buffer.size() != ((long) i2)) {
            throw new IOException(buffer.size() + " != " + i2);
        }
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        this.f6043t.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f6038o, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    boolean onData = FramedConnection.this.f6045v.onData(i3, buffer, i4, z2);
                    if (onData) {
                        FramedConnection.this.f6034i.rstStream(i3, ErrorCode.CANCEL);
                    }
                    if (onData || z2) {
                        synchronized (FramedConnection.this) {
                            FramedConnection.this.f6048y.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6707c(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.f6043t.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f6038o, Integer.valueOf(i)}) {
            public void execute() {
                FramedConnection.this.f6045v.onReset(i2, errorCode2);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.f6048y.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(FramedStream framedStream) throws IOException {
                framedStream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public abstract void onStream(FramedStream framedStream) throws IOException;

        public void onSettings(FramedConnection framedConnection) {
        }
    }
}
