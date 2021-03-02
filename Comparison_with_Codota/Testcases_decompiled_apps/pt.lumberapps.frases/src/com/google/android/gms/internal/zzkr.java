package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

@zzin
public class zzkr {

    /* renamed from: a */
    private long f6642a;

    /* renamed from: b */
    private long f6643b = Long.MIN_VALUE;

    /* renamed from: c */
    private Object f6644c = new Object();

    public zzkr(long j) {
        this.f6642a = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.f6644c) {
            long elapsedRealtime = zzu.zzfu().elapsedRealtime();
            if (this.f6643b + this.f6642a > elapsedRealtime) {
                z = false;
            } else {
                this.f6643b = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
