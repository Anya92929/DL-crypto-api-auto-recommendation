package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import com.google.android.gms.tagmanager.C2075cr;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.tagmanager.ba */
class C2019ba {
    /* renamed from: cD */
    public static C2075cr.C2079c m6803cD(String str) throws JSONException {
        C1026d.C1027a n = m6804n(new JSONObject(str));
        C2075cr.C2080d oV = C2075cr.C2079c.m6972oV();
        for (int i = 0; i < n.f3086gx.length; i++) {
            oV.mo11662a(C2075cr.C2077a.m6965oR().mo11655b(C0929b.INSTANCE_NAME.toString(), n.f3086gx[i]).mo11655b(C0929b.FUNCTION.toString(), C2114di.m7101cU(C2131m.m7175nO())).mo11655b(C2131m.m7176nP(), n.f3087gy[i]).mo11657oU());
        }
        return oV.mo11666oY();
    }

    /* renamed from: n */
    private static C1026d.C1027a m6804n(Object obj) throws JSONException {
        return C2114di.m7124u(m6805o(obj));
    }

    /* renamed from: o */
    static Object m6805o(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, m6805o(jSONObject.get(next)));
            }
            return hashMap;
        }
    }
}
