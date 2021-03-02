package com.google.ads;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.ads.d */
public class C0210d {

    /* renamed from: a */
    private C0208c f388a = null;

    /* renamed from: b */
    private long f389b = -1;

    /* renamed from: a */
    public boolean mo3373a() {
        return this.f388a != null && SystemClock.elapsedRealtime() < this.f389b;
    }

    /* renamed from: a */
    public void mo3372a(C0208c cVar, int i) {
        this.f388a = cVar;
        this.f389b = TimeUnit.MILLISECONDS.convert((long) i, TimeUnit.SECONDS) + SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public C0208c mo3374b() {
        return this.f388a;
    }
}
