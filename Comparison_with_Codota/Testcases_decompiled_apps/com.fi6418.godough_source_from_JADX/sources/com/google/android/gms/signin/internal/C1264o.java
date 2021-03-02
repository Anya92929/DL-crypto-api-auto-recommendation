package com.google.android.gms.signin.internal;

import com.google.android.gms.common.api.C0754s;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.C1247g;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.signin.internal.o */
class C1264o extends C1254e {

    /* renamed from: a */
    private final C1247g f5291a;

    /* renamed from: b */
    private final ExecutorService f5292b;

    public C1264o(C1247g gVar, ExecutorService executorService) {
        this.f5291a = gVar;
        this.f5292b = executorService;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0754s m5245a() {
        return this.f5291a.mo9022d();
    }

    /* renamed from: a */
    public void mo9044a(String str, String str2, C1258i iVar) {
        this.f5292b.submit(new C1266q(this, str, str2, iVar));
    }

    /* renamed from: a */
    public void mo9045a(String str, List<Scope> list, C1258i iVar) {
        this.f5292b.submit(new C1265p(this, list, str, iVar));
    }
}
