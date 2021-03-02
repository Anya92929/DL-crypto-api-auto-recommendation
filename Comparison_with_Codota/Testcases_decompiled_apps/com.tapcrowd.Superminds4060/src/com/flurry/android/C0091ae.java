package com.flurry.android;

/* renamed from: com.flurry.android.ae */
final class C0091ae implements Runnable {

    /* renamed from: a */
    private /* synthetic */ int f105a;

    /* renamed from: b */
    private /* synthetic */ C0120v f106b;

    C0091ae(C0120v vVar, int i) {
        this.f106b = vVar;
        this.f105a = i;
    }

    public final void run() {
        this.f106b.f258z.onAdsUpdated(new CallbackEvent(this.f105a));
    }
}
