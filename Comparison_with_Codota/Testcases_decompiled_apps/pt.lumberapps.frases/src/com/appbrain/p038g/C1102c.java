package com.appbrain.p038g;

import android.util.SparseArray;
import cmn.C0722aq;
import cmn.C0724as;
import cmn.C0725at;
import cmn.C0752n;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1020x;
import com.appbrain.p034c.C1024a;
import com.appbrain.p039h.C1109b;
import com.appbrain.p039h.C1111d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.appbrain.g.c */
public class C1102c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f3074a = "There was a network error, please try again.";

    /* renamed from: b */
    private final C1105f f3075b = new C1105f(new C1101b());

    /* renamed from: c */
    private C0722aq f3076c;

    /* renamed from: d */
    private final List f3077d = new ArrayList();

    protected C1102c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1109b mo3755a(C1011o oVar, String str) {
        C1111d J = C1109b.m5100J();
        J.mo4415a(2);
        J.mo4421b(C1002f.m4161a(oVar.mo3915b()));
        J.mo4419a(str);
        J.mo4420b(C0752n.m3278b().mo3432f());
        for (C1103d dVar : this.f3077d) {
            C1020x a = dVar.mo4379a();
            if (a != null) {
                J.mo4423c(a.mo3914a());
                J.mo4422c(dVar.mo4380b());
            }
        }
        return J.mo4028d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo4377a(C0724as asVar) {
        this.f3076c = new C0722aq(asVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final byte[] mo4378b(C1011o oVar, String str) {
        C1104e eVar;
        C0725at.m3231b();
        if (str.indexOf(36) != -1) {
            str = str.substring(str.lastIndexOf(36) + 1);
        }
        byte[] a = this.f3076c.mo3408a(str, this.f3075b.mo4381a(mo3755a(oVar, str)).mo3915b());
        if (a == null) {
            eVar = null;
        } else {
            C1109b a2 = C1109b.m5113a(a);
            this.f3075b.mo4382b(a2);
            C1104e a3 = C1104e.m5089a(a2);
            if (a2.mo4391I() != 0) {
                if (a2.mo4391I() != a2.mo4390H()) {
                    throw new IllegalStateException("RPC extension count not matching " + a2.mo4391I() + " " + a2.mo4390H());
                }
                SparseArray sparseArray = new SparseArray(a2.mo4391I());
                for (int i = 0; i < a2.mo4391I(); i++) {
                    sparseArray.put(a2.mo4393a(i), a2.mo4394b(i));
                }
                for (C1103d b : this.f3077d) {
                    sparseArray.get(b.mo4380b());
                }
            }
            eVar = a3;
        }
        if (eVar.f3079b == null) {
            return eVar.f3078a;
        }
        throw new C1024a(eVar.f3079b);
    }
}
