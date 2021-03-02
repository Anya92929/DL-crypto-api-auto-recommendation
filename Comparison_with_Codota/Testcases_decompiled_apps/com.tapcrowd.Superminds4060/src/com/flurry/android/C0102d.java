package com.flurry.android;

import android.content.Context;

/* renamed from: com.flurry.android.d */
final class C0102d implements Runnable {

    /* renamed from: a */
    private /* synthetic */ Context f188a;

    /* renamed from: b */
    private /* synthetic */ boolean f189b;

    /* renamed from: c */
    private /* synthetic */ FlurryAgent f190c;

    C0102d(FlurryAgent flurryAgent, Context context, boolean z) {
        this.f190c = flurryAgent;
        this.f188a = context;
        this.f189b = z;
    }

    public final void run() {
        if (!this.f190c.f68w) {
            this.f190c.m11a(this.f188a);
        }
        FlurryAgent.m17a(this.f190c, this.f188a, this.f189b);
    }
}
