package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzin
public final class zzkd extends zzb {
    /* renamed from: a */
    private static boolean m7302a() {
        return zzaz(2) && zzta();
    }

    /* renamed from: v */
    public static void m7303v(String str) {
        if (m7302a()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzta() {
        return ((Boolean) zzdc.zzbap.get()).booleanValue();
    }
}
