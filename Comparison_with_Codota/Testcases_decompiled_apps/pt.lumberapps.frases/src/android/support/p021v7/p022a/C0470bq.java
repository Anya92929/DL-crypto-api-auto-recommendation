package android.support.p021v7.p022a;

import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;

/* renamed from: android.support.v7.a.bq */
final class C0470bq implements C0539af {

    /* renamed from: a */
    final /* synthetic */ C0465bl f695a;

    private C0470bq(C0465bl blVar) {
        this.f695a = blVar;
    }

    /* synthetic */ C0470bq(C0465bl blVar, C0466bm bmVar) {
        this(blVar);
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        if (this.f695a.f683c != null) {
            this.f695a.f683c.onPanelClosed(0, oVar);
        }
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        if (oVar != null || this.f695a.f683c == null) {
            return true;
        }
        this.f695a.f683c.onMenuOpened(0, oVar);
        return true;
    }
}
