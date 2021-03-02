package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzar;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkg;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzin
/* renamed from: com.google.android.gms.ads.internal.p */
class C1295p implements zzan, Runnable {

    /* renamed from: a */
    CountDownLatch f3854a = new CountDownLatch(1);

    /* renamed from: b */
    private final List f3855b = new Vector();

    /* renamed from: c */
    private final AtomicReference f3856c = new AtomicReference();

    /* renamed from: d */
    private zzv f3857d;

    public C1295p(zzv zzv) {
        this.f3857d = zzv;
        if (zzm.zziw().zztx()) {
            zzkg.zza((Runnable) this);
        } else {
            run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r2.getApplicationContext();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Context m5705a(android.content.Context r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.zzcy r0 = com.google.android.gms.internal.zzdc.zzayk
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x000f
        L_0x000e:
            return r2
        L_0x000f:
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x000e
            r2 = r0
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.C1295p.m5705a(android.content.Context):android.content.Context");
    }

    /* renamed from: b */
    private void m5706b() {
        if (!this.f3855b.isEmpty()) {
            for (Object[] objArr : this.f3855b) {
                if (objArr.length == 1) {
                    ((zzan) this.f3856c.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzan) this.f3856c.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f3855b.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzan mo5557a(String str, Context context, boolean z) {
        return zzar.zza(str, context, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5558a(zzan zzan) {
        this.f3856c.set(zzan);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5559a() {
        try {
            this.f3854a.await();
            return true;
        } catch (InterruptedException e) {
            zzkd.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public void run() {
        try {
            mo5558a(mo5557a(this.f3857d.zzaow.zzcs, m5705a(this.f3857d.zzagf), !((Boolean) zzdc.zzayw.get()).booleanValue() || this.f3857d.zzaow.zzcnm));
        } finally {
            this.f3854a.countDown();
            this.f3857d = null;
        }
    }

    public void zza(int i, int i2, int i3) {
        zzan zzan = (zzan) this.f3856c.get();
        if (zzan != null) {
            m5706b();
            zzan.zza(i, i2, i3);
            return;
        }
        this.f3855b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzan zzan = (zzan) this.f3856c.get();
        if (zzan != null) {
            m5706b();
            zzan.zza(motionEvent);
            return;
        }
        this.f3855b.add(new Object[]{motionEvent});
    }

    public String zzb(Context context) {
        zzan zzan;
        if (!mo5559a() || (zzan = (zzan) this.f3856c.get()) == null) {
            return "";
        }
        m5706b();
        return zzan.zzb(m5705a(context));
    }

    public String zzb(Context context, String str) {
        zzan zzan;
        if (!mo5559a() || (zzan = (zzan) this.f3856c.get()) == null) {
            return "";
        }
        m5706b();
        return zzan.zzb(m5705a(context), str);
    }
}
