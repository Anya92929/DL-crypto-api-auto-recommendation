package com.appbrain.p032a;

/* renamed from: com.appbrain.a.ak */
final class C0795ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0799ao f2089a;

    /* renamed from: b */
    final /* synthetic */ int f2090b;

    C0795ak(C0799ao aoVar, int i) {
        this.f2089a = aoVar;
        this.f2090b = i;
    }

    public final void run() {
        String unused = C0794aj.f2086a;
        new StringBuilder("Event type ").append(this.f2089a).append(" for listener ID ").append(this.f2090b).append(".");
        C0798an anVar = (C0798an) C0794aj.f2087b.get(this.f2090b);
        if (anVar == null) {
            new IllegalStateException("Event listener ID unknown");
            return;
        }
        try {
            switch (C0797am.f2093a[this.f2089a.ordinal()]) {
                case 1:
                    if (!anVar.f2095b) {
                        anVar.f2095b = true;
                        anVar.f2094a.mo3911a();
                        return;
                    }
                    return;
                case 2:
                    if (!anVar.f2096c) {
                        anVar.f2096c = true;
                        anVar.f2094a.onClick();
                        return;
                    }
                    return;
                case 3:
                    anVar.f2094a.mo3912a(anVar.f2096c);
                    C0794aj.f2087b.remove(this.f2090b);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }
}
