package android.support.p021v7.widget;

import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0547an;
import android.support.p021v7.view.menu.C0562o;

/* renamed from: android.support.v7.widget.s */
class C0697s implements C0539af {

    /* renamed from: a */
    final /* synthetic */ C0689k f1718a;

    private C0697s(C0689k kVar) {
        this.f1718a = kVar;
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        if (oVar instanceof C0547an) {
            oVar.mo2377p().mo2454a(false);
        }
        C0539af a = this.f1718a.mo2400a();
        if (a != null) {
            a.mo2041a(oVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        if (oVar == null) {
            return false;
        }
        this.f1718a.f1690h = ((C0547an) oVar).getItem().getItemId();
        C0539af a = this.f1718a.mo2400a();
        return a != null ? a.mo2042a(oVar) : false;
    }
}
