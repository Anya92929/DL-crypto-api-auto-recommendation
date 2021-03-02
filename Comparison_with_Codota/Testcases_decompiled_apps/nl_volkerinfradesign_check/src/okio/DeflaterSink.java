package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {

    /* renamed from: a */
    private final BufferedSink f6279a;

    /* renamed from: b */
    private final Deflater f6280b;

    /* renamed from: c */
    private boolean f6281c;

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f6279a = bufferedSink;
            this.f6280b = deflater;
        }
    }

    public void write(Buffer buffer, long j) throws IOException {
        C1319ji.m5708a(buffer.f6272b, 0, j);
        while (j > 0) {
            C1316jf jfVar = buffer.f6271a;
            int min = (int) Math.min(j, (long) (jfVar.f4572c - jfVar.f4571b));
            this.f6280b.setInput(jfVar.f4570a, jfVar.f4571b, min);
            m6895a(false);
            buffer.f6272b -= (long) min;
            jfVar.f4571b += min;
            if (jfVar.f4571b == jfVar.f4572c) {
                buffer.f6271a = jfVar.mo8800a();
                C1317jg.m5701a(jfVar);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m6895a(boolean z) throws IOException {
        C1316jf a;
        int deflate;
        Buffer buffer = this.f6279a.buffer();
        while (true) {
            a = buffer.mo11169a(1);
            if (z) {
                deflate = this.f6280b.deflate(a.f4570a, a.f4572c, 2048 - a.f4572c, 2);
            } else {
                deflate = this.f6280b.deflate(a.f4570a, a.f4572c, 2048 - a.f4572c);
            }
            if (deflate > 0) {
                a.f4572c += deflate;
                buffer.f6272b += (long) deflate;
                this.f6279a.emitCompleteSegments();
            } else if (this.f6280b.needsInput()) {
                break;
            }
        }
        if (a.f4571b == a.f4572c) {
            buffer.f6271a = a.mo8800a();
            C1317jg.m5701a(a);
        }
    }

    public void flush() throws IOException {
        m6895a(true);
        this.f6279a.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11200a() throws IOException {
        this.f6280b.finish();
        m6895a(false);
    }

    public void close() throws IOException {
        if (!this.f6281c) {
            Throwable th = null;
            try {
                mo11200a();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f6280b.end();
                th = th;
            } catch (Throwable th3) {
                th = th3;
                if (th != null) {
                    th = th;
                }
            }
            try {
                this.f6279a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f6281c = true;
            if (th != null) {
                C1319ji.m5709a(th);
            }
        }
    }

    public Timeout timeout() {
        return this.f6279a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f6279a + ")";
    }
}
