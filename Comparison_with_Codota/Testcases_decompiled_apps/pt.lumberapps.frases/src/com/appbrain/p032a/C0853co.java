package com.appbrain.p032a;

import android.content.Context;
import cmn.C0724as;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1021y;
import com.appbrain.p037f.C1035aa;
import com.appbrain.p039h.C1109b;
import com.appbrain.p039h.C1111d;
import java.util.ArrayList;

/* renamed from: com.appbrain.a.co */
public abstract class C0853co {

    /* renamed from: a */
    private final C0792ah f2260a;

    public C0853co(Context context) {
        this.f2260a = C0792ah.m3596a(context);
    }

    /* renamed from: a */
    public static C0724as m3749a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(",");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(split[i] + str2);
        }
        return new C0724as(arrayList);
    }

    /* renamed from: a */
    private C1109b m3750a(C1011o oVar, String str, C1035aa aaVar) {
        C1021y d = oVar.mo4027d();
        mo3725a(d, aaVar);
        C1111d J = C1109b.m5100J();
        J.mo4421b(C1002f.m4161a(d.mo4028d().mo3915b()));
        J.mo4419a(str);
        return J.mo4028d();
    }

    /* renamed from: a */
    public final C1109b mo3724a(C1011o oVar, String str) {
        return m3750a(oVar, str, this.f2260a.mo3634a());
    }

    /* renamed from: a */
    public abstract void mo3725a(C1021y yVar, C1035aa aaVar);

    /* renamed from: b */
    public final C1109b mo3726b(C1011o oVar, String str) {
        return m3750a(oVar, str, this.f2260a.mo3635b());
    }
}
