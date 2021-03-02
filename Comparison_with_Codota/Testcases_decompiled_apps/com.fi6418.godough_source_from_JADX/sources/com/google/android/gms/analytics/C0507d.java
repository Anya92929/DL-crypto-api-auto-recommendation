package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.d */
class C0507d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0506c f3678a;

    C0507d(C0506c cVar) {
        this.f3678a = cVar;
    }

    public void run() {
        if (!this.f3678a.f3677d.stopSelfResult(this.f3678a.f3674a)) {
            return;
        }
        if (this.f3678a.f3675b.mo6603e().mo6731a()) {
            this.f3678a.f3676c.mo6869b("Device AnalyticsService processed last dispatch request");
        } else {
            this.f3678a.f3676c.mo6869b("Local AnalyticsService processed last dispatch request");
        }
    }
}
