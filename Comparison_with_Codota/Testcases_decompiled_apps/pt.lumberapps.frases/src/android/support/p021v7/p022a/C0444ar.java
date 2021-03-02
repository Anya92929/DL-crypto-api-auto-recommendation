package android.support.p021v7.p022a;

import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.view.C0527h;
import android.view.ActionMode;
import android.view.Window;

/* renamed from: android.support.v7.a.ar */
class C0444ar extends C0439am {

    /* renamed from: c */
    final /* synthetic */ C0443aq f610c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0444ar(C0443aq aqVar, Window.Callback callback) {
        super(aqVar, callback);
        this.f610c = aqVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final ActionMode mo2024a(ActionMode.Callback callback) {
        C0527h hVar = new C0527h(this.f610c.f589a, callback);
        C0521b b = this.f610c.mo2031b((C0522c) hVar);
        if (b != null) {
            return hVar.mo2221b(b);
        }
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f610c.mo2005n() ? mo2024a(callback) : super.onWindowStartingActionMode(callback);
    }
}
