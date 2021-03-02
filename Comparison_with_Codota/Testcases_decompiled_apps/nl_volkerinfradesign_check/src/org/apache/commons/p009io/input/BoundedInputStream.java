package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BoundedInputStream */
public class BoundedInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f6889a;

    /* renamed from: b */
    private final long f6890b;

    /* renamed from: c */
    private long f6891c;

    /* renamed from: d */
    private long f6892d;

    /* renamed from: e */
    private boolean f6893e;

    public BoundedInputStream(InputStream inputStream, long j) {
        this.f6891c = 0;
        this.f6892d = -1;
        this.f6893e = true;
        this.f6890b = j;
        this.f6889a = inputStream;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    public int read() throws IOException {
        if (this.f6890b >= 0 && this.f6891c >= this.f6890b) {
            return -1;
        }
        int read = this.f6889a.read();
        this.f6891c++;
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6890b >= 0 && this.f6891c >= this.f6890b) {
            return -1;
        }
        int read = this.f6889a.read(bArr, i, (int) (this.f6890b >= 0 ? Math.min((long) i2, this.f6890b - this.f6891c) : (long) i2));
        if (read == -1) {
            return -1;
        }
        this.f6891c += (long) read;
        return read;
    }

    public long skip(long j) throws IOException {
        if (this.f6890b >= 0) {
            j = Math.min(j, this.f6890b - this.f6891c);
        }
        long skip = this.f6889a.skip(j);
        this.f6891c += skip;
        return skip;
    }

    public int available() throws IOException {
        if (this.f6890b < 0 || this.f6891c < this.f6890b) {
            return this.f6889a.available();
        }
        return 0;
    }

    public String toString() {
        return this.f6889a.toString();
    }

    public void close() throws IOException {
        if (this.f6893e) {
            this.f6889a.close();
        }
    }

    public synchronized void reset() throws IOException {
        this.f6889a.reset();
        this.f6891c = this.f6892d;
    }

    public synchronized void mark(int i) {
        this.f6889a.mark(i);
        this.f6892d = this.f6891c;
    }

    public boolean markSupported() {
        return this.f6889a.markSupported();
    }

    public boolean isPropagateClose() {
        return this.f6893e;
    }

    public void setPropagateClose(boolean z) {
        this.f6893e = z;
    }
}
