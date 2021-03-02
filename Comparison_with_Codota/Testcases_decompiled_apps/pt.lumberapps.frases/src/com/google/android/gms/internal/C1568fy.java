package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzin
/* renamed from: com.google.android.gms.internal.fy */
class C1568fy {

    /* renamed from: a */
    private final String f5008a;

    /* renamed from: b */
    private final int f5009b;

    /* renamed from: c */
    private final List f5010c;

    /* renamed from: d */
    private final String f5011d;

    public C1568fy(String str, int i, List list, String str2) {
        this.f5008a = str;
        this.f5009b = i;
        if (list == null) {
            this.f5010c = new ArrayList();
        } else {
            this.f5010c = list;
        }
        this.f5011d = str2;
    }

    /* renamed from: a */
    public String mo7276a() {
        return this.f5008a;
    }

    /* renamed from: b */
    public int mo7277b() {
        return this.f5009b;
    }

    /* renamed from: c */
    public Iterable mo7278c() {
        return this.f5010c;
    }

    /* renamed from: d */
    public String mo7279d() {
        return this.f5011d;
    }
}
