package p000;

import android.support.p001v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: jd */
public final class C1312jd implements BufferedSink {

    /* renamed from: a */
    public final Buffer f4562a;

    /* renamed from: b */
    public final Sink f4563b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f4564c;

    public C1312jd(Sink sink, Buffer buffer) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f4562a = buffer;
        this.f4563b = sink;
    }

    public C1312jd(Sink sink) {
        this(sink, new Buffer());
    }

    public Buffer buffer() {
        return this.f4562a;
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.write(buffer, j);
        emitCompleteSegments();
    }

    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.write(byteString);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeUtf8(str);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str, int i, int i2) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8CodePoint(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeString(str, charset);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, int i, int i2, Charset charset) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte[] bArr) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.write(bArr);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.f4562a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this.f4562a, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            emitCompleteSegments();
        }
        return this;
    }

    public BufferedSink writeByte(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeByte(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShort(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeShort(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShortLe(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeShortLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeInt(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeInt(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeIntLe(int i) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeIntLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeLong(long j) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeLongLe(long j) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeLongLe(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeDecimalLong(long j) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        this.f4562a.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.f4562a.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.f4563b.write(this.f4562a, completeSegmentByteCount);
        }
        return this;
    }

    public BufferedSink emit() throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        long size = this.f4562a.size();
        if (size > 0) {
            this.f4563b.write(this.f4562a, size);
        }
        return this;
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void write(int i) throws IOException {
                if (C1312jd.this.f4564c) {
                    throw new IOException("closed");
                }
                C1312jd.this.f4562a.writeByte((int) (byte) i);
                C1312jd.this.emitCompleteSegments();
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (C1312jd.this.f4564c) {
                    throw new IOException("closed");
                }
                C1312jd.this.f4562a.write(bArr, i, i2);
                C1312jd.this.emitCompleteSegments();
            }

            public void flush() throws IOException {
                if (!C1312jd.this.f4564c) {
                    C1312jd.this.flush();
                }
            }

            public void close() throws IOException {
                C1312jd.this.close();
            }

            public String toString() {
                return C1312jd.this + ".outputStream()";
            }
        };
    }

    public void flush() throws IOException {
        if (this.f4564c) {
            throw new IllegalStateException("closed");
        }
        if (this.f4562a.f6272b > 0) {
            this.f4563b.write(this.f4562a, this.f4562a.f6272b);
        }
        this.f4563b.flush();
    }

    public void close() throws IOException {
        if (!this.f4564c) {
            Throwable th = null;
            try {
                if (this.f4562a.f6272b > 0) {
                    this.f4563b.write(this.f4562a, this.f4562a.f6272b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4563b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f4564c = true;
            if (th != null) {
                C1319ji.m5709a(th);
            }
        }
    }

    public Timeout timeout() {
        return this.f4563b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4563b + ")";
    }
}
