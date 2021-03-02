package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzin
public final class zzga {
    public final List zzbnk;
    public final long zzbnl;
    public final List zzbnm;
    public final List zzbnn;
    public final List zzbno;
    public final List zzbnp;
    public final boolean zzbnq;
    public final String zzbnr;
    public final long zzbns;
    public final String zzbnt;
    public final int zzbnu;
    public final int zzbnv;
    public final long zzbnw;
    public final boolean zzbnx;
    public int zzbny;
    public int zzbnz;

    public zzga(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (zzkd.zzaz(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzkd.m7303v(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzfz zzfz = new zzfz(jSONArray.getJSONObject(i2));
            arrayList.add(zzfz);
            if (i < 0 && m7073a(zzfz)) {
                i = i2;
            }
        }
        this.zzbny = i;
        this.zzbnz = jSONArray.length();
        this.zzbnk = Collections.unmodifiableList(arrayList);
        this.zzbnr = jSONObject.getString("qdata");
        this.zzbnv = jSONObject.optInt("fs_model_type", -1);
        this.zzbnw = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzbnl = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzbnm = zzu.zzgf().zza(optJSONObject, "click_urls");
            this.zzbnn = zzu.zzgf().zza(optJSONObject, "imp_urls");
            this.zzbno = zzu.zzgf().zza(optJSONObject, "nofill_urls");
            this.zzbnp = zzu.zzgf().zza(optJSONObject, "remote_ping_urls");
            this.zzbnq = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzbns = optLong > 0 ? optLong * 1000 : -1;
            RewardItemParcel zza = RewardItemParcel.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzbnt = null;
                this.zzbnu = 0;
            } else {
                this.zzbnt = zza.type;
                this.zzbnu = zza.zzcid;
            }
            this.zzbnx = optJSONObject.optBoolean("use_displayed_impression", false);
            return;
        }
        this.zzbnl = -1;
        this.zzbnm = null;
        this.zzbnn = null;
        this.zzbno = null;
        this.zzbnp = null;
        this.zzbns = -1;
        this.zzbnt = null;
        this.zzbnu = 0;
        this.zzbnx = false;
        this.zzbnq = false;
    }

    public zzga(List list, long j, List list2, List list3, List list4, List list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzbnk = list;
        this.zzbnl = j;
        this.zzbnm = list2;
        this.zzbnn = list3;
        this.zzbno = list4;
        this.zzbnp = list5;
        this.zzbnq = z;
        this.zzbnr = str;
        this.zzbns = j2;
        this.zzbny = i;
        this.zzbnz = i2;
        this.zzbnt = str2;
        this.zzbnu = i3;
        this.zzbnv = i4;
        this.zzbnw = j3;
        this.zzbnx = z2;
    }

    /* renamed from: a */
    private boolean m7073a(zzfz zzfz) {
        for (String equals : zzfz.zzbmw) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
