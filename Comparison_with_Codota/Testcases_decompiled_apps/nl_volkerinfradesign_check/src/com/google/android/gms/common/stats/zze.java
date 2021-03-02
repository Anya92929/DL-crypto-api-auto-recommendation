package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p001v4.util.SimpleArrayMap;
import android.util.Log;
import org.apache.commons.lang3.time.DateUtils;

public class zze {

    /* renamed from: a */
    private final long f3103a;

    /* renamed from: b */
    private final int f3104b;

    /* renamed from: c */
    private final SimpleArrayMap<String, Long> f3105c;

    public zze() {
        this.f3103a = DateUtils.MILLIS_PER_MINUTE;
        this.f3104b = 10;
        this.f3105c = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.f3103a = j;
        this.f3104b = i;
        this.f3105c = new SimpleArrayMap<>();
    }

    /* renamed from: a */
    private void m4000a(long j, long j2) {
        for (int size = this.f3105c.size() - 1; size >= 0; size--) {
            if (j2 - this.f3105c.valueAt(size).longValue() > j) {
                this.f3105c.removeAt(size);
            }
        }
    }

    public Long zzcS(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f3103a;
        synchronized (this) {
            while (this.f3105c.size() >= this.f3104b) {
                m4000a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f3104b + " is not enough. Current durationThreshold is: " + j);
            }
            put = this.f3105c.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean zzcT(String str) {
        boolean z;
        synchronized (this) {
            z = this.f3105c.remove(str) != null;
        }
        return z;
    }
}
