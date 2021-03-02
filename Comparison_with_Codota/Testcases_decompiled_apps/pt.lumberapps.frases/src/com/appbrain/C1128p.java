package com.appbrain;

/* renamed from: com.appbrain.p */
final class C1128p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f3164a;

    /* renamed from: b */
    final /* synthetic */ String f3165b;

    /* renamed from: c */
    final /* synthetic */ AppBrainBanner f3166c;

    C1128p(AppBrainBanner appBrainBanner, boolean z, String str) {
        this.f3166c = appBrainBanner;
        this.f3164a = z;
        this.f3165b = str;
    }

    public final void run() {
        this.f3166c.f2045a.mo3876a(this.f3164a, this.f3165b);
    }
}
