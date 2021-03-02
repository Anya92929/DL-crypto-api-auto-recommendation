package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.C1107el;

@C1130ez
/* renamed from: com.google.android.gms.internal.eq */
public final class C1115eq extends C1107el.C1108a {

    /* renamed from: oD */
    private final PlayStorePurchaseListener f3257oD;

    public C1115eq(PlayStorePurchaseListener playStorePurchaseListener) {
        this.f3257oD = playStorePurchaseListener;
    }

    /* renamed from: a */
    public void mo8435a(C1104ek ekVar) {
        this.f3257oD.onInAppPurchaseFinished(new C1113eo(ekVar));
    }

    public boolean isValidPurchase(String productId) {
        return this.f3257oD.isValidPurchase(productId);
    }
}
