package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.fs */
public final class C1187fs {

    /* renamed from: up */
    private static final SimpleDateFormat f3607up = new SimpleDateFormat("yyyyMMdd");

    /* renamed from: a */
    public static C1171fk m4498a(Context context, C1168fi fiVar, String str) {
        C1171fk fkVar;
        List<String> list;
        List<String> list2;
        List<String> list3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", (String) null);
            String optString2 = jSONObject.optString("ad_url", (String) null);
            String optString3 = jSONObject.optString("ad_size", (String) null);
            String optString4 = jSONObject.optString("ad_html", (String) null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", (String) null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", (String) null);
            int i = -1;
            if ("portrait".equals(optString6)) {
                i = C1213gj.m4634dn();
            } else if ("landscape".equals(optString6)) {
                i = C1213gj.m4633dm();
            }
            if (!TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString)) {
                    C1229gs.m4679W("Could not parse the mediation config: Missing required ad_base_url field");
                    return new C1171fk(0);
                }
                fkVar = null;
            } else if (!TextUtils.isEmpty(optString2)) {
                C1171fk a = C1184fr.m4493a(context, fiVar.f3529lD.f3777wD, optString2, (String) null, (C1192fv) null);
                optString = a.f3558rP;
                optString4 = a.f3560tG;
                j = a.f3566tM;
                fkVar = a;
            } else {
                C1229gs.m4679W("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                return new C1171fk(0);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List<String> list4 = fkVar == null ? null : fkVar.f3555qf;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList<>();
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    list4.add(optJSONArray.getString(i2));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            List<String> list5 = fkVar == null ? null : fkVar.f3556qg;
            if (optJSONArray2 != null) {
                if (list5 == null) {
                    list5 = new LinkedList<>();
                }
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    list5.add(optJSONArray2.getString(i3));
                }
                list2 = list5;
            } else {
                list2 = list5;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            List<String> list6 = fkVar == null ? null : fkVar.f3564tK;
            if (optJSONArray3 != null) {
                if (list6 == null) {
                    list6 = new LinkedList<>();
                }
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    list6.add(optJSONArray3.getString(i4));
                }
                list3 = list6;
            } else {
                list3 = list6;
            }
            if (fkVar != null) {
                if (fkVar.orientation != -1) {
                    i = fkVar.orientation;
                }
                if (fkVar.f3561tH > 0) {
                    j2 = fkVar.f3561tH;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", (String) null);
            }
            return new C1171fk(optString, optString4, list, list2, j2, false, -1, list3, -1, i, optString3, j, optString5, optBoolean, str2, optString7, false, false, fiVar.f3537tF, false);
        } catch (JSONException e) {
            C1229gs.m4679W("Could not parse the mediation config: " + e.getMessage());
            return new C1171fk(0);
        }
    }

    /* renamed from: a */
    public static String m4499a(C1168fi fiVar, C1193fw fwVar, Location location, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            if (arrayList.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", arrayList));
            }
            if (fiVar.f3538tw != null) {
                hashMap.put("ad_pos", fiVar.f3538tw);
            }
            m4501a((HashMap<String, Object>) hashMap, fiVar.f3539tx);
            hashMap.put("format", fiVar.f3530lH.f2622of);
            if (fiVar.f3530lH.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (fiVar.f3530lH.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (fiVar.f3530lH.f2624oh != null) {
                StringBuilder sb = new StringBuilder();
                for (C0927ay ayVar : fiVar.f3530lH.f2624oh) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / fwVar.f3658vi) : ayVar.width);
                    sb.append("x");
                    sb.append(ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / fwVar.f3658vi) : ayVar.height);
                }
                hashMap.put("sz", sb);
            }
            if (fiVar.f3535tD != 0) {
                hashMap.put("native_version", Integer.valueOf(fiVar.f3535tD));
                hashMap.put("native_templates", fiVar.f3531lS);
            }
            hashMap.put("slotname", fiVar.f3528lA);
            hashMap.put("pn", fiVar.applicationInfo.packageName);
            if (fiVar.f3540ty != null) {
                hashMap.put("vc", Integer.valueOf(fiVar.f3540ty.versionCode));
            }
            hashMap.put("ms", fiVar.f3541tz);
            hashMap.put("seq_num", fiVar.f3532tA);
            hashMap.put("session_id", fiVar.f3533tB);
            hashMap.put("js", fiVar.f3529lD.f3777wD);
            m4503a((HashMap<String, Object>) hashMap, fwVar);
            if (fiVar.f3539tx.versionCode >= 2 && fiVar.f3539tx.f2618ob != null) {
                m4500a((HashMap<String, Object>) hashMap, fiVar.f3539tx.f2618ob);
            }
            if (fiVar.versionCode >= 2) {
                hashMap.put("quality_signals", fiVar.f3534tC);
            }
            if (fiVar.versionCode >= 4 && fiVar.f3537tF) {
                hashMap.put("forceHttps", Boolean.valueOf(fiVar.f3537tF));
            }
            if (fiVar.versionCode >= 3 && fiVar.f3536tE != null) {
                hashMap.put("content_info", fiVar.f3536tE);
            }
            if (C1229gs.m4684u(2)) {
                C1229gs.m4678V("Ad Request JSON: " + C1213gj.m4642t((Map<String, ?>) hashMap).toString(2));
            }
            return C1213gj.m4642t((Map<String, ?>) hashMap).toString();
        } catch (JSONException e) {
            C1229gs.m4679W("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static void m4500a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    /* renamed from: a */
    private static void m4501a(HashMap<String, Object> hashMap, C0924av avVar) {
        String dj = C1205gf.m4600dj();
        if (dj != null) {
            hashMap.put("abf", dj);
        }
        if (avVar.f2610nT != -1) {
            hashMap.put("cust_age", f3607up.format(new Date(avVar.f2610nT)));
        }
        if (avVar.extras != null) {
            hashMap.put("extras", avVar.extras);
        }
        if (avVar.f2611nU != -1) {
            hashMap.put("cust_gender", Integer.valueOf(avVar.f2611nU));
        }
        if (avVar.f2612nV != null) {
            hashMap.put("kw", avVar.f2612nV);
        }
        if (avVar.f2614nX != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(avVar.f2614nX));
        }
        if (avVar.f2613nW) {
            hashMap.put("adtest", "on");
        }
        if (avVar.versionCode >= 2) {
            if (avVar.f2615nY) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(avVar.f2616nZ)) {
                hashMap.put("ppid", avVar.f2616nZ);
            }
            if (avVar.f2617oa != null) {
                m4502a(hashMap, avVar.f2617oa);
            }
        }
        if (avVar.versionCode >= 3 && avVar.f2619oc != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, avVar.f2619oc);
        }
    }

    /* renamed from: a */
    private static void m4502a(HashMap<String, Object> hashMap, C0948bj bjVar) {
        String str;
        String str2 = null;
        if (Color.alpha(bjVar.f2890oH) != 0) {
            hashMap.put("acolor", m4505t(bjVar.f2890oH));
        }
        if (Color.alpha(bjVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", m4505t(bjVar.backgroundColor));
        }
        if (!(Color.alpha(bjVar.f2891oI) == 0 || Color.alpha(bjVar.f2892oJ) == 0)) {
            hashMap.put("gradientto", m4505t(bjVar.f2891oI));
            hashMap.put("gradientfrom", m4505t(bjVar.f2892oJ));
        }
        if (Color.alpha(bjVar.f2893oK) != 0) {
            hashMap.put("bcolor", m4505t(bjVar.f2893oK));
        }
        hashMap.put("bthick", Integer.toString(bjVar.f2894oL));
        switch (bjVar.f2895oM) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (bjVar.f2896oN) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (bjVar.f2897oO != null) {
            hashMap.put("channel", bjVar.f2897oO);
        }
        if (Color.alpha(bjVar.f2898oP) != 0) {
            hashMap.put("dcolor", m4505t(bjVar.f2898oP));
        }
        if (bjVar.f2899oQ != null) {
            hashMap.put("font", bjVar.f2899oQ);
        }
        if (Color.alpha(bjVar.f2900oR) != 0) {
            hashMap.put("hcolor", m4505t(bjVar.f2900oR));
        }
        hashMap.put("headersize", Integer.toString(bjVar.f2901oS));
        if (bjVar.f2902oT != null) {
            hashMap.put("q", bjVar.f2902oT);
        }
    }

    /* renamed from: a */
    private static void m4503a(HashMap<String, Object> hashMap, C1193fw fwVar) {
        hashMap.put("am", Integer.valueOf(fwVar.f3642uS));
        hashMap.put("cog", m4504s(fwVar.f3643uT));
        hashMap.put("coh", m4504s(fwVar.f3644uU));
        if (!TextUtils.isEmpty(fwVar.f3645uV)) {
            hashMap.put("carrier", fwVar.f3645uV);
        }
        hashMap.put("gl", fwVar.f3646uW);
        if (fwVar.f3647uX) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", m4504s(fwVar.f3648uY));
        hashMap.put("sp", m4504s(fwVar.f3649uZ));
        hashMap.put("hl", fwVar.f3650va);
        if (!TextUtils.isEmpty(fwVar.f3651vb)) {
            hashMap.put("mv", fwVar.f3651vb);
        }
        hashMap.put("muv", Integer.valueOf(fwVar.f3652vc));
        if (fwVar.f3653vd != -2) {
            hashMap.put("cnt", Integer.valueOf(fwVar.f3653vd));
        }
        hashMap.put("gnt", Integer.valueOf(fwVar.f3654ve));
        hashMap.put("pt", Integer.valueOf(fwVar.f3655vf));
        hashMap.put("rm", Integer.valueOf(fwVar.f3656vg));
        hashMap.put("riv", Integer.valueOf(fwVar.f3657vh));
        hashMap.put("u_sd", Float.valueOf(fwVar.f3658vi));
        hashMap.put("sh", Integer.valueOf(fwVar.f3660vk));
        hashMap.put("sw", Integer.valueOf(fwVar.f3659vj));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", fwVar.f3664vo);
        bundle.putBoolean("active_network_metered", fwVar.f3663vn);
        hashMap.put("connectivity", bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", fwVar.f3662vm);
        bundle2.putDouble("battery_level", fwVar.f3661vl);
        hashMap.put("battery", bundle2);
    }

    /* renamed from: s */
    private static Integer m4504s(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    /* renamed from: t */
    private static String m4505t(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
