package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzdc;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.ads.internal.ah */
class C1221ah {

    /* renamed from: a */
    private final String f3443a;

    /* renamed from: b */
    private final Map f3444b = new TreeMap();

    /* renamed from: c */
    private String f3445c;

    /* renamed from: d */
    private String f3446d;

    public C1221ah(String str) {
        this.f3443a = str;
    }

    /* renamed from: a */
    public String mo5012a() {
        return this.f3446d;
    }

    /* renamed from: a */
    public void mo5013a(AdRequestParcel adRequestParcel) {
        this.f3445c = adRequestParcel.zzatt.zzaxl;
        Bundle bundle = adRequestParcel.zzatw != null ? adRequestParcel.zzatw.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = (String) zzdc.zzbdc.get();
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.f3446d = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.f3444b.put(str2.substring("csa_".length()), bundle.getString(str2));
                }
            }
        }
    }

    /* renamed from: b */
    public String mo5014b() {
        return this.f3445c;
    }

    /* renamed from: c */
    public String mo5015c() {
        return this.f3443a;
    }

    /* renamed from: d */
    public Map mo5016d() {
        return this.f3444b;
    }
}
