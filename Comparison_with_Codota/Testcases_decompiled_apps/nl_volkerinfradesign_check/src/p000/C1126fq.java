package p000;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: fq */
public class C1126fq {
    /* renamed from: a */
    public static Object m5076a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    /* renamed from: a */
    public static boolean m5082a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    /* renamed from: b */
    public static int m5084b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    /* renamed from: c */
    public static int m5086c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    /* renamed from: d */
    public static boolean m5087d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    /* renamed from: a */
    public static void m5078a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m5079a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    public static void m5080a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public static void m5081a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    /* renamed from: e */
    public static void m5088e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    /* renamed from: a */
    public static void m5077a(Object obj, int i, int i2, int i3) {
        ((OverScroller) obj).notifyHorizontalEdgeReached(i, i2, i3);
    }

    /* renamed from: b */
    public static void m5085b(Object obj, int i, int i2, int i3) {
        ((OverScroller) obj).notifyVerticalEdgeReached(i, i2, i3);
    }

    /* renamed from: f */
    public static boolean m5089f(Object obj) {
        return ((OverScroller) obj).isOverScrolled();
    }

    /* renamed from: g */
    public static int m5090g(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    /* renamed from: h */
    public static int m5091h(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }

    /* renamed from: a */
    public static boolean m5083a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }
}
