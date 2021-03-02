package org.apache.commons.p009io.output;

import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.CountingOutputStream */
public class CountingOutputStream extends ProxyOutputStream {

    /* renamed from: a */
    private long f6986a = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* access modifiers changed from: protected */
    public synchronized void beforeWrite(int i) {
        this.f6986a += (long) i;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= 2147483647L) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= 2147483647L) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }

    public synchronized long getByteCount() {
        return this.f6986a;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.f6986a;
        this.f6986a = 0;
        return j;
    }
}
