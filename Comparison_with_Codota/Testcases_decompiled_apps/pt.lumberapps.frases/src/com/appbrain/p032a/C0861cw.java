package com.appbrain.p032a;

import android.content.Context;
import android.support.p009v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.AttributeSet;
import cmn.C0708ac;
import cmn.C0738bf;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1046al;

/* renamed from: com.appbrain.a.cw */
public final class C0861cw {

    /* renamed from: a */
    private final C0785aa f2283a;

    /* renamed from: b */
    private int f2284b = -1;

    public C0861cw(C0785aa aaVar) {
        this.f2283a = aaVar;
    }

    /* renamed from: a */
    public static C0962i m3778a(Context context, C1138z zVar, C1042ah ahVar, int i, int i2) {
        String str = ahVar.mo4199i() + new C0803as().mo3648b(i2).toString();
        return new C0962i(ahVar.mo4190c(i), ahVar.mo4191d(i), ahVar.mo4189b(i), new C0864cz(context, ahVar.mo4192e(i), ahVar.mo4202k(), ahVar.mo4188a(i), str, ahVar.mo4193f(i), ahVar.mo4207p() > i ? ahVar.mo4200j(i) : 0, zVar), str);
    }

    /* renamed from: a */
    static /* synthetic */ void m3779a(C0861cw cwVar, Context context, C1138z zVar, C0708ac acVar, C1042ah ahVar) {
        int i;
        C0785aa aaVar;
        int i2 = 0;
        int a = C0956gj.m4057a().mo3884a(context, ahVar);
        if (a < 0) {
            acVar.mo3385a((Object) null);
            return;
        }
        String h = (ahVar.mo4204m() == 0 ? C1046al.m4614f() : ahVar.mo4198i(a)).mo4210h();
        if (cwVar.f2283a == null) {
            i = cwVar.f2284b;
            boolean z = !TextUtils.isEmpty(h);
            if (i < 0 || i >= 4 || (!z && C0838c.m3705a(i))) {
                i = C0838c.m3698a(z);
            }
            aaVar = C0838c.m3708b(i);
        } else {
            i = 10;
            aaVar = cwVar.f2283a;
        }
        if (aaVar.mo3632a()) {
            i2 = C0738bf.m3250a(C0838c.f2210a.length);
        }
        acVar.mo3385a(new C0863cy(cwVar, h, m3778a(context, zVar, ahVar, a, (i * 1000) + FragmentTransaction.TRANSIT_ENTER_MASK + i2), C0838c.f2210a[i2], aaVar, context));
    }

    /* renamed from: a */
    public final void mo3738a(int i) {
        this.f2284b = i;
    }

    /* renamed from: a */
    public final void mo3739a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f2284b = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", "appDesign", -1);
        }
    }

    /* renamed from: a */
    public final boolean mo3740a() {
        return this.f2283a != null;
    }
}
