package android.support.p021v7.p022a;

import android.view.ActionMode;
import android.view.Window;

/* renamed from: android.support.v7.a.at */
class C0446at extends C0444ar {

    /* renamed from: d */
    final /* synthetic */ C0445as f612d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0446at(C0445as asVar, Window.Callback callback) {
        super(asVar, callback);
        this.f612d = asVar;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.f612d.mo2005n()) {
            switch (i) {
                case 0:
                    return mo2024a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
