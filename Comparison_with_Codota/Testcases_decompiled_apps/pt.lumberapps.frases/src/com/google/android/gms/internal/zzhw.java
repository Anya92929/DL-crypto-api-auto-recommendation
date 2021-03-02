package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzin
public class zzhw implements InAppPurchase {

    /* renamed from: a */
    private final zzhn f6353a;

    public zzhw(zzhn zzhn) {
        this.f6353a = zzhn;
    }

    public String getProductId() {
        try {
            return this.f6353a.getProductId();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.f6353a.recordPlayBillingResolution(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.f6353a.recordResolution(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
