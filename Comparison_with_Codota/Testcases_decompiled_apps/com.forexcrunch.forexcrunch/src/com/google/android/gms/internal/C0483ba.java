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

/* renamed from: com.google.android.gms.internal.ba */
public class C0483ba {

    /* renamed from: dt */
    protected C0429au f1099dt;

    /* renamed from: ej */
    protected C0485a f1100ej;

    /* renamed from: com.google.android.gms.internal.ba$a */
    public static final class C0485a {
        public int bottom;

        /* renamed from: ek */
        public IBinder f1101ek;

        /* renamed from: el */
        public int f1102el;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private C0485a(int i, IBinder iBinder) {
            this.f1102el = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.f1101ek = iBinder;
        }

        /* renamed from: aE */
        public Bundle mo4761aE() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.f1102el);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$b */
    private static final class C0486b extends C0483ba implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: dE */
        private boolean f1103dE = false;

        /* renamed from: em */
        private WeakReference<View> f1104em;

        protected C0486b(C0429au auVar, int i) {
            super(auVar, i);
        }

        /* renamed from: b */
        private void m1303b(View view) {
            Display display;
            int i = -1;
            if (C0427as.m914as() && (display = view.getDisplay()) != null) {
                i = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.f1100ej.f1102el = i;
            this.f1100ej.f1101ek = windowToken;
            this.f1100ej.left = iArr[0];
            this.f1100ej.top = iArr[1];
            this.f1100ej.right = iArr[0] + width;
            this.f1100ej.bottom = iArr[1] + height;
            if (this.f1103dE) {
                mo4757aB();
                this.f1103dE = false;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: F */
        public void mo4755F(int i) {
            this.f1100ej = new C0485a(i, (IBinder) null);
        }

        /* renamed from: a */
        public void mo4756a(View view) {
            this.f1099dt.mo4597ax();
            if (this.f1104em != null) {
                View view2 = (View) this.f1104em.get();
                Context context = this.f1099dt.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (C0427as.m913ar()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.f1104em = null;
            Context context2 = this.f1099dt.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View findViewById = ((Activity) context2).findViewById(16908290);
                if (findViewById == null) {
                    findViewById = ((Activity) context2).getWindow().getDecorView();
                }
                C0475ax.m1064b("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = findViewById;
            }
            if (view != null) {
                m1303b(view);
                this.f1104em = new WeakReference<>(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            C0475ax.m1065c("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        /* renamed from: aB */
        public void mo4757aB() {
            if (this.f1100ej.f1101ek != null) {
                C0483ba.super.mo4757aB();
            } else {
                this.f1103dE = this.f1104em != null;
            }
        }

        public void onGlobalLayout() {
            View view;
            if (this.f1104em != null && (view = (View) this.f1104em.get()) != null) {
                m1303b(view);
            }
        }

        public void onViewAttachedToWindow(View v) {
            m1303b(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.f1099dt.mo4597ax();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private C0483ba(C0429au auVar, int i) {
        this.f1099dt = auVar;
        mo4755F(i);
    }

    /* renamed from: a */
    public static C0483ba m1296a(C0429au auVar, int i) {
        return C0427as.m910ao() ? new C0486b(auVar, i) : new C0483ba(auVar, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: F */
    public void mo4755F(int i) {
        this.f1100ej = new C0485a(i, new Binder());
    }

    /* renamed from: a */
    public void mo4756a(View view) {
    }

    /* renamed from: aB */
    public void mo4757aB() {
        this.f1099dt.mo4589a(this.f1100ej.f1101ek, this.f1100ej.mo4761aE());
    }

    /* renamed from: aC */
    public Bundle mo4758aC() {
        return this.f1100ej.mo4761aE();
    }

    /* renamed from: aD */
    public IBinder mo4759aD() {
        return this.f1100ej.f1101ek;
    }

    public void setGravity(int gravity) {
        this.f1100ej.gravity = gravity;
    }
}
