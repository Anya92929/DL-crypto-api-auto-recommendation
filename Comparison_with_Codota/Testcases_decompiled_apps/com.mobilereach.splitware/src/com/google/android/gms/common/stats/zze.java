package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzanN;
    private final int zzanO;
    private final SimpleArrayMap<String, Long> zzanP;

    public zze() {
        this.zzanN = 60000;
        this.zzanO = 10;
        this.zzanP = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.zzanN = j;
        this.zzanO = i;
        this.zzanP = new SimpleArrayMap<>();
    }

    private void zzb(long j, long j2) {
        for (int size = this.zzanP.size() - 1; size >= 0; size--) {
            if (j2 - this.zzanP.valueAt(size).longValue() > j) {
                this.zzanP.removeAt(size);
            }
        }
    }

    public Long zzcS(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzanN;
        synchronized (this) {
            while (this.zzanP.size() >= this.zzanO) {
                zzb(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.zzanO + " is not enough. Current durationThreshold is: " + j);
            }
            put = this.zzanP.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean zzcT(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzanP.remove(str) != null;
        }
        return z;
    }
}
