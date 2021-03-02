package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.p000v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.internal.widget.ThemeUtils */
public class ThemeUtils {

    /* renamed from: a */
    static final int[] f2367a = {-16842910};

    /* renamed from: b */
    static final int[] f2368b = {16842908};

    /* renamed from: c */
    static final int[] f2369c = {16843518};

    /* renamed from: d */
    static final int[] f2370d = {16842919};

    /* renamed from: e */
    static final int[] f2371e = {16842912};

    /* renamed from: f */
    static final int[] f2372f = {16842913};

    /* renamed from: g */
    static final int[] f2373g = {-16842919, -16842908};

    /* renamed from: h */
    static final int[] f2374h = new int[0];

    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f2375i = new ThreadLocal<>();

    /* renamed from: j */
    private static final int[] f2376j = new int[1];

    /* renamed from: a */
    static int m1514a(Context context, int i, float f) {
        int themeAttrColor = getThemeAttrColor(context, i);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(((float) Color.alpha(themeAttrColor)) * f));
    }

    /* renamed from: a */
    private static TypedValue m1515a() {
        TypedValue typedValue = f2375i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f2375i.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList createDisabledStateList(int i, int i2) {
        return new ColorStateList(new int[][]{f2367a, f2374h}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f2367a, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue a = m1515a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m1514a(context, i, a.getFloat());
    }

    public static int getThemeAttrColor(Context context, int i) {
        f2376j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f2376j);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i) {
        f2376j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f2376j);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
