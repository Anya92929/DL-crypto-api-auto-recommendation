package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.hh */
class C1605hh {

    /* renamed from: a */
    zzl f5076a;

    /* renamed from: b */
    AdRequestParcel f5077b;

    /* renamed from: c */
    C1575ge f5078c;

    /* renamed from: d */
    long f5079d;

    /* renamed from: e */
    boolean f5080e;

    /* renamed from: f */
    boolean f5081f;

    /* renamed from: g */
    final /* synthetic */ C1604hg f5082g;

    C1605hh(C1604hg hgVar, zzfh zzfh) {
        this.f5082g = hgVar;
        this.f5076a = zzfh.zzbd(hgVar.f5073c);
        this.f5078c = new C1575ge();
        this.f5078c.mo7285a(this.f5076a);
    }

    C1605hh(C1604hg hgVar, zzfh zzfh, AdRequestParcel adRequestParcel) {
        this(hgVar, zzfh);
        this.f5077b = adRequestParcel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7305a() {
        if (!this.f5080e) {
            this.f5081f = this.f5076a.zzb(zzfk.m7035b(this.f5077b != null ? this.f5077b : this.f5082g.f5072b));
            this.f5080e = true;
            this.f5079d = zzu.zzfu().currentTimeMillis();
        }
    }
}
