package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimedSemaphore {
    public static final int NO_LIMIT = 0;

    /* renamed from: a */
    private final ScheduledExecutorService f7115a;

    /* renamed from: b */
    private final long f7116b;

    /* renamed from: c */
    private final TimeUnit f7117c;

    /* renamed from: d */
    private final boolean f7118d;

    /* renamed from: e */
    private ScheduledFuture<?> f7119e;

    /* renamed from: f */
    private long f7120f;

    /* renamed from: g */
    private long f7121g;

    /* renamed from: h */
    private int f7122h;

    /* renamed from: i */
    private int f7123i;

    /* renamed from: j */
    private int f7124j;

    /* renamed from: k */
    private boolean f7125k;

    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this((ScheduledExecutorService) null, j, timeUnit, i);
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        if (j <= 0) {
            throw new IllegalArgumentException("Time period must be greater 0!");
        }
        this.f7116b = j;
        this.f7117c = timeUnit;
        if (scheduledExecutorService != null) {
            this.f7115a = scheduledExecutorService;
            this.f7118d = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.f7115a = scheduledThreadPoolExecutor;
            this.f7118d = true;
        }
        setLimit(i);
    }

    public final synchronized int getLimit() {
        return this.f7122h;
    }

    public final synchronized void setLimit(int i) {
        this.f7122h = i;
    }

    public synchronized void shutdown() {
        if (!this.f7125k) {
            if (this.f7118d) {
                getExecutorService().shutdownNow();
            }
            if (this.f7119e != null) {
                this.f7119e.cancel(false);
            }
            this.f7125k = true;
        }
    }

    public synchronized boolean isShutdown() {
        return this.f7125k;
    }

    public synchronized void acquire() throws InterruptedException {
        boolean z;
        if (isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.f7119e == null) {
            this.f7119e = startTimer();
        }
        do {
            z = getLimit() <= 0 || this.f7123i < getLimit();
            if (!z) {
                wait();
                continue;
            } else {
                this.f7123i++;
            }
        } while (!z);
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.f7124j;
    }

    public synchronized int getAcquireCount() {
        return this.f7123i;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        double d;
        if (this.f7121g == 0) {
            d = 0.0d;
        } else {
            d = ((double) this.f7120f) / ((double) this.f7121g);
        }
        return d;
    }

    public long getPeriod() {
        return this.f7116b;
    }

    public TimeUnit getUnit() {
        return this.f7117c;
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService getExecutorService() {
        return this.f7115a;
    }

    /* access modifiers changed from: protected */
    public ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() {
            public void run() {
                TimedSemaphore.this.mo13164a();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo13164a() {
        this.f7124j = this.f7123i;
        this.f7120f += (long) this.f7123i;
        this.f7121g++;
        this.f7123i = 0;
        notifyAll();
    }
}
