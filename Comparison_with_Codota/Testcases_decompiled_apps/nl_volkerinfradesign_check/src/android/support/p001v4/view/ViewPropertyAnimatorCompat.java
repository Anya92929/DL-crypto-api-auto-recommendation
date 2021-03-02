package android.support.p001v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat */
public class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    static final C0355g f1067a;

    /* renamed from: b */
    private WeakReference<View> f1068b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Runnable f1069c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f1070d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f1071e = -1;

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$g */
    interface C0355g {
        /* renamed from: a */
        long mo2135a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: a */
        void mo2136a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: a */
        void mo2137a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        /* renamed from: a */
        void mo2138a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        /* renamed from: a */
        void mo2139a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        /* renamed from: a */
        void mo2140a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator);

        /* renamed from: a */
        void mo2141a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        /* renamed from: b */
        Interpolator mo2142b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: b */
        void mo2143b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: b */
        void mo2144b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        /* renamed from: b */
        void mo2145b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        /* renamed from: c */
        long mo2146c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: c */
        void mo2147c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: d */
        void mo2148d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: d */
        void mo2149d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: e */
        void mo2150e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: e */
        void mo2151e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: f */
        void mo2152f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        /* renamed from: f */
        void mo2153f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: g */
        void mo2154g(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: h */
        void mo2155h(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: i */
        void mo2156i(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: j */
        void mo2157j(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: k */
        void mo2158k(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: l */
        void mo2159l(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: m */
        void mo2160m(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: n */
        void mo2161n(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: o */
        void mo2162o(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: p */
        void mo2163p(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: q */
        void mo2164q(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: r */
        void mo2165r(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: s */
        void mo2166s(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: t */
        void mo2167t(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: u */
        void mo2168u(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: v */
        void mo2169v(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: w */
        void mo2170w(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: x */
        void mo2171x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f1068b = new WeakReference<>(view);
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$a */
    static class C0347a implements C0355g {

        /* renamed from: a */
        WeakHashMap<View, Runnable> f1072a = null;

        C0347a() {
        }

        /* renamed from: a */
        public void mo2137a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        /* renamed from: a */
        public void mo2136a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: b */
        public void mo2143b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: c */
        public void mo2147c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: a */
        public void mo2141a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.f1070d = runnable;
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: a */
        public long mo2135a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        /* renamed from: a */
        public void mo2140a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        /* renamed from: b */
        public Interpolator mo2142b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return null;
        }

        /* renamed from: b */
        public void mo2144b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        /* renamed from: c */
        public long mo2146c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        /* renamed from: d */
        public void mo2149d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: e */
        public void mo2151e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: f */
        public void mo2153f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: g */
        public void mo2154g(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: h */
        public void mo2155h(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: i */
        public void mo2156i(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: j */
        public void mo2157j(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: k */
        public void mo2158k(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: l */
        public void mo2159l(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: m */
        public void mo2160m(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: n */
        public void mo2161n(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: d */
        public void mo2148d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: o */
        public void mo2162o(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: p */
        public void mo2163p(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: q */
        public void mo2164q(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: r */
        public void mo2165r(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: s */
        public void mo2166s(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        /* renamed from: t */
        public void mo2167t(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        /* renamed from: u */
        public void mo2168u(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: v */
        public void mo2169v(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: w */
        public void mo2170w(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        /* renamed from: x */
        public void mo2171x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        /* renamed from: e */
        public void mo2150e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            m1646a(view);
            m1647g(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: f */
        public void mo2152f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        /* renamed from: b */
        public void mo2145b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.f1069c = runnable;
            m1648h(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: a */
        public void mo2138a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
        }

        /* renamed from: a */
        public void mo2139a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public void m1647g(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(2113929216);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            Runnable a = viewPropertyAnimatorCompat.f1069c;
            Runnable b = viewPropertyAnimatorCompat.f1070d;
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
            if (this.f1072a != null) {
                this.f1072a.remove(view);
            }
        }

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$a$a */
        class C0348a implements Runnable {

            /* renamed from: a */
            WeakReference<View> f1073a;

            /* renamed from: b */
            ViewPropertyAnimatorCompat f1074b;

            private C0348a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.f1073a = new WeakReference<>(view);
                this.f1074b = viewPropertyAnimatorCompat;
            }

            public void run() {
                View view = (View) this.f1073a.get();
                if (view != null) {
                    C0347a.this.m1647g(this.f1074b, view);
                }
            }
        }

        /* renamed from: a */
        private void m1646a(View view) {
            Runnable runnable;
            if (this.f1072a != null && (runnable = this.f1072a.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        /* renamed from: h */
        private void m1648h(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Runnable runnable;
            if (this.f1072a != null) {
                runnable = this.f1072a.get(view);
            } else {
                runnable = null;
            }
            if (runnable == null) {
                runnable = new C0348a(viewPropertyAnimatorCompat, view);
                if (this.f1072a == null) {
                    this.f1072a = new WeakHashMap<>();
                }
                this.f1072a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$b */
    static class C0349b extends C0347a {

        /* renamed from: b */
        WeakHashMap<View, Integer> f1076b = null;

        C0349b() {
        }

        /* renamed from: a */
        public void mo2137a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            C1068eb.m4779a(view, j);
        }

        /* renamed from: a */
        public void mo2136a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4778a(view, f);
        }

        /* renamed from: b */
        public void mo2143b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4783b(view, f);
        }

        /* renamed from: c */
        public void mo2147c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4786c(view, f);
        }

        /* renamed from: a */
        public long mo2135a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return C1068eb.m4777a(view);
        }

        /* renamed from: a */
        public void mo2140a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
            C1068eb.m4781a(view, interpolator);
        }

        /* renamed from: b */
        public void mo2144b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            C1068eb.m4784b(view, j);
        }

        /* renamed from: c */
        public long mo2146c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return C1068eb.m4782b(view);
        }

        /* renamed from: d */
        public void mo2149d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4788d(view, f);
        }

        /* renamed from: e */
        public void mo2151e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4789e(view, f);
        }

        /* renamed from: f */
        public void mo2153f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4790f(view, f);
        }

        /* renamed from: g */
        public void mo2154g(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4791g(view, f);
        }

        /* renamed from: h */
        public void mo2155h(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4792h(view, f);
        }

        /* renamed from: i */
        public void mo2156i(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4793i(view, f);
        }

        /* renamed from: j */
        public void mo2157j(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4794j(view, f);
        }

        /* renamed from: k */
        public void mo2158k(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4795k(view, f);
        }

        /* renamed from: l */
        public void mo2159l(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4796l(view, f);
        }

        /* renamed from: m */
        public void mo2160m(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4797m(view, f);
        }

        /* renamed from: n */
        public void mo2161n(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4798n(view, f);
        }

        /* renamed from: d */
        public void mo2148d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            C1068eb.m4785c(view);
        }

        /* renamed from: o */
        public void mo2162o(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4799o(view, f);
        }

        /* renamed from: p */
        public void mo2163p(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4800p(view, f);
        }

        /* renamed from: q */
        public void mo2164q(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4801q(view, f);
        }

        /* renamed from: r */
        public void mo2165r(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4802r(view, f);
        }

        /* renamed from: u */
        public void mo2168u(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4803s(view, f);
        }

        /* renamed from: v */
        public void mo2169v(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1068eb.m4804t(view, f);
        }

        /* renamed from: e */
        public void mo2150e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            C1068eb.m4787d(view);
        }

        /* renamed from: a */
        public void mo2138a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
            C1068eb.m4780a(view, (ViewPropertyAnimatorListener) new C0350a(viewPropertyAnimatorCompat));
        }

        /* renamed from: a */
        public void mo2141a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            C1068eb.m4780a(view, (ViewPropertyAnimatorListener) new C0350a(viewPropertyAnimatorCompat));
            Runnable unused = viewPropertyAnimatorCompat.f1070d = runnable;
        }

        /* renamed from: b */
        public void mo2145b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            C1068eb.m4780a(view, (ViewPropertyAnimatorListener) new C0350a(viewPropertyAnimatorCompat));
            Runnable unused = viewPropertyAnimatorCompat.f1069c = runnable;
        }

        /* renamed from: f */
        public void mo2152f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            int unused = viewPropertyAnimatorCompat.f1071e = ViewCompat.getLayerType(view);
            C1068eb.m4780a(view, (ViewPropertyAnimatorListener) new C0350a(viewPropertyAnimatorCompat));
        }

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$b$a */
        static class C0350a implements ViewPropertyAnimatorListener {

            /* renamed from: a */
            ViewPropertyAnimatorCompat f1077a;

            C0350a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.f1077a = viewPropertyAnimatorCompat;
            }

            public void onAnimationStart(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f1077a.f1071e >= 0) {
                    ViewCompat.setLayerType(view, 2, (Paint) null);
                }
                if (this.f1077a.f1069c != null) {
                    this.f1077a.f1069c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }

            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f1077a.f1071e >= 0) {
                    ViewCompat.setLayerType(view, this.f1077a.f1071e, (Paint) null);
                    int unused = this.f1077a.f1071e = -1;
                }
                if (this.f1077a.f1070d != null) {
                    this.f1077a.f1070d.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
            }

            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$d */
    static class C0352d extends C0349b {
        C0352d() {
        }

        /* renamed from: a */
        public void mo2138a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            C1070ec.m4806a(view, viewPropertyAnimatorListener);
        }

        /* renamed from: b */
        public void mo2145b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            C1070ec.m4807a(view, runnable);
        }

        /* renamed from: a */
        public void mo2141a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            C1070ec.m4808b(view, runnable);
        }

        /* renamed from: f */
        public void mo2152f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            C1070ec.m4805a(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$c */
    static class C0351c extends C0352d {
        C0351c() {
        }

        /* renamed from: b */
        public Interpolator mo2142b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return C1072ed.m4809a(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$e */
    static class C0353e extends C0351c {
        C0353e() {
        }

        /* renamed from: a */
        public void mo2139a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            C1073ee.m4810a(view, viewPropertyAnimatorUpdateListener);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$f */
    static class C0354f extends C0353e {
        C0354f() {
        }

        /* renamed from: w */
        public void mo2170w(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1075ef.m4811a(view, f);
        }

        /* renamed from: x */
        public void mo2171x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1075ef.m4812b(view, f);
        }

        /* renamed from: s */
        public void mo2166s(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1075ef.m4813c(view, f);
        }

        /* renamed from: t */
        public void mo2167t(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            C1075ef.m4814d(view, f);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1067a = new C0354f();
        } else if (i >= 19) {
            f1067a = new C0353e();
        } else if (i >= 18) {
            f1067a = new C0351c();
        } else if (i >= 16) {
            f1067a = new C0352d();
        } else if (i >= 14) {
            f1067a = new C0349b();
        } else {
            f1067a = new C0347a();
        }
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2137a(this, view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2136a(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2149d(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2143b(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2147c(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2141a(this, view, runnable);
        }
        return this;
    }

    public long getDuration() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            return f1067a.mo2135a(this, view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2140a(this, view, interpolator);
        }
        return this;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            return f1067a.mo2142b(this, view);
        }
        return null;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2144b(this, view, j);
        }
        return this;
    }

    public long getStartDelay() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            return f1067a.mo2146c(this, view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2151e(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2153f(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2154g(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2155h(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2156i(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2157j(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2158k(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2159l(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2160m(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2161n(this, view, f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2148d(this, view);
        }
    }

    /* renamed from: x */
    public ViewPropertyAnimatorCompat mo2129x(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2162o(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2163p(this, view, f);
        }
        return this;
    }

    /* renamed from: y */
    public ViewPropertyAnimatorCompat mo2131y(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2164q(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2165r(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2168u(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2169v(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2171x(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2170w(this, view, f);
        }
        return this;
    }

    /* renamed from: z */
    public ViewPropertyAnimatorCompat mo2133z(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2166s(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2167t(this, view, f);
        }
        return this;
    }

    public void start() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2150e(this, view);
        }
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2152f(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2145b(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2138a(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View) this.f1068b.get();
        if (view != null) {
            f1067a.mo2139a(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }
}
