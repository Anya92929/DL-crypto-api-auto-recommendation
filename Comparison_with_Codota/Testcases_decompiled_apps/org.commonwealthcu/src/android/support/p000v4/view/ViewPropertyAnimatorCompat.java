package android.support.p000v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat */
public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL;
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    /* access modifiers changed from: private */
    public Runnable mEndAction = null;
    /* access modifiers changed from: private */
    public int mOldLayerType = -1;
    /* access modifiers changed from: private */
    public Runnable mStartAction = null;
    private WeakReference mView;

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl */
    class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap mStarterMap = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter */
        class Starter implements Runnable {
            WeakReference mViewRef;
            ViewPropertyAnimatorCompat mVpa;

            private Starter(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.mViewRef = new WeakReference(view);
                this.mVpa = viewPropertyAnimatorCompat;
            }

            public void run() {
                View view = (View) this.mViewRef.get();
                if (view != null) {
                    BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, view);
                }
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        private void postStartMessage(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Runnable runnable = this.mStarterMap != null ? (Runnable) this.mStarterMap.get(view) : null;
            if (runnable == null) {
                runnable = new Starter(viewPropertyAnimatorCompat, view);
                if (this.mStarterMap == null) {
                    this.mStarterMap = new WeakHashMap();
                }
                this.mStarterMap.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        private void removeStartMessage(View view) {
            Runnable runnable;
            if (this.mStarterMap != null && (runnable = (Runnable) this.mStarterMap.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        /* access modifiers changed from: private */
        public void startAnimation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            Runnable access$100 = viewPropertyAnimatorCompat.mStartAction;
            Runnable access$000 = viewPropertyAnimatorCompat.mEndAction;
            if (access$100 != null) {
                access$100.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            if (access$000 != null) {
                access$000.run();
            }
            if (this.mStarterMap != null) {
                this.mStarterMap.remove(view);
            }
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            postStartMessage(viewPropertyAnimatorCompat, view);
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
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            removeStartMessage(view);
            startAnimation(viewPropertyAnimatorCompat, view);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.mEndAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            Runnable unused = viewPropertyAnimatorCompat.mStartAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: x */
        public void mo2129x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: y */
        public void mo2131y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: z */
        public void mo2133z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl */
    class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap mLayerMap = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener */
        class MyVpaListener implements ViewPropertyAnimatorListener {
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            public void onAnimationCancel(View view) {
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }

            public void onAnimationEnd(View view) {
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, this.mVpa.mOldLayerType, (Paint) null);
                    int unused = this.mVpa.mOldLayerType = -1;
                }
                if (this.mVpa.mEndAction != null) {
                    this.mVpa.mEndAction.run();
                }
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
            }

            public void onAnimationStart(View view) {
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, 2, (Paint) null);
                }
                if (this.mVpa.mStartAction != null) {
                    this.mVpa.mStartAction.run();
                }
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
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
            view.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
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
            Runnable unused = viewPropertyAnimatorCompat.mEndAction = runnable;
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            int unused = viewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(view);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            Runnable unused = viewPropertyAnimatorCompat.mStartAction = runnable;
        }

        /* renamed from: x */
        public void mo2129x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.m16x(view, f);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        /* renamed from: y */
        public void mo2131y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.m17y(view, f);
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
        public void mo2133z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.m18z(view, f);
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
        void mo2129x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: y */
        void mo2131y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: z */
        void mo2133z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new LollipopViewPropertyAnimatorCompatImpl();
        } else if (i >= 19) {
            IMPL = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference(view);
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alpha(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }

    public long getDuration() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }

    public long getStartDelay() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotation(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }

    public void start() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationX(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationY(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationZ(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationZBy(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }

    /* renamed from: x */
    public ViewPropertyAnimatorCompat mo2092x(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2129x(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.xBy(this, view, f);
        }
        return this;
    }

    /* renamed from: y */
    public ViewPropertyAnimatorCompat mo2094y(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2131y(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.yBy(this, view, f);
        }
        return this;
    }

    /* renamed from: z */
    public ViewPropertyAnimatorCompat mo2096z(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2133z(this, view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.zBy(this, view, f);
        }
        return this;
    }
}
