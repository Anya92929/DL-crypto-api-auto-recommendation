package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ma */
final class C1733ma implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzkv f5326a;

    /* renamed from: b */
    final /* synthetic */ Callable f5327b;

    C1733ma(zzkv zzkv, Callable callable) {
        this.f5326a = zzkv;
        this.f5327b = callable;
    }

    public void run() {
        try {
            Process.setThreadPriority(10);
            this.f5326a.zzh(this.f5327b.call());
        } catch (Exception e) {
            zzu.zzft().zzb((Throwable) e, true);
            this.f5326a.cancel(true);
        }
    }
}
