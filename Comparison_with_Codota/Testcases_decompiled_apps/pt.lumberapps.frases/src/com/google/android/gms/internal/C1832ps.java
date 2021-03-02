package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.internal.zzpm;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ps */
class C1832ps implements IBinder.DeathRecipient, C1833pt {

    /* renamed from: a */
    private final WeakReference f5509a;

    /* renamed from: b */
    private final WeakReference f5510b;

    /* renamed from: c */
    private final WeakReference f5511c;

    private C1832ps(zzpm.zza zza, zzd zzd, IBinder iBinder) {
        this.f5510b = new WeakReference(zzd);
        this.f5509a = new WeakReference(zza);
        this.f5511c = new WeakReference(iBinder);
    }

    /* synthetic */ C1832ps(zzpm.zza zza, zzd zzd, IBinder iBinder, C1831pr prVar) {
        this(zza, zzd, iBinder);
    }

    /* renamed from: a */
    private void m6575a() {
        zzpm.zza zza = (zzpm.zza) this.f5509a.get();
        zzd zzd = (zzd) this.f5510b.get();
        if (!(zzd == null || zza == null)) {
            zzd.remove(zza.zzaoj().intValue());
        }
        IBinder iBinder = (IBinder) this.f5511c.get();
        if (this.f5511c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    /* renamed from: a */
    public void mo7653a(zzpm.zza zza) {
        m6575a();
    }

    public void binderDied() {
        m6575a();
    }
}
