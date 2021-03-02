package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.ah */
public final class C0984ah extends C1037y<T>.C1038z {

    /* renamed from: e */
    final /* synthetic */ C1037y f4687e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0984ah(C1037y yVar, int i, Bundle bundle) {
        super(yVar, i, bundle);
        this.f4687e = yVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7515a(ConnectionResult connectionResult) {
        this.f4687e.f4776k.mo7359b(connectionResult);
        this.f4687e.mo7649a(connectionResult);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7516a() {
        this.f4687e.f4776k.mo7359b(ConnectionResult.f4398a);
        return true;
    }
}
