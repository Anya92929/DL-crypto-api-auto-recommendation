package android.support.p021v7.widget;

import android.content.Context;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.view.menu.C0536ac;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.view.View;

/* renamed from: android.support.v7.widget.r */
class C0696r extends C0536ac {

    /* renamed from: a */
    final /* synthetic */ C0689k f1717a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0696r(C0689k kVar, Context context, C0562o oVar, View view, boolean z) {
        super(context, oVar, view, z, C0506b.actionOverflowMenuStyle);
        this.f1717a = kVar;
        mo2322a(8388613);
        mo2323a((C0539af) kVar.f1689g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo2329e() {
        if (this.f1717a.f1042c != null) {
            this.f1717a.f1042c.close();
        }
        C0696r unused = this.f1717a.f1706x = null;
        super.mo2329e();
    }
}
