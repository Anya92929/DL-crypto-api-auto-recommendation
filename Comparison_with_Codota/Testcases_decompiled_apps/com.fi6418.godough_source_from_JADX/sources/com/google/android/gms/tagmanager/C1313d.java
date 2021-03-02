package com.google.android.gms.tagmanager;

import java.util.List;

/* renamed from: com.google.android.gms.tagmanager.d */
class C1313d implements C1317h {

    /* renamed from: a */
    final /* synthetic */ C1294b f5396a;

    C1313d(C1294b bVar) {
        this.f5396a = bVar;
    }

    /* renamed from: a */
    public void mo9166a(List<C1314e> list) {
        for (C1314e next : list) {
            this.f5396a.m5331b(this.f5396a.mo9116a(next.f5397a, next.f5398b));
        }
        this.f5396a.f5362i.countDown();
    }
}
