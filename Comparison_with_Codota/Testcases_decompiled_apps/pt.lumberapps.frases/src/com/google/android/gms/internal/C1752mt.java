package com.google.android.gms.internal;

import com.google.android.gms.internal.zzkx;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.mt */
final class C1752mt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzkv f5360a;

    /* renamed from: b */
    final /* synthetic */ zzkx.zza f5361b;

    /* renamed from: c */
    final /* synthetic */ zzky f5362c;

    C1752mt(zzkv zzkv, zzkx.zza zza, zzky zzky) {
        this.f5360a = zzkv;
        this.f5361b = zza;
        this.f5362c = zzky;
    }

    public void run() {
        try {
            this.f5360a.zzh(this.f5361b.apply(this.f5362c.get()));
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            this.f5360a.cancel(true);
        }
    }
}
