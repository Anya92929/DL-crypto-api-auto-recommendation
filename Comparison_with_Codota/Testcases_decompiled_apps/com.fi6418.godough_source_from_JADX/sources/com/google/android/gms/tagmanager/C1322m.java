package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* renamed from: com.google.android.gms.tagmanager.m */
class C1322m implements ComponentCallbacks2 {

    /* renamed from: a */
    final /* synthetic */ C1319j f5408a;

    C1322m(C1319j jVar) {
        this.f5408a = jVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20) {
            this.f5408a.mo9171a();
        }
    }
}
