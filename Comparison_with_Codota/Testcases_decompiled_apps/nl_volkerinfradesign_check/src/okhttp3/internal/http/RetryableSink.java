package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink implements Sink {

    /* renamed from: a */
    private boolean f6237a;

    /* renamed from: b */
    private final int f6238b;

    /* renamed from: c */
    private final Buffer f6239c;

    public RetryableSink(int i) {
        this.f6239c = new Buffer();
        this.f6238b = i;
    }

    public RetryableSink() {
        this(-1);
    }

    public void close() throws IOException {
        if (!this.f6237a) {
            this.f6237a = true;
            if (this.f6239c.size() < ((long) this.f6238b)) {
                throw new ProtocolException("content-length promised " + this.f6238b + " bytes, but received " + this.f6239c.size());
            }
        }
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (this.f6237a) {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(buffer.size(), 0, j);
        if (this.f6238b == -1 || this.f6239c.size() <= ((long) this.f6238b) - j) {
            this.f6239c.write(buffer, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f6238b + " bytes");
    }

    public void flush() throws IOException {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public long contentLength() throws IOException {
        return this.f6239c.size();
    }

    public void writeToSocket(Sink sink) throws IOException {
        Buffer buffer = new Buffer();
        this.f6239c.copyTo(buffer, 0, this.f6239c.size());
        sink.write(buffer, buffer.size());
    }
}
