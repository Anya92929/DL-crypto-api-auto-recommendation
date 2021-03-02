package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzhs;

@zzin
public final class zzhx extends zzhs.zza {

    /* renamed from: a */
    private final PlayStorePurchaseListener f6354a;

    public zzhx(PlayStorePurchaseListener playStorePurchaseListener) {
        this.f6354a = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.f6354a.isValidPurchase(str);
    }

    public void zza(zzhr zzhr) {
        this.f6354a.onInAppPurchaseFinished(new zzhv(zzhr));
    }
}
