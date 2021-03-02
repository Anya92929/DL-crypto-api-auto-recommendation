package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzih;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.formats.c */
class C1259c extends zzih.zza {

    /* renamed from: a */
    final /* synthetic */ JSONObject f3625a;

    /* renamed from: b */
    final /* synthetic */ zzi f3626b;

    C1259c(zzi zzi, JSONObject jSONObject) {
        this.f3626b = zzi;
        this.f3625a = jSONObject;
    }

    public void zze(zzft zzft) {
        zzft.zza("google.afma.nativeAds.handleImpressionPing", this.f3625a);
    }
}
