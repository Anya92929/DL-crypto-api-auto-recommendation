package org.apache.commons.p009io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* renamed from: org.apache.commons.io.input.NullReader */
public class NullReader extends Reader {

    /* renamed from: a */
    private final long f6912a;

    /* renamed from: b */
    private long f6913b;

    /* renamed from: c */
    private long f6914c;

    /* renamed from: d */
    private long f6915d;

    /* renamed from: e */
    private boolean f6916e;

    /* renamed from: f */
    private final boolean f6917f;

    /* renamed from: g */
    private final boolean f6918g;

    public NullReader(long j) {
        this(j, true, false);
    }

    public NullReader(long j, boolean z, boolean z2) {
        this.f6914c = -1;
        this.f6912a = j;
        this.f6918g = z;
        this.f6917f = z2;
    }

    public long getPosition() {
        return this.f6913b;
    }

    public long getSize() {
        return this.f6912a;
    }

    public void close() throws IOException {
        this.f6916e = false;
        this.f6913b = 0;
        this.f6914c = -1;
    }

    public synchronized void mark(int i) {
        if (!this.f6918g) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        this.f6914c = this.f6913b;
        this.f6915d = (long) i;
    }

    public boolean markSupported() {
        return this.f6918g;
    }

    public int read() throws IOException {
        if (this.f6916e) {
            throw new IOException("Read after end of file");
        } else if (this.f6913b == this.f6912a) {
            return m7294a();
        } else {
            this.f6913b++;
            return processChar();
        }
    }

    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        if (this.f6916e) {
            throw new IOException("Read after end of file");
        } else if (this.f6913b == this.f6912a) {
            return m7294a();
        } else {
            this.f6913b += (long) i2;
            if (this.f6913b > this.f6912a) {
                i2 -= (int) (this.f6913b - this.f6912a);
                this.f6913b = this.f6912a;
            }
            processChars(cArr, i, i2);
            return i2;
        }
    }

    public synchronized void reset() throws IOException {
        if (!this.f6918g) {
            throw new UnsupportedOperationException("Mark not supported");
        } else if (this.f6914c < 0) {
            throw new IOException("No position has been marked");
        } else if (this.f6913b > this.f6914c + this.f6915d) {
            throw new IOException("Marked position [" + this.f6914c + "] is no longer valid - passed the read limit [" + this.f6915d + "]");
        } else {
            this.f6913b = this.f6914c;
            this.f6916e = false;
        }
    }

    public long skip(long j) throws IOException {
        if (this.f6916e) {
            throw new IOException("Skip after end of file");
        } else if (this.f6913b == this.f6912a) {
            return (long) m7294a();
        } else {
            this.f6913b += j;
            if (this.f6913b <= this.f6912a) {
                return j;
            }
            long j2 = j - (this.f6913b - this.f6912a);
            this.f6913b = this.f6912a;
            return j2;
        }
    }

    /* access modifiers changed from: protected */
    public int processChar() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void processChars(char[] cArr, int i, int i2) {
    }

    /* renamed from: a */
    private int m7294a() throws EOFException {
        this.f6916e = true;
        if (!this.f6917f) {
            return -1;
        }
        throw new EOFException();
    }
}
