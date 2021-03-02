package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.dk */
class C2116dk extends C1998aj {

    /* renamed from: ID */
    private static final String f4585ID = C0880a.UPPERCASE_STRING.toString();
    private static final String aoU = C0929b.ARG0.toString();

    public C2116dk() {
        super(f4585ID, aoU);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return C2114di.m7124u(C2114di.m7106j(map.get(aoU)).toUpperCase());
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
