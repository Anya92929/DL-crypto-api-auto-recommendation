package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.C1095eh;

@C1130ez
/* renamed from: com.google.android.gms.internal.em */
public final class C1110em extends C1095eh.C1096a {

    /* renamed from: oC */
    private final InAppPurchaseListener f3253oC;

    public C1110em(InAppPurchaseListener inAppPurchaseListener) {
        this.f3253oC = inAppPurchaseListener;
    }

    /* renamed from: a */
    public void mo8422a(C1092eg egVar) {
        this.f3253oC.onInAppPurchaseRequested(new C1114ep(egVar));
    }
}
