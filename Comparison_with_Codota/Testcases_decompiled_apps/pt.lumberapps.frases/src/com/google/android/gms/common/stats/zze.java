package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p009v4.p019f.C0150o;
import android.util.Log;

public class zze {

    /* renamed from: a */
    private final long f4718a;

    /* renamed from: b */
    private final int f4719b;

    /* renamed from: c */
    private final C0150o f4720c;

    public zze() {
        this.f4718a = 60000;
        this.f4719b = 10;
        this.f4720c = new C0150o(10);
    }

    public zze(int i, long j) {
        this.f4718a = j;
        this.f4719b = i;
        this.f4720c = new C0150o();
    }

    /* renamed from: a */
    private void m6193a(long j, long j2) {
        for (int size = this.f4720c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f4720c.mo1153c(size)).longValue() > j) {
                this.f4720c.mo1157d(size);
            }
        }
    }

    public Long zzhx(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f4718a;
        synchronized (this) {
            while (this.f4720c.size() >= this.f4719b) {
                m6193a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", new StringBuilder(94).append("The max capacity ").append(this.f4719b).append(" is not enough. Current durationThreshold is: ").append(j).toString());
            }
            l = (Long) this.f4720c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzhy(String str) {
        boolean z;
        synchronized (this) {
            z = this.f4720c.remove(str) != null;
        }
        return z;
    }
}
