package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.CompoundButtonCompatLollipop */
class CompoundButtonCompatLollipop {
    CompoundButtonCompatLollipop() {
    }

    /* renamed from: a */
    static ColorStateList m1021a(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    /* renamed from: a */
    static void m1022a(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    /* renamed from: a */
    static void m1023a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }

    /* renamed from: b */
    static PorterDuff.Mode m1024b(CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }
}
