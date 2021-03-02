package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

@zzin
/* renamed from: com.google.android.gms.internal.lh */
final class C1713lh {

    /* renamed from: a */
    private long f5289a = -1;

    /* renamed from: b */
    private long f5290b = -1;

    /* renamed from: a */
    public long mo7467a() {
        return this.f5290b;
    }

    /* renamed from: b */
    public void mo7468b() {
        this.f5290b = SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public void mo7469c() {
        this.f5289a = SystemClock.elapsedRealtime();
    }

    /* renamed from: d */
    public Bundle mo7470d() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f5289a);
        bundle.putLong("tclose", this.f5290b);
        return bundle;
    }
}
