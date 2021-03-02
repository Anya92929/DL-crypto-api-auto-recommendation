package android.support.p009v4.widget;

import android.support.p009v4.view.C0152a;
import android.support.p009v4.view.p020a.C0175f;
import android.view.View;

/* renamed from: android.support.v4.widget.t */
final class C0419t extends C0152a {

    /* renamed from: b */
    final /* synthetic */ DrawerLayout f572b;

    C0419t(DrawerLayout drawerLayout) {
        this.f572b = drawerLayout;
    }

    /* renamed from: a */
    public void mo1248a(View view, C0175f fVar) {
        super.mo1248a(view, fVar);
        if (!DrawerLayout.m1372l(view)) {
            fVar.setParent((View) null);
        }
    }
}
