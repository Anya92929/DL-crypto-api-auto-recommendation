package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.gm */
class C1583gm implements C1600hc {

    /* renamed from: a */
    final /* synthetic */ String f5037a;

    /* renamed from: b */
    final /* synthetic */ String f5038b;

    /* renamed from: c */
    final /* synthetic */ C1582gl f5039c;

    C1583gm(C1582gl glVar, String str, String str2) {
        this.f5039c = glVar;
        this.f5037a = str;
        this.f5038b = str2;
    }

    /* renamed from: a */
    public void mo7287a(C1601hd hdVar) {
        if (hdVar.f5063b != null) {
            hdVar.f5063b.onAppEvent(this.f5037a, this.f5038b);
        }
    }
}
