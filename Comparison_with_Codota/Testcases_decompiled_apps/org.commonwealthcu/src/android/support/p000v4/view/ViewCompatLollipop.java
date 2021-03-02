package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.ViewCompatLollipop */
class ViewCompatLollipop {
    ViewCompatLollipop() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((android.support.p000v4.view.WindowInsetsCompatApi21) r3).unwrap();
        r1 = r2.dispatchApplyWindowInsets(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View r2, android.support.p000v4.view.WindowInsetsCompat r3) {
        /*
            boolean r0 = r3 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r0 == 0) goto L_0x0016
            r0 = r3
            android.support.v4.view.WindowInsetsCompatApi21 r0 = (android.support.p000v4.view.WindowInsetsCompatApi21) r0
            android.view.WindowInsets r0 = r0.unwrap()
            android.view.WindowInsets r1 = r2.dispatchApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            android.support.v4.view.WindowInsetsCompatApi21 r3 = new android.support.v4.view.WindowInsetsCompatApi21
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.dispatchApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    static PorterDuff.Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((android.support.p000v4.view.WindowInsetsCompatApi21) r3).unwrap();
        r1 = r2.onApplyWindowInsets(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r2, android.support.p000v4.view.WindowInsetsCompat r3) {
        /*
            boolean r0 = r3 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r0 == 0) goto L_0x0016
            r0 = r3
            android.support.v4.view.WindowInsetsCompatApi21 r0 = (android.support.p000v4.view.WindowInsetsCompatApi21) r0
            android.view.WindowInsets r0 = r0.unwrap()
            android.view.WindowInsets r1 = r2.onApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            android.support.v4.view.WindowInsetsCompatApi21 r3 = new android.support.v4.view.WindowInsetsCompatApi21
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.onApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void setElevation(View view, float f) {
        view.setElevation(f);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return ((WindowInsetsCompatApi21) OnApplyWindowInsetsListener.this.onApplyWindowInsets(view, new WindowInsetsCompatApi21(windowInsets))).unwrap();
            }
        });
    }

    public static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    public static void setTranslationZ(View view, float f) {
        view.setTranslationZ(f);
    }

    public static boolean startNestedScroll(View view, int i) {
        return view.startNestedScroll(i);
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }
}
