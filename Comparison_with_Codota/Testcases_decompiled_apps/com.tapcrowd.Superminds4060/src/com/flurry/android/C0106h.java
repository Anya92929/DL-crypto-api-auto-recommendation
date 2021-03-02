package com.flurry.android;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.flurry.android.h */
final class C0106h extends LinkedHashMap {

    /* renamed from: a */
    private /* synthetic */ C0093ag f198a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0106h(C0093ag agVar, int i, float f) {
        super(i, f, true);
        this.f198a = agVar;
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.f198a.f110b;
    }
}
