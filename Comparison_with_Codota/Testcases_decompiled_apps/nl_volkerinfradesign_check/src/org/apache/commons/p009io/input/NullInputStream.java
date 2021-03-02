package org.apache.commons.p009io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.NullInputStream */
public class NullInputStream extends InputStream {

    /* renamed from: a */
    private final long f6905a;

    /* renamed from: b */
    private long f6906b;

    /* renamed from: c */
    private long f6907c;

    /* renamed from: d */
    private long f6908d;

    /* renamed from: e */
    private boolean f6909e;

    /* renamed from: f */
    private final boolean f6910f;

    /* renamed from: g */
    private final boolean f6911g;

    public NullInputStream(long j) {
        this(j, true, false);
    }

    public NullInputStream(long j, boolean z, boolean z2) {
        this.f6907c = -1;
        this.f6905a = j;
        this.f6911g = z;
        this.f6910f = z2;
    }

    public long getPosition() {
        return this.f6906b;
    }

    public long getSize() {
        return this.f6905a;
    }

    public int available() {
        long j = this.f6905a - this.f6906b;
        if (j <= 0) {
            return 0;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public void close() throws IOException {
        this.f6909e = false;
        this.f6906b = 0;
        this.f6907c = -1;
    }

    public synchronized void mark(int i) {
        if (!this.f6911g) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        this.f6907c = this.f6906b;
        this.f6908d = (long) i;
    }

    public boolean markSupported() {
        return this.f6911g;
    }

    public int read() throws IOException {
        if (this.f6909e) {
            throw new IOException("Read after end of file");
        } else if (this.f6906b == this.f6905a) {
            return m7293a();
        } else {
            this.f6906b++;
            return processByte();
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6909e) {
            throw new IOException("Read after end of file");
        } else if (this.f6906b == this.f6905a) {
            return m7293a();
        } else {
            this.f6906b += (long) i2;
            if (this.f6906b > this.f6905a) {
                i2 -= (int) (this.f6906b - this.f6905a);
                this.f6906b = this.f6905a;
            }
            processBytes(bArr, i, i2);
            return i2;
        }
    }

    public synchronized void reset() throws IOException {
        if (!this.f6911g) {
            throw new UnsupportedOperationException("Mark not supported");
        } else if (this.f6907c < 0) {
            throw new IOException("No position has been marked");
        } else if (this.f6906b > this.f6907c + this.f6908d) {
            throw new IOException("Marked position [" + this.f6907c + "] is no longer valid - passed the read limit [" + this.f6908d + "]");
        } else {
            this.f6906b = this.f6907c;
            this.f6909e = false;
        }
    }

    public long skip(long j) throws IOException {
        if (this.f6909e) {
            throw new IOException("Skip after end of file");
        } else if (this.f6906b == this.f6905a) {
            return (long) m7293a();
        } else {
            this.f6906b += j;
            if (this.f6906b <= this.f6905a) {
                return j;
            }
            long j2 = j - (this.f6906b - this.f6905a);
            this.f6906b = this.f6905a;
            return j2;
        }
    }

    /* access modifiers changed from: protected */
    public int processByte() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void processBytes(byte[] bArr, int i, int i2) {
    }

    /* renamed from: a */
    private int m7293a() throws EOFException {
        this.f6909e = true;
        if (!this.f6910f) {
            return -1;
        }
        throw new EOFException();
    }
}
