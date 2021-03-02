package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzin
public final class zzfz {
    public final String zzbmu;
    public final String zzbmv;
    public final List zzbmw;
    public final String zzbmx;
    public final String zzbmy;
    public final List zzbmz;
    public final List zzbna;
    public final List zzbnb;
    public final String zzbnc;
    public final List zzbnd;
    public final List zzbne;
    public final String zzbnf;
    public final String zzbng;
    public final String zzbnh;
    public final List zzbni;
    public final String zzbnj;

    public zzfz(String str, String str2, List list, String str3, String str4, List list2, List list3, String str5, String str6, List list4, List list5, String str7, String str8, String str9, List list6, String str10, List list7) {
        this.zzbmu = str;
        this.zzbmv = str2;
        this.zzbmw = list;
        this.zzbmx = str3;
        this.zzbmy = str4;
        this.zzbmz = list2;
        this.zzbna = list3;
        this.zzbnc = str5;
        this.zzbnd = list4;
        this.zzbne = list5;
        this.zzbnf = str7;
        this.zzbng = str8;
        this.zzbnh = str9;
        this.zzbni = list6;
        this.zzbnj = str10;
        this.zzbnb = list7;
    }

    public zzfz(JSONObject jSONObject) {
        String str = null;
        this.zzbmv = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzbmw = Collections.unmodifiableList(arrayList);
        this.zzbmx = jSONObject.optString("allocation_id", (String) null);
        this.zzbmz = zzu.zzgf().zza(jSONObject, "clickurl");
        this.zzbna = zzu.zzgf().zza(jSONObject, "imp_urls");
        this.zzbnb = zzu.zzgf().zza(jSONObject, "fill_urls");
        this.zzbnd = zzu.zzgf().zza(jSONObject, "video_start_urls");
        this.zzbne = zzu.zzgf().zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzbmu = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzbnc = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzbmy = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzbnf = jSONObject.optString("html_template", (String) null);
        this.zzbng = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzbnh = optJSONObject3 != null ? optJSONObject3.toString() : null;
        this.zzbni = zzu.zzgf().zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzbnj = optJSONObject4 != null ? optJSONObject4.toString() : str;
    }
}
