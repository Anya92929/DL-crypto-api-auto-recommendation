package p000;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: cs */
public class C1025cs {
    /* renamed from: a */
    public static int m4594a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    /* renamed from: a */
    public static void m4596a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }

    /* renamed from: a */
    public static void m4595a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        Gravity.apply(i, i2, i3, rect, i4, i5, rect2, i6);
    }

    /* renamed from: a */
    public static void m4597a(int i, Rect rect, Rect rect2, int i2) {
        Gravity.applyDisplay(i, rect, rect2, i2);
    }
}
