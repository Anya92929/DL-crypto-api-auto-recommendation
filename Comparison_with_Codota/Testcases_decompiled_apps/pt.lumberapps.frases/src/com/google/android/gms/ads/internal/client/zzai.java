package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzin;

@zzin
public class zzai extends zzg {
    public zzai() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzaa zzc(IBinder iBinder) {
        return zzaa.zza.zzs(iBinder);
    }

    public zzz zzm(Context context) {
        try {
            return zzz.zza.zzr(((zzaa) mo6997a(context)).zza(zze.zzac(context), com.google.android.gms.common.internal.zze.f4556xM));
        } catch (RemoteException e) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
