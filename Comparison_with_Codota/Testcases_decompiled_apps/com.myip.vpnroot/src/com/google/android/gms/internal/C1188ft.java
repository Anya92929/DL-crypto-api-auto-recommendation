package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@C1130ez
/* renamed from: com.google.android.gms.internal.ft */
public final class C1188ft {

    /* renamed from: md */
    private C1232gv f3608md;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f3609mw = new Object();
    /* access modifiers changed from: private */

    /* renamed from: uq */
    public String f3610uq;
    /* access modifiers changed from: private */

    /* renamed from: ur */
    public C1216gk<C1192fv> f3611ur = new C1216gk<>();

    /* renamed from: us */
    public final C0974by f3612us = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            synchronized (C1188ft.this.f3609mw) {
                if (!C1188ft.this.f3611ur.isDone()) {
                    C1192fv fvVar = new C1192fv(1, map);
                    C1229gs.m4679W("Invalid " + fvVar.getType() + " request error: " + fvVar.mo8532cM());
                    C1188ft.this.f3611ur.mo8592a(fvVar);
                }
            }
        }
    };

    /* renamed from: ut */
    public final C0974by f3613ut = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            synchronized (C1188ft.this.f3609mw) {
                if (!C1188ft.this.f3611ur.isDone()) {
                    C1192fv fvVar = new C1192fv(-2, map);
                    String url = fvVar.getUrl();
                    if (url == null) {
                        C1229gs.m4679W("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", C1205gf.m4598a(gvVar.getContext(), map.get("check_adapters"), C1188ft.this.f3610uq));
                        fvVar.setUrl(replaceAll);
                        C1229gs.m4678V("Ad request URL modified to " + replaceAll);
                    }
                    C1188ft.this.f3611ur.mo8592a(fvVar);
                }
            }
        }
    };

    public C1188ft(String str) {
        this.f3610uq = str;
    }

    /* renamed from: b */
    public void mo8527b(C1232gv gvVar) {
        this.f3608md = gvVar;
    }

    /* renamed from: cL */
    public Future<C1192fv> mo8528cL() {
        return this.f3611ur;
    }
}
