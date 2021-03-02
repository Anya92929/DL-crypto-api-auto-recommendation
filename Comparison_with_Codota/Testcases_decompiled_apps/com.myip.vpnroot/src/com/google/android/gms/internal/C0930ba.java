package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.C0941bf;

@C1130ez
/* renamed from: com.google.android.gms.internal.ba */
public final class C0930ba extends C0941bf.C0942a {

    /* renamed from: oi */
    private final AppEventListener f2837oi;

    public C0930ba(AppEventListener appEventListener) {
        this.f2837oi = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.f2837oi.onAppEvent(name, info);
    }
}
