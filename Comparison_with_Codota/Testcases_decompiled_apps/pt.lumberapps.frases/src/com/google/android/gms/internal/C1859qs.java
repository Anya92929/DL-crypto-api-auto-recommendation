package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzsb;

/* renamed from: com.google.android.gms.internal.qs */
final class C1859qs implements zzsb.zzb {
    C1859qs() {
    }

    public zzsb.zzb.C2113zzb zza(Context context, String str, zzsb.zzb.zza zza) {
        zzsb.zzb.C2113zzb zzb = new zzsb.zzb.C2113zzb();
        zzb.f6986KP = zza.zzt(context, str);
        zzb.f6987KQ = zza.zzd(context, str, true);
        if (zzb.f6986KP == 0 && zzb.f6987KQ == 0) {
            zzb.f6988KR = 0;
        } else if (zzb.f6986KP >= zzb.f6987KQ) {
            zzb.f6988KR = -1;
        } else {
            zzb.f6988KR = 1;
        }
        return zzb;
    }
}
