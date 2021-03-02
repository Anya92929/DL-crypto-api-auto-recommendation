package okio;

import java.io.IOException;

public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    private final Source f6283a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6283a = source;
    }

    public final Source delegate() {
        return this.f6283a;
    }

    public long read(Buffer buffer, long j) throws IOException {
        return this.f6283a.read(buffer, j);
    }

    public Timeout timeout() {
        return this.f6283a.timeout();
    }

    public void close() throws IOException {
        this.f6283a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6283a.toString() + ")";
    }
}
