package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.bn */
class C0554bn implements C0542bb<C0555c> {

    /* renamed from: a */
    private final C0516ac f3846a;

    /* renamed from: b */
    private final C0555c f3847b = new C0555c();

    public C0554bn(C0516ac acVar) {
        this.f3846a = acVar;
    }

    /* renamed from: a */
    public void mo6720a(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f3847b.f3851d = i;
        } else {
            this.f3846a.mo6604f().mo6877d("Int xml configuration name not recognized", str);
        }
    }

    /* renamed from: a */
    public void mo6721a(String str, String str2) {
    }

    /* renamed from: a */
    public void mo6722a(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.f3847b.f3852e = z ? 1 : 0;
            return;
        }
        this.f3846a.mo6604f().mo6877d("Bool xml configuration name not recognized", str);
    }

    /* renamed from: b */
    public C0555c mo6719a() {
        return this.f3847b;
    }

    /* renamed from: b */
    public void mo6723b(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f3847b.f3848a = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.f3847b.f3849b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f3847b.f3850c = str2;
        } else {
            this.f3846a.mo6604f().mo6877d("String xml configuration name not recognized", str);
        }
    }
}
