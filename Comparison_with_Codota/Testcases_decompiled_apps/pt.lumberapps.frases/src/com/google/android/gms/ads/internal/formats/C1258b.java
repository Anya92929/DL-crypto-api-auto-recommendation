package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzih;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.formats.b */
class C1258b extends zzih.zza {

    /* renamed from: a */
    final /* synthetic */ JSONObject f3623a;

    /* renamed from: b */
    final /* synthetic */ zzi f3624b;

    C1258b(zzi zzi, JSONObject jSONObject) {
        this.f3624b = zzi;
        this.f3623a = jSONObject;
    }

    public void zze(zzft zzft) {
        zzft.zza("google.afma.nativeAds.handleClickGmsg", this.f3623a);
    }
}
