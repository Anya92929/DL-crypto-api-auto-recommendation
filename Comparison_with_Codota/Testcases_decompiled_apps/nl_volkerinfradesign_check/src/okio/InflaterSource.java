package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {

    /* renamed from: a */
    private final BufferedSource f6295a;

    /* renamed from: b */
    private final Inflater f6296b;

    /* renamed from: c */
    private int f6297c;

    /* renamed from: d */
    private boolean f6298d;

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f6295a = bufferedSource;
            this.f6296b = inflater;
        }
    }

    public long read(Buffer buffer, long j) throws IOException {
        boolean refill;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f6298d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            do {
                refill = refill();
                try {
                    C1316jf a = buffer.mo11169a(1);
                    int inflate = this.f6296b.inflate(a.f4570a, a.f4572c, 2048 - a.f4572c);
                    if (inflate > 0) {
                        a.f4572c += inflate;
                        buffer.f6272b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f6296b.finished() || this.f6296b.needsDictionary()) {
                        m6904a();
                        if (a.f4571b == a.f4572c) {
                            buffer.f6271a = a.mo8800a();
                            C1317jg.m5701a(a);
                        }
                        return -1;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            } while (!refill);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean refill() throws IOException {
        if (!this.f6296b.needsInput()) {
            return false;
        }
        m6904a();
        if (this.f6296b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f6295a.exhausted()) {
            return true;
        } else {
            C1316jf jfVar = this.f6295a.buffer().f6271a;
            this.f6297c = jfVar.f4572c - jfVar.f4571b;
            this.f6296b.setInput(jfVar.f4570a, jfVar.f4571b, this.f6297c);
            return false;
        }
    }

    /* renamed from: a */
    private void m6904a() throws IOException {
        if (this.f6297c != 0) {
            int remaining = this.f6297c - this.f6296b.getRemaining();
            this.f6297c -= remaining;
            this.f6295a.skip((long) remaining);
        }
    }

    public Timeout timeout() {
        return this.f6295a.timeout();
    }

    public void close() throws IOException {
        if (!this.f6298d) {
            this.f6296b.end();
            this.f6298d = true;
            this.f6295a.close();
        }
    }
}
