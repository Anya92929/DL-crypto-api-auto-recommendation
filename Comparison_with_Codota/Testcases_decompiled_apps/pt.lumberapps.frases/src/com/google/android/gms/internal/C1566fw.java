package com.google.android.gms.internal;

import java.net.URL;
import java.util.ArrayList;

@zzin
/* renamed from: com.google.android.gms.internal.fw */
class C1566fw {

    /* renamed from: a */
    private final String f5000a;

    /* renamed from: b */
    private final URL f5001b;

    /* renamed from: c */
    private final ArrayList f5002c;

    /* renamed from: d */
    private final String f5003d;

    public C1566fw(String str, URL url, ArrayList arrayList, String str2) {
        this.f5000a = str;
        this.f5001b = url;
        if (arrayList == null) {
            this.f5002c = new ArrayList();
        } else {
            this.f5002c = arrayList;
        }
        this.f5003d = str2;
    }

    /* renamed from: a */
    public String mo7269a() {
        return this.f5000a;
    }

    /* renamed from: b */
    public URL mo7270b() {
        return this.f5001b;
    }

    /* renamed from: c */
    public ArrayList mo7271c() {
        return this.f5002c;
    }

    /* renamed from: d */
    public String mo7272d() {
        return this.f5003d;
    }
}
