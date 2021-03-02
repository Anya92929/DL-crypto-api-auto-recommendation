package android.support.p021v7.widget;

import android.support.p021v7.view.menu.C0533a;
import android.view.View;

/* renamed from: android.support.v7.widget.dw */
class C0679dw implements View.OnClickListener {

    /* renamed from: a */
    final C0533a f1677a = new C0533a(this.f1678b.f1659a.getContext(), 0, 16908332, 0, 0, this.f1678b.f1667i);

    /* renamed from: b */
    final /* synthetic */ C0678dv f1678b;

    C0679dw(C0678dv dvVar) {
        this.f1678b = dvVar;
    }

    public void onClick(View view) {
        if (this.f1678b.f1670l != null && this.f1678b.f1671m) {
            this.f1678b.f1670l.onMenuItemSelected(0, this.f1677a);
        }
    }
}
