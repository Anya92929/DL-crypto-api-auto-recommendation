package p000;

import android.graphics.Paint;
import android.view.View;

/* renamed from: do */
public class C1053do {
    /* renamed from: a */
    public static int m4716a(View view) {
        return view.getLabelFor();
    }

    /* renamed from: a */
    public static void m4717a(View view, int i) {
        view.setLabelFor(i);
    }

    /* renamed from: a */
    public static void m4719a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    /* renamed from: b */
    public static int m4720b(View view) {
        return view.getLayoutDirection();
    }

    /* renamed from: b */
    public static void m4721b(View view, int i) {
        view.setLayoutDirection(i);
    }

    /* renamed from: c */
    public static int m4722c(View view) {
        return view.getPaddingStart();
    }

    /* renamed from: d */
    public static int m4723d(View view) {
        return view.getPaddingEnd();
    }

    /* renamed from: a */
    public static void m4718a(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    /* renamed from: e */
    public static int m4724e(View view) {
        return view.getWindowSystemUiVisibility();
    }

    /* renamed from: f */
    public static boolean m4725f(View view) {
        return view.isPaddingRelative();
    }
}
