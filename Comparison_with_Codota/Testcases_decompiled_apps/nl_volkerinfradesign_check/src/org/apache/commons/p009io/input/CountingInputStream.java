package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.CountingInputStream */
public class CountingInputStream extends ProxyInputStream {

    /* renamed from: a */
    private long f6903a;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized long skip(long j) throws IOException {
        long skip;
        skip = super.skip(j);
        this.f6903a += skip;
        return skip;
    }

    /* access modifiers changed from: protected */
    public synchronized void afterRead(int i) {
        if (i != -1) {
            this.f6903a += (long) i;
        }
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
        return this.f6903a;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.f6903a;
        this.f6903a = 0;
        return j;
    }
}
