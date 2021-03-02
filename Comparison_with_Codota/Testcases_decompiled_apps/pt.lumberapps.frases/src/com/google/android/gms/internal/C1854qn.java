package com.google.android.gms.internal;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.qn */
class C1854qn {

    /* renamed from: a */
    public static final boolean f5523a = zzs.DEBUG;

    /* renamed from: b */
    private final List f5524b = new ArrayList();

    /* renamed from: c */
    private boolean f5525c = false;

    C1854qn() {
    }

    /* renamed from: a */
    private long m6600a() {
        if (this.f5524b.size() == 0) {
            return 0;
        }
        return ((C1855qo) this.f5524b.get(this.f5524b.size() - 1)).f5528c - ((C1855qo) this.f5524b.get(0)).f5528c;
    }

    /* renamed from: a */
    public synchronized void mo7683a(String str) {
        this.f5525c = true;
        long a = m6600a();
        if (a > 0) {
            long j = ((C1855qo) this.f5524b.get(0)).f5528c;
            zzs.zzb("(%-4d ms) %s", Long.valueOf(a), str);
            long j2 = j;
            for (C1855qo qoVar : this.f5524b) {
                long j3 = qoVar.f5528c;
                zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(qoVar.f5527b), qoVar.f5526a);
                j2 = j3;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo7684a(String str, long j) {
        if (this.f5525c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f5524b.add(new C1855qo(str, j, SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!this.f5525c) {
            mo7683a("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
