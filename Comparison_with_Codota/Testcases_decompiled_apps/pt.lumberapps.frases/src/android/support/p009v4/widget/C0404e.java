package android.support.p009v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.e */
public final class C0404e {

    /* renamed from: a */
    private static final C0407h f555a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f555a = new C0405f();
        } else if (i >= 21) {
            f555a = new C0408i();
        } else {
            f555a = new C0406g();
        }
    }

    /* renamed from: a */
    public static Drawable m1704a(CompoundButton compoundButton) {
        return f555a.mo1873a(compoundButton);
    }

    /* renamed from: a */
    public static void m1705a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f555a.mo1874a(compoundButton, colorStateList);
    }

    /* renamed from: a */
    public static void m1706a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        f555a.mo1875a(compoundButton, mode);
    }
}
