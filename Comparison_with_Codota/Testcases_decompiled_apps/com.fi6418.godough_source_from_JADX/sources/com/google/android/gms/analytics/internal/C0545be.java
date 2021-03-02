package com.google.android.gms.analytics.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.analytics.internal.be */
abstract class C0545be {

    /* renamed from: b */
    private static volatile Handler f3791b;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0516ac f3792a;

    /* renamed from: c */
    private final Runnable f3793c = new C0546bf(this);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile long f3794d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f3795e;

    C0545be(C0516ac acVar) {
        C1009bf.m4528a(acVar);
        this.f3792a = acVar;
    }

    /* renamed from: e */
    private Handler m3189e() {
        Handler handler;
        if (f3791b != null) {
            return f3791b;
        }
        synchronized (C0545be.class) {
            if (f3791b == null) {
                f3791b = new Handler(this.f3792a.mo6600b().getMainLooper());
            }
            handler = f3791b;
        }
        return handler;
    }

    /* renamed from: a */
    public abstract void mo6650a();

    /* renamed from: a */
    public void mo6763a(long j) {
        mo6767d();
        if (j >= 0) {
            this.f3794d = this.f3792a.mo6602d().mo6990a();
            if (!m3189e().postDelayed(this.f3793c, j)) {
                this.f3792a.mo6604f().mo6880e("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: b */
    public long mo6764b() {
        if (this.f3794d == 0) {
            return 0;
        }
        return Math.abs(this.f3792a.mo6602d().mo6990a() - this.f3794d);
    }

    /* renamed from: b */
    public void mo6765b(long j) {
        long j2 = 0;
        if (mo6766c()) {
            if (j < 0) {
                mo6767d();
                return;
            }
            long abs = j - Math.abs(this.f3792a.mo6602d().mo6990a() - this.f3794d);
            if (abs >= 0) {
                j2 = abs;
            }
            m3189e().removeCallbacks(this.f3793c);
            if (!m3189e().postDelayed(this.f3793c, j2)) {
                this.f3792a.mo6604f().mo6880e("Failed to adjust delayed post. time", Long.valueOf(j2));
            }
        }
    }

    /* renamed from: c */
    public boolean mo6766c() {
        return this.f3794d != 0;
    }

    /* renamed from: d */
    public void mo6767d() {
        this.f3794d = 0;
        m3189e().removeCallbacks(this.f3793c);
    }
}
