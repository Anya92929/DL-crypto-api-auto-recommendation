package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.C0143c;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.internal.C1123eu;

@C1130ez
/* renamed from: com.google.android.gms.internal.ex */
public final class C1128ex extends C1123eu.C1124a {

    /* renamed from: oF */
    private final PublisherInterstitialAd f3267oF;

    /* renamed from: oG */
    private final C0143c f3268oG;

    public C1128ex(C0143c cVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f3268oG = cVar;
        this.f3267oF = publisherInterstitialAd;
    }

    /* renamed from: a */
    public void mo8454a(C1117es esVar) {
        this.f3268oG.mo3365a(this.f3267oF, new C1126ev(esVar));
    }

    /* renamed from: e */
    public boolean mo8455e(String str, String str2) {
        return this.f3268oG.mo3366a(this.f3267oF, str, str2);
    }
}
