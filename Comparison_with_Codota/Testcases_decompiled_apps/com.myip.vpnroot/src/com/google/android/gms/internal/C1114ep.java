package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

@C1130ez
/* renamed from: com.google.android.gms.internal.ep */
public class C1114ep implements InAppPurchase {

    /* renamed from: sx */
    private final C1092eg f3256sx;

    public C1114ep(C1092eg egVar) {
        this.f3256sx = egVar;
    }

    public String getProductId() {
        try {
            return this.f3256sx.getProductId();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.f3256sx.recordPlayBillingResolution(billingResponseCode);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.f3256sx.recordResolution(resolution);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
