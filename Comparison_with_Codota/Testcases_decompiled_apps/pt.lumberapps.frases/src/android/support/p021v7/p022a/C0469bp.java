package android.support.p021v7.p022a;

import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.a.bp */
final class C0469bp implements C0563p {

    /* renamed from: a */
    final /* synthetic */ C0465bl f694a;

    private C0469bp(C0465bl blVar) {
        this.f694a = blVar;
    }

    /* synthetic */ C0469bp(C0465bl blVar, C0466bm bmVar) {
        this(blVar);
    }

    /* renamed from: a */
    public void mo2028a(C0562o oVar) {
        if (this.f694a.f683c == null) {
            return;
        }
        if (this.f694a.f681a.mo3103i()) {
            this.f694a.f683c.onPanelClosed(C0515k.AppCompatTheme_ratingBarStyle, oVar);
        } else if (this.f694a.f683c.onPreparePanel(0, (View) null, oVar)) {
            this.f694a.f683c.onMenuOpened(C0515k.AppCompatTheme_ratingBarStyle, oVar);
        }
    }

    /* renamed from: a */
    public boolean mo2030a(C0562o oVar, MenuItem menuItem) {
        return false;
    }
}
