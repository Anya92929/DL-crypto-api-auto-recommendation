package com.appbrain.p032a;

import android.content.Context;
import cmn.C0724as;
import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1011o;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1050ap;
import com.appbrain.p037f.C1063bb;
import com.appbrain.p037f.C1071bj;
import com.appbrain.p037f.C1082j;
import com.appbrain.p038g.C1102c;
import com.appbrain.p039h.C1109b;

/* renamed from: com.appbrain.a.dr */
public final class C0883dr extends C1102c {

    /* renamed from: a */
    private static C0883dr f2348a = null;

    /* renamed from: b */
    private final C0853co f2349b;

    private C0883dr(Context context, C0724as asVar) {
        this.f2349b = new C0866da(context);
        mo4377a(asVar);
    }

    /* renamed from: a */
    public static synchronized C0883dr m3828a(Context context) {
        C0883dr drVar;
        synchronized (C0883dr.class) {
            if (f2348a == null) {
                C0926fg.m3925a().mo3817a(context, false, false);
                C0932fm a = C0932fm.m3968a();
                f2348a = new C0883dr(context, C0853co.m3749a(a.mo3841a("adserver", C0793ai.f2083c), a.mo3841a("ppath", "/api/pb?action=")));
            }
            drVar = f2348a;
        }
        return drVar;
    }

    /* renamed from: a */
    private Object m3829a(C1011o oVar, String str, C0986aa aaVar) {
        byte[] b = mo4378b(oVar, str);
        if (b == null) {
            return null;
        }
        return aaVar.mo3918a(b);
    }

    /* renamed from: a */
    public final C1042ah mo3761a(C1050ap apVar) {
        return (C1042ah) m3829a(apVar, "ba", C1042ah.f2810b);
    }

    /* renamed from: a */
    public final C1082j mo3762a(C1063bb bbVar) {
        return (C1082j) m3829a(bbVar, "ev", C1082j.f3015b);
    }

    /* renamed from: a */
    public final C1082j mo3763a(C1071bj bjVar) {
        return (C1082j) m3829a(bjVar, "ai", C1082j.f3015b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1109b mo3755a(C1011o oVar, String str) {
        return this.f2349b.mo3726b(oVar, str);
    }
}
