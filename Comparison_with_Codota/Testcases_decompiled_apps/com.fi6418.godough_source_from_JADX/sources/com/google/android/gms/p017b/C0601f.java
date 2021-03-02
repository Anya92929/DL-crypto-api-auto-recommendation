package com.google.android.gms.p017b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: com.google.android.gms.b.f */
class C0601f implements C0604i {

    /* renamed from: a */
    final /* synthetic */ FrameLayout f3963a;

    /* renamed from: b */
    final /* synthetic */ LayoutInflater f3964b;

    /* renamed from: c */
    final /* synthetic */ ViewGroup f3965c;

    /* renamed from: d */
    final /* synthetic */ Bundle f3966d;

    /* renamed from: e */
    final /* synthetic */ C0597b f3967e;

    C0601f(C0597b bVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3967e = bVar;
        this.f3963a = frameLayout;
        this.f3964b = layoutInflater;
        this.f3965c = viewGroup;
        this.f3966d = bundle;
    }

    /* renamed from: a */
    public int mo6964a() {
        return 2;
    }

    /* renamed from: a */
    public void mo6965a(C0596a aVar) {
        this.f3963a.removeAllViews();
        this.f3963a.addView(this.f3967e.f3952a.mo6942a(this.f3964b, this.f3965c, this.f3966d));
    }
}
