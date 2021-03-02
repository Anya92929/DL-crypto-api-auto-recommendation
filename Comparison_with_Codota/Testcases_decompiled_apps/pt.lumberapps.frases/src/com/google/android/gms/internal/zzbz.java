package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzcb;

public final class zzbz extends zzg {

    /* renamed from: a */
    private static final zzbz f5994a = new zzbz();

    private zzbz() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    /* renamed from: a */
    private zzca m6920a(String str, Context context, boolean z) {
        IBinder zzb;
        zzd zzac = zze.zzac(context);
        if (z) {
            try {
                zzb = ((zzcb) mo6997a(context)).zza(str, zzac);
            } catch (RemoteException | zzg.zza e) {
                return null;
            }
        } else {
            zzb = ((zzcb) mo6997a(context)).zzb(str, zzac);
        }
        return zzca.zza.zzd(zzb);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = f5994a.m6920a(r1, r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzca zzb(java.lang.String r1, android.content.Context r2, boolean r3) {
        /*
            com.google.android.gms.common.zzc r0 = com.google.android.gms.common.zzc.zzang()
            int r0 = r0.isGooglePlayServicesAvailable(r2)
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.zzbz r0 = f5994a
            com.google.android.gms.internal.zzca r0 = r0.m6920a(r1, r2, r3)
            if (r0 != 0) goto L_0x0017
        L_0x0012:
            com.google.android.gms.internal.zzby r0 = new com.google.android.gms.internal.zzby
            r0.<init>(r1, r2, r3)
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbz.zzb(java.lang.String, android.content.Context, boolean):com.google.android.gms.internal.zzca");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzcb zzc(IBinder iBinder) {
        return zzcb.zza.zze(iBinder);
    }
}
