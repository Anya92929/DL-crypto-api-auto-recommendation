package com.google.android.gms.ads.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzla;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.o */
class C1276o implements zzla.zzc {

    /* renamed from: a */
    final /* synthetic */ C1275n f3730a;

    C1276o(C1275n nVar) {
        this.f3730a = nVar;
    }

    /* renamed from: a */
    public void zzd(zzft zzft) {
        zzft.zza("/appSettingsFetched", this.f3730a.f3729f.zzaku);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f3730a.f3725b)) {
                jSONObject.put("app_id", this.f3730a.f3725b);
            } else if (!TextUtils.isEmpty(this.f3730a.f3726c)) {
                jSONObject.put("ad_unit_id", this.f3730a.f3726c);
            }
            jSONObject.put("is_init", this.f3730a.f3727d);
            jSONObject.put("pn", this.f3730a.f3728e.getPackageName());
            zzft.zza("AFMA_fetchAppSettings", jSONObject);
        } catch (Exception e) {
            zzft.zzb("/appSettingsFetched", this.f3730a.f3729f.zzaku);
            zzkd.zzb("Error requesting application settings", e);
        }
    }
}
