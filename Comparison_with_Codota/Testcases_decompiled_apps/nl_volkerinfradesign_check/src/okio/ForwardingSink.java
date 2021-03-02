package okio;

import java.io.IOException;

public abstract class ForwardingSink implements Sink {

    /* renamed from: a */
    private final Sink f6282a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6282a = sink;
    }

    public final Sink delegate() {
        return this.f6282a;
    }

    public void write(Buffer buffer, long j) throws IOException {
        this.f6282a.write(buffer, j);
    }

    public void flush() throws IOException {
        this.f6282a.flush();
    }

    public Timeout timeout() {
        return this.f6282a.timeout();
    }

    public void close() throws IOException {
        this.f6282a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6282a.toString() + ")";
    }
}
