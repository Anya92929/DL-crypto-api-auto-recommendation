package android.support.p009v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.at */
public final class C0377at {

    /* renamed from: a */
    static final C0383az f510a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f510a = new C0379av();
        } else if (i >= 21) {
            f510a = new C0378au();
        } else if (i >= 19) {
            f510a = new C0382ay();
        } else if (i >= 9) {
            f510a = new C0381ax();
        } else {
            f510a = new C0380aw();
        }
    }

    /* renamed from: a */
    public static void m1543a(PopupWindow popupWindow, int i) {
        f510a.mo1803a(popupWindow, i);
    }

    /* renamed from: a */
    public static void m1544a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f510a.mo1804a(popupWindow, view, i, i2, i3);
    }

    /* renamed from: a */
    public static void m1545a(PopupWindow popupWindow, boolean z) {
        f510a.mo1802a(popupWindow, z);
    }
}
