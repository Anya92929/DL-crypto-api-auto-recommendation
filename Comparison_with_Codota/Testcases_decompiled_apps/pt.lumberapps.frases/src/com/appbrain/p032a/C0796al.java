package com.appbrain.p032a;

import com.appbrain.C0982ac;

/* renamed from: com.appbrain.a.al */
final class C0796al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2091a;

    /* renamed from: b */
    final /* synthetic */ C0982ac f2092b;

    C0796al(int i, C0982ac acVar) {
        this.f2091a = i;
        this.f2092b = acVar;
    }

    public final void run() {
        String unused = C0794aj.f2086a;
        new StringBuilder("Registering listener with ID ").append(this.f2091a).append(".");
        C0794aj.f2087b.put(this.f2091a, new C0798an(this.f2092b));
    }
}
