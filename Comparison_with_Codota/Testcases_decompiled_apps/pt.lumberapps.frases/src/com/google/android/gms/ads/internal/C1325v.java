package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzlh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.v */
final class C1325v implements zzep {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f3997a;

    C1325v(CountDownLatch countDownLatch) {
        this.f3997a = countDownLatch;
    }

    public void zza(zzlh zzlh, Map map) {
        this.f3997a.countDown();
        zzlh.getView().setVisibility(0);
    }
}
