package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ii */
public abstract class C1316ii {

    /* renamed from: Go */
    protected final C1334ip f3973Go;

    /* renamed from: Gp */
    private final String f3974Gp;

    /* renamed from: Gq */
    private C1338ir f3975Gq;

    protected C1316ii(String str, String str2, String str3) {
        C1326ik.m4985aF(str);
        this.f3974Gp = str;
        this.f3973Go = new C1334ip(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.f3973Go.mo8909aK(str3);
        }
    }

    /* renamed from: a */
    public final void mo8834a(C1338ir irVar) {
        this.f3975Gq = irVar;
        if (this.f3975Gq == null) {
            mo8839fB();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo8835a(String str, long j, String str2) throws IOException {
        this.f3973Go.mo8907a("Sending text message: %s to: %s", str, str2);
        this.f3975Gq.mo4102a(this.f3974Gp, str, j, str2);
    }

    /* renamed from: aD */
    public void mo8836aD(String str) {
    }

    /* renamed from: b */
    public void mo8837b(long j, int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: fA */
    public final long mo8838fA() {
        return this.f3975Gq.mo4104fy();
    }

    /* renamed from: fB */
    public void mo8839fB() {
    }

    public final String getNamespace() {
        return this.f3974Gp;
    }
}
