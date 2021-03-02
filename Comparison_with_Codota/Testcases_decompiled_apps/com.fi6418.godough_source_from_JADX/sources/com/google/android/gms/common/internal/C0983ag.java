package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.ag */
public final class C0983ag extends C1037y<T>.C1038z {

    /* renamed from: e */
    final /* synthetic */ C1037y f4686e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0983ag(C1037y yVar) {
        super(yVar, 0, (Bundle) null);
        this.f4686e = yVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7513a(ConnectionResult connectionResult) {
        this.f4686e.f4776k.mo7358a(connectionResult);
        this.f4686e.mo7649a(connectionResult);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7514a() {
        this.f4686e.f4776k.mo7358a(ConnectionResult.f4398a);
        return true;
    }
}
