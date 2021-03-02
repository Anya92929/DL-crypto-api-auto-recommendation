package p000;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* renamed from: ft */
public class C1133ft {

    /* renamed from: a */
    private static Field f4093a;

    /* renamed from: b */
    private static boolean f4094b;

    /* renamed from: c */
    private static Field f4095c;

    /* renamed from: d */
    private static boolean f4096d;

    /* renamed from: e */
    private static Field f4097e;

    /* renamed from: f */
    private static boolean f4098f;

    /* renamed from: g */
    private static Field f4099g;

    /* renamed from: h */
    private static boolean f4100h;

    /* renamed from: a */
    public static int m5112a(TextView textView) {
        if (!f4096d) {
            f4095c = m5114a("mMaxMode");
            f4096d = true;
        }
        if (f4095c != null && m5113a(f4095c, textView) == 1) {
            if (!f4094b) {
                f4093a = m5114a("mMaximum");
                f4094b = true;
            }
            if (f4093a != null) {
                return m5113a(f4093a, textView);
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m5115b(TextView textView) {
        if (!f4100h) {
            f4099g = m5114a("mMinMode");
            f4100h = true;
        }
        if (f4099g != null && m5113a(f4099g, textView) == 1) {
            if (!f4098f) {
                f4097e = m5114a("mMinimum");
                f4098f = true;
            }
            if (f4097e != null) {
                return m5113a(f4097e, textView);
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static Field m5114a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    /* renamed from: a */
    private static int m5113a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }
}
