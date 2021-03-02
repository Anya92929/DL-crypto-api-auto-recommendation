package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.C0142b;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.internal.C1120et;

@C1130ez
/* renamed from: com.google.android.gms.internal.ew */
public final class C1127ew extends C1120et.C1121a {

    /* renamed from: oE */
    private final C0142b f3265oE;

    /* renamed from: sQ */
    private final PublisherAdView f3266sQ;

    public C1127ew(C0142b bVar, PublisherAdView publisherAdView) {
        this.f3265oE = bVar;
        this.f3266sQ = publisherAdView;
    }

    /* renamed from: a */
    public void mo8449a(C1117es esVar) {
        this.f3265oE.mo3363a(this.f3266sQ, new C1126ev(esVar));
    }

    /* renamed from: e */
    public boolean mo8450e(String str, String str2) {
        return this.f3265oE.mo3364a(this.f3266sQ, str, str2);
    }
}
