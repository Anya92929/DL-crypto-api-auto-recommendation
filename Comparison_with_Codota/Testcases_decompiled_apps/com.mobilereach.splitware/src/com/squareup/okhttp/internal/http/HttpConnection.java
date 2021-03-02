package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpConnection {
    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    /* access modifiers changed from: private */
    public final Connection connection;
    /* access modifiers changed from: private */
    public int onIdle = 0;
    /* access modifiers changed from: private */
    public final ConnectionPool pool;
    /* access modifiers changed from: private */
    public final BufferedSink sink;
    private final Socket socket;
    /* access modifiers changed from: private */
    public final BufferedSource source;
    /* access modifiers changed from: private */
    public int state = 0;

    public HttpConnection(ConnectionPool pool2, Connection connection2, Socket socket2) throws IOException {
        this.pool = pool2;
        this.connection = connection2;
        this.socket = socket2;
        this.source = Okio.buffer(Okio.source(socket2));
        this.sink = Okio.buffer(Okio.sink(socket2));
    }

    public void setTimeouts(int readTimeoutMillis, int writeTimeoutMillis) {
        if (readTimeoutMillis != 0) {
            this.source.timeout().timeout((long) readTimeoutMillis, TimeUnit.MILLISECONDS);
        }
        if (writeTimeoutMillis != 0) {
            this.sink.timeout().timeout((long) writeTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    public void poolOnIdle() {
        this.onIdle = 1;
        if (this.state == 0) {
            this.onIdle = 0;
            Internal.instance.recycle(this.pool, this.connection);
        }
    }

    public void closeOnIdle() throws IOException {
        this.onIdle = 2;
        if (this.state == 0) {
            this.state = 6;
            this.connection.getSocket().close();
        }
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public void closeIfOwnedBy(Object owner) throws IOException {
        Internal.instance.closeIfOwnedBy(this.connection, owner);
    }

    public void flush() throws IOException {
        this.sink.flush();
    }

    public long bufferSize() {
        return this.source.buffer().size();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isReadable() {
        /*
            r7 = this;
            r3 = 0
            r4 = 1
            java.net.Socket r5 = r7.socket     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            int r2 = r5.getSoTimeout()     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            java.net.Socket r5 = r7.socket     // Catch:{ all -> 0x0023 }
            r6 = 1
            r5.setSoTimeout(r6)     // Catch:{ all -> 0x0023 }
            okio.BufferedSource r5 = r7.source     // Catch:{ all -> 0x0023 }
            boolean r5 = r5.exhausted()     // Catch:{ all -> 0x0023 }
            if (r5 == 0) goto L_0x001c
            java.net.Socket r5 = r7.socket     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            r5.setSoTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
        L_0x001b:
            return r3
        L_0x001c:
            java.net.Socket r5 = r7.socket     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            r5.setSoTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            r3 = r4
            goto L_0x001b
        L_0x0023:
            r5 = move-exception
            java.net.Socket r6 = r7.socket     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            r6.setSoTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
            throw r5     // Catch:{ SocketTimeoutException -> 0x002a, IOException -> 0x002d }
        L_0x002a:
            r1 = move-exception
            r3 = r4
            goto L_0x001b
        L_0x002d:
            r0 = move-exception
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpConnection.isReadable():boolean");
    }

    public void writeRequest(Headers headers, String requestLine) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(requestLine).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine statusLine;
        Response.Builder responseBuilder;
        if (this.state == 1 || this.state == 3) {
            do {
                try {
                    statusLine = StatusLine.parse(this.source.readUtf8LineStrict());
                    responseBuilder = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message);
                    Headers.Builder headersBuilder = new Headers.Builder();
                    readHeaders(headersBuilder);
                    headersBuilder.add(OkHeaders.SELECTED_PROTOCOL, statusLine.protocol.toString());
                    responseBuilder.headers(headersBuilder.build());
                } catch (EOFException e) {
                    IOException exception = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + ")");
                    exception.initCause(e);
                    throw exception;
                }
            } while (statusLine.code == 100);
            this.state = 4;
            return responseBuilder;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void readHeaders(Headers.Builder builder) throws IOException {
        while (true) {
            String line = this.source.readUtf8LineStrict();
            if (line.length() != 0) {
                Internal.instance.addLenient(builder, line);
            } else {
                return;
            }
        }
    }

    public Sink newChunkedSink() {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new ChunkedSink();
    }

    public Sink newFixedLengthSink(long contentLength) {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new FixedLengthSink(contentLength);
    }

    public void writeRequestBody(RetryableSink requestBody) throws IOException {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 3;
        requestBody.writeToSocket(this.sink);
    }

    public Source newFixedLengthSource(long length) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new FixedLengthSource(length);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new ChunkedSource(httpEngine);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new UnknownLengthSource();
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;

        private FixedLengthSink(long bytesRemaining2) {
            this.bytesRemaining = bytesRemaining2;
        }

        public Timeout timeout() {
            return HttpConnection.this.sink.timeout();
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(source.size(), 0, byteCount);
            if (byteCount > this.bytesRemaining) {
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + byteCount);
            }
            HttpConnection.this.sink.write(source, byteCount);
            this.bytesRemaining -= byteCount;
        }

        public void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                int unused = HttpConnection.this.state = 3;
            }
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;

        private ChunkedSink() {
        }

        public Timeout timeout() {
            return HttpConnection.this.sink.timeout();
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (byteCount != 0) {
                HttpConnection.this.sink.writeHexadecimalUnsignedLong(byteCount);
                HttpConnection.this.sink.writeUtf8("\r\n");
                HttpConnection.this.sink.write(source, byteCount);
                HttpConnection.this.sink.writeUtf8("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                HttpConnection.this.sink.writeUtf8("0\r\n\r\n");
                int unused = HttpConnection.this.state = 3;
            }
        }
    }

    private abstract class AbstractSource implements Source {
        protected boolean closed;

        private AbstractSource() {
        }

        public Timeout timeout() {
            return HttpConnection.this.source.timeout();
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean recyclable) throws IOException {
            if (HttpConnection.this.state != 5) {
                throw new IllegalStateException("state: " + HttpConnection.this.state);
            }
            int unused = HttpConnection.this.state = 0;
            if (recyclable && HttpConnection.this.onIdle == 1) {
                int unused2 = HttpConnection.this.onIdle = 0;
                Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
            } else if (HttpConnection.this.onIdle == 2) {
                int unused3 = HttpConnection.this.state = 6;
                HttpConnection.this.connection.getSocket().close();
            }
        }

        /* access modifiers changed from: protected */
        public final void unexpectedEndOfInput() {
            Util.closeQuietly(HttpConnection.this.connection.getSocket());
            int unused = HttpConnection.this.state = 6;
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long length) throws IOException {
            super();
            this.bytesRemaining = length;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(sink, Math.min(this.bytesRemaining, byteCount));
                if (read == -1) {
                    unexpectedEndOfInput();
                    throw new ProtocolException("unexpected end of stream");
                }
                this.bytesRemaining -= read;
                if (this.bytesRemaining != 0) {
                    return read;
                }
                endOfInput(true);
                return read;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine2) throws IOException {
            super();
            this.httpEngine = httpEngine2;
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = HttpConnection.this.source.read(sink, Math.min(byteCount, this.bytesRemainingInChunk));
                if (read == -1) {
                    unexpectedEndOfInput();
                    throw new IOException("unexpected end of stream");
                }
                this.bytesRemainingInChunk -= read;
                return read;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                HttpConnection.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = HttpConnection.this.source.readHexadecimalUnsignedLong();
                String extensions = HttpConnection.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || (!extensions.isEmpty() && !extensions.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + extensions + "\"");
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Headers.Builder trailersBuilder = new Headers.Builder();
                    HttpConnection.this.readHeaders(trailersBuilder);
                    this.httpEngine.receiveHeaders(trailersBuilder.build());
                    endOfInput(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(sink, byteCount);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(false);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }
}
