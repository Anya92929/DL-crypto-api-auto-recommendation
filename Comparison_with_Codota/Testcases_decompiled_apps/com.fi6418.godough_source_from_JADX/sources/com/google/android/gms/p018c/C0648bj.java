package com.google.android.gms.p018c;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.c.bj */
public class C0648bj {

    /* renamed from: a */
    private final Map<String, C0661c> f4310a;

    /* renamed from: b */
    private final C0661c f4311b;

    /* renamed from: a */
    public Map<String, C0661c> mo7132a() {
        return Collections.unmodifiableMap(this.f4310a);
    }

    /* renamed from: a */
    public void mo7133a(String str, C0661c cVar) {
        this.f4310a.put(str, cVar);
    }

    /* renamed from: b */
    public C0661c mo7134b() {
        return this.f4311b;
    }

    public String toString() {
        return "Properties: " + mo7132a() + " pushAfterEvaluate: " + this.f4311b;
    }
}
