package com.google.android.gms.analytics.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.analytics.internal.ak */
class C0524ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ComponentName f3737a;

    /* renamed from: b */
    final /* synthetic */ C0522ai f3738b;

    C0524ak(C0522ai aiVar, ComponentName componentName) {
        this.f3738b = aiVar;
        this.f3737a = componentName;
    }

    public void run() {
        this.f3738b.f3732a.m3028a(this.f3737a);
    }
}
