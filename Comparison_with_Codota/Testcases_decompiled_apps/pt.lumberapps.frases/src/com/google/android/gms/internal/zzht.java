package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzho;

@zzin
public final class zzht extends zzho.zza {

    /* renamed from: a */
    private final InAppPurchaseListener f6351a;

    public zzht(InAppPurchaseListener inAppPurchaseListener) {
        this.f6351a = inAppPurchaseListener;
    }

    public void zza(zzhn zzhn) {
        this.f6351a.onInAppPurchaseRequested(new zzhw(zzhn));
    }
}
