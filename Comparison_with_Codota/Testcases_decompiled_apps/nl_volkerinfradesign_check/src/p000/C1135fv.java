package p000;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/* renamed from: fv */
public class C1135fv {
    /* renamed from: a */
    public static void m5119a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Drawable drawable5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            drawable5 = drawable3;
        } else {
            drawable5 = drawable;
        }
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    /* renamed from: b */
    public static void m5120b(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Drawable drawable5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            drawable5 = drawable3;
        } else {
            drawable5 = drawable;
        }
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
    }

    /* renamed from: a */
    public static void m5118a(@NonNull TextView textView, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            i5 = i3;
        } else {
            i5 = i;
        }
        if (!z) {
            i = i3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
    }
}
