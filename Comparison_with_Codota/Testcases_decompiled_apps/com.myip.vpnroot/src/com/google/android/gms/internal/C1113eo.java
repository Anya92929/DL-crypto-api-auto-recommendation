package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@C1130ez
/* renamed from: com.google.android.gms.internal.eo */
public class C1113eo implements InAppPurchaseResult {

    /* renamed from: sL */
    private final C1104ek f3255sL;

    public C1113eo(C1104ek ekVar) {
        this.f3255sL = ekVar;
    }

    public void finishPurchase() {
        try {
            this.f3255sL.finishPurchase();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.f3255sL.getProductId();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.f3255sL.getPurchaseData();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.f3255sL.getResultCode();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.f3255sL.isVerified();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
