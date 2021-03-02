package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzjw {

    /* renamed from: a */
    private final long f6546a;

    /* renamed from: b */
    private final List f6547b = new ArrayList();

    /* renamed from: c */
    private final Map f6548c = new HashMap();

    /* renamed from: d */
    private String f6549d;

    /* renamed from: e */
    private String f6550e;

    /* renamed from: f */
    private boolean f6551f = false;

    public zzjw(String str, long j) {
        this.f6550e = str;
        this.f6546a = j;
        m7286a(str);
    }

    /* renamed from: a */
    private void m7286a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.f6551f = false;
                    zzkd.zzcx("App settings could not be fetched successfully.");
                    return;
                }
                this.f6551f = true;
                this.f6549d = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        m7287a(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (JSONException e) {
                zzkd.zzd("Exception occurred while processing app setting json", e);
                zzu.zzft().zzb((Throwable) e, true);
            }
        }
    }

    /* renamed from: a */
    private void m7287a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        String optString = jSONObject.optString("format");
        String optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.f6547b.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                int i = 0;
                while (i < optJSONArray.length() && (optJSONArray2 = r5.optJSONArray("adapters")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList.add(optJSONArray2.getString(i2));
                    }
                    JSONObject optJSONObject2 = (r5 = optJSONArray.getJSONObject(i)).optJSONObject("data");
                    if (optJSONObject2 != null) {
                        Bundle bundle = new Bundle();
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bundle.putString(next, optJSONObject2.getString(next));
                        }
                        C1714li liVar = new C1714li(this, arrayList, bundle);
                        C1715lj ljVar = this.f6548c.containsKey(optString2) ? (C1715lj) this.f6548c.get(optString2) : new C1715lj(this);
                        ljVar.mo7471a(liVar);
                        this.f6548c.put(optString2, ljVar);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long zzse() {
        return this.f6546a;
    }

    public boolean zzsf() {
        return this.f6551f;
    }

    public String zzsg() {
        return this.f6550e;
    }

    public String zzsh() {
        return this.f6549d;
    }
}
