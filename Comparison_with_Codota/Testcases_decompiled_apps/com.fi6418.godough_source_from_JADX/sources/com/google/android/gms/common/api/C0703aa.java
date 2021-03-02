package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.C1004ba;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.aa */
class C0703aa extends C1004ba {

    /* renamed from: a */
    private final WeakReference<C0758w> f4426a;

    C0703aa(C0758w wVar) {
        this.f4426a = new WeakReference<>(wVar);
    }

    /* renamed from: a */
    public void mo7355a(ResolveAccountResponse resolveAccountResponse) {
        C0758w wVar = (C0758w) this.f4426a.get();
        if (wVar != null) {
            wVar.f4533a.mo7374a((C0720ar) new C0704ab(this, wVar, wVar, resolveAccountResponse));
        }
    }
}
