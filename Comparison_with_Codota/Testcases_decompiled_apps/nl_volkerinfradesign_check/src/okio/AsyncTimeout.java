package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AsyncTimeout extends Timeout {

    /* renamed from: a */
    private static AsyncTimeout f6262a;

    /* renamed from: b */
    private boolean f6263b;

    /* renamed from: c */
    private AsyncTimeout f6264c;

    /* renamed from: d */
    private long f6265d;

    public final void enter() {
        if (this.f6263b) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.f6263b = true;
            m6881a(this, timeoutNanos, hasDeadline);
        }
    }

    /* renamed from: a */
    private static synchronized void m6881a(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f6262a == null) {
                f6262a = new AsyncTimeout();
                new C1824a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                asyncTimeout.f6265d = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                asyncTimeout.f6265d = nanoTime + j;
            } else if (z) {
                asyncTimeout.f6265d = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long a = asyncTimeout.m6879a(nanoTime);
            AsyncTimeout asyncTimeout2 = f6262a;
            while (asyncTimeout2.f6264c != null && a >= asyncTimeout2.f6264c.m6879a(nanoTime)) {
                asyncTimeout2 = asyncTimeout2.f6264c;
            }
            asyncTimeout.f6264c = asyncTimeout2.f6264c;
            asyncTimeout2.f6264c = asyncTimeout;
            if (asyncTimeout2 == f6262a) {
                AsyncTimeout.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.f6263b) {
            return false;
        }
        this.f6263b = false;
        return m6882a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m6882a(AsyncTimeout asyncTimeout) {
        boolean z;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = f6262a;
            while (true) {
                if (asyncTimeout2 == null) {
                    z = true;
                    break;
                } else if (asyncTimeout2.f6264c == asyncTimeout) {
                    asyncTimeout2.f6264c = asyncTimeout.f6264c;
                    asyncTimeout.f6264c = null;
                    z = false;
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.f6264c;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private long m6879a(long j) {
        return this.f6265d - j;
    }

    public void timedOut() {
    }

    public final Sink sink(final Sink sink) {
        return new Sink() {
            public void write(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.write(buffer, j);
                    AsyncTimeout.this.mo11160a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo11159a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo11160a(false);
                    throw th;
                }
            }

            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.flush();
                    AsyncTimeout.this.mo11160a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo11159a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo11160a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.close();
                    AsyncTimeout.this.mo11160a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo11159a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo11160a(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() {
            public long read(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    long read = source.read(buffer, j);
                    AsyncTimeout.this.mo11160a(true);
                    return read;
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo11159a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo11160a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                try {
                    source.close();
                    AsyncTimeout.this.mo11160a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.mo11159a(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.mo11160a(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo11160a(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final IOException mo11159a(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: okio.AsyncTimeout$a */
    static final class C1824a extends Thread {
        public C1824a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    AsyncTimeout b = AsyncTimeout.mo11041a();
                    if (b != null) {
                        b.timedOut();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static synchronized AsyncTimeout mo11041a() throws InterruptedException {
        AsyncTimeout asyncTimeout = null;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = f6262a.f6264c;
            if (asyncTimeout2 == null) {
                AsyncTimeout.class.wait();
            } else {
                long a = asyncTimeout2.m6879a(System.nanoTime());
                if (a > 0) {
                    long j = a / 1000000;
                    AsyncTimeout.class.wait(j, (int) (a - (1000000 * j)));
                } else {
                    f6262a.f6264c = asyncTimeout2.f6264c;
                    asyncTimeout2.f6264c = null;
                    asyncTimeout = asyncTimeout2;
                }
            }
        }
        return asyncTimeout;
    }
}
