package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkd;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.a */
class C1213a extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f3429a;

    /* renamed from: b */
    final /* synthetic */ Timer f3430b;

    /* renamed from: c */
    final /* synthetic */ zza f3431c;

    C1213a(zza zza, CountDownLatch countDownLatch, Timer timer) {
        this.f3431c = zza;
        this.f3429a = countDownLatch;
        this.f3430b = timer;
    }

    public void run() {
        if (((long) ((Integer) zzdc.zzbcl.get()).intValue()) != this.f3429a.getCount()) {
            zzkd.zzcv("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.f3429a.getCount() == 0) {
                this.f3430b.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.f3431c.f4011f.zzagf.getPackageName()).concat("_adsTrace_");
        try {
            zzkd.zzcv("Starting method tracing");
            this.f3429a.countDown();
            Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzu.zzfu().currentTimeMillis()).toString(), ((Integer) zzdc.zzbcm.get()).intValue());
        } catch (Exception e) {
            zzkd.zzd("Exception occurred while starting method tracing.", e);
        }
    }
}
