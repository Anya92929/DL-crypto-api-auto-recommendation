package org.apache.commons.p009io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.ThresholdingOutputStream */
public abstract class ThresholdingOutputStream extends OutputStream {

    /* renamed from: a */
    private final int f7000a;

    /* renamed from: b */
    private long f7001b;

    /* renamed from: c */
    private boolean f7002c;

    /* access modifiers changed from: protected */
    public abstract OutputStream getStream() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void thresholdReached() throws IOException;

    public ThresholdingOutputStream(int i) {
        this.f7000a = i;
    }

    public void write(int i) throws IOException {
        checkThreshold(1);
        getStream().write(i);
        this.f7001b++;
    }

    public void write(byte[] bArr) throws IOException {
        checkThreshold(bArr.length);
        getStream().write(bArr);
        this.f7001b += (long) bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkThreshold(i2);
        getStream().write(bArr, i, i2);
        this.f7001b += (long) i2;
    }

    public void flush() throws IOException {
        getStream().flush();
    }

    public void close() throws IOException {
        try {
            flush();
        } catch (IOException e) {
        }
        getStream().close();
    }

    public int getThreshold() {
        return this.f7000a;
    }

    public long getByteCount() {
        return this.f7001b;
    }

    public boolean isThresholdExceeded() {
        return this.f7001b > ((long) this.f7000a);
    }

    /* access modifiers changed from: protected */
    public void checkThreshold(int i) throws IOException {
        if (!this.f7002c && this.f7001b + ((long) i) > ((long) this.f7000a)) {
            this.f7002c = true;
            thresholdReached();
        }
    }

    /* access modifiers changed from: protected */
    public void resetByteCount() {
        this.f7002c = false;
        this.f7001b = 0;
    }
}
