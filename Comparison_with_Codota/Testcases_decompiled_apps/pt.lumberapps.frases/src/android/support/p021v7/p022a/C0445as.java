package android.support.p021v7.p022a;

import android.app.UiModeManager;
import android.content.Context;
import android.view.Window;

/* renamed from: android.support.v7.a.as */
class C0445as extends C0443aq {

    /* renamed from: r */
    private final UiModeManager f611r;

    C0445as(Context context, Window window, C0434ah ahVar) {
        super(context, window, ahVar);
        this.f611r = (UiModeManager) context.getSystemService("uimode");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo1996a(Window.Callback callback) {
        return new C0446at(this, callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo2023d(int i) {
        if (i == 0 && this.f611r.getNightMode() == 0) {
            return -1;
        }
        return super.mo2023d(i);
    }
}
