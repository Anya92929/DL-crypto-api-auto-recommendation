package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.cr */
public final class C1011cr {
    /* renamed from: a */
    public static List<String> m4150a(JSONObject jSONObject, String str) throws JSONException {
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

    /* renamed from: a */
    public static void m4151a(Context context, String str, C1196fz fzVar, String str2, boolean z, List<String> list) {
        String str3 = z ? "1" : "0";
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", fzVar.f3681vq.f3039qi).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", C1201gb.f3708vK).replaceAll("@gw_seqnum@", fzVar.f3673tA);
            if (fzVar.f3670qy != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", fzVar.f3670qy.f3028pX).replaceAll("@gw_allocid@", fzVar.f3670qy.f3030pZ);
            }
            new C1227gq(context, str, replaceAll2).start();
        }
    }
}
