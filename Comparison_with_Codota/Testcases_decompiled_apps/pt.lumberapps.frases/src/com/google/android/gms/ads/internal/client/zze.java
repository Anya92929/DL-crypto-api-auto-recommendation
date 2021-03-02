package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

@zzin
public class zze extends zzg {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzv zzc(IBinder iBinder) {
        return zzv.zza.zzo(iBinder);
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        try {
            return zzu.zza.zzn(((zzv) mo6997a(context)).zza(com.google.android.gms.dynamic.zze.zzac(context), adSizeParcel, str, zzgj, com.google.android.gms.common.internal.zze.f4556xM, i));
        } catch (RemoteException | zzg.zza e) {
            zzb.zza("Could not create remote AdManager.", e);
            return null;
        }
    }
}
