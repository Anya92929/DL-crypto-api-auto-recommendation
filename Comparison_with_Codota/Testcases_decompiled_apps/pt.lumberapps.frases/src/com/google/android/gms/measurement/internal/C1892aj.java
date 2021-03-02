package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzab;

/* renamed from: com.google.android.gms.measurement.internal.aj */
abstract class C1892aj {

    /* renamed from: b */
    private static volatile Handler f7086b;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzx f7087a;

    /* renamed from: c */
    private final Runnable f7088c = new C1893ak(this);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile long f7089d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f7090e = true;

    C1892aj(zzx zzx) {
        zzab.zzy(zzx);
        this.f7087a = zzx;
    }

    /* renamed from: d */
    private Handler m7639d() {
        Handler handler;
        if (f7086b != null) {
            return f7086b;
        }
        synchronized (C1892aj.class) {
            if (f7086b == null) {
                f7086b = new Handler(this.f7087a.getContext().getMainLooper());
            }
            handler = f7086b;
        }
        return handler;
    }

    /* renamed from: a */
    public abstract void mo9215a();

    /* renamed from: a */
    public void mo9233a(long j) {
        mo9235c();
        if (j >= 0) {
            this.f7089d = this.f7087a.zzyw().currentTimeMillis();
            if (!m7639d().postDelayed(this.f7088c, j)) {
                this.f7087a.zzbsd().zzbsv().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: b */
    public boolean mo9234b() {
        return this.f7089d != 0;
    }

    /* renamed from: c */
    public void mo9235c() {
        this.f7089d = 0;
        m7639d().removeCallbacks(this.f7088c);
    }
}
