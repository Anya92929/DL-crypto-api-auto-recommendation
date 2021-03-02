package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0540b;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0624am;
import com.google.android.gms.p018c.C0626ao;
import com.google.android.gms.p018c.C0627ap;
import com.google.android.gms.p018c.C0635ax;
import com.google.android.gms.p018c.C0668j;
import java.util.ListIterator;

/* renamed from: com.google.android.gms.analytics.w */
public class C0592w extends C0627ap<C0592w> {

    /* renamed from: b */
    private final C0516ac f3944b;

    /* renamed from: c */
    private boolean f3945c;

    public C0592w(C0516ac acVar) {
        super(acVar.mo6606h(), acVar.mo6602d());
        this.f3944b = acVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6934a(C0624am amVar) {
        C0668j jVar = (C0668j) amVar.mo6998b(C0668j.class);
        if (TextUtils.isEmpty(jVar.mo7220b())) {
            jVar.mo7221b(this.f3944b.mo6614p().mo6706b());
        }
        if (this.f3945c && TextUtils.isEmpty(jVar.mo7225d())) {
            C0540b o = this.f3944b.mo6613o();
            jVar.mo7226d(o.mo6715c());
            jVar.mo7219a(o.mo6714b());
        }
    }

    /* renamed from: b */
    public void mo6935b(String str) {
        C1009bf.m4530a(str);
        mo6937c(str);
        mo7013n().add(new C0593x(this.f3944b, str));
    }

    /* renamed from: b */
    public void mo6936b(boolean z) {
        this.f3945c = z;
    }

    /* renamed from: c */
    public void mo6937c(String str) {
        Uri a = C0593x.m3474a(str);
        ListIterator<C0635ax> listIterator = mo7013n().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(listIterator.next().mo6940a())) {
                listIterator.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C0516ac mo6938k() {
        return this.f3944b;
    }

    /* renamed from: l */
    public C0624am mo6939l() {
        C0624am a = mo7012m().mo6994a();
        a.mo6997a((C0626ao) this.f3944b.mo6615q().mo6681c());
        a.mo6997a((C0626ao) this.f3944b.mo6616r().mo6769b());
        mo7011b(a);
        return a;
    }
}
