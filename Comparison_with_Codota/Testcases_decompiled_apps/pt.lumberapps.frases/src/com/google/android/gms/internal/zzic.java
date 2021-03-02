package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzju;

@zzin
public class zzic {

    public interface zza {
        void zzb(zzju zzju);
    }

    public zzkj zza(Context context, com.google.android.gms.ads.internal.zza zza2, zzju.zza zza3, zzas zzas, zzlh zzlh, zzgj zzgj, zza zza4, zzdk zzdk) {
        zzkj zzia;
        AdResponseParcel adResponseParcel = zza3.zzciq;
        if (adResponseParcel.zzcby) {
            zzia = new zzif(context, zza3, zzgj, zza4, zzdk, zzlh);
        } else if (!adResponseParcel.zzauu) {
            zzia = adResponseParcel.zzcce ? new zzia(context, zza3, zzlh, zza4) : (!((Boolean) zzdc.zzazs.get()).booleanValue() || !zzs.zzavu() || zzs.zzavw() || zzlh == null || !zzlh.zzdn().zzaus) ? new zzid(context, zza3, zzlh, zza4) : new zzie(context, zza3, zzlh, zza4);
        } else if (zza2 instanceof zzq) {
            zzia = new zzig(context, (zzq) zza2, zza3, zzas, zza4);
        } else {
            String valueOf = String.valueOf(zza2 != null ? zza2.getClass().getName() : "null");
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Invalid NativeAdManager type. Found: ").append(valueOf).append("; Required: NativeAdManager.").toString());
        }
        String valueOf2 = String.valueOf(zzia.getClass().getName());
        zzkd.zzcv(valueOf2.length() != 0 ? "AdRenderer: ".concat(valueOf2) : new String("AdRenderer: "));
        zzia.zzpy();
        return zzia;
    }

    public zzkj zza(Context context, zzju.zza zza2, zzjf zzjf) {
        zzjl zzjl = new zzjl(context, zza2, zzjf);
        String valueOf = String.valueOf(zzjl.getClass().getName());
        zzkd.zzcv(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzjl.zzpy();
        return zzjl;
    }
}
