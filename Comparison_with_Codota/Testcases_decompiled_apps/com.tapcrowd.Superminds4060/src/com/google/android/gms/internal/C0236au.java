package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.au */
public final class C0236au {
    /* renamed from: a */
    public static List<String> m520a(JSONObject jSONObject, String str) throws JSONException {
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
    public static void m521a(Context context, String str, C0330ce ceVar, String str2, boolean z, List<String> list) {
        String str3 = z ? "1" : "0";
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", ceVar.f995hA.f590eZ).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", C0331cf.f997hB).replaceAll("@gw_seqnum@", ceVar.f990gE);
            if (ceVar.f985fm != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", ceVar.f985fm.f580eP).replaceAll("@gw_allocid@", ceVar.f985fm.f582eR);
            }
            new C0342cl(context, str, replaceAll2).start();
        }
    }
}
