package com.appbrain.p032a;

import android.content.Context;
import cmn.C0724as;
import com.appbrain.p033b.C1011o;
import com.appbrain.p037f.C1082j;
import com.appbrain.p037f.C1094v;
import com.appbrain.p038g.C1102c;
import com.appbrain.p039h.C1109b;

/* renamed from: com.appbrain.a.dl */
public final class C0877dl extends C1102c {

    /* renamed from: a */
    private static C0877dl f2335a = null;

    /* renamed from: b */
    private final C0853co f2336b;

    private C0877dl(Context context, C0724as asVar) {
        this.f2336b = new C0878dm(this, context);
        mo4377a(asVar);
    }

    /* renamed from: a */
    public static synchronized C0877dl m3808a(Context context) {
        C0877dl dlVar;
        synchronized (C0877dl.class) {
            if (f2335a == null) {
                C0926fg.m3925a().mo3817a(context, false, false);
                C0932fm a = C0932fm.m3968a();
                f2335a = new C0877dl(context, C0853co.m3749a(a.mo3841a("pserver", C0793ai.f2082b), a.mo3841a("ppath", "/api/pb?action=")));
            }
            dlVar = f2335a;
        }
        return dlVar;
    }

    /* renamed from: a */
    public final C1082j mo3754a(C1094v vVar) {
        byte[] b = mo4378b(vVar, "up");
        if (b == null) {
            return null;
        }
        return C1082j.m4957a(b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1109b mo3755a(C1011o oVar, String str) {
        return this.f2336b.mo3726b(oVar, str);
    }
}
