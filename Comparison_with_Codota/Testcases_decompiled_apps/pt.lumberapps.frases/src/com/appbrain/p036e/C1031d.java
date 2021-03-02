package com.appbrain.p036e;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* renamed from: com.appbrain.e.d */
public final class C1031d {
    /* renamed from: a */
    public static Drawable m4306a(Drawable drawable, Resources resources) {
        Drawable newDrawable = drawable.getConstantState().newDrawable(resources);
        try {
            newDrawable.mutate();
        } catch (NullPointerException e) {
        }
        return newDrawable;
    }

    /* renamed from: a */
    public static GradientDrawable m4307a(int i, int i2, int i3, float f, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i2});
        gradientDrawable.setStroke(i4, i3);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }
}
