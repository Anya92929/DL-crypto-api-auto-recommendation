package com.flurry.android;

/* renamed from: com.flurry.android.af */
final class C0092af implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f107a;

    /* renamed from: b */
    private /* synthetic */ C0120v f108b;

    C0092af(C0120v vVar, String str) {
        this.f108b = vVar;
        this.f107a = str;
    }

    public final void run() {
        CallbackEvent callbackEvent = new CallbackEvent(101);
        callbackEvent.setMessage(this.f107a);
        if (this.f108b.f258z != null) {
            this.f108b.f258z.onMarketAppLaunchError(callbackEvent);
        }
    }
}
