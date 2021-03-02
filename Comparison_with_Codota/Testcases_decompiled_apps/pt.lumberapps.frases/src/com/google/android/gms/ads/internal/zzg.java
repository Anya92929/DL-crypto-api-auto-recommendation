package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;

@zzin
public class zzg {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f4023a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f4024b;
    public final zzep zzaku = new C1274m(this);

    /* renamed from: a */
    private static boolean m5804a(zzjw zzjw) {
        if (zzjw == null) {
            return true;
        }
        return (((zzu.zzfu().currentTimeMillis() - zzjw.zzse()) > ((Long) zzdc.zzbcv.get()).longValue() ? 1 : ((zzu.zzfu().currentTimeMillis() - zzjw.zzse()) == ((Long) zzdc.zzbcv.get()).longValue() ? 0 : -1)) > 0) || !zzjw.zzsf();
    }

    public void zza(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzjw zzjw, String str, String str2) {
        if (m5804a(zzjw)) {
            if (context == null) {
                zzkd.zzcx("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                this.f4024b = context;
                zzkh.zzclc.post(new C1275n(this, zzu.zzfq().zzc(context, versionInfoParcel), str, str2, z, context));
            } else {
                zzkd.zzcx("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
