package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzin
public class zzhv implements InAppPurchaseResult {

    /* renamed from: a */
    private final zzhr f6352a;

    public zzhv(zzhr zzhr) {
        this.f6352a = zzhr;
    }

    public void finishPurchase() {
        try {
            this.f6352a.finishPurchase();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.f6352a.getProductId();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.f6352a.getPurchaseData();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.f6352a.getResultCode();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.f6352a.isVerified();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
