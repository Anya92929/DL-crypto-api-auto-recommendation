package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;

/* renamed from: com.google.android.gms.common.stats.g */
public class C1098g {

    /* renamed from: a */
    private final long f4862a;

    /* renamed from: b */
    private final int f4863b;

    /* renamed from: c */
    private final SimpleArrayMap<String, Long> f4864c;

    public C1098g() {
        this.f4862a = 60000;
        this.f4863b = 10;
        this.f4864c = new SimpleArrayMap<>(10);
    }

    public C1098g(int i, long j) {
        this.f4862a = j;
        this.f4863b = i;
        this.f4864c = new SimpleArrayMap<>();
    }

    /* renamed from: a */
    private void m4773a(long j, long j2) {
        for (int size = this.f4864c.size() - 1; size >= 0; size--) {
            if (j2 - this.f4864c.valueAt(size).longValue() > j) {
                this.f4864c.removeAt(size);
            }
        }
    }

    /* renamed from: a */
    public Long mo7706a(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f4862a;
        synchronized (this) {
            while (this.f4864c.size() >= this.f4863b) {
                m4773a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f4863b + " is not enough. Current durationThreshold is: " + j);
            }
            put = this.f4864c.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    /* renamed from: b */
    public boolean mo7707b(String str) {
        boolean z;
        synchronized (this) {
            z = this.f4864c.remove(str) != null;
        }
        return z;
    }
}
