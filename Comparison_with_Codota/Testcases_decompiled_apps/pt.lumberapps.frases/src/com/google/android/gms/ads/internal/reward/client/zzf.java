package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.reward.client.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

@zzin
public class zzf extends zzg {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzc zzc(IBinder iBinder) {
        return zzc.zza.zzbg(iBinder);
    }

    public zzb zzb(Context context, zzgj zzgj) {
        try {
            return zzb.zza.zzbf(((zzc) mo6997a(context)).zza(zze.zzac(context), zzgj, com.google.android.gms.common.internal.zze.f4556xM));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }
}
