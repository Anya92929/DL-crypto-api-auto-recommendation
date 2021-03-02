package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.view.C0333fc;
import android.view.View;

/* renamed from: android.support.v7.a.bb */
class C0455bb extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ C0447au f645a;

    C0455bb(C0447au auVar) {
        this.f645a = auVar;
    }

    public void onAnimationEnd(View view) {
        C0247by.m903b((View) this.f645a.f625n, 1.0f);
        this.f645a.f628q.mo1554a((C0332fb) null);
        this.f645a.f628q = null;
    }

    public void onAnimationStart(View view) {
        this.f645a.f625n.setVisibility(0);
        this.f645a.f625n.sendAccessibilityEvent(32);
        if (this.f645a.f625n.getParent() != null) {
            C0247by.requestApplyInsets((View) this.f645a.f625n.getParent());
        }
    }
}
