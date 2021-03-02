package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.p009v4.p012b.C0094a;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.di */
class C0665di {

    /* renamed from: a */
    static final int[] f1633a = {-16842910};

    /* renamed from: b */
    static final int[] f1634b = {16842908};

    /* renamed from: c */
    static final int[] f1635c = {16843518};

    /* renamed from: d */
    static final int[] f1636d = {16842919};

    /* renamed from: e */
    static final int[] f1637e = {16842912};

    /* renamed from: f */
    static final int[] f1638f = {16842913};

    /* renamed from: g */
    static final int[] f1639g = {-16842919, -16842908};

    /* renamed from: h */
    static final int[] f1640h = new int[0];

    /* renamed from: i */
    private static final ThreadLocal f1641i = new ThreadLocal();

    /* renamed from: j */
    private static final int[] f1642j = new int[1];

    /* renamed from: a */
    public static int m3003a(Context context, int i) {
        f1642j[0] = i;
        C0670dn a = C0670dn.m3013a(context, (AttributeSet) null, f1642j);
        try {
            return a.mo3321b(0, 0);
        } finally {
            a.mo3319a();
        }
    }

    /* renamed from: a */
    static int m3004a(Context context, int i, float f) {
        int a = m3003a(context, i);
        return C0094a.m192b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    /* renamed from: a */
    private static TypedValue m3005a() {
        TypedValue typedValue = (TypedValue) f1641i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1641i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: b */
    public static ColorStateList m3006b(Context context, int i) {
        f1642j[0] = i;
        C0670dn a = C0670dn.m3013a(context, (AttributeSet) null, f1642j);
        try {
            return a.mo3328e(0);
        } finally {
            a.mo3319a();
        }
    }

    /* renamed from: c */
    public static int m3007c(Context context, int i) {
        ColorStateList b = m3006b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1633a, b.getDefaultColor());
        }
        TypedValue a = m3005a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m3004a(context, i, a.getFloat());
    }
}
