package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@zzin
public class zzgf {
    public List zza(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzju zzju, String str2, boolean z, List list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String replaceAll = ((String) it.next()).replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", zzju.zzcig.zzbnr).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzu.zzft().getSessionId()).replaceAll("@gw_seqnum@", zzju.zzcau).replaceAll("@gw_adnetstatus@", zzju.zzcih);
                if (zzju.zzbon != null) {
                    replaceAll = replaceAll.replaceAll("@gw_adnetid@", zzju.zzbon.zzbmv).replaceAll("@gw_allocid@", zzju.zzbon.zzbmx);
                }
                Future future = (Future) new zzkq(context, str, replaceAll).zzpy();
            }
        }
    }
}
