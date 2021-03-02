package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {

    /* renamed from: a */
    private Timeout f6284a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6284a = timeout;
    }

    public final Timeout delegate() {
        return this.f6284a;
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6284a = timeout;
        return this;
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f6284a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f6284a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.f6284a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.f6284a.deadlineNanoTime();
    }

    public Timeout deadlineNanoTime(long j) {
        return this.f6284a.deadlineNanoTime(j);
    }

    public Timeout clearTimeout() {
        return this.f6284a.clearTimeout();
    }

    public Timeout clearDeadline() {
        return this.f6284a.clearDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f6284a.throwIfReached();
    }
}
