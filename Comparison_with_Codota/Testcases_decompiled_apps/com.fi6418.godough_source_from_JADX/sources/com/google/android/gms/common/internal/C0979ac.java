package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: com.google.android.gms.common.internal.ac */
public final class C0979ac extends C0997au {

    /* renamed from: a */
    private C1037y f4679a;

    /* renamed from: b */
    private final int f4680b;

    public C0979ac(C1037y yVar, int i) {
        this.f4679a = yVar;
        this.f4680b = i;
    }

    /* renamed from: a */
    private void m4367a() {
        this.f4679a = null;
    }

    /* renamed from: a */
    public void mo7507a(int i, Bundle bundle) {
        C1009bf.m4529a(this.f4679a, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
        this.f4679a.mo7647a(i, bundle, this.f4680b);
        m4367a();
    }

    /* renamed from: a */
    public void mo7508a(int i, IBinder iBinder, Bundle bundle) {
        C1009bf.m4529a(this.f4679a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f4679a.mo7648a(i, iBinder, bundle, this.f4680b);
        m4367a();
    }
}
