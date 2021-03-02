package android.support.p021v7.p022a;

import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;

/* renamed from: android.support.v7.a.bo */
final class C0468bo implements C0539af {

    /* renamed from: a */
    final /* synthetic */ C0465bl f692a;

    /* renamed from: b */
    private boolean f693b;

    private C0468bo(C0465bl blVar) {
        this.f692a = blVar;
    }

    /* synthetic */ C0468bo(C0465bl blVar, C0466bm bmVar) {
        this(blVar);
    }

    /* renamed from: a */
    public void mo2041a(C0562o oVar, boolean z) {
        if (!this.f693b) {
            this.f693b = true;
            this.f692a.f681a.mo3108n();
            if (this.f692a.f683c != null) {
                this.f692a.f683c.onPanelClosed(C0515k.AppCompatTheme_ratingBarStyle, oVar);
            }
            this.f693b = false;
        }
    }

    /* renamed from: a */
    public boolean mo2042a(C0562o oVar) {
        if (this.f692a.f683c == null) {
            return false;
        }
        this.f692a.f683c.onMenuOpened(C0515k.AppCompatTheme_ratingBarStyle, oVar);
        return true;
    }
}
