package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

@zzin
/* renamed from: com.google.android.gms.internal.mv */
class C1754mv {

    /* renamed from: a */
    private final Object f5367a = new Object();

    /* renamed from: b */
    private final List f5368b = new ArrayList();

    /* renamed from: c */
    private final List f5369c = new ArrayList();

    /* renamed from: d */
    private boolean f5370d = false;

    /* renamed from: c */
    private void m6481c(Runnable runnable) {
        zzkg.zza(runnable);
    }

    /* renamed from: d */
    private void m6482d(Runnable runnable) {
        zza.zzcnb.post(runnable);
    }

    /* renamed from: a */
    public void mo7499a() {
        synchronized (this.f5367a) {
            if (!this.f5370d) {
                for (Runnable c : this.f5368b) {
                    m6481c(c);
                }
                for (Runnable d : this.f5369c) {
                    m6482d(d);
                }
                this.f5368b.clear();
                this.f5369c.clear();
                this.f5370d = true;
            }
        }
    }

    /* renamed from: a */
    public void mo7500a(Runnable runnable) {
        synchronized (this.f5367a) {
            if (this.f5370d) {
                m6481c(runnable);
            } else {
                this.f5368b.add(runnable);
            }
        }
    }

    /* renamed from: b */
    public void mo7501b(Runnable runnable) {
        synchronized (this.f5367a) {
            if (this.f5370d) {
                m6482d(runnable);
            } else {
                this.f5369c.add(runnable);
            }
        }
    }
}
