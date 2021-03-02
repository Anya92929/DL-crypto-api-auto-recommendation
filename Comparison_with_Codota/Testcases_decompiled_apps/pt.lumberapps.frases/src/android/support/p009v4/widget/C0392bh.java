package android.support.p009v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.bh */
class C0392bh implements C0391bg {
    C0392bh() {
    }

    /* renamed from: a */
    public Object mo1820a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    /* renamed from: a */
    public void mo1821a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void mo1822a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    public void mo1823a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public void mo1824a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public boolean mo1825a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    /* renamed from: a */
    public boolean mo1826a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    /* renamed from: b */
    public int mo1827b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    /* renamed from: c */
    public int mo1828c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    /* renamed from: d */
    public float mo1829d(Object obj) {
        return 0.0f;
    }

    /* renamed from: e */
    public boolean mo1830e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    /* renamed from: f */
    public void mo1831f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    /* renamed from: g */
    public int mo1832g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    /* renamed from: h */
    public int mo1833h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
