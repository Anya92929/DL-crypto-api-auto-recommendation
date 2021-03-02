package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class SpdyStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
    long bytesLeftInWriteWindow;
    /* access modifiers changed from: private */
    public final SpdyConnection connection;
    /* access modifiers changed from: private */
    public ErrorCode errorCode = null;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public final int f21id;
    /* access modifiers changed from: private */
    public final SpdyTimeout readTimeout = new SpdyTimeout();
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final SpdyDataSink sink;
    private final SpdyDataSource source;
    long unacknowledgedBytesRead = 0;
    /* access modifiers changed from: private */
    public final SpdyTimeout writeTimeout = new SpdyTimeout();

    SpdyStream(int id, SpdyConnection connection2, boolean outFinished, boolean inFinished, List<Header> requestHeaders2) {
        if (connection2 == null) {
            throw new NullPointerException("connection == null");
        } else if (requestHeaders2 == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f21id = id;
            this.connection = connection2;
            this.bytesLeftInWriteWindow = (long) connection2.peerSettings.getInitialWindowSize(65536);
            this.source = new SpdyDataSource((long) connection2.okHttpSettings.getInitialWindowSize(65536));
            this.sink = new SpdyDataSink();
            boolean unused = this.source.finished = inFinished;
            boolean unused2 = this.sink.finished = outFinished;
            this.requestHeaders = requestHeaders2;
        }
    }

    public int getId() {
        return this.f21id;
    }

    public synchronized boolean isOpen() {
        boolean z = false;
        synchronized (this) {
            if (this.errorCode == null) {
                if ((!this.source.finished && !this.source.closed) || ((!this.sink.finished && !this.sink.closed) || this.responseHeaders == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isLocallyInitiated() {
        boolean streamIsClient;
        if ((this.f21id & 1) == 1) {
            streamIsClient = true;
        } else {
            streamIsClient = false;
        }
        return this.connection.client == streamIsClient;
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> getResponseHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.responseHeaders != null) {
        } else {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return this.responseHeaders;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void reply(List<Header> responseHeaders2, boolean out) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean outFinished = false;
            synchronized (this) {
                if (responseHeaders2 == null) {
                    throw new NullPointerException("responseHeaders == null");
                } else if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                } else {
                    this.responseHeaders = responseHeaders2;
                    if (!out) {
                        boolean unused = this.sink.finished = true;
                        outFinished = true;
                    }
                }
            }
            this.connection.writeSynReply(this.f21id, outFinished, responseHeaders2);
            if (outFinished) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public Source getSource() {
        return this.source;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public void close(ErrorCode rstStatusCode) throws IOException {
        if (closeInternal(rstStatusCode)) {
            this.connection.writeSynReset(this.f21id, rstStatusCode);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.f21id, errorCode2);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode2;
                notifyAll();
                this.connection.removeStream(this.f21id);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> headers, HeadersMode headersMode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            ErrorCode errorCode2 = null;
            boolean open = true;
            synchronized (this) {
                if (this.responseHeaders == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.responseHeaders = headers;
                        open = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode2 = ErrorCode.STREAM_IN_USE;
                } else {
                    List<Header> newHeaders = new ArrayList<>();
                    newHeaders.addAll(this.responseHeaders);
                    newHeaders.addAll(headers);
                    this.responseHeaders = newHeaders;
                }
            }
            if (errorCode2 != null) {
                closeLater(errorCode2);
            } else if (!open) {
                this.connection.removeStream(this.f21id);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource in, int length) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            this.source.receive(in, (long) length);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void receiveFin() {
        boolean open;
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                boolean unused = this.source.finished = true;
                open = isOpen();
                notifyAll();
            }
            if (!open) {
                this.connection.removeStream(this.f21id);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    private final class SpdyDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private SpdyDataSource(long maxByteCount2) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = maxByteCount2;
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            long read;
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            }
            synchronized (SpdyStream.this) {
                waitUntilReadable();
                checkNotClosed();
                if (this.readBuffer.size() == 0) {
                    read = -1;
                } else {
                    read = this.readBuffer.read(sink, Math.min(byteCount, this.readBuffer.size()));
                    SpdyStream.this.unacknowledgedBytesRead += read;
                    if (SpdyStream.this.unacknowledgedBytesRead >= ((long) (SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                        SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.f21id, SpdyStream.this.unacknowledgedBytesRead);
                        SpdyStream.this.unacknowledgedBytesRead = 0;
                    }
                    synchronized (SpdyStream.this.connection) {
                        SpdyStream.this.connection.unacknowledgedBytesRead += read;
                        if (SpdyStream.this.connection.unacknowledgedBytesRead >= ((long) (SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                            SpdyStream.this.connection.writeWindowUpdateLater(0, SpdyStream.this.connection.unacknowledgedBytesRead);
                            SpdyStream.this.connection.unacknowledgedBytesRead = 0;
                        }
                    }
                }
            }
            return read;
        }

        private void waitUntilReadable() throws IOException {
            SpdyStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                try {
                    SpdyStream.this.waitForIo();
                } finally {
                    SpdyStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource in, long byteCount) throws IOException {
            boolean finished2;
            boolean flowControlError;
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                while (byteCount > 0) {
                    synchronized (SpdyStream.this) {
                        finished2 = this.finished;
                        flowControlError = this.readBuffer.size() + byteCount > this.maxByteCount;
                    }
                    if (flowControlError) {
                        in.skip(byteCount);
                        SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (finished2) {
                        in.skip(byteCount);
                        return;
                    } else {
                        long read = in.read(this.receiveBuffer, byteCount);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        byteCount -= read;
                        synchronized (SpdyStream.this) {
                            boolean wasEmpty = this.readBuffer.size() == 0;
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (wasEmpty) {
                                SpdyStream.this.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return SpdyStream.this.readTimeout;
        }

        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                SpdyStream.this.notifyAll();
            }
            SpdyStream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }
    }

    /* access modifiers changed from: private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean cancel;
        boolean open;
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                cancel = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
                open = isOpen();
            }
            if (cancel) {
                close(ErrorCode.CANCEL);
            } else if (!open) {
                this.connection.removeStream(this.f21id);
            }
        } else {
            throw new AssertionError();
        }
    }

    final class SpdyDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
        private static final long EMIT_BUFFER_SIZE = 16384;
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public boolean finished;
        private final Buffer sendBuffer = new Buffer();

        SpdyDataSink() {
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.size() >= EMIT_BUFFER_SIZE) {
                    emitDataFrame(false);
                }
                return;
            }
            throw new AssertionError();
        }

        private void emitDataFrame(boolean outFinished) throws IOException {
            long toWrite;
            synchronized (SpdyStream.this) {
                SpdyStream.this.writeTimeout.enter();
                while (SpdyStream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                    try {
                        SpdyStream.this.waitForIo();
                    } catch (Throwable th) {
                        SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                SpdyStream.this.checkOutNotClosed();
                toWrite = Math.min(SpdyStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                SpdyStream.this.bytesLeftInWriteWindow -= toWrite;
            }
            SpdyStream.this.connection.writeData(SpdyStream.this.f21id, outFinished && toWrite == this.sendBuffer.size(), this.sendBuffer, toWrite);
        }

        public void flush() throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                synchronized (SpdyStream.this) {
                    SpdyStream.this.checkOutNotClosed();
                }
                while (this.sendBuffer.size() > 0) {
                    emitDataFrame(false);
                }
                SpdyStream.this.connection.flush();
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return SpdyStream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r6.this$0.sink.finished != false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            if (r6.sendBuffer.size() <= 0) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r6.sendBuffer.size() <= 0) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
            emitDataFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            com.squareup.okhttp.internal.spdy.SpdyStream.access$500(r6.this$0).writeData(com.squareup.okhttp.internal.spdy.SpdyStream.access$600(r6.this$0), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
            r1 = r6.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r6.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
            com.squareup.okhttp.internal.spdy.SpdyStream.access$500(r6.this$0).flush();
            com.squareup.okhttp.internal.spdy.SpdyStream.access$1000(r6.this$0);
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
                boolean r0 = $assertionsDisabled
                if (r0 != 0) goto L_0x0015
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 == 0) goto L_0x0015
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0015:
                com.squareup.okhttp.internal.spdy.SpdyStream r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                monitor-enter(r1)
                boolean r0 = r6.closed     // Catch:{ all -> 0x003f }
                if (r0 == 0) goto L_0x001e
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
            L_0x001d:
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                com.squareup.okhttp.internal.spdy.SpdyStream$SpdyDataSink r0 = r0.sink
                boolean r0 = r0.finished
                if (r0 != 0) goto L_0x0052
                okio.Buffer r0 = r6.sendBuffer
                long r0 = r0.size()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0042
            L_0x0031:
                okio.Buffer r0 = r6.sendBuffer
                long r0 = r0.size()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0052
                r6.emitDataFrame(r2)
                goto L_0x0031
            L_0x003f:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                throw r0
            L_0x0042:
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                com.squareup.okhttp.internal.spdy.SpdyConnection r0 = r0.connection
                com.squareup.okhttp.internal.spdy.SpdyStream r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                int r1 = r1.f21id
                r3 = 0
                r0.writeData(r1, r2, r3, r4)
            L_0x0052:
                com.squareup.okhttp.internal.spdy.SpdyStream r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                monitor-enter(r1)
                r0 = 1
                r6.closed = r0     // Catch:{ all -> 0x0068 }
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                com.squareup.okhttp.internal.spdy.SpdyConnection r0 = r0.connection
                r0.flush()
                com.squareup.okhttp.internal.spdy.SpdyStream r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this
                r0.cancelStreamIfNecessary()
                goto L_0x001d
            L_0x0068:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyStream.SpdyDataSink.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long delta) {
        this.bytesLeftInWriteWindow += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: private */
    public void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    /* access modifiers changed from: private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    class SpdyTimeout extends AsyncTimeout {
        SpdyTimeout() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            SpdyStream.this.closeLater(ErrorCode.CANCEL);
        }

        public void exitAndThrowIfTimedOut() throws InterruptedIOException {
            if (exit()) {
                throw new InterruptedIOException("timeout");
            }
        }
    }
}
