package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.C0581l;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0615ad;
import com.google.android.gms.p018c.C0616ae;
import com.google.android.gms.p018c.C0628aq;

/* renamed from: com.google.android.gms.analytics.internal.ae */
public class C0518ae {

    /* renamed from: a */
    private final Context f3719a;

    /* renamed from: b */
    private final Context f3720b;

    public C0518ae(Context context) {
        C1009bf.m4528a(context);
        Context applicationContext = context.getApplicationContext();
        C1009bf.m4529a(applicationContext, (Object) "Application context can't be null");
        this.f3719a = applicationContext;
        this.f3720b = applicationContext;
    }

    /* renamed from: a */
    public Context mo6619a() {
        return this.f3719a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0547bg mo6620a(C0516ac acVar) {
        return new C0547bg(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0628aq mo6621a(Context context) {
        return C0628aq.m3617a(context);
    }

    /* renamed from: b */
    public Context mo6622b() {
        return this.f3720b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0527an mo6623b(C0516ac acVar) {
        return new C0527an(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0540b mo6624c(C0516ac acVar) {
        return new C0540b(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0535av mo6625d(C0516ac acVar) {
        return new C0535av(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0571s mo6626e(C0516ac acVar) {
        return new C0571s(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C0562j mo6627f(C0516ac acVar) {
        return new C0562j(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C0543bc mo6628g(C0516ac acVar) {
        return new C0543bc(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public C0615ad mo6629h(C0516ac acVar) {
        return C0616ae.m3557c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0581l mo6630i(C0516ac acVar) {
        return new C0581l(acVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0528ao mo6631j(C0516ac acVar) {
        return new C0528ao(acVar, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C0563k mo6632k(C0516ac acVar) {
        return new C0563k(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0572t mo6633l(C0516ac acVar) {
        return new C0572t(acVar, this);
    }

    /* renamed from: m */
    public C0525al mo6634m(C0516ac acVar) {
        return new C0525al(acVar);
    }

    /* renamed from: n */
    public C0564l mo6635n(C0516ac acVar) {
        return new C0564l(acVar);
    }

    /* renamed from: o */
    public C0520ag mo6636o(C0516ac acVar) {
        return new C0520ag(acVar);
    }

    /* renamed from: p */
    public C0548bh mo6637p(C0516ac acVar) {
        return new C0548bh(acVar);
    }

    /* renamed from: q */
    public C0566n mo6638q(C0516ac acVar) {
        return new C0566n(acVar);
    }
}
