package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;

@zzin
public final class zzhu extends zzg {
    public zzhu() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzhq zzc(IBinder iBinder) {
        return zzhq.zza.zzaw(iBinder);
    }

    public zzhp zzg(Activity activity) {
        try {
            return zzhp.zza.zzav(((zzhq) mo6997a(activity)).zzo(zze.zzac(activity)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }
}
