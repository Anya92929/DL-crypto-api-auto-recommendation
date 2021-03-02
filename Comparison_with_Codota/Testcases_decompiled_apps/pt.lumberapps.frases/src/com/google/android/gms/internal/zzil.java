package com.google.android.gms.internal;

import android.support.p009v4.p019f.C0150o;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.internal.zzii;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@zzin
public class zzil implements zzii.zza {

    /* renamed from: a */
    private final boolean f6427a;

    public zzil(boolean z) {
        this.f6427a = z;
    }

    /* renamed from: a */
    private C0150o m7203a(C0150o oVar) {
        C0150o oVar2 = new C0150o();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= oVar.size()) {
                return oVar2;
            }
            oVar2.put(oVar.mo1152b(i2), ((Future) oVar.mo1153c(i2)).get());
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private void m7204a(zzii zzii, JSONObject jSONObject, C0150o oVar) {
        oVar.put(jSONObject.getString("name"), zzii.zza(jSONObject, "image_value", this.f6427a));
    }

    /* renamed from: a */
    private void m7205a(JSONObject jSONObject, C0150o oVar) {
        oVar.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    /* renamed from: zzd */
    public zzf zza(zzii zzii, JSONObject jSONObject) {
        C0150o oVar = new C0150o();
        C0150o oVar2 = new C0150o();
        zzky zzg = zzii.zzg(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                m7205a(jSONObject2, oVar2);
            } else if ("image".equals(string)) {
                m7204a(zzii, jSONObject2, oVar);
            } else {
                String valueOf = String.valueOf(string);
                zzkd.zzcx(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        return new zzf(jSONObject.getString("custom_template_id"), m7203a(oVar), oVar2, (zza) zzg.get());
    }
}
