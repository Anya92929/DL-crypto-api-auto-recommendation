package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {

    /* renamed from: a */
    private int f6290a = 0;

    /* renamed from: b */
    private final BufferedSource f6291b;

    /* renamed from: c */
    private final Inflater f6292c;

    /* renamed from: d */
    private final InflaterSource f6293d;

    /* renamed from: e */
    private final CRC32 f6294e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f6292c = new Inflater(true);
        this.f6291b = Okio.buffer(source);
        this.f6293d = new InflaterSource(this.f6291b, this.f6292c);
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f6290a == 0) {
                m6900a();
                this.f6290a = 1;
            }
            if (this.f6290a == 1) {
                long j2 = buffer.f6272b;
                long read = this.f6293d.read(buffer, j);
                if (read != -1) {
                    m6902a(buffer, j2, read);
                    return read;
                }
                this.f6290a = 2;
            }
            if (this.f6290a == 2) {
                m6903b();
                this.f6290a = 3;
                if (!this.f6291b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    private void m6900a() throws IOException {
        boolean z;
        this.f6291b.require(10);
        byte b = this.f6291b.buffer().getByte(3);
        if (((b >> 1) & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            m6902a(this.f6291b.buffer(), 0, 10);
        }
        m6901a("ID1ID2", 8075, (int) this.f6291b.readShort());
        this.f6291b.skip(8);
        if (((b >> 2) & 1) == 1) {
            this.f6291b.require(2);
            if (z) {
                m6902a(this.f6291b.buffer(), 0, 2);
            }
            short readShortLe = this.f6291b.buffer().readShortLe();
            this.f6291b.require((long) readShortLe);
            if (z) {
                m6902a(this.f6291b.buffer(), 0, (long) readShortLe);
            }
            this.f6291b.skip((long) readShortLe);
        }
        if (((b >> 3) & 1) == 1) {
            long indexOf = this.f6291b.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                m6902a(this.f6291b.buffer(), 0, 1 + indexOf);
            }
            this.f6291b.skip(1 + indexOf);
        }
        if (((b >> 4) & 1) == 1) {
            long indexOf2 = this.f6291b.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m6902a(this.f6291b.buffer(), 0, 1 + indexOf2);
            }
            this.f6291b.skip(1 + indexOf2);
        }
        if (z) {
            m6901a("FHCRC", (int) this.f6291b.readShortLe(), (int) (short) ((int) this.f6294e.getValue()));
            this.f6294e.reset();
        }
    }

    /* renamed from: b */
    private void m6903b() throws IOException {
        m6901a("CRC", this.f6291b.readIntLe(), (int) this.f6294e.getValue());
        m6901a("ISIZE", this.f6291b.readIntLe(), this.f6292c.getTotalOut());
    }

    public Timeout timeout() {
        return this.f6291b.timeout();
    }

    public void close() throws IOException {
        this.f6293d.close();
    }

    /* renamed from: a */
    private void m6902a(Buffer buffer, long j, long j2) {
        C1316jf jfVar = buffer.f6271a;
        while (j >= ((long) (jfVar.f4572c - jfVar.f4571b))) {
            j -= (long) (jfVar.f4572c - jfVar.f4571b);
            jfVar = jfVar.f4575f;
        }
        while (j2 > 0) {
            int i = (int) (((long) jfVar.f4571b) + j);
            int min = (int) Math.min((long) (jfVar.f4572c - i), j2);
            this.f6294e.update(jfVar.f4570a, i, min);
            j2 -= (long) min;
            jfVar = jfVar.f4575f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m6901a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
