package android.support.p021v7.p022a;

import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.view.Window;

/* renamed from: android.support.v7.a.bc */
final class C0456bc implements C0539af {

    /* renamed from: a */
    final /* synthetic */ C0447au f646a;

    private C0456bc(C0447au auVar) {
        this.f646a = auVar;
    }

    /* synthetic */ C0456bc(C0447au auVar, C0448av avVar) {
        this(auVar);
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        this.f646a.m1890b(oVar);
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        Window.Callback p = this.f646a.mo2007p();
        if (p == null) {
            return true;
        }
        p.onMenuOpened(C0515k.AppCompatTheme_ratingBarStyle, oVar);
        return true;
    }
}
