package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.p001v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: ha */
public class C1188ha {

    /* renamed from: a */
    public static final int[] f4237a = {-16842910};

    /* renamed from: b */
    public static final int[] f4238b = {16842908};

    /* renamed from: c */
    public static final int[] f4239c = {16843518};

    /* renamed from: d */
    public static final int[] f4240d = {16842919};

    /* renamed from: e */
    public static final int[] f4241e = {16842912};

    /* renamed from: f */
    public static final int[] f4242f = {16842913};

    /* renamed from: g */
    public static final int[] f4243g = {-16842919, -16842908};

    /* renamed from: h */
    public static final int[] f4244h = new int[0];

    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f4245i = new ThreadLocal<>();

    /* renamed from: j */
    private static final int[] f4246j = new int[1];

    /* renamed from: a */
    public static int m5254a(Context context, int i) {
        f4246j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f4246j);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public static ColorStateList m5257b(Context context, int i) {
        f4246j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f4246j);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: c */
    public static int m5258c(Context context, int i) {
        ColorStateList b = m5257b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f4237a, b.getDefaultColor());
        }
        TypedValue a = m5256a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m5255a(context, i, a.getFloat());
    }

    /* renamed from: a */
    private static TypedValue m5256a() {
        TypedValue typedValue = f4245i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f4245i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: a */
    public static int m5255a(Context context, int i, float f) {
        int a = m5254a(context, i);
        return ColorUtils.setAlphaComponent(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
