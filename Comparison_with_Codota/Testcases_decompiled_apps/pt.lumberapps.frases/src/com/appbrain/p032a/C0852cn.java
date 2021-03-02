package com.appbrain.p032a;

/* renamed from: com.appbrain.a.cn */
public final class C0852cn implements Comparable {

    /* renamed from: a */
    public final String f2258a;

    /* renamed from: b */
    public final int f2259b;

    public C0852cn(String str, int i) {
        this.f2258a = str;
        this.f2259b = i;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0852cn cnVar = (C0852cn) obj;
        if (this.f2259b > cnVar.f2259b) {
            return -1;
        }
        return this.f2259b == cnVar.f2259b ? 0 : 1;
    }

    public final String toString() {
        return this.f2258a + " (" + this.f2259b + ")";
    }
}
