package com.google.android.gms.internal;

import com.google.android.gms.internal.zzih;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ki */
class C1687ki extends zzih.zza {

    /* renamed from: a */
    final /* synthetic */ C1694kp f5210a;

    /* renamed from: b */
    final /* synthetic */ zzkv f5211b;

    /* renamed from: c */
    final /* synthetic */ String f5212c;

    /* renamed from: d */
    final /* synthetic */ zzii f5213d;

    C1687ki(zzii zzii, C1694kp kpVar, zzkv zzkv, String str) {
        this.f5213d = zzii;
        this.f5210a = kpVar;
        this.f5211b = zzkv;
        this.f5212c = str;
    }

    public void zze(zzft zzft) {
        C1688kj kjVar = new C1688kj(this, zzft);
        this.f5210a.f5235a = kjVar;
        zzft.zza("/nativeAdPreProcess", (zzep) kjVar);
        try {
            JSONObject jSONObject = new JSONObject(this.f5213d.f6418h.zzciq.body);
            jSONObject.put("ads_id", this.f5212c);
            zzft.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        } catch (JSONException e) {
            zzkd.zzd("Exception occurred while invoking javascript", e);
            this.f5211b.zzh((Object) null);
        }
    }

    public void zzqq() {
        this.f5211b.zzh((Object) null);
    }
}
