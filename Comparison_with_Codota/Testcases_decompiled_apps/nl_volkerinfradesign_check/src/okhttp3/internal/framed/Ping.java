package okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping {

    /* renamed from: a */
    private final CountDownLatch f6138a = new CountDownLatch(1);

    /* renamed from: b */
    private long f6139b = -1;

    /* renamed from: c */
    private long f6140c = -1;

    Ping() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11059a() {
        if (this.f6139b != -1) {
            throw new IllegalStateException();
        }
        this.f6139b = System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11060b() {
        if (this.f6140c != -1 || this.f6139b == -1) {
            throw new IllegalStateException();
        }
        this.f6140c = System.nanoTime();
        this.f6138a.countDown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo11061c() {
        if (this.f6140c != -1 || this.f6139b == -1) {
            throw new IllegalStateException();
        }
        this.f6140c = this.f6139b - 1;
        this.f6138a.countDown();
    }

    public long roundTripTime() throws InterruptedException {
        this.f6138a.await();
        return this.f6140c - this.f6139b;
    }

    public long roundTripTime(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.f6138a.await(j, timeUnit)) {
            return this.f6140c - this.f6139b;
        }
        return -2;
    }
}
