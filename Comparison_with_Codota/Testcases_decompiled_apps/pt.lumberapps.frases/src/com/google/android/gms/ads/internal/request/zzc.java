package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.request.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzla;

@zzin
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    /* renamed from: a */
    private static zzkj m5741a(Context context, VersionInfoParcel versionInfoParcel, zzla zzla, zza zza2) {
        zzkd.zzcv("Fetching ad response from remote ad request service.");
        if (zzm.zziw().zzar(context)) {
            return new zzd.zzb(context, versionInfoParcel, zzla, zza2);
        }
        zzkd.zzcx("Failed to connect to remote ad request service.");
        return null;
    }

    /* renamed from: a */
    static zzkj m5742a(Context context, VersionInfoParcel versionInfoParcel, zzla zzla, zza zza2, C1305f fVar) {
        return fVar.mo5641a(versionInfoParcel) ? m5743a(context, zzla, zza2) : m5741a(context, versionInfoParcel, zzla, zza2);
    }

    /* renamed from: a */
    private static zzkj m5743a(Context context, zzla zzla, zza zza2) {
        zzkd.zzcv("Fetching ad response from local ad request service.");
        zzd.zza zza3 = new zzd.zza(context, zzla, zza2);
        Void voidR = (Void) zza3.zzpy();
        return zza3;
    }

    public static zzkj zza(Context context, VersionInfoParcel versionInfoParcel, zzla zzla, zza zza2) {
        return m5742a(context, versionInfoParcel, zzla, zza2, new C1304e(context));
    }
}
