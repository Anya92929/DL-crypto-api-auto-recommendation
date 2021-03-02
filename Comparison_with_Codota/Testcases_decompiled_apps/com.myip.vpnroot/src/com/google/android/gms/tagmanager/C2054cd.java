package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cd */
abstract class C2054cd extends C1998aj {
    private static final String aoU = C0929b.ARG0.toString();
    private static final String apQ = C0929b.ARG1.toString();

    public C2054cd(String str) {
        super(str, aoU, apQ);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        for (C1026d.C1027a aVar : map.values()) {
            if (aVar == C2114di.m7119pI()) {
                return C2114di.m7124u(false);
            }
        }
        C1026d.C1027a aVar2 = map.get(aoU);
        C1026d.C1027a aVar3 = map.get(apQ);
        return C2114di.m7124u(Boolean.valueOf((aVar2 == null || aVar3 == null) ? false : mo11611a(aVar2, aVar3, map)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo11611a(C1026d.C1027a aVar, C1026d.C1027a aVar2, Map<String, C1026d.C1027a> map);

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
