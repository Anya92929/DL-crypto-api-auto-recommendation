package com.appbrain.p032a;

/* renamed from: com.appbrain.a.bw */
final class C0834bw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2197a;

    /* renamed from: b */
    final /* synthetic */ String f2198b;

    /* renamed from: c */
    final /* synthetic */ String f2199c;

    /* renamed from: d */
    final /* synthetic */ String f2200d;

    /* renamed from: e */
    final /* synthetic */ int f2201e;

    /* renamed from: f */
    final /* synthetic */ C0800ap f2202f;

    C0834bw(C0800ap apVar, String str, String str2, String str3, String str4, int i) {
        this.f2202f = apVar;
        this.f2197a = str;
        this.f2198b = str2;
        this.f2199c = str3;
        this.f2200d = str4;
        this.f2201e = i;
    }

    public final void run() {
        boolean z = this.f2202f.f2105e != C0841cc.f2215a;
        if (z) {
            this.f2202f.sendImpression();
            C0842cd.m3721a(this.f2202f.f2101a, this.f2197a, this.f2198b, this.f2199c);
            C0932fm.m3968a().mo3852k();
            if (this.f2202f.f2102b != null) {
                this.f2202f.f2102b.mo3675a();
            }
        }
        C0842cd.m3720a(this.f2202f.f2101a, this.f2200d, new C0844cf(z, this.f2197a, this.f2198b, this.f2199c, this.f2201e));
    }
}
