package android.support.p009v4.view;

import android.view.View;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.cf */
class C0255cf extends C0253cd {

    /* renamed from: b */
    static boolean f359b = false;

    C0255cf() {
    }

    /* renamed from: a */
    public void mo1485a(View view, C0152a aVar) {
        C0267cr.m1088a(view, aVar == null ? null : aVar.mo1246a());
    }

    /* renamed from: a */
    public boolean mo1490a(View view, int i) {
        return C0267cr.m1089a(view, i);
    }

    /* renamed from: b */
    public boolean mo1495b(View view, int i) {
        return C0267cr.m1090b(view, i);
    }

    /* renamed from: k */
    public C0314ek mo1511k(View view) {
        if (this.f355a == null) {
            this.f355a = new WeakHashMap();
        }
        C0314ek ekVar = (C0314ek) this.f355a.get(view);
        if (ekVar != null) {
            return ekVar;
        }
        C0314ek ekVar2 = new C0314ek(view);
        this.f355a.put(view, ekVar2);
        return ekVar2;
    }
}
