package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.support.p009v4.p010a.C0025a;
import android.util.Log;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.br */
class C0620br {

    /* renamed from: a */
    private static final ThreadLocal f1484a = new ThreadLocal();

    /* renamed from: a */
    static ColorStateList m2806a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList c = m2809c(context, i);
        return c == null ? C0025a.getColorStateList(context, i) : c;
    }

    /* renamed from: a */
    private static TypedValue m2807a() {
        TypedValue typedValue = (TypedValue) f1484a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1484a.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: b */
    static boolean m2808b(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = m2807a();
        resources.getValue(i, a, true);
        return a.type >= 28 && a.type <= 31;
    }

    /* renamed from: c */
    private static ColorStateList m2809c(Context context, int i) {
        if (m2808b(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0589an.m2718a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("ColorStateListUtils", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }
}
