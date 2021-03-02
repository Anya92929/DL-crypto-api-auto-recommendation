package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* renamed from: android.support.v4.widget.TintableCompoundButton */
public interface TintableCompoundButton {
    ColorStateList getSupportButtonTintList();

    PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(ColorStateList colorStateList);

    void setSupportButtonTintMode(PorterDuff.Mode mode);
}
