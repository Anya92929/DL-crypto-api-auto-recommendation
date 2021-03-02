package android.support.p009v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.cw */
class C0272cw {

    /* renamed from: a */
    private static ThreadLocal f362a;

    /* renamed from: a */
    public static float m1104a(View view) {
        return view.getElevation();
    }

    /* renamed from: a */
    private static Rect m1105a() {
        if (f362a == null) {
            f362a = new ThreadLocal();
        }
        Rect rect = (Rect) f362a.get();
        if (rect == null) {
            rect = new Rect();
            f362a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((android.support.p009v4.view.C0336ff) r3).mo1598f();
        r1 = r2.onApplyWindowInsets(r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p009v4.view.C0335fe m1106a(android.view.View r2, android.support.p009v4.view.C0335fe r3) {
        /*
            boolean r0 = r3 instanceof android.support.p009v4.view.C0336ff
            if (r0 == 0) goto L_0x0016
            r0 = r3
            android.support.v4.view.ff r0 = (android.support.p009v4.view.C0336ff) r0
            android.view.WindowInsets r0 = r0.mo1598f()
            android.view.WindowInsets r1 = r2.onApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            android.support.v4.view.ff r3 = new android.support.v4.view.ff
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.view.C0272cw.m1106a(android.view.View, android.support.v4.view.fe):android.support.v4.view.fe");
    }

    /* renamed from: a */
    public static void m1107a(View view, float f) {
        view.setElevation(f);
    }

    /* renamed from: a */
    static void m1108a(View view, int i) {
        boolean z;
        Rect a = m1105a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        C0266cq.m1078a(view, i);
        if (z && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    /* renamed from: a */
    static void m1109a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && z) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    /* renamed from: a */
    static void m1110a(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && z) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    /* renamed from: a */
    public static void m1111a(View view, C0238bp bpVar) {
        if (bpVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new C0273cx(bpVar));
        }
    }

    /* renamed from: b */
    static ColorStateList m1112b(View view) {
        return view.getBackgroundTintList();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((android.support.p009v4.view.C0336ff) r3).mo1598f();
        r1 = r2.dispatchApplyWindowInsets(r0);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p009v4.view.C0335fe m1113b(android.view.View r2, android.support.p009v4.view.C0335fe r3) {
        /*
            boolean r0 = r3 instanceof android.support.p009v4.view.C0336ff
            if (r0 == 0) goto L_0x0016
            r0 = r3
            android.support.v4.view.ff r0 = (android.support.p009v4.view.C0336ff) r0
            android.view.WindowInsets r0 = r0.mo1598f()
            android.view.WindowInsets r1 = r2.dispatchApplyWindowInsets(r0)
            if (r1 == r0) goto L_0x0016
            android.support.v4.view.ff r3 = new android.support.v4.view.ff
            r3.<init>(r1)
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.view.C0272cw.m1113b(android.view.View, android.support.v4.view.fe):android.support.v4.view.fe");
    }

    /* renamed from: b */
    static void m1114b(View view, int i) {
        boolean z;
        Rect a = m1105a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        C0266cq.m1083b(view, i);
        if (z && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    /* renamed from: c */
    static PorterDuff.Mode m1115c(View view) {
        return view.getBackgroundTintMode();
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }
}
