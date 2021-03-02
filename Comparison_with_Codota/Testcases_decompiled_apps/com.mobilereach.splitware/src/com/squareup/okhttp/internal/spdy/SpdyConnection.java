package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
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
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class SpdyConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    /* access modifiers changed from: private */
    public final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    /* access modifiers changed from: private */
    public final IncomingStreamHandler handler;
    /* access modifiers changed from: private */
    public final String hostName;
    private long idleStartTimeNs;
    /* access modifiers changed from: private */
    public int lastGoodStreamId;
    private int nextPingId;
    /* access modifiers changed from: private */
    public int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    /* access modifiers changed from: private */
    public final PushObserver pushObserver;
    final Reader readerRunnable;
    /* access modifiers changed from: private */
    public boolean receivedInitialPeerSettings;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    /* access modifiers changed from: private */
    public final Map<Integer, SpdyStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    static {
        boolean z;
        if (!SpdyConnection.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
    }

    private SpdyConnection(Builder builder) throws IOException {
        int i = 2;
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.handler = builder.handler;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : i;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        this.hostName = builder.hostName;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[]{this.hostName}), true));
            this.peerSettings.set(7, 0, 65535);
            this.peerSettings.set(5, 0, 16384);
        } else if (this.protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(this.protocol);
        }
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(Okio.buffer(Okio.sink(builder.socket)), this.client);
        this.readerRunnable = new Reader();
        new Thread(this.readerRunnable).start();
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized SpdyStream getStream(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    /* access modifiers changed from: package-private */
    public synchronized SpdyStream removeStream(int streamId) {
        SpdyStream stream;
        stream = this.streams.remove(Integer.valueOf(streamId));
        if (stream != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        return stream;
    }

    private synchronized void setIdle(boolean value) {
        this.idleStartTimeNs = value ? System.nanoTime() : Long.MAX_VALUE;
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public SpdyStream pushStream(int associatedStreamId, List<Header> requestHeaders, boolean out) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(associatedStreamId, requestHeaders, out, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    public SpdyStream newStream(List<Header> requestHeaders, boolean out, boolean in) throws IOException {
        return newStream(0, requestHeaders, out, in);
    }

    private SpdyStream newStream(int associatedStreamId, List<Header> requestHeaders, boolean out, boolean in) throws IOException {
        boolean outFinished;
        int streamId;
        SpdyStream stream;
        boolean inFinished = true;
        if (!out) {
            outFinished = true;
        } else {
            outFinished = false;
        }
        if (in) {
            inFinished = false;
        }
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                streamId = this.nextStreamId;
                this.nextStreamId += 2;
                stream = new SpdyStream(streamId, this, outFinished, inFinished, requestHeaders);
                if (stream.isOpen()) {
                    this.streams.put(Integer.valueOf(streamId), stream);
                    setIdle(false);
                }
            }
            if (associatedStreamId == 0) {
                this.frameWriter.synStream(outFinished, inFinished, streamId, associatedStreamId, requestHeaders);
            } else if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.frameWriter.pushPromise(associatedStreamId, streamId, requestHeaders);
            }
        }
        if (!out) {
            this.frameWriter.flush();
        }
        return stream;
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int streamId, boolean outFinished, List<Header> alternating) throws IOException {
        this.frameWriter.synReply(outFinished, streamId, alternating);
    }

    public void writeData(int streamId, boolean outFinished, Buffer buffer, long byteCount) throws IOException {
        int toWrite;
        boolean z;
        if (byteCount == 0) {
            this.frameWriter.data(outFinished, streamId, buffer, 0);
            return;
        }
        while (byteCount > 0) {
            synchronized (this) {
                while (this.bytesLeftInWriteWindow <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                toWrite = Math.min((int) Math.min(byteCount, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
                this.bytesLeftInWriteWindow -= (long) toWrite;
            }
            byteCount -= (long) toWrite;
            FrameWriter frameWriter2 = this.frameWriter;
            if (!outFinished || byteCount != 0) {
                z = false;
            } else {
                z = true;
            }
            frameWriter2.data(z, streamId, buffer, toWrite);
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long delta) {
        this.bytesLeftInWriteWindow += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int streamId, ErrorCode errorCode) {
        final int i = streamId;
        final ErrorCode errorCode2 = errorCode;
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i, errorCode2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int streamId, ErrorCode statusCode) throws IOException {
        this.frameWriter.rstStream(streamId, statusCode);
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int streamId, long unacknowledgedBytesRead2) {
        final int i = streamId;
        final long j = unacknowledgedBytesRead2;
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
            public void execute() {
                try {
                    SpdyConnection.this.frameWriter.windowUpdate(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    public Ping ping() throws IOException {
        int pingId;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            pingId = this.nextPingId;
            this.nextPingId += 2;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put(Integer.valueOf(pingId), ping);
        }
        writePing(false, pingId, 1330343787, ping);
        return ping;
    }

    /* access modifiers changed from: private */
    public void writePingLater(boolean reply, int payload1, int payload2, Ping ping) {
        final boolean z = reply;
        final int i = payload1;
        final int i2 = payload2;
        final Ping ping2 = ping;
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(payload1), Integer.valueOf(payload2)}) {
            public void execute() {
                try {
                    SpdyConnection.this.writePing(z, i, i2, ping2);
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void writePing(boolean reply, int payload1, int payload2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(reply, payload1, payload2);
        }
    }

    /* access modifiers changed from: private */
    public synchronized Ping removePing(int id) {
        return this.pings != null ? this.pings.remove(Integer.valueOf(id)) : null;
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public void shutdown(ErrorCode statusCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int lastGoodStreamId2 = this.lastGoodStreamId;
                    this.frameWriter.goAway(lastGoodStreamId2, statusCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* JADX WARNING: type inference failed for: r7v15, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r7v19, types: [java.lang.Object[]] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(com.squareup.okhttp.internal.spdy.ErrorCode r11, com.squareup.okhttp.internal.spdy.ErrorCode r12) throws java.io.IOException {
        /*
            r10 = this;
            r8 = 0
            boolean r7 = $assertionsDisabled
            if (r7 != 0) goto L_0x0011
            boolean r7 = java.lang.Thread.holdsLock(r10)
            if (r7 == 0) goto L_0x0011
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0011:
            r6 = 0
            r10.shutdown(r11)     // Catch:{ IOException -> 0x006b }
        L_0x0015:
            r5 = 0
            r3 = 0
            monitor-enter(r10)
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.SpdyStream> r7 = r10.streams     // Catch:{ all -> 0x006e }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x006e }
            if (r7 != 0) goto L_0x003f
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.SpdyStream> r7 = r10.streams     // Catch:{ all -> 0x006e }
            java.util.Collection r7 = r7.values()     // Catch:{ all -> 0x006e }
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.SpdyStream> r9 = r10.streams     // Catch:{ all -> 0x006e }
            int r9 = r9.size()     // Catch:{ all -> 0x006e }
            com.squareup.okhttp.internal.spdy.SpdyStream[] r9 = new com.squareup.okhttp.internal.spdy.SpdyStream[r9]     // Catch:{ all -> 0x006e }
            java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x006e }
            r0 = r7
            com.squareup.okhttp.internal.spdy.SpdyStream[] r0 = (com.squareup.okhttp.internal.spdy.SpdyStream[]) r0     // Catch:{ all -> 0x006e }
            r5 = r0
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.SpdyStream> r7 = r10.streams     // Catch:{ all -> 0x006e }
            r7.clear()     // Catch:{ all -> 0x006e }
            r7 = 0
            r10.setIdle(r7)     // Catch:{ all -> 0x006e }
        L_0x003f:
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.Ping> r7 = r10.pings     // Catch:{ all -> 0x006e }
            if (r7 == 0) goto L_0x005c
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.Ping> r7 = r10.pings     // Catch:{ all -> 0x006e }
            java.util.Collection r7 = r7.values()     // Catch:{ all -> 0x006e }
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.spdy.Ping> r9 = r10.pings     // Catch:{ all -> 0x006e }
            int r9 = r9.size()     // Catch:{ all -> 0x006e }
            com.squareup.okhttp.internal.spdy.Ping[] r9 = new com.squareup.okhttp.internal.spdy.Ping[r9]     // Catch:{ all -> 0x006e }
            java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x006e }
            r0 = r7
            com.squareup.okhttp.internal.spdy.Ping[] r0 = (com.squareup.okhttp.internal.spdy.Ping[]) r0     // Catch:{ all -> 0x006e }
            r3 = r0
            r7 = 0
            r10.pings = r7     // Catch:{ all -> 0x006e }
        L_0x005c:
            monitor-exit(r10)     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x0076
            int r9 = r5.length
            r7 = r8
        L_0x0061:
            if (r7 >= r9) goto L_0x0076
            r4 = r5[r7]
            r4.close(r12)     // Catch:{ IOException -> 0x0071 }
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x0061
        L_0x006b:
            r1 = move-exception
            r6 = r1
            goto L_0x0015
        L_0x006e:
            r7 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x006e }
            throw r7
        L_0x0071:
            r1 = move-exception
            if (r6 == 0) goto L_0x0068
            r6 = r1
            goto L_0x0068
        L_0x0076:
            if (r3 == 0) goto L_0x0084
            int r9 = r3.length
            r7 = r8
        L_0x007a:
            if (r7 >= r9) goto L_0x0084
            r2 = r3[r7]
            r2.cancel()
            int r7 = r7 + 1
            goto L_0x007a
        L_0x0084:
            com.squareup.okhttp.internal.spdy.FrameWriter r7 = r10.frameWriter     // Catch:{ IOException -> 0x0091 }
            r7.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0089:
            java.net.Socket r7 = r10.socket     // Catch:{ IOException -> 0x0096 }
            r7.close()     // Catch:{ IOException -> 0x0096 }
        L_0x008e:
            if (r6 == 0) goto L_0x0099
            throw r6
        L_0x0091:
            r1 = move-exception
            if (r6 != 0) goto L_0x0089
            r6 = r1
            goto L_0x0089
        L_0x0096:
            r1 = move-exception
            r6 = r1
            goto L_0x008e
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyConnection.close(com.squareup.okhttp.internal.spdy.ErrorCode, com.squareup.okhttp.internal.spdy.ErrorCode):void");
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int windowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (windowSize != 65536) {
            this.frameWriter.windowUpdate(0, (long) (windowSize - 65536));
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean client;
        /* access modifiers changed from: private */
        public IncomingStreamHandler handler;
        /* access modifiers changed from: private */
        public String hostName;
        /* access modifiers changed from: private */
        public Protocol protocol;
        /* access modifiers changed from: private */
        public PushObserver pushObserver;
        /* access modifiers changed from: private */
        public Socket socket;

        public Builder(boolean client2, Socket socket2) throws IOException {
            this(((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), client2, socket2);
        }

        public Builder(String hostName2, boolean client2, Socket socket2) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = hostName2;
            this.client = client2;
            this.socket = socket2;
        }

        public Builder handler(IncomingStreamHandler handler2) {
            this.handler = handler2;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public SpdyConnection build() throws IOException {
            return new SpdyConnection(this);
        }
    }

    class Reader extends NamedRunnable implements FrameReader.Handler {
        FrameReader frameReader;

        private Reader() {
            super("OkHttp %s", SpdyConnection.this.hostName);
        }

        /* access modifiers changed from: protected */
        public void execute() {
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode = ErrorCode.INTERNAL_ERROR;
            try {
                this.frameReader = SpdyConnection.this.variant.newReader(Okio.buffer(Okio.source(SpdyConnection.this.socket)), SpdyConnection.this.client);
                if (!SpdyConnection.this.client) {
                    this.frameReader.readConnectionPreface();
                }
                do {
                } while (this.frameReader.nextFrame(this));
                try {
                    SpdyConnection.this.close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                Util.closeQuietly((Closeable) this.frameReader);
            } catch (IOException e2) {
                connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    SpdyConnection.this.close(connectionErrorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                Util.closeQuietly((Closeable) this.frameReader);
            } catch (Throwable th) {
                try {
                    SpdyConnection.this.close(connectionErrorCode, streamErrorCode);
                } catch (IOException e4) {
                }
                Util.closeQuietly((Closeable) this.frameReader);
                throw th;
            }
        }

        public void data(boolean inFinished, int streamId, BufferedSource source, int length) throws IOException {
            if (SpdyConnection.this.pushedStream(streamId)) {
                SpdyConnection.this.pushDataLater(streamId, source, length, inFinished);
                return;
            }
            SpdyStream dataStream = SpdyConnection.this.getStream(streamId);
            if (dataStream == null) {
                SpdyConnection.this.writeSynResetLater(streamId, ErrorCode.INVALID_STREAM);
                source.skip((long) length);
                return;
            }
            dataStream.receiveData(source, length);
            if (inFinished) {
                dataStream.receiveFin();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0092, code lost:
            if (r15.failIfStreamPresent() == false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
            r6.closeLater(com.squareup.okhttp.internal.spdy.ErrorCode.PROTOCOL_ERROR);
            r9.this$0.removeStream(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a0, code lost:
            r6.receiveHeaders(r14, r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
            if (r11 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a5, code lost:
            r6.receiveFin();
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
        public void headers(boolean r10, boolean r11, int r12, int r13, java.util.List<com.squareup.okhttp.internal.spdy.Header> r14, com.squareup.okhttp.internal.spdy.HeadersMode r15) {
            /*
                r9 = this;
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this
                boolean r1 = r1.pushedStream(r12)
                if (r1 == 0) goto L_0x000e
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this
                r1.pushHeadersLater(r12, r14, r11)
            L_0x000d:
                return
            L_0x000e:
                com.squareup.okhttp.internal.spdy.SpdyConnection r7 = com.squareup.okhttp.internal.spdy.SpdyConnection.this
                monitor-enter(r7)
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                boolean r1 = r1.shutdown     // Catch:{ all -> 0x001b }
                if (r1 == 0) goto L_0x001e
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x001b:
                r1 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                throw r1
            L_0x001e:
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.SpdyStream r6 = r1.getStream(r12)     // Catch:{ all -> 0x001b }
                if (r6 != 0) goto L_0x008d
                boolean r1 = r15.failIfStreamAbsent()     // Catch:{ all -> 0x001b }
                if (r1 == 0) goto L_0x0035
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.ErrorCode r2 = com.squareup.okhttp.internal.spdy.ErrorCode.INVALID_STREAM     // Catch:{ all -> 0x001b }
                r1.writeSynResetLater(r12, r2)     // Catch:{ all -> 0x001b }
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x0035:
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                int r1 = r1.lastGoodStreamId     // Catch:{ all -> 0x001b }
                if (r12 > r1) goto L_0x003f
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x003f:
                int r1 = r12 % 2
                com.squareup.okhttp.internal.spdy.SpdyConnection r2 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                int r2 = r2.nextStreamId     // Catch:{ all -> 0x001b }
                int r2 = r2 % 2
                if (r1 != r2) goto L_0x004d
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x004d:
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = new com.squareup.okhttp.internal.spdy.SpdyStream     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.SpdyConnection r2 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                r1 = r12
                r3 = r10
                r4 = r11
                r5 = r14
                r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                int unused = r1.lastGoodStreamId = r12     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                java.util.Map r1 = r1.streams     // Catch:{ all -> 0x001b }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x001b }
                r1.put(r2, r0)     // Catch:{ all -> 0x001b }
                java.util.concurrent.ExecutorService r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.executor     // Catch:{ all -> 0x001b }
                com.squareup.okhttp.internal.spdy.SpdyConnection$Reader$1 r2 = new com.squareup.okhttp.internal.spdy.SpdyConnection$Reader$1     // Catch:{ all -> 0x001b }
                java.lang.String r3 = "OkHttp %s stream %d"
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x001b }
                r5 = 0
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x001b }
                java.lang.String r8 = r8.hostName     // Catch:{ all -> 0x001b }
                r4[r5] = r8     // Catch:{ all -> 0x001b }
                r5 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x001b }
                r4[r5] = r8     // Catch:{ all -> 0x001b }
                r2.<init>(r3, r4, r0)     // Catch:{ all -> 0x001b }
                r1.execute(r2)     // Catch:{ all -> 0x001b }
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                goto L_0x000d
            L_0x008d:
                monitor-exit(r7)     // Catch:{ all -> 0x001b }
                boolean r1 = r15.failIfStreamPresent()
                if (r1 == 0) goto L_0x00a0
                com.squareup.okhttp.internal.spdy.ErrorCode r1 = com.squareup.okhttp.internal.spdy.ErrorCode.PROTOCOL_ERROR
                r6.closeLater(r1)
                com.squareup.okhttp.internal.spdy.SpdyConnection r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this
                r1.removeStream(r12)
                goto L_0x000d
            L_0x00a0:
                r6.receiveHeaders(r14, r15)
                if (r11 == 0) goto L_0x000d
                r6.receiveFin()
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.headers(boolean, boolean, int, int, java.util.List, com.squareup.okhttp.internal.spdy.HeadersMode):void");
        }

        public void rstStream(int streamId, ErrorCode errorCode) {
            if (SpdyConnection.this.pushedStream(streamId)) {
                SpdyConnection.this.pushResetLater(streamId, errorCode);
                return;
            }
            SpdyStream rstStream = SpdyConnection.this.removeStream(streamId);
            if (rstStream != null) {
                rstStream.receiveRstStream(errorCode);
            }
        }

        /* JADX WARNING: type inference failed for: r8v25, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void settings(boolean r12, com.squareup.okhttp.internal.spdy.Settings r13) {
            /*
                r11 = this;
                r2 = 0
                r7 = 0
                com.squareup.okhttp.internal.spdy.SpdyConnection r9 = com.squareup.okhttp.internal.spdy.SpdyConnection.this
                monitor-enter(r9)
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.Settings r8 = r8.peerSettings     // Catch:{ all -> 0x0093 }
                r10 = 65536(0x10000, float:9.18355E-41)
                int r5 = r8.getInitialWindowSize(r10)     // Catch:{ all -> 0x0093 }
                if (r12 == 0) goto L_0x0019
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.Settings r8 = r8.peerSettings     // Catch:{ all -> 0x0093 }
                r8.clear()     // Catch:{ all -> 0x0093 }
            L_0x0019:
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.Settings r8 = r8.peerSettings     // Catch:{ all -> 0x0093 }
                r8.merge(r13)     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.Protocol r8 = r8.getProtocol()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.Protocol r10 = com.squareup.okhttp.Protocol.HTTP_2     // Catch:{ all -> 0x0093 }
                if (r8 != r10) goto L_0x002d
                r11.ackSettingsLater(r13)     // Catch:{ all -> 0x0093 }
            L_0x002d:
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.Settings r8 = r8.peerSettings     // Catch:{ all -> 0x0093 }
                r10 = 65536(0x10000, float:9.18355E-41)
                int r4 = r8.getInitialWindowSize(r10)     // Catch:{ all -> 0x0093 }
                r8 = -1
                if (r4 == r8) goto L_0x007c
                if (r4 == r5) goto L_0x007c
                int r8 = r4 - r5
                long r2 = (long) r8     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                boolean r8 = r8.receivedInitialPeerSettings     // Catch:{ all -> 0x0093 }
                if (r8 != 0) goto L_0x0052
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                r8.addBytesToWriteWindow(r2)     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                r10 = 1
                boolean unused = r8.receivedInitialPeerSettings = r10     // Catch:{ all -> 0x0093 }
            L_0x0052:
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r8 = r8.streams     // Catch:{ all -> 0x0093 }
                boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0093 }
                if (r8 != 0) goto L_0x007c
                com.squareup.okhttp.internal.spdy.SpdyConnection r8 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r8 = r8.streams     // Catch:{ all -> 0x0093 }
                java.util.Collection r8 = r8.values()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.SpdyConnection r10 = com.squareup.okhttp.internal.spdy.SpdyConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r10 = r10.streams     // Catch:{ all -> 0x0093 }
                int r10 = r10.size()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.spdy.SpdyStream[] r10 = new com.squareup.okhttp.internal.spdy.SpdyStream[r10]     // Catch:{ all -> 0x0093 }
                java.lang.Object[] r8 = r8.toArray(r10)     // Catch:{ all -> 0x0093 }
                r0 = r8
                com.squareup.okhttp.internal.spdy.SpdyStream[] r0 = (com.squareup.okhttp.internal.spdy.SpdyStream[]) r0     // Catch:{ all -> 0x0093 }
                r7 = r0
            L_0x007c:
                monitor-exit(r9)     // Catch:{ all -> 0x0093 }
                if (r7 == 0) goto L_0x0099
                r8 = 0
                int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r8 == 0) goto L_0x0099
                int r9 = r7.length
                r8 = 0
            L_0x0087:
                if (r8 >= r9) goto L_0x0099
                r6 = r7[r8]
                monitor-enter(r6)
                r6.addBytesToWriteWindow(r2)     // Catch:{ all -> 0x0096 }
                monitor-exit(r6)     // Catch:{ all -> 0x0096 }
                int r8 = r8 + 1
                goto L_0x0087
            L_0x0093:
                r8 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0093 }
                throw r8
            L_0x0096:
                r8 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0096 }
                throw r8
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.settings(boolean, com.squareup.okhttp.internal.spdy.Settings):void");
        }

        private void ackSettingsLater(final Settings peerSettings) {
            SpdyConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{SpdyConnection.this.hostName}) {
                public void execute() {
                    try {
                        SpdyConnection.this.frameWriter.ackSettings(peerSettings);
                    } catch (IOException e) {
                    }
                }
            });
        }

        public void ackSettings() {
        }

        public void ping(boolean reply, int payload1, int payload2) {
            if (reply) {
                Ping ping = SpdyConnection.this.removePing(payload1);
                if (ping != null) {
                    ping.receive();
                    return;
                }
                return;
            }
            SpdyConnection.this.writePingLater(true, payload1, payload2, (Ping) null);
        }

        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            SpdyStream[] streamsCopy;
            if (debugData.size() > 0) {
            }
            synchronized (SpdyConnection.this) {
                streamsCopy = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                boolean unused = SpdyConnection.this.shutdown = true;
            }
            for (SpdyStream spdyStream : streamsCopy) {
                if (spdyStream.getId() > lastGoodStreamId && spdyStream.isLocallyInitiated()) {
                    spdyStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    SpdyConnection.this.removeStream(spdyStream.getId());
                }
            }
        }

        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                synchronized (SpdyConnection.this) {
                    SpdyConnection.this.bytesLeftInWriteWindow += windowSizeIncrement;
                    SpdyConnection.this.notifyAll();
                }
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(streamId);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                }
            }
        }

        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) {
            SpdyConnection.this.pushRequestLater(promisedStreamId, requestHeaders);
        }

        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
        }
    }

    /* access modifiers changed from: private */
    public boolean pushedStream(int streamId) {
        return this.protocol == Protocol.HTTP_2 && streamId != 0 && (streamId & 1) == 0;
    }

    /* access modifiers changed from: private */
    public void pushRequestLater(int streamId, List<Header> requestHeaders) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                writeSynResetLater(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(streamId));
            final int i = streamId;
            final List<Header> list = requestHeaders;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
                public void execute() {
                    if (SpdyConnection.this.pushObserver.onRequest(i, list)) {
                        try {
                            SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void pushHeadersLater(int streamId, List<Header> requestHeaders, boolean inFinished) {
        final int i = streamId;
        final List<Header> list = requestHeaders;
        final boolean z = inFinished;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
            public void execute() {
                boolean cancel = SpdyConnection.this.pushObserver.onHeaders(i, list, z);
                if (cancel) {
                    try {
                        SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (cancel || z) {
                    synchronized (SpdyConnection.this) {
                        SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void pushDataLater(int streamId, BufferedSource source, int byteCount, boolean inFinished) throws IOException {
        final Buffer buffer = new Buffer();
        source.require((long) byteCount);
        source.read(buffer, (long) byteCount);
        if (buffer.size() != ((long) byteCount)) {
            throw new IOException(buffer.size() + " != " + byteCount);
        }
        final int i = streamId;
        final int i2 = byteCount;
        final boolean z = inFinished;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
            public void execute() {
                try {
                    boolean cancel = SpdyConnection.this.pushObserver.onData(i, buffer, i2, z);
                    if (cancel) {
                        SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    }
                    if (cancel || z) {
                        synchronized (SpdyConnection.this) {
                            SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void pushResetLater(int streamId, ErrorCode errorCode) {
        final int i = streamId;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(streamId)}) {
            public void execute() {
                SpdyConnection.this.pushObserver.onReset(i, errorCode2);
                synchronized (SpdyConnection.this) {
                    SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
