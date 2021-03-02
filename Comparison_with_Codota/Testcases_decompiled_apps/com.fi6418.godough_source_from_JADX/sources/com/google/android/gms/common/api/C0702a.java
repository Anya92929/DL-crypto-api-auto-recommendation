package com.google.android.gms.common.api;

import com.google.android.gms.common.api.C0729b;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.common.api.a */
public final class C0702a<O extends C0729b> {

    /* renamed from: a */
    private final C0742g<?, O> f4421a;

    /* renamed from: b */
    private final C0746k<?, O> f4422b = null;

    /* renamed from: c */
    private final C0744i<?> f4423c;

    /* renamed from: d */
    private final C0747l<?> f4424d;

    /* renamed from: e */
    private final String f4425e;

    public <C extends C0743h> C0702a(String str, C0742g<C, O> gVar, C0744i<C> iVar) {
        C1009bf.m4529a(gVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        C1009bf.m4529a(iVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.f4425e = str;
        this.f4421a = gVar;
        this.f4423c = iVar;
        this.f4424d = null;
    }

    /* renamed from: a */
    public C0742g<?, O> mo7350a() {
        C1009bf.m4533a(this.f4421a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f4421a;
    }

    /* renamed from: b */
    public C0746k<?, O> mo7351b() {
        C1009bf.m4533a(this.f4422b != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.f4422b;
    }

    /* renamed from: c */
    public C0744i<?> mo7352c() {
        C1009bf.m4533a(this.f4423c != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.f4423c;
    }

    /* renamed from: d */
    public boolean mo7353d() {
        return this.f4424d != null;
    }

    /* renamed from: e */
    public String mo7354e() {
        return this.f4425e;
    }
}
