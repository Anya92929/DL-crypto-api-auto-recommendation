package android.support.p021v7.p022a;

import android.view.Menu;
import android.view.Window;
import java.util.List;

/* renamed from: android.support.v7.a.ao */
class C0441ao extends C0446at {

    /* renamed from: b */
    final /* synthetic */ C0440an f605b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0441ao(C0440an anVar, Window.Callback callback) {
        super(anVar, callback);
        this.f605b = anVar;
    }

    public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        C0460bg a = this.f605b.mo2027a(0, true);
        if (a == null || a.f660j == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, a.f660j, i);
        }
    }
}
