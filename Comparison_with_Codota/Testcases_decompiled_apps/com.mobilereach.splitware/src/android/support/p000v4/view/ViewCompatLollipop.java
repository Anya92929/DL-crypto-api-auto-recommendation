package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.ViewCompatLollipop */
class ViewCompatLollipop {
    private static ThreadLocal<Rect> sThreadLocalRect;

    ViewCompatLollipop() {
    }

    public static void setTransitionName(View view, String transitionName) {
        view.setTransitionName(transitionName);
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    public static void setElevation(View view, float elevation) {
        view.setElevation(elevation);
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static void setTranslationZ(View view, float translationZ) {
        view.setTranslationZ(translationZ);
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener listener) {
        if (listener == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ((WindowInsetsCompatApi21) listener.onApplyWindowInsets(view, new WindowInsetsCompatApi21(windowInsets))).unwrap();
                }
            });
        }
    }

    public static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    static void setBackgroundTintList(View view, ColorStateList tintList) {
        view.setBackgroundTintList(tintList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean hasTint = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && hasTint) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static PorterDuff.Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean hasTint = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && hasTint) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = ((android.support.p000v4.view.WindowInsetsCompatApi21) r4).unwrap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r3, android.support.p000v4.view.WindowInsetsCompat r4) {
        /*
            boolean r2 = r4 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r2 == 0) goto L_0x0016
            r2 = r4
            android.support.v4.view.WindowInsetsCompatApi21 r2 = (android.support.p000v4.view.WindowInsetsCompatApi21) r2
            android.view.WindowInsets r1 = r2.unwrap()
            android.view.WindowInsets r0 = r3.onApplyWindowInsets(r1)
            if (r0 == r1) goto L_0x0016
            android.support.v4.view.WindowInsetsCompatApi21 r4 = new android.support.v4.view.WindowInsetsCompatApi21
            r4.<init>(r0)
        L_0x0016:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.onApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = ((android.support.p000v4.view.WindowInsetsCompatApi21) r4).unwrap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View r3, android.support.p000v4.view.WindowInsetsCompat r4) {
        /*
            boolean r2 = r4 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r2 == 0) goto L_0x0016
            r2 = r4
            android.support.v4.view.WindowInsetsCompatApi21 r2 = (android.support.p000v4.view.WindowInsetsCompatApi21) r2
            android.view.WindowInsets r1 = r2.unwrap()
            android.view.WindowInsets r0 = r3.dispatchApplyWindowInsets(r1)
            if (r0 == r1) goto L_0x0016
            android.support.v4.view.WindowInsetsCompatApi21 r4 = new android.support.v4.view.WindowInsetsCompatApi21
            r4.<init>(r0)
        L_0x0016:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.dispatchApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    public static void setNestedScrollingEnabled(View view, boolean enabled) {
        view.setNestedScrollingEnabled(enabled);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean startNestedScroll(View view, int axes) {
        return view.startNestedScroll(axes);
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean dispatchNestedScroll(View view, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return view.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public static boolean dispatchNestedPreScroll(View view, int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return view.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public static boolean dispatchNestedFling(View view, float velocityX, float velocityY, boolean consumed) {
        return view.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public static boolean dispatchNestedPreFling(View view, float velocityX, float velocityY) {
        return view.dispatchNestedPreFling(velocityX, velocityY);
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    static void offsetTopAndBottom(View view, int offset) {
        Rect parentRect = getEmptyTempRect();
        boolean needInvalidateWorkaround = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View p = (View) parent;
            parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
            needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ViewCompatHC.offsetTopAndBottom(view, offset);
        if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(parentRect);
        }
    }

    static void offsetLeftAndRight(View view, int offset) {
        Rect parentRect = getEmptyTempRect();
        boolean needInvalidateWorkaround = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View p = (View) parent;
            parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
            needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ViewCompatHC.offsetLeftAndRight(view, offset);
        if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(parentRect);
        }
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
