package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.dd */
abstract class C2108dd extends C2054cd {
    public C2108dd(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11611a(C1026d.C1027a aVar, C1026d.C1027a aVar2, Map<String, C1026d.C1027a> map) {
        String j = C2114di.m7106j(aVar);
        String j2 = C2114di.m7106j(aVar2);
        if (j == C2114di.m7118pH() || j2 == C2114di.m7118pH()) {
            return false;
        }
        return mo11541a(j, j2, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo11541a(String str, String str2, Map<String, C1026d.C1027a> map);
}
