package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@zzin
/* renamed from: com.google.android.gms.internal.hf */
class C1603hf {

    /* renamed from: a */
    private final Object[] f5070a;

    C1603hf(AdRequestParcel adRequestParcel, String str, int i) {
        this.f5070a = m6421a(adRequestParcel, str, i);
    }

    /* renamed from: a */
    private static String m6420a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(new ArrayList(bundle.keySet()));
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            sb.append(obj == null ? "null" : obj instanceof Bundle ? m6420a((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Object[] m6421a(AdRequestParcel adRequestParcel, String str, int i) {
        HashSet hashSet = new HashSet(Arrays.asList(((String) zzdc.zzbag.get()).split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.zzatm));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(m6420a(adRequestParcel.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzatn));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.zzato != null) {
                arrayList.add(adRequestParcel.zzato.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzatp));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzatq));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzatr));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.zzats);
        }
        if (hashSet.contains("location")) {
            if (adRequestParcel.zzatu != null) {
                arrayList.add(adRequestParcel.zzatu.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.zzatv);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m6420a(adRequestParcel.zzatw));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m6420a(adRequestParcel.zzatx));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.zzaty != null) {
                arrayList.add(adRequestParcel.zzaty.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.zzatz);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.zzaua);
        }
        return arrayList.toArray();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1603hf)) {
            return false;
        }
        return Arrays.equals(this.f5070a, ((C1603hf) obj).f5070a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5070a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f5070a));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
