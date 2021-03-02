package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zzbw {

    /* renamed from: a */
    private final zzca f5989a;

    public zzbw(String str, Context context, boolean z) {
        this.f5989a = zzbz.zzb(str, context, z);
    }

    public void zza(MotionEvent motionEvent) {
        this.f5989a.zzd(zze.zzac(motionEvent));
    }

    public Uri zzc(Uri uri, Context context) {
        zzd zza = this.f5989a.zza(zze.zzac(uri), zze.zzac(context));
        if (zza != null) {
            return (Uri) zze.zzad(zza);
        }
        throw new zzbx();
    }

    public Uri zzd(Uri uri, Context context) {
        zzd zzb = this.f5989a.zzb(zze.zzac(uri), zze.zzac(context));
        if (zzb != null) {
            return (Uri) zze.zzad(zzb);
        }
        throw new zzbx();
    }
}
