package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.z */
class C1747z implements C0885ac {

    /* renamed from: mi */
    private C1232gv f4411mi;

    public C1747z(C1232gv gvVar) {
        this.f4411mi = gvVar;
    }

    /* renamed from: a */
    public void mo7897a(C0888af afVar, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        this.f4411mi.mo8622a("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }
}
