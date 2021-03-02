package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

@zzin
public final class zzd extends zzg {
    public zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzt zzc(IBinder iBinder) {
        return zzt.zza.zzm(iBinder);
    }

    public zzs zza(Context context, String str, zzgj zzgj) {
        try {
            return zzs.zza.zzl(((zzt) mo6997a(context)).zza(zze.zzac(context), str, zzgj, com.google.android.gms.common.internal.zze.f4556xM));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
        }
        return null;
    }
}
