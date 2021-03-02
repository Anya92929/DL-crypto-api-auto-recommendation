package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzii;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzin
public class zzik implements zzii.zza {

    /* renamed from: a */
    private final boolean f6425a;

    /* renamed from: b */
    private final boolean f6426b;

    public zzik(boolean z, boolean z2) {
        this.f6425a = z;
        this.f6426b = z2;
    }

    /* renamed from: zzc */
    public zze zza(zzii zzii, JSONObject jSONObject) {
        List<zzky> zza = zzii.zza(jSONObject, "images", true, this.f6425a, this.f6426b);
        zzky zza2 = zzii.zza(jSONObject, "secondary_image", false, this.f6425a);
        zzky zzg = zzii.zzg(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (zzky zzky : zza) {
            arrayList.add((zzc) zzky.get());
        }
        return new zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzdr) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (zza) zzg.get(), new Bundle());
    }
}
