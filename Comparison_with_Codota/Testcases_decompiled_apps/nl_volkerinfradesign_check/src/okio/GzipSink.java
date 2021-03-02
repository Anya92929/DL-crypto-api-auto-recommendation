package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {

    /* renamed from: a */
    private final BufferedSink f6285a;

    /* renamed from: b */
    private final Deflater f6286b;

    /* renamed from: c */
    private final DeflaterSink f6287c;

    /* renamed from: d */
    private boolean f6288d;

    /* renamed from: e */
    private final CRC32 f6289e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f6286b = new Deflater(-1, true);
        this.f6285a = Okio.buffer(sink);
        this.f6287c = new DeflaterSink(this.f6285a, this.f6286b);
        m6897a();
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            m6898a(buffer, j);
            this.f6287c.write(buffer, j);
        }
    }

    public void flush() throws IOException {
        this.f6287c.flush();
    }

    public Timeout timeout() {
        return this.f6285a.timeout();
    }

    public void close() throws IOException {
        if (!this.f6288d) {
            Throwable th = null;
            try {
                this.f6287c.mo11200a();
                m6899b();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f6286b.end();
                th = th;
            } catch (Throwable th3) {
                th = th3;
                if (th != null) {
                    th = th;
                }
            }
            try {
                this.f6285a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f6288d = true;
            if (th != null) {
                C1319ji.m5709a(th);
            }
        }
    }

    /* renamed from: a */
    private void m6897a() {
        Buffer buffer = this.f6285a.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    /* renamed from: b */
    private void m6899b() throws IOException {
        this.f6285a.writeIntLe((int) this.f6289e.getValue());
        this.f6285a.writeIntLe(this.f6286b.getTotalIn());
    }

    /* renamed from: a */
    private void m6898a(Buffer buffer, long j) {
        C1316jf jfVar = buffer.f6271a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (jfVar.f4572c - jfVar.f4571b));
            this.f6289e.update(jfVar.f4570a, jfVar.f4571b, min);
            j -= (long) min;
            jfVar = jfVar.f4575f;
        }
    }
}
