package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C0585p;
import com.google.android.gms.analytics.internal.C0561i;
import com.google.android.gms.analytics.p016a.C0502a;
import com.google.android.gms.analytics.p016a.C0503b;
import com.google.android.gms.analytics.p016a.C0504c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.p */
public class C0585p<T extends C0585p> {

    /* renamed from: a */
    C0503b f3922a;

    /* renamed from: b */
    Map<String, List<C0502a>> f3923b = new HashMap();

    /* renamed from: c */
    List<C0504c> f3924c = new ArrayList();

    /* renamed from: d */
    List<C0502a> f3925d = new ArrayList();

    /* renamed from: e */
    private Map<String, String> f3926e = new HashMap();

    protected C0585p() {
    }

    /* renamed from: a */
    public T mo6919a(int i, String str) {
        mo6922a(C0594y.m3485a(i), str);
        return this;
    }

    /* renamed from: a */
    public T mo6920a(C0502a aVar) {
        if (aVar == null) {
            C0561i.m3263c("product should be non-null");
        } else {
            this.f3925d.add(aVar);
        }
        return this;
    }

    /* renamed from: a */
    public T mo6921a(C0503b bVar) {
        this.f3922a = bVar;
        return this;
    }

    /* renamed from: a */
    public final T mo6922a(String str, String str2) {
        if (str != null) {
            this.f3926e.put(str, str2);
        } else {
            C0561i.m3263c(" HitBuilder.set() called with a null paramName.");
        }
        return this;
    }

    /* renamed from: a */
    public Map<String, String> mo6914a() {
        HashMap hashMap = new HashMap(this.f3926e);
        if (this.f3922a != null) {
            hashMap.putAll(this.f3922a.mo6565a());
        }
        int i = 1;
        for (C0504c a : this.f3924c) {
            hashMap.putAll(a.mo6568a(C0594y.m3491f(i)));
            i++;
        }
        int i2 = 1;
        for (C0502a b : this.f3925d) {
            hashMap.putAll(b.mo6563b(C0594y.m3489d(i2)));
            i2++;
        }
        int i3 = 1;
        for (Map.Entry next : this.f3923b.entrySet()) {
            String i4 = C0594y.m3494i(i3);
            int i5 = 1;
            for (C0502a b2 : (List) next.getValue()) {
                hashMap.putAll(b2.mo6563b(i4 + C0594y.m3493h(i5)));
                i5++;
            }
            if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                hashMap.put(i4 + "nm", next.getKey());
            }
            i3++;
        }
        return hashMap;
    }

    /* renamed from: b */
    public T mo6923b() {
        mo6922a("&sc", "start");
        return this;
    }
}
