package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.zzin;

@zzin
public final class zzj extends zzw.zza {

    /* renamed from: a */
    private final AppEventListener f3595a;

    public zzj(AppEventListener appEventListener) {
        this.f3595a = appEventListener;
    }

    public void onAppEvent(String str, String str2) {
        this.f3595a.onAppEvent(str, str2);
    }
}
