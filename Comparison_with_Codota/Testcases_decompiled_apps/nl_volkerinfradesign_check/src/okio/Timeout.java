package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout NONE = new Timeout() {
        public Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }

        public Timeout deadlineNanoTime(long j) {
            return this;
        }

        public void throwIfReached() throws IOException {
        }
    };

    /* renamed from: a */
    private boolean f6305a;

    /* renamed from: b */
    private long f6306b;

    /* renamed from: c */
    private long f6307c;

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f6307c = timeUnit.toNanos(j);
            return this;
        }
    }

    public long timeoutNanos() {
        return this.f6307c;
    }

    public boolean hasDeadline() {
        return this.f6305a;
    }

    public long deadlineNanoTime() {
        if (this.f6305a) {
            return this.f6306b;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long j) {
        this.f6305a = true;
        this.f6306b = j;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j);
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public Timeout clearTimeout() {
        this.f6307c = 0;
        return this;
    }

    public Timeout clearDeadline() {
        this.f6305a = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f6305a && this.f6306b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
