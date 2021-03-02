package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.by */
abstract class C2046by extends C2054cd {
    public C2046by(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11611a(C1026d.C1027a aVar, C1026d.C1027a aVar2, Map<String, C1026d.C1027a> map) {
        C2113dh k = C2114di.m7107k(aVar);
        C2113dh k2 = C2114di.m7107k(aVar2);
        if (k == C2114di.m7117pG() || k2 == C2114di.m7117pG()) {
            return false;
        }
        return mo11551a(k, k2, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo11551a(C2113dh dhVar, C2113dh dhVar2, Map<String, C1026d.C1027a> map);
}
