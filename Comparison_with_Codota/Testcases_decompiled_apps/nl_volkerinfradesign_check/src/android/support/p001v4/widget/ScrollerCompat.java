package android.support.p001v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.widget.ScrollerCompat */
public class ScrollerCompat {

    /* renamed from: a */
    Object f1284a;

    /* renamed from: b */
    C0433a f1285b;

    /* renamed from: android.support.v4.widget.ScrollerCompat$a */
    interface C0433a {
        /* renamed from: a */
        Object mo2901a(Context context, Interpolator interpolator);

        /* renamed from: a */
        void mo2902a(Object obj, int i, int i2, int i3);

        /* renamed from: a */
        void mo2903a(Object obj, int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo2904a(Object obj, int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo2905a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        /* renamed from: a */
        void mo2906a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        /* renamed from: a */
        boolean mo2907a(Object obj);

        /* renamed from: a */
        boolean mo2908a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        /* renamed from: b */
        int mo2909b(Object obj);

        /* renamed from: b */
        void mo2910b(Object obj, int i, int i2, int i3);

        /* renamed from: c */
        int mo2911c(Object obj);

        /* renamed from: d */
        float mo2912d(Object obj);

        /* renamed from: e */
        boolean mo2913e(Object obj);

        /* renamed from: f */
        void mo2914f(Object obj);

        /* renamed from: g */
        boolean mo2915g(Object obj);

        /* renamed from: h */
        int mo2916h(Object obj);

        /* renamed from: i */
        int mo2917i(Object obj);
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$b */
    static class C0434b implements C0433a {
        C0434b() {
        }

        /* renamed from: a */
        public Object mo2901a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        /* renamed from: a */
        public boolean mo2907a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        /* renamed from: b */
        public int mo2909b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        /* renamed from: c */
        public int mo2911c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        /* renamed from: d */
        public float mo2912d(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: e */
        public boolean mo2913e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        /* renamed from: a */
        public void mo2903a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo2904a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public void mo2905a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        /* renamed from: a */
        public void mo2906a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        /* renamed from: f */
        public void mo2914f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        /* renamed from: a */
        public void mo2902a(Object obj, int i, int i2, int i3) {
        }

        /* renamed from: b */
        public void mo2910b(Object obj, int i, int i2, int i3) {
        }

        /* renamed from: g */
        public boolean mo2915g(Object obj) {
            return false;
        }

        /* renamed from: h */
        public int mo2916h(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        /* renamed from: i */
        public int mo2917i(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        /* renamed from: a */
        public boolean mo2908a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$c */
    static class C0435c implements C0433a {
        C0435c() {
        }

        /* renamed from: a */
        public Object mo2901a(Context context, Interpolator interpolator) {
            return C1126fq.m5076a(context, interpolator);
        }

        /* renamed from: a */
        public boolean mo2907a(Object obj) {
            return C1126fq.m5082a(obj);
        }

        /* renamed from: b */
        public int mo2909b(Object obj) {
            return C1126fq.m5084b(obj);
        }

        /* renamed from: c */
        public int mo2911c(Object obj) {
            return C1126fq.m5086c(obj);
        }

        /* renamed from: d */
        public float mo2912d(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: e */
        public boolean mo2913e(Object obj) {
            return C1126fq.m5087d(obj);
        }

        /* renamed from: a */
        public void mo2903a(Object obj, int i, int i2, int i3, int i4) {
            C1126fq.m5078a(obj, i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo2904a(Object obj, int i, int i2, int i3, int i4, int i5) {
            C1126fq.m5079a(obj, i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public void mo2905a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C1126fq.m5080a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        /* renamed from: a */
        public void mo2906a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            C1126fq.m5081a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        /* renamed from: f */
        public void mo2914f(Object obj) {
            C1126fq.m5088e(obj);
        }

        /* renamed from: a */
        public void mo2902a(Object obj, int i, int i2, int i3) {
            C1126fq.m5077a(obj, i, i2, i3);
        }

        /* renamed from: b */
        public void mo2910b(Object obj, int i, int i2, int i3) {
            C1126fq.m5085b(obj, i, i2, i3);
        }

        /* renamed from: g */
        public boolean mo2915g(Object obj) {
            return C1126fq.m5089f(obj);
        }

        /* renamed from: h */
        public int mo2916h(Object obj) {
            return C1126fq.m5090g(obj);
        }

        /* renamed from: i */
        public int mo2917i(Object obj) {
            return C1126fq.m5091h(obj);
        }

        /* renamed from: a */
        public boolean mo2908a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return C1126fq.m5083a(obj, i, i2, i3, i4, i5, i6);
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$d */
    static class C0436d extends C0435c {
        C0436d() {
        }

        /* renamed from: d */
        public float mo2912d(Object obj) {
            return C1127fr.m5092a(obj);
        }
    }

    public static ScrollerCompat create(Context context) {
        return create(context, (Interpolator) null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(Build.VERSION.SDK_INT, context, interpolator);
    }

    private ScrollerCompat(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1285b = new C0436d();
        } else if (i >= 9) {
            this.f1285b = new C0435c();
        } else {
            this.f1285b = new C0434b();
        }
        this.f1284a = this.f1285b.mo2901a(context, interpolator);
    }

    public boolean isFinished() {
        return this.f1285b.mo2907a(this.f1284a);
    }

    public int getCurrX() {
        return this.f1285b.mo2909b(this.f1284a);
    }

    public int getCurrY() {
        return this.f1285b.mo2911c(this.f1284a);
    }

    public int getFinalX() {
        return this.f1285b.mo2916h(this.f1284a);
    }

    public int getFinalY() {
        return this.f1285b.mo2917i(this.f1284a);
    }

    public float getCurrVelocity() {
        return this.f1285b.mo2912d(this.f1284a);
    }

    public boolean computeScrollOffset() {
        return this.f1285b.mo2913e(this.f1284a);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        this.f1285b.mo2903a(this.f1284a, i, i2, i3, i4);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f1285b.mo2904a(this.f1284a, i, i2, i3, i4, i5);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1285b.mo2905a(this.f1284a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1285b.mo2906a(this.f1284a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1285b.mo2908a(this.f1284a, i, i2, i3, i4, i5, i6);
    }

    public void abortAnimation() {
        this.f1285b.mo2914f(this.f1284a);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f1285b.mo2902a(this.f1284a, i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f1285b.mo2910b(this.f1284a, i, i2, i3);
    }

    public boolean isOverScrolled() {
        return this.f1285b.mo2915g(this.f1284a);
    }
}
