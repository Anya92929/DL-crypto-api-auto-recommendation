package p000;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* renamed from: iw */
public class C1299iw extends ForwardingSink {

    /* renamed from: a */
    private boolean f4525a;

    public C1299iw(Sink sink) {
        super(sink);
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (this.f4525a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.f4525a = true;
            mo8702a(e);
        }
    }

    public void flush() throws IOException {
        if (!this.f4525a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f4525a = true;
                mo8702a(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f4525a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f4525a = true;
                mo8702a(e);
            }
        }
    }

    /* renamed from: a */
    public void mo8702a(IOException iOException) {
    }
}
