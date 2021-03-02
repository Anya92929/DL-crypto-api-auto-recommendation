package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

@TargetApi(14)
/* renamed from: com.google.android.gms.common.images.e */
final class C1355e implements ComponentCallbacks2 {

    /* renamed from: a */
    private final C1352b f4428a;

    public C1355e(C1352b bVar) {
        this.f4428a = bVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        this.f4428a.evictAll();
    }

    public void onTrimMemory(int i) {
        if (i >= 60) {
            this.f4428a.evictAll();
        } else if (i >= 20) {
            this.f4428a.trimToSize(this.f4428a.size() / 2);
        }
    }
}
