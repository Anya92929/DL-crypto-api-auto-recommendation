package com.appbrain.p032a;

import cmn.C0726au;
import com.appbrain.p037f.C1071bj;
import com.appbrain.p037f.C1082j;

/* renamed from: com.appbrain.a.ca */
final class C0839ca extends C0726au {

    /* renamed from: c */
    final /* synthetic */ C1071bj f2213c;

    /* renamed from: d */
    final /* synthetic */ C0800ap f2214d;

    C0839ca(C0800ap apVar, C1071bj bjVar) {
        this.f2214d = apVar;
        this.f2213c = bjVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1082j mo3411a() {
        try {
            return C0883dr.m3828a(this.f2214d.f2101a).mo3763a(this.f2213c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo3412a(Object obj) {
        C1082j jVar = (C1082j) obj;
        if (jVar != null) {
            C0932fm.m3970a(this.f2214d.f2101a, jVar.mo4342h());
        }
    }
}
