package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzii;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzin
public class zzij implements zzii.zza {

    /* renamed from: a */
    private final boolean f6423a;

    /* renamed from: b */
    private final boolean f6424b;

    public zzij(boolean z, boolean z2) {
        this.f6423a = z;
        this.f6424b = z2;
    }

    /* renamed from: zzb */
    public zzd zza(zzii zzii, JSONObject jSONObject) {
        List<zzky> zza = zzii.zza(jSONObject, "images", true, this.f6423a, this.f6424b);
        zzky zza2 = zzii.zza(jSONObject, "app_icon", true, this.f6423a);
        zzky zzg = zzii.zzg(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (zzky zzky : zza) {
            arrayList.add((zzc) zzky.get());
        }
        return new zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzdr) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (zza) zzg.get(), new Bundle());
    }
}
