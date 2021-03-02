package android.support.p000v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.widget.ScrollerCompat */
public class ScrollerCompat {

    /* renamed from: a */
    Object f1586a;

    /* renamed from: b */
    ScrollerCompatImpl f1587b;

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl */
    interface ScrollerCompatImpl {
        void abortAnimation(Object obj);

        boolean computeScrollOffset(Object obj);

        Object createScroller(Context context, Interpolator interpolator);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        float getCurrVelocity(Object obj);

        int getCurrX(Object obj);

        int getCurrY(Object obj);

        int getFinalX(Object obj);

        int getFinalY(Object obj);

        boolean isFinished(Object obj);

        boolean isOverScrolled(Object obj);

        void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3);

        void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3);

        void startScroll(Object obj, int i, int i2, int i3, int i4);

        void startScroll(Object obj, int i, int i2, int i3, int i4, int i5);
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplBase */
    class ScrollerCompatImplBase implements ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        public void abortAnimation(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public boolean computeScrollOffset(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public Object createScroller(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public float getCurrVelocity(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public int getCurrX(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int getCurrY(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public int getFinalX(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int getFinalY(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public boolean isFinished(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public boolean isOverScrolled(Object obj) {
            return false;
        }

        public void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3) {
        }

        public void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3) {
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplGingerbread */
    class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        public void abortAnimation(Object obj) {
            ScrollerCompatGingerbread.abortAnimation(obj);
        }

        public boolean computeScrollOffset(Object obj) {
            return ScrollerCompatGingerbread.computeScrollOffset(obj);
        }

        public Object createScroller(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public float getCurrVelocity(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public int getCurrX(Object obj) {
            return ScrollerCompatGingerbread.getCurrX(obj);
        }

        public int getCurrY(Object obj) {
            return ScrollerCompatGingerbread.getCurrY(obj);
        }

        public int getFinalX(Object obj) {
            return ScrollerCompatGingerbread.getFinalX(obj);
        }

        public int getFinalY(Object obj) {
            return ScrollerCompatGingerbread.getFinalY(obj);
        }

        public boolean isFinished(Object obj) {
            return ScrollerCompatGingerbread.isFinished(obj);
        }

        public boolean isOverScrolled(Object obj) {
            return ScrollerCompatGingerbread.isOverScrolled(obj);
        }

        public void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3) {
            ScrollerCompatGingerbread.notifyHorizontalEdgeReached(obj, i, i2, i3);
        }

        public void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3) {
            ScrollerCompatGingerbread.notifyVerticalEdgeReached(obj, i, i2, i3);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4) {
            ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4, int i5) {
            ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4, i5);
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplIcs */
    class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        public float getCurrVelocity(Object obj) {
            return ScrollerCompatIcs.getCurrVelocity(obj);
        }
    }

    private ScrollerCompat(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1587b = new ScrollerCompatImplIcs();
        } else if (i >= 9) {
            this.f1587b = new ScrollerCompatImplGingerbread();
        } else {
            this.f1587b = new ScrollerCompatImplBase();
        }
        this.f1586a = this.f1587b.createScroller(context, interpolator);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(Build.VERSION.SDK_INT, context, interpolator);
    }

    public static ScrollerCompat create(Context context) {
        return create(context, (Interpolator) null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    public void abortAnimation() {
        this.f1587b.abortAnimation(this.f1586a);
    }

    public boolean computeScrollOffset() {
        return this.f1587b.computeScrollOffset(this.f1586a);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1587b.fling(this.f1586a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1587b.fling(this.f1586a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public float getCurrVelocity() {
        return this.f1587b.getCurrVelocity(this.f1586a);
    }

    public int getCurrX() {
        return this.f1587b.getCurrX(this.f1586a);
    }

    public int getCurrY() {
        return this.f1587b.getCurrY(this.f1586a);
    }

    public int getFinalX() {
        return this.f1587b.getFinalX(this.f1586a);
    }

    public int getFinalY() {
        return this.f1587b.getFinalY(this.f1586a);
    }

    public boolean isFinished() {
        return this.f1587b.isFinished(this.f1586a);
    }

    public boolean isOverScrolled() {
        return this.f1587b.isOverScrolled(this.f1586a);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f1587b.notifyHorizontalEdgeReached(this.f1586a, i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f1587b.notifyVerticalEdgeReached(this.f1586a, i, i2, i3);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        this.f1587b.startScroll(this.f1586a, i, i2, i3, i4);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f1587b.startScroll(this.f1586a, i, i2, i3, i4, i5);
    }
}
