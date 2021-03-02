package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C2144p extends C1998aj {

    /* renamed from: ID */
    private static final String f4599ID = C0880a.CONTAINER_VERSION.toString();

    /* renamed from: Sq */
    private final String f4600Sq;

    public C2144p(String str) {
        super(f4599ID, new String[0]);
        this.f4600Sq = str;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return this.f4600Sq == null ? C2114di.m7119pI() : C2114di.m7124u(this.f4600Sq);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
