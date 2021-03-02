package com.google.android.gms.internal;

import android.location.Location;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.cordova.Globalization;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.ca */
public final class C0324ca {

    /* renamed from: gS */
    private static final SimpleDateFormat f943gS = new SimpleDateFormat("yyyyMMdd");

    /* renamed from: a */
    public static String m658a(C0313bu buVar, C0329cd cdVar, Location location) {
        try {
            HashMap hashMap = new HashMap();
            if (buVar.f913gA != null) {
                hashMap.put("ad_pos", buVar.f913gA);
            }
            m661a((HashMap<String, Object>) hashMap, buVar.f914gB);
            hashMap.put("format", buVar.f911ed.f1581ew);
            if (buVar.f911ed.width == -1) {
                hashMap.put("smart_w", Globalization.FULL);
            }
            if (buVar.f911ed.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            hashMap.put("slotname", buVar.adUnitId);
            hashMap.put("pn", buVar.applicationInfo.packageName);
            if (buVar.f915gC != null) {
                hashMap.put("vc", Integer.valueOf(buVar.f915gC.versionCode));
            }
            hashMap.put("ms", buVar.f916gD);
            hashMap.put("seq_num", buVar.f917gE);
            hashMap.put("session_id", buVar.f918gF);
            hashMap.put("js", buVar.f912eg.f1014hP);
            m660a((HashMap<String, Object>) hashMap, cdVar);
            m659a((HashMap<String, Object>) hashMap, location);
            if (C0344cn.m732k(2)) {
                C0344cn.m736p("Ad Request JSON: " + C0337ci.m712l(hashMap).toString(2));
            }
            return C0337ci.m712l(hashMap).toString();
        } catch (JSONException e) {
            C0344cn.m737q("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static void m659a(HashMap<String, Object> hashMap, Location location) {
        if (location != null) {
            HashMap hashMap2 = new HashMap();
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            hashMap2.put("radius", valueOf);
            hashMap2.put("lat", valueOf3);
            hashMap2.put(Globalization.LONG, valueOf4);
            hashMap2.put(Globalization.TIME, valueOf2);
            hashMap.put("loc", hashMap2);
        }
    }

    /* renamed from: a */
    private static void m660a(HashMap<String, Object> hashMap, C0329cd cdVar) {
        hashMap.put("am", Integer.valueOf(cdVar.f962hh));
        hashMap.put("cog", m662g(cdVar.f963hi));
        hashMap.put("coh", m662g(cdVar.f964hj));
        if (!TextUtils.isEmpty(cdVar.f965hk)) {
            hashMap.put("carrier", cdVar.f965hk);
        }
        hashMap.put("gl", cdVar.f966hl);
        if (cdVar.f967hm) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", m662g(cdVar.f968hn));
        hashMap.put("sp", m662g(cdVar.f969ho));
        hashMap.put("hl", cdVar.f970hp);
        if (!TextUtils.isEmpty(cdVar.f971hq)) {
            hashMap.put("mv", cdVar.f971hq);
        }
        hashMap.put("muv", Integer.valueOf(cdVar.f972hr));
        if (cdVar.f973hs != -2) {
            hashMap.put("cnt", Integer.valueOf(cdVar.f973hs));
        }
        hashMap.put("gnt", Integer.valueOf(cdVar.f974ht));
        hashMap.put("pt", Integer.valueOf(cdVar.f975hu));
        hashMap.put("rm", Integer.valueOf(cdVar.f976hv));
        hashMap.put("riv", Integer.valueOf(cdVar.f977hw));
        hashMap.put("u_sd", Float.valueOf(cdVar.f978hx));
        hashMap.put("sh", Integer.valueOf(cdVar.f980hz));
        hashMap.put("sw", Integer.valueOf(cdVar.f979hy));
    }

    /* renamed from: a */
    private static void m661a(HashMap<String, Object> hashMap, C0620v vVar) {
        if (vVar.f1577es != -1) {
            hashMap.put("cust_age", f943gS.format(new Date(vVar.f1577es)));
        }
        if (vVar.extras != null) {
            hashMap.put("extras", vVar.extras);
        }
        if (vVar.f1578et != -1) {
            hashMap.put("cust_gender", Integer.valueOf(vVar.f1578et));
        }
        if (vVar.f1579eu != null) {
            hashMap.put("kw", vVar.f1579eu);
        }
        if (vVar.tagForChildDirectedTreatment != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(vVar.tagForChildDirectedTreatment));
        }
        if (vVar.f1580ev) {
            hashMap.put("adtest", "on");
        }
    }

    /* renamed from: g */
    private static Integer m662g(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
