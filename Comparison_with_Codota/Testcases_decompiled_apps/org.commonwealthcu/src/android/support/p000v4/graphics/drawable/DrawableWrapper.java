package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapper */
public interface DrawableWrapper {
    Drawable getWrappedDrawable();

    void setTint(int i);

    void setTintList(ColorStateList colorStateList);

    void setTintMode(PorterDuff.Mode mode);

    void setWrappedDrawable(Drawable drawable);
}
