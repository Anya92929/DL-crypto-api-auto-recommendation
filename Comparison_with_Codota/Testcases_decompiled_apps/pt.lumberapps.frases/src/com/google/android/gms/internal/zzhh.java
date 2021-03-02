package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhi;
import com.google.android.gms.internal.zzhj;

@zzin
public final class zzhh extends zzg {
    public zzhh() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzhj zzc(IBinder iBinder) {
        return zzhj.zza.zzar(iBinder);
    }

    public zzhi zzf(Activity activity) {
        try {
            return zzhi.zza.zzaq(((zzhj) mo6997a(activity)).zzn(zze.zzac(activity)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
