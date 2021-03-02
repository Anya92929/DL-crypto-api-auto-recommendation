package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzsb;

/* renamed from: com.google.android.gms.internal.qq */
final class C1857qq implements zzsb.zzb {
    C1857qq() {
    }

    public zzsb.zzb.C2113zzb zza(Context context, String str, zzsb.zzb.zza zza) {
        zzsb.zzb.C2113zzb zzb = new zzsb.zzb.C2113zzb();
        zzb.f6987KQ = zza.zzd(context, str, true);
        if (zzb.f6987KQ != 0) {
            zzb.f6988KR = 1;
        } else {
            zzb.f6986KP = zza.zzt(context, str);
            if (zzb.f6986KP != 0) {
                zzb.f6988KR = -1;
            }
        }
        return zzb;
    }
}
