package com.parse;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: ParseTestUtils */
class Synchronizer {
    boolean done = false;
    CountDownLatch latch = new CountDownLatch(1);

    Synchronizer() {
    }

    /* access modifiers changed from: package-private */
    public void start(int count) {
        this.latch = new CountDownLatch(count);
    }

    /* access modifiers changed from: package-private */
    public void finish() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("finish() should be called from the UI thread");
        } else if (this.done) {
            throw new RuntimeException("finish() was called too much");
        } else {
            this.latch.countDown();
        }
    }

    /* access modifiers changed from: package-private */
    public void assertFinishes() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("assertFinishes() should *not* be called from the UI thread");
        }
        try {
            Thread.sleep(500);
            this.done = this.latch.await(10, TimeUnit.SECONDS);
            if (!this.done) {
                throw new RuntimeException("finish() was never called");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
