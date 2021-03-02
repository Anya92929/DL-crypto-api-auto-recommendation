package android.support.p021v7.p022a;

import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.view.Menu;
import android.view.Window;

/* renamed from: android.support.v7.a.bh */
final class C0461bh implements C0539af {

    /* renamed from: a */
    final /* synthetic */ C0447au f670a;

    private C0461bh(C0447au auVar) {
        this.f670a = auVar;
    }

    /* synthetic */ C0461bh(C0447au auVar, C0448av avVar) {
        this(auVar);
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        C0562o p = oVar.mo2377p();
        boolean z2 = p != oVar;
        C0447au auVar = this.f670a;
        if (z2) {
            oVar = p;
        }
        C0460bg a = auVar.m1875a((Menu) oVar);
        if (a == null) {
            return;
        }
        if (z2) {
            this.f670a.m1876a(a.f651a, a, (Menu) p);
            this.f670a.m1882a(a, true);
            return;
        }
        this.f670a.m1882a(a, z);
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        Window.Callback p;
        if (oVar != null || !this.f670a.f596h || (p = this.f670a.mo2007p()) == null || this.f670a.mo2006o()) {
            return true;
        }
        p.onMenuOpened(C0515k.AppCompatTheme_ratingBarStyle, oVar);
        return true;
    }
}
