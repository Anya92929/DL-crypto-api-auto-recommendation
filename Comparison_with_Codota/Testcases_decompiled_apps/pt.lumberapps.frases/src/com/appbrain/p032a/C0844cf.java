package com.appbrain.p032a;

import java.io.Serializable;

/* renamed from: com.appbrain.a.cf */
public final class C0844cf implements Serializable {

    /* renamed from: a */
    public final boolean f2224a;

    /* renamed from: b */
    public final String f2225b;

    /* renamed from: c */
    public final String f2226c;

    /* renamed from: d */
    public final String f2227d;

    /* renamed from: e */
    public final boolean f2228e;

    C0844cf(boolean z, String str, String str2, String str3, int i) {
        boolean z2 = true;
        this.f2224a = z;
        this.f2225b = str;
        this.f2226c = str2;
        this.f2227d = str3;
        int i2 = 1 << (C0843ce.f2222a - 1);
        this.f2228e = (i & i2) != i2 ? false : z2;
    }
}
