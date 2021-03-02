package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkc;
import java.util.concurrent.Future;

@zzin
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza  reason: collision with other inner class name */
    public interface C2105zza {
        void zza(zzju.zza zza);
    }

    public zzkc zza(Context context, AdRequestInfoParcel.zza zza, zzas zzas, C2105zza zza2) {
        zzkc zzn = zza.zzcar.extras.getBundle("sdk_less_server_data") != null ? new zzn(context, zza, zza2) : new zzb(context, zza, zzas, zza2);
        Future future = (Future) zzn.zzpy();
        return zzn;
    }
}
