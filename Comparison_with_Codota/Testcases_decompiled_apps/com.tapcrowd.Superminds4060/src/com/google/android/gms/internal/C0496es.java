package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.es */
public class C0496es {

    /* renamed from: mz */
    protected C0443em f1268mz;

    /* renamed from: np */
    protected C0498a f1269np;

    /* renamed from: com.google.android.gms.internal.es$a */
    public static final class C0498a {
        public int bottom;
        public int gravity;
        public int left;

        /* renamed from: nq */
        public IBinder f1270nq;

        /* renamed from: nr */
        public int f1271nr;
        public int right;
        public int top;

        private C0498a(int i, IBinder iBinder) {
            this.f1271nr = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.f1270nq = iBinder;
        }

        /* renamed from: ca */
        public Bundle mo4706ca() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.f1271nr);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    /* renamed from: com.google.android.gms.internal.es$b */
    private static final class C0499b extends C0496es implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: mK */
        private boolean f1272mK = false;

        /* renamed from: ns */
        private WeakReference<View> f1273ns;

        protected C0499b(C0443em emVar, int i) {
            super(emVar, i);
        }

        /* renamed from: f */
        private void m1483f(View view) {
            Display display;
            int i = -1;
            if (C0441ek.m1091bO() && (display = view.getDisplay()) != null) {
                i = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.f1269np.f1271nr = i;
            this.f1269np.f1270nq = windowToken;
            this.f1269np.left = iArr[0];
            this.f1269np.top = iArr[1];
            this.f1269np.right = iArr[0] + width;
            this.f1269np.bottom = iArr[1] + height;
            if (this.f1272mK) {
                mo4701bX();
                this.f1272mK = false;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: Q */
        public void mo4700Q(int i) {
            this.f1269np = new C0498a(i, (IBinder) null);
        }

        /* renamed from: bX */
        public void mo4701bX() {
            if (this.f1269np.f1270nq != null) {
                C0496es.super.mo4701bX();
            } else {
                this.f1272mK = this.f1273ns != null;
            }
        }

        /* renamed from: e */
        public void mo4704e(View view) {
            this.f1268mz.mo4554bT();
            if (this.f1273ns != null) {
                View view2 = (View) this.f1273ns.get();
                Context context = this.f1268mz.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (C0441ek.m1090bN()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.f1273ns = null;
            Context context2 = this.f1268mz.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View findViewById = ((Activity) context2).findViewById(16908290);
                if (findViewById == null) {
                    findViewById = ((Activity) context2).getWindow().getDecorView();
                }
                C0489ep.m1241c("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = findViewById;
            }
            if (view != null) {
                m1483f(view);
                this.f1273ns = new WeakReference<>(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            C0489ep.m1242d("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void onGlobalLayout() {
            View view;
            if (this.f1273ns != null && (view = (View) this.f1273ns.get()) != null) {
                m1483f(view);
            }
        }

        public void onViewAttachedToWindow(View v) {
            m1483f(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.f1268mz.mo4554bT();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private C0496es(C0443em emVar, int i) {
        this.f1268mz = emVar;
        mo4700Q(i);
    }

    /* renamed from: a */
    public static C0496es m1476a(C0443em emVar, int i) {
        return C0441ek.m1087bK() ? new C0499b(emVar, i) : new C0496es(emVar, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public void mo4700Q(int i) {
        this.f1269np = new C0498a(i, new Binder());
    }

    /* renamed from: bX */
    public void mo4701bX() {
        this.f1268mz.mo4547a(this.f1269np.f1270nq, this.f1269np.mo4706ca());
    }

    /* renamed from: bY */
    public Bundle mo4702bY() {
        return this.f1269np.mo4706ca();
    }

    /* renamed from: bZ */
    public IBinder mo4703bZ() {
        return this.f1269np.f1270nq;
    }

    /* renamed from: e */
    public void mo4704e(View view) {
    }

    public void setGravity(int gravity) {
        this.f1269np.gravity = gravity;
    }
}
