package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze implements zzn {

    /* renamed from: a */
    private final Executor f6145a;

    public zze(Handler handler) {
        this.f6145a = new C1545fb(this, handler);
    }

    public void zza(zzk zzk, zzm zzm) {
        zza(zzk, zzm, (Runnable) null);
    }

    public void zza(zzk zzk, zzm zzm, Runnable runnable) {
        zzk.zzu();
        zzk.zzc("post-response");
        this.f6145a.execute(new C1546fc(this, zzk, zzm, runnable));
    }

    public void zza(zzk zzk, zzr zzr) {
        zzk.zzc("post-error");
        this.f6145a.execute(new C1546fc(this, zzk, zzm.zzd(zzr), (Runnable) null));
    }
}
