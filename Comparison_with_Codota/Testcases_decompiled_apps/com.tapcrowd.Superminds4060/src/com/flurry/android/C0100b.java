package com.flurry.android;

import android.content.Context;

/* renamed from: com.flurry.android.b */
final class C0100b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f126a;

    /* renamed from: b */
    final /* synthetic */ FlurryAgent f127b;

    /* renamed from: c */
    private /* synthetic */ boolean f128c;

    C0100b(FlurryAgent flurryAgent, boolean z, Context context) {
        this.f127b = flurryAgent;
        this.f128c = z;
        this.f126a = context;
    }

    public final void run() {
        this.f127b.m55k();
        this.f127b.m58n();
        if (!this.f128c) {
            this.f127b.f64s.postDelayed(new C0110l(this), FlurryAgent.f26i);
        }
        if (FlurryAgent.f32o) {
            this.f127b.f63ab.mo3355c();
        }
    }
}
