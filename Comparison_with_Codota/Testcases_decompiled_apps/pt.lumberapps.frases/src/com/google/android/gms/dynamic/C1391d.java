package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: com.google.android.gms.dynamic.d */
class C1391d implements C1395h {

    /* renamed from: a */
    final /* synthetic */ FrameLayout f4766a;

    /* renamed from: b */
    final /* synthetic */ LayoutInflater f4767b;

    /* renamed from: c */
    final /* synthetic */ ViewGroup f4768c;

    /* renamed from: d */
    final /* synthetic */ Bundle f4769d;

    /* renamed from: e */
    final /* synthetic */ zza f4770e;

    C1391d(zza zza, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4770e = zza;
        this.f4766a = frameLayout;
        this.f4767b = layoutInflater;
        this.f4768c = viewGroup;
        this.f4769d = bundle;
    }

    /* renamed from: a */
    public int mo6948a() {
        return 2;
    }

    /* renamed from: a */
    public void mo6949a(LifecycleDelegate lifecycleDelegate) {
        this.f4766a.removeAllViews();
        this.f4766a.addView(this.f4770e.f4777a.onCreateView(this.f4767b, this.f4768c, this.f4769d));
    }
}
