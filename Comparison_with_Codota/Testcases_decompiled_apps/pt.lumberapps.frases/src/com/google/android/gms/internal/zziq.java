package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zziz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public final class zziq {

    /* renamed from: a */
    private static final SimpleDateFormat f6438a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* renamed from: a */
    private static Bundle m7215a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    /* renamed from: a */
    private static Integer m7216a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    /* renamed from: a */
    private static String m7217a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    /* renamed from: a */
    private static String m7218a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzbgq : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    /* renamed from: a */
    private static List m7219a(JSONArray jSONArray, List list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    /* renamed from: a */
    static JSONArray m7220a(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static void m7221a(HashMap hashMap, Location location) {
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
    private static void m7222a(HashMap hashMap, AdRequestParcel adRequestParcel) {
        String zzsy = zzkb.zzsy();
        if (zzsy != null) {
            hashMap.put("abf", zzsy);
        }
        if (adRequestParcel.zzatm != -1) {
            hashMap.put("cust_age", f6438a.format(new Date(adRequestParcel.zzatm)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzatn != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zzatn));
        }
        if (adRequestParcel.zzato != null) {
            hashMap.put("kw", adRequestParcel.zzato);
        }
        if (adRequestParcel.zzatq != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzatq));
        }
        if (adRequestParcel.zzatp) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzatr) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzats)) {
                hashMap.put("ppid", adRequestParcel.zzats);
            }
            if (adRequestParcel.zzatt != null) {
                m7223a(hashMap, adRequestParcel.zzatt);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzatv != null) {
            hashMap.put("url", adRequestParcel.zzatv);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzatx != null) {
                hashMap.put("custom_targeting", adRequestParcel.zzatx);
            }
            if (adRequestParcel.zzaty != null) {
                hashMap.put("category_exclusions", adRequestParcel.zzaty);
            }
            if (adRequestParcel.zzatz != null) {
                hashMap.put("request_agent", adRequestParcel.zzatz);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zzaua != null) {
            hashMap.put("request_pkg", adRequestParcel.zzaua);
        }
        if (adRequestParcel.versionCode >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zzaub));
        }
    }

    /* renamed from: a */
    private static void m7223a(HashMap hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzawz) != 0) {
            hashMap.put("acolor", m7217a(searchAdRequestParcel.zzawz));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", m7217a(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzaxa) == 0 || Color.alpha(searchAdRequestParcel.zzaxb) == 0)) {
            hashMap.put("gradientto", m7217a(searchAdRequestParcel.zzaxa));
            hashMap.put("gradientfrom", m7217a(searchAdRequestParcel.zzaxb));
        }
        if (Color.alpha(searchAdRequestParcel.zzaxc) != 0) {
            hashMap.put("bcolor", m7217a(searchAdRequestParcel.zzaxc));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zzaxd));
        switch (searchAdRequestParcel.zzaxe) {
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
        switch (searchAdRequestParcel.zzaxf) {
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
        if (searchAdRequestParcel.zzaxg != null) {
            hashMap.put("channel", searchAdRequestParcel.zzaxg);
        }
        if (Color.alpha(searchAdRequestParcel.zzaxh) != 0) {
            hashMap.put("dcolor", m7217a(searchAdRequestParcel.zzaxh));
        }
        if (searchAdRequestParcel.zzaxi != null) {
            hashMap.put("font", searchAdRequestParcel.zzaxi);
        }
        if (Color.alpha(searchAdRequestParcel.zzaxj) != 0) {
            hashMap.put("hcolor", m7217a(searchAdRequestParcel.zzaxj));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzaxk));
        if (searchAdRequestParcel.zzaxl != null) {
            hashMap.put("q", searchAdRequestParcel.zzaxl);
        }
    }

    /* renamed from: a */
    private static void m7224a(HashMap hashMap, zziv zziv, zziz.zza zza, Bundle bundle) {
        hashMap.put("am", Integer.valueOf(zziv.zzcgd));
        hashMap.put("cog", m7216a(zziv.zzcge));
        hashMap.put("coh", m7216a(zziv.zzcgf));
        if (!TextUtils.isEmpty(zziv.zzcgg)) {
            hashMap.put("carrier", zziv.zzcgg);
        }
        hashMap.put("gl", zziv.zzcgh);
        if (zziv.zzcgi) {
            hashMap.put("simulator", 1);
        }
        if (zziv.zzcgj) {
            hashMap.put("is_sidewinder", 1);
        }
        hashMap.put("ma", m7216a(zziv.zzcgk));
        hashMap.put("sp", m7216a(zziv.zzcgl));
        hashMap.put("hl", zziv.zzcgm);
        if (!TextUtils.isEmpty(zziv.zzcgn)) {
            hashMap.put("mv", zziv.zzcgn);
        }
        hashMap.put("muv", Integer.valueOf(zziv.zzcgo));
        if (zziv.zzcgp != -2) {
            hashMap.put("cnt", Integer.valueOf(zziv.zzcgp));
        }
        hashMap.put("gnt", Integer.valueOf(zziv.zzcgq));
        hashMap.put("pt", Integer.valueOf(zziv.zzcgr));
        hashMap.put("rm", Integer.valueOf(zziv.zzcgs));
        hashMap.put("riv", Integer.valueOf(zziv.zzcgt));
        Bundle bundle2 = new Bundle();
        bundle2.putString("build", zziv.zzcgy);
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("is_charging", zziv.zzcgv);
        bundle3.putDouble("battery_level", zziv.zzcgu);
        bundle2.putBundle("battery", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putInt("active_network_state", zziv.zzcgx);
        bundle4.putBoolean("active_network_metered", zziv.zzcgw);
        if (zza != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("predicted_latency_micros", 0);
            bundle5.putLong("predicted_down_throughput_bps", 0);
            bundle5.putLong("predicted_up_throughput_bps", 0);
            bundle4.putBundle("predictions", bundle5);
        }
        bundle2.putBundle("network", bundle4);
        Bundle bundle6 = new Bundle();
        bundle6.putBoolean("is_browser_custom_tabs_capable", zziv.zzcgz);
        bundle2.putBundle("browser", bundle6);
        if (bundle != null) {
            bundle2.putBundle("android_mem_info", m7215a(bundle));
        }
        hashMap.put("device", bundle2);
    }

    /* renamed from: a */
    private static void m7225a(HashMap hashMap, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", str);
        hashMap.put("pii", bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x013b A[Catch:{ JSONException -> 0x0220 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r45, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r46, java.lang.String r47) {
        /*
            org.json.JSONObject r28 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0220 }
            r0 = r28
            r1 = r47
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "ad_base_url"
            r5 = 0
            r0 = r28
            java.lang.String r6 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "ad_url"
            r5 = 0
            r0 = r28
            java.lang.String r7 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "ad_size"
            r5 = 0
            r0 = r28
            java.lang.String r19 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "ad_slot_size"
            r0 = r28
            r1 = r19
            java.lang.String r44 = r0.optString(r4, r1)     // Catch:{ JSONException -> 0x0220 }
            if (r46 == 0) goto L_0x00c6
            r0 = r46
            int r4 = r0.zzcax     // Catch:{ JSONException -> 0x0220 }
            if (r4 == 0) goto L_0x00c6
            r27 = 1
        L_0x0038:
            java.lang.String r4 = "ad_json"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            if (r5 != 0) goto L_0x004c
            java.lang.String r4 = "ad_html"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
        L_0x004c:
            if (r5 != 0) goto L_0x0057
            java.lang.String r4 = "body"
            r5 = 0
            r0 = r28
            java.lang.String r5 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
        L_0x0057:
            r20 = -1
            java.lang.String r4 = "debug_dialog"
            r8 = 0
            r0 = r28
            java.lang.String r22 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x0220 }
            if (r4 == 0) goto L_0x00ca
            java.lang.String r4 = "interstitial_timeout"
            r0 = r28
            double r8 = r0.getDouble(r4)     // Catch:{ JSONException -> 0x0220 }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r12 = (long) r8     // Catch:{ JSONException -> 0x0220 }
        L_0x007b:
            java.lang.String r4 = "orientation"
            r8 = 0
            r0 = r28
            java.lang.String r4 = r0.optString(r4, r8)     // Catch:{ JSONException -> 0x0220 }
            r18 = -1
            java.lang.String r8 = "portrait"
            boolean r8 = r8.equals(r4)     // Catch:{ JSONException -> 0x0220 }
            if (r8 == 0) goto L_0x00cd
            com.google.android.gms.internal.zzki r4 = com.google.android.gms.ads.internal.zzu.zzfs()     // Catch:{ JSONException -> 0x0220 }
            int r18 = r4.zztk()     // Catch:{ JSONException -> 0x0220 }
        L_0x0096:
            r4 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0220 }
            if (r8 == 0) goto L_0x0255
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0220 }
            if (r8 != 0) goto L_0x0255
            r0 = r46
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r0.zzaow     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r6 = r4.zzcs     // Catch:{ JSONException -> 0x0220 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r46
            r5 = r45
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = com.google.android.gms.internal.zzip.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r6 = r4.zzbto     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r7 = r4.body     // Catch:{ JSONException -> 0x0220 }
            long r0 = r4.zzccc     // Catch:{ JSONException -> 0x0220 }
            r20 = r0
        L_0x00bd:
            if (r7 != 0) goto L_0x00de
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x0220 }
            r5 = 0
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0220 }
        L_0x00c5:
            return r4
        L_0x00c6:
            r27 = 0
            goto L_0x0038
        L_0x00ca:
            r12 = -1
            goto L_0x007b
        L_0x00cd:
            java.lang.String r8 = "landscape"
            boolean r4 = r8.equals(r4)     // Catch:{ JSONException -> 0x0220 }
            if (r4 == 0) goto L_0x0096
            com.google.android.gms.internal.zzki r4 = com.google.android.gms.ads.internal.zzu.zzfs()     // Catch:{ JSONException -> 0x0220 }
            int r18 = r4.zztj()     // Catch:{ JSONException -> 0x0220 }
            goto L_0x0096
        L_0x00de:
            java.lang.String r5 = "click_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0220 }
            if (r4 != 0) goto L_0x0240
            r8 = 0
        L_0x00e9:
            if (r5 == 0) goto L_0x00ef
            java.util.List r8 = m7219a((org.json.JSONArray) r5, (java.util.List) r8)     // Catch:{ JSONException -> 0x0220 }
        L_0x00ef:
            java.lang.String r5 = "impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0220 }
            if (r4 != 0) goto L_0x0244
            r9 = 0
        L_0x00fa:
            if (r5 == 0) goto L_0x0100
            java.util.List r9 = m7219a((org.json.JSONArray) r5, (java.util.List) r9)     // Catch:{ JSONException -> 0x0220 }
        L_0x0100:
            java.lang.String r5 = "manual_impression_urls"
            r0 = r28
            org.json.JSONArray r5 = r0.optJSONArray(r5)     // Catch:{ JSONException -> 0x0220 }
            if (r4 != 0) goto L_0x0248
            r15 = 0
        L_0x010b:
            if (r5 == 0) goto L_0x0111
            java.util.List r15 = m7219a((org.json.JSONArray) r5, (java.util.List) r15)     // Catch:{ JSONException -> 0x0220 }
        L_0x0111:
            if (r4 == 0) goto L_0x0252
            int r5 = r4.orientation     // Catch:{ JSONException -> 0x0220 }
            r10 = -1
            if (r5 == r10) goto L_0x011c
            int r0 = r4.orientation     // Catch:{ JSONException -> 0x0220 }
            r18 = r0
        L_0x011c:
            long r10 = r4.zzcbx     // Catch:{ JSONException -> 0x0220 }
            r16 = 0
            int r5 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x0252
            long r10 = r4.zzcbx     // Catch:{ JSONException -> 0x0220 }
        L_0x0126:
            java.lang.String r4 = "active_view"
            r0 = r28
            java.lang.String r25 = r0.optString(r4)     // Catch:{ JSONException -> 0x0220 }
            r24 = 0
            java.lang.String r4 = "ad_is_javascript"
            r5 = 0
            r0 = r28
            boolean r23 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            if (r23 == 0) goto L_0x0144
            java.lang.String r4 = "ad_passback_url"
            r5 = 0
            r0 = r28
            java.lang.String r24 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
        L_0x0144:
            java.lang.String r4 = "mediation"
            r5 = 0
            r0 = r28
            boolean r12 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "custom_render_allowed"
            r5 = 0
            r0 = r28
            boolean r26 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "content_url_opted_out"
            r5 = 1
            r0 = r28
            boolean r29 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "prefetch"
            r5 = 0
            r0 = r28
            boolean r30 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "refresh_interval_milliseconds"
            r16 = -1
            r0 = r28
            r1 = r16
            long r16 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "mediation_config_cache_time_milliseconds"
            r32 = -1
            r0 = r28
            r1 = r32
            long r13 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "gws_query_id"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r31 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "height"
            java.lang.String r5 = "fluid"
            java.lang.String r32 = ""
            r0 = r28
            r1 = r32
            java.lang.String r5 = r0.optString(r5, r1)     // Catch:{ JSONException -> 0x0220 }
            boolean r32 = r4.equals(r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "native_express"
            r5 = 0
            r0 = r28
            boolean r33 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "video_start_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0220 }
            r5 = 0
            java.util.List r35 = m7219a((org.json.JSONArray) r4, (java.util.List) r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "video_complete_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0220 }
            r5 = 0
            java.util.List r36 = m7219a((org.json.JSONArray) r4, (java.util.List) r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "rewards"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0220 }
            com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel r34 = com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel.zza(r4)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "use_displayed_impression"
            r5 = 0
            r0 = r28
            boolean r37 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "auto_protection_configuration"
            r0 = r28
            org.json.JSONObject r4 = r0.optJSONObject(r4)     // Catch:{ JSONException -> 0x0220 }
            com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel r38 = com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel.zzh(r4)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "set_cookie"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r40 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "remote_ping_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x0220 }
            r5 = 0
            java.util.List r41 = m7219a((org.json.JSONArray) r4, (java.util.List) r5)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "safe_browsing"
            r0 = r28
            java.lang.String r42 = r0.optString(r4)     // Catch:{ JSONException -> 0x0220 }
            java.lang.String r4 = "render_in_browser"
            r0 = r46
            boolean r5 = r0.zzbnq     // Catch:{ JSONException -> 0x0220 }
            r0 = r28
            boolean r43 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x0220 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x0220 }
            r0 = r46
            boolean r0 = r0.zzcaz     // Catch:{ JSONException -> 0x0220 }
            r28 = r0
            r0 = r46
            boolean r0 = r0.zzcbq     // Catch:{ JSONException -> 0x0220 }
            r39 = r0
            r5 = r46
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)     // Catch:{ JSONException -> 0x0220 }
            goto L_0x00c5
        L_0x0220:
            r4 = move-exception
            java.lang.String r5 = "Could not parse the inline ad response: "
            java.lang.String r4 = r4.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r6 = r4.length()
            if (r6 == 0) goto L_0x024c
            java.lang.String r4 = r5.concat(r4)
        L_0x0235:
            com.google.android.gms.internal.zzkd.zzcx(r4)
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r5 = 0
            r4.<init>(r5)
            goto L_0x00c5
        L_0x0240:
            java.util.List r8 = r4.zzbnm     // Catch:{ JSONException -> 0x0220 }
            goto L_0x00e9
        L_0x0244:
            java.util.List r9 = r4.zzbnn     // Catch:{ JSONException -> 0x0220 }
            goto L_0x00fa
        L_0x0248:
            java.util.List r15 = r4.zzcca     // Catch:{ JSONException -> 0x0220 }
            goto L_0x010b
        L_0x024c:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r5)
            goto L_0x0235
        L_0x0252:
            r10 = r12
            goto L_0x0126
        L_0x0255:
            r7 = r5
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zziq.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zziv zziv, zziz.zza zza, Location location, zzcv zzcv, String str, List list, Bundle bundle, String str2) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzcaq != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzcaq);
            }
            m7222a(hashMap, adRequestInfoParcel.zzcar);
            if (adRequestInfoParcel.zzapa.zzaut != null) {
                boolean z = false;
                boolean z2 = false;
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzapa.zzaut) {
                    if (!adSizeParcel.zzauv && !z2) {
                        hashMap.put("format", adSizeParcel.zzaur);
                        z2 = true;
                    }
                    if (adSizeParcel.zzauv && !z) {
                        hashMap.put("fluid", "height");
                        z = true;
                    }
                    if (z2 && z) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", adRequestInfoParcel.zzapa.zzaur);
                if (adRequestInfoParcel.zzapa.zzauv) {
                    hashMap.put("fluid", "height");
                }
            }
            if (adRequestInfoParcel.zzapa.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzapa.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzapa.zzaut != null) {
                StringBuilder sb = new StringBuilder();
                boolean z3 = false;
                for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.zzapa.zzaut) {
                    if (adSizeParcel2.zzauv) {
                        z3 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        sb.append(adSizeParcel2.width == -1 ? (int) (((float) adSizeParcel2.widthPixels) / zziv.zzcbd) : adSizeParcel2.width);
                        sb.append("x");
                        sb.append(adSizeParcel2.height == -2 ? (int) (((float) adSizeParcel2.heightPixels) / zziv.zzcbd) : adSizeParcel2.height);
                    }
                }
                if (z3) {
                    if (sb.length() != 0) {
                        sb.insert(0, "|");
                    }
                    sb.insert(0, "320x50");
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.zzcax != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzcax));
                if (!adRequestInfoParcel.zzapa.zzauw) {
                    hashMap.put("native_templates", adRequestInfoParcel.zzaps);
                    hashMap.put("native_image_orientation", m7218a(adRequestInfoParcel.zzapo));
                    if (!adRequestInfoParcel.zzcbi.isEmpty()) {
                        hashMap.put("native_custom_templates", adRequestInfoParcel.zzcbi);
                    }
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzaou);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzcas != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzcas.versionCode));
            }
            hashMap.put("ms", str);
            hashMap.put("seq_num", adRequestInfoParcel.zzcau);
            hashMap.put("session_id", adRequestInfoParcel.zzcav);
            hashMap.put("js", adRequestInfoParcel.zzaow.zzcs);
            m7224a(hashMap, zziv, zza, adRequestInfoParcel.zzcbv);
            m7225a(hashMap, str2);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                m7221a(hashMap, location);
            } else if (adRequestInfoParcel.zzcar.versionCode >= 2 && adRequestInfoParcel.zzcar.zzatu != null) {
                m7221a(hashMap, adRequestInfoParcel.zzcar.zzatu);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzcaw);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzcaz) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzcaz));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzcbd));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzcbc));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzcbb));
            } else {
                hashMap.put("u_sd", Float.valueOf(zziv.zzcbd));
                hashMap.put("sh", Integer.valueOf(zziv.zzcbc));
                hashMap.put("sw", Integer.valueOf(zziv.zzcbb));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcbe)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzcbe));
                    } catch (JSONException e) {
                        zzkd.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzcbf));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzcbg);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzcbk != null) {
                hashMap.put("capability", adRequestInfoParcel.zzcbk.toBundle());
            }
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzcbl)) {
                hashMap.put("anchor", adRequestInfoParcel.zzcbl);
            }
            if (adRequestInfoParcel.versionCode >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(adRequestInfoParcel.zzcbm));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(adRequestInfoParcel.zzcbs));
            }
            if (adRequestInfoParcel.versionCode >= 14 && adRequestInfoParcel.zzcbn > 0) {
                hashMap.put("target_api", Integer.valueOf(adRequestInfoParcel.zzcbn));
            }
            if (adRequestInfoParcel.versionCode >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(adRequestInfoParcel.zzcbo == -1 ? -1 : adRequestInfoParcel.zzcbo));
            }
            if (adRequestInfoParcel.versionCode >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(adRequestInfoParcel.zzcbp));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcbt)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(adRequestInfoParcel.zzcbt));
                    } catch (JSONException e2) {
                        zzkd.zzd("Problem creating json from app settings", e2);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(adRequestInfoParcel.zzbnq));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(adRequestInfoParcel.zzcbu));
            }
            if (zzkd.zzaz(2)) {
                String valueOf = String.valueOf(zzu.zzfq().zzam((Map) hashMap).toString(2));
                zzkd.m7303v(valueOf.length() != 0 ? "Ad Request JSON: ".concat(valueOf) : new String("Ad Request JSON: "));
            }
            return zzu.zzfq().zzam((Map) hashMap);
        } catch (JSONException e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            zzkd.zzcx(valueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(valueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.zzbto != null) {
            jSONObject.put("ad_base_url", adResponseParcel.zzbto);
        }
        if (adResponseParcel.zzccb != null) {
            jSONObject.put("ad_size", adResponseParcel.zzccb);
        }
        jSONObject.put("native", adResponseParcel.zzauu);
        if (adResponseParcel.zzauu) {
            jSONObject.put("ad_json", adResponseParcel.body);
        } else {
            jSONObject.put("ad_html", adResponseParcel.body);
        }
        if (adResponseParcel.zzccd != null) {
            jSONObject.put("debug_dialog", adResponseParcel.zzccd);
        }
        if (adResponseParcel.zzcbx != -1) {
            jSONObject.put("interstitial_timeout", ((double) adResponseParcel.zzcbx) / 1000.0d);
        }
        if (adResponseParcel.orientation == zzu.zzfs().zztk()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.orientation == zzu.zzfs().zztj()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.zzbnm != null) {
            jSONObject.put("click_urls", m7220a(adResponseParcel.zzbnm));
        }
        if (adResponseParcel.zzbnn != null) {
            jSONObject.put("impression_urls", m7220a(adResponseParcel.zzbnn));
        }
        if (adResponseParcel.zzcca != null) {
            jSONObject.put("manual_impression_urls", m7220a(adResponseParcel.zzcca));
        }
        if (adResponseParcel.zzccg != null) {
            jSONObject.put("active_view", adResponseParcel.zzccg);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.zzcce);
        if (adResponseParcel.zzccf != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.zzccf);
        }
        jSONObject.put("mediation", adResponseParcel.zzcby);
        jSONObject.put("custom_render_allowed", adResponseParcel.zzcch);
        jSONObject.put("content_url_opted_out", adResponseParcel.zzcci);
        jSONObject.put("prefetch", adResponseParcel.zzccj);
        if (adResponseParcel.zzbns != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.zzbns);
        }
        if (adResponseParcel.zzcbz != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.zzcbz);
        }
        if (!TextUtils.isEmpty(adResponseParcel.zzccm)) {
            jSONObject.put("gws_query_id", adResponseParcel.zzccm);
        }
        jSONObject.put("fluid", adResponseParcel.zzauv ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.zzauw);
        if (adResponseParcel.zzcco != null) {
            jSONObject.put("video_start_urls", m7220a(adResponseParcel.zzcco));
        }
        if (adResponseParcel.zzccp != null) {
            jSONObject.put("video_complete_urls", m7220a(adResponseParcel.zzccp));
        }
        if (adResponseParcel.zzccn != null) {
            jSONObject.put("rewards", adResponseParcel.zzccn.zzrw());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.zzccq);
        jSONObject.put("auto_protection_configuration", adResponseParcel.zzccr);
        jSONObject.put("render_in_browser", adResponseParcel.zzbnq);
        return jSONObject;
    }
}
