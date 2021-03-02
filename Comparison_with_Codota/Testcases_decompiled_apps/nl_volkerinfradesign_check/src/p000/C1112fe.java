package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;

/* renamed from: fe */
public class C1112fe {
    /* renamed from: a */
    public static void m5048a(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    /* renamed from: a */
    public static ColorStateList m5047a(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    /* renamed from: a */
    public static void m5049a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }

    /* renamed from: b */
    public static PorterDuff.Mode m5050b(CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }
}
