package android.support.p021v7.p022a;

import android.support.p009v4.view.C0238bp;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0335fe;
import android.view.View;

/* renamed from: android.support.v7.a.aw */
class C0449aw implements C0238bp {

    /* renamed from: a */
    final /* synthetic */ C0447au f639a;

    C0449aw(C0447au auVar) {
        this.f639a = auVar;
    }

    /* renamed from: a */
    public C0335fe mo1441a(View view, C0335fe feVar) {
        int b = feVar.mo1594b();
        int c = this.f639a.m1902g(b);
        if (b != c) {
            feVar = feVar.mo1593a(feVar.mo1592a(), c, feVar.mo1595c(), feVar.mo1596d());
        }
        return C0247by.m889a(view, feVar);
    }
}
