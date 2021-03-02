package android.support.p001v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public class ResourcesCompat {
    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0602au.m3404a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0602au.m3403a(resources, i, i2, theme);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            return C0604aw.m3407a(resources, i, i2);
        }
        return resources.getDrawable(i);
    }

    @ColorInt
    public int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0603av.m3405a(resources, i, theme);
        }
        return resources.getColor(i);
    }

    @Nullable
    public ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0603av.m3406b(resources, i, theme);
        }
        return resources.getColorStateList(i);
    }
}
