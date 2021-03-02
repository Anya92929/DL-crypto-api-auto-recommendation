package com.appbrain.p032a;

/* renamed from: com.appbrain.a.cr */
final class C0856cr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2268a;

    /* renamed from: b */
    final /* synthetic */ C0855cq f2269b;

    C0856cr(C0855cq cqVar, String str) {
        this.f2269b = cqVar;
        this.f2268a = str;
    }

    public final void run() {
        if (!C0884ds.m3840c()) {
            this.f2269b.f2267b.f2263c.setVisibility(0);
        }
        if (!this.f2269b.f2267b.mo3829j() && this.f2269b.f2267b.f2263c.getVisibility() != 0 && C0842cd.m3730c(this.f2269b.f2267b.mo3827h(), this.f2268a, this.f2269b.f2267b.f2264d)) {
            this.f2269b.f2267b.mo3727f();
        }
    }
}
