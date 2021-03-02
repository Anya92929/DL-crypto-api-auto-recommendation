package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.C1251b;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.y */
class C0760y extends C1251b {

    /* renamed from: a */
    private final WeakReference<C0758w> f4556a;

    C0760y(C0758w wVar) {
        this.f4556a = new WeakReference<>(wVar);
    }

    /* renamed from: a */
    public void mo7456a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        C0758w wVar = (C0758w) this.f4556a.get();
        if (wVar != null) {
            wVar.f4533a.mo7374a((C0720ar) new C0761z(this, wVar, wVar, connectionResult));
        }
    }
}
