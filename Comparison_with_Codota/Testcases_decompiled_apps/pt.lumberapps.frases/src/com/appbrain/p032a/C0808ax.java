package com.appbrain.p032a;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.appbrain.a.ax */
final class C0808ax extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ C0807aw f2132a;

    C0808ax(C0807aw awVar) {
        this.f2132a = awVar;
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry entry) {
        return this.f2132a.f2129h.size() > 8;
    }
}
