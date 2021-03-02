package android.support.p000v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat */
public class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    static final ViewPropertyAnimatorCompatImpl f1333a;

    /* renamed from: b */
    private WeakReference<View> f1334b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Runnable f1335c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f1336d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f1337e = -1;

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl */
    class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {

        /* renamed from: a */
        WeakHashMap<View, Runnable> f1338a = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter */
        class Starter implements Runnable {

            /* renamed from: a */
            WeakReference<View> f1339a;

            /* renamed from: b */
            ViewPropertyAnimatorCompat f1340b;

            private Starter(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.f1339a = new WeakReference<>(view);
                this.f1340b = viewPropertyAnimatorCompat;
            }

            public void run() {
                View view = (View) this.f1339a.get();
                if (view != null) {
                    BaseViewPropertyAnimatorCompatImpl.this.m940a(this.f1340b, view);
                }
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m940a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            Runnable a = viewPropertyAnimatorCompat.f1335c;
            Runnable b = viewPropertyAnimatorCompat.f1336d;
            if (a != null) {
                a.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f1338a != null) {
                this.f1338a.remove(view);
            }
        }

        /* renamed from: a */
        private void m941a(View view) {
            Runnable runnable;
            if (this.f1338a != null && (runnable = this.f1338a.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        /* renamed from: b */
        private void m942b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Runnable runnable = this.f1338a != null ? this.f1338a.get(view) : null;
            if (runnable == null) {
                runnable = new Starter(viewPropertyAnimatorCompat, view);
                if (this.f1338a == null) {
                    this.f1338a = new WeakHashMap<>();
                }
                this.f1338a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return null;
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            m941a(view);
            m940a(viewPropertyAnimatorCompat, view);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.f1336d = runnable;
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.f1335c = runnable;
            m942b(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: x */
        public void mo2573x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: y */
        public void mo2575y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m942b(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: z */
        public void mo2577z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl */
    class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {

        /* renamed from: b */
        WeakHashMap<View, Integer> f1342b = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener */
        class MyVpaListener implements ViewPropertyAnimatorListener {

            /* renamed from: a */
            ViewPropertyAnimatorCompat f1343a;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.f1343a = viewPropertyAnimatorCompat;
            }

            public void onAnimationCancel(View view) {
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }

            public void onAnimationEnd(View view) {
                if (this.f1343a.f1337e >= 0) {
                    ViewCompat.setLayerType(view, this.f1343a.f1337e, (Paint) null);
                    int unused = this.f1343a.f1337e = -1;
                }
                if (this.f1343a.f1336d != null) {
                    this.f1343a.f1336d.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
            }

            public void onAnimationStart(View view) {
                if (this.f1343a.f1337e >= 0) {
                    ViewCompat.setLayerType(view, 2, (Paint) null);
                }
                if (this.f1343a.f1335c != null) {
                    this.f1343a.f1335c.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.alpha(view, f);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.alphaBy(view, f);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotation(view, f);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationBy(view, f);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationX(view, f);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view, f);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationY(view, f);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view, f);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleX(view, f);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view, f);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleY(view, f);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view, f);
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompatICS.setDuration(view, j);
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view, j);
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.start(view);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationX(view, f);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationXBy(view, f);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationY(view, f);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationYBy(view, f);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            Runnable unused = viewPropertyAnimatorCompat.f1336d = runnable;
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            int unused = viewPropertyAnimatorCompat.f1337e = ViewCompat.getLayerType(view);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            Runnable unused = viewPropertyAnimatorCompat.f1335c = runnable;
        }

        /* renamed from: x */
        public void mo2573x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.m952x(view, f);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        /* renamed from: y */
        public void mo2575y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.m953y(view, f);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.yBy(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl */
    class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl */
    class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl */
    class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$LollipopViewPropertyAnimatorCompatImpl */
    class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZ(view, f);
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZBy(view, f);
        }

        /* renamed from: z */
        public void mo2577z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.m954z(view, f);
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.zBy(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl */
    interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator);

        void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        /* renamed from: x */
        void mo2573x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: y */
        void mo2575y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: z */
        void mo2577z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1333a = new LollipopViewPropertyAnimatorCompatImpl();
        } else if (i >= 19) {
            f1333a = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            f1333a = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            f1333a = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            f1333a = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            f1333a = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f1334b = new WeakReference<>(view);
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.alpha(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.alphaBy(this, view, f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.cancel(this, view);
        }
    }

    public long getDuration() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            return f1333a.getDuration(this, view);
        }
        return 0;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            return f1333a.getInterpolator(this, view);
        }
        return null;
    }

    public long getStartDelay() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            return f1333a.getStartDelay(this, view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotation(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotationBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.rotationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.scaleX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.scaleXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.scaleY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.scaleYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.setDuration(this, view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.setStartDelay(this, view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }

    public void start() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.start(this, view);
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationZ(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.translationZBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.withEndAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.withLayer(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.withStartAction(this, view, runnable);
        }
        return this;
    }

    /* renamed from: x */
    public ViewPropertyAnimatorCompat mo2536x(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.mo2573x(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.xBy(this, view, f);
        }
        return this;
    }

    /* renamed from: y */
    public ViewPropertyAnimatorCompat mo2538y(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.mo2575y(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.yBy(this, view, f);
        }
        return this;
    }

    /* renamed from: z */
    public ViewPropertyAnimatorCompat mo2540z(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.mo2577z(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.f1334b.get();
        if (view != null) {
            f1333a.zBy(this, view, f);
        }
        return this;
    }
}
