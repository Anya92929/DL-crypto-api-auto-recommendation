package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.p001v4.view.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;

/* renamed from: dr */
public class C1056dr {
    /* renamed from: a */
    public static void m4738a(View view, String str) {
        view.setTransitionName(str);
    }

    /* renamed from: a */
    public static String m4733a(View view) {
        return view.getTransitionName();
    }

    /* renamed from: b */
    public static void m4746b(View view) {
        view.requestApplyInsets();
    }

    /* renamed from: a */
    public static void m4734a(View view, float f) {
        view.setElevation(f);
    }

    /* renamed from: c */
    public static float m4748c(View view) {
        return view.getElevation();
    }

    /* renamed from: b */
    public static void m4747b(View view, float f) {
        view.setTranslationZ(f);
    }

    /* renamed from: d */
    public static float m4749d(View view) {
        return view.getTranslationZ();
    }

    /* renamed from: a */
    public static void m4737a(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return ((C1076eg) onApplyWindowInsetsListener.onApplyWindowInsets(view, new C1076eg(windowInsets))).mo8090a();
            }
        });
    }

    /* renamed from: e */
    public static ColorStateList m4750e(View view) {
        return view.getBackgroundTintList();
    }

    /* renamed from: a */
    public static void m4735a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    /* renamed from: f */
    public static PorterDuff.Mode m4751f(View view) {
        return view.getBackgroundTintMode();
    }

    /* renamed from: a */
    public static void m4736a(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((p000.C1076eg) r3).mo8090a();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p001v4.view.WindowInsetsCompat m4732a(android.view.View r2, android.support.p001v4.view.WindowInsetsCompat r3) {
        /*
            boolean r0 = r3 instanceof p000.C1076eg
            if (r0 == 0) goto L_0x0016
            r0 = r3
            eg r0 = (p000.C1076eg) r0
            android.view.WindowInsets r0 = r0.mo8090a()
            android.view.WindowInsets r1 = r2.onApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            eg r3 = new eg
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1056dr.m4732a(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((p000.C1076eg) r3).mo8090a();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p001v4.view.WindowInsetsCompat m4745b(android.view.View r2, android.support.p001v4.view.WindowInsetsCompat r3) {
        /*
            boolean r0 = r3 instanceof p000.C1076eg
            if (r0 == 0) goto L_0x0016
            r0 = r3
            eg r0 = (p000.C1076eg) r0
            android.view.WindowInsets r0 = r0.mo8090a()
            android.view.WindowInsets r1 = r2.dispatchApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            eg r3 = new eg
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1056dr.m4745b(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    /* renamed from: a */
    public static void m4739a(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    /* renamed from: g */
    public static boolean m4752g(View view) {
        return view.isNestedScrollingEnabled();
    }

    /* renamed from: a */
    public static boolean m4742a(View view, int i) {
        return view.startNestedScroll(i);
    }

    /* renamed from: h */
    public static void m4753h(View view) {
        view.stopNestedScroll();
    }

    /* renamed from: i */
    public static boolean m4754i(View view) {
        return view.hasNestedScrollingParent();
    }

    /* renamed from: a */
    public static boolean m4743a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* renamed from: a */
    public static boolean m4744a(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    /* renamed from: a */
    public static boolean m4741a(View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    /* renamed from: a */
    public static boolean m4740a(View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    /* renamed from: j */
    public static float m4755j(View view) {
        return view.getZ();
    }
}
