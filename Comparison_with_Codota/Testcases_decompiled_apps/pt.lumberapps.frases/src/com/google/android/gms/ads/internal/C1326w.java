package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.w */
final class C1326w implements zzep {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f3998a;

    C1326w(CountDownLatch countDownLatch) {
        this.f3998a = countDownLatch;
    }

    public void zza(zzlh zzlh, Map map) {
        zzkd.zzcx("Adapter returned an ad, but assets substitution failed");
        this.f3998a.countDown();
        zzlh.destroy();
    }
}
