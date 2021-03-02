package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.view.C0333fc;
import android.view.View;

/* renamed from: android.support.v7.a.be */
class C0458be extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ C0457bd f649a;

    C0458be(C0457bd bdVar) {
        this.f649a = bdVar;
    }

    public void onAnimationEnd(View view) {
        this.f649a.f647a.f625n.setVisibility(8);
        if (this.f649a.f647a.f626o != null) {
            this.f649a.f647a.f626o.dismiss();
        } else if (this.f649a.f647a.f625n.getParent() instanceof View) {
            C0247by.requestApplyInsets((View) this.f649a.f647a.f625n.getParent());
        }
        this.f649a.f647a.f625n.removeAllViews();
        this.f649a.f647a.f628q.mo1554a((C0332fb) null);
        this.f649a.f647a.f628q = null;
    }
}
