package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.C1394kc;
import java.lang.ref.WeakReference;

public class PopupManager {

    /* renamed from: XO */
    protected GamesClientImpl f1945XO;

    /* renamed from: XP */
    protected PopupLocationInfo f1946XP;

    public static final class PopupLocationInfo {

        /* renamed from: XQ */
        public IBinder f1947XQ;

        /* renamed from: XR */
        public int f1948XR;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private PopupLocationInfo(int gravity2, IBinder windowToken) {
            this.f1948XR = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity2;
            this.f1947XQ = windowToken;
        }

        /* renamed from: kM */
        public Bundle mo7054kM() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.f1948XR);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: Wn */
        private boolean f1949Wn = false;

        /* renamed from: XS */
        private WeakReference<View> f1950XS;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        /* renamed from: m */
        private void m3184m(View view) {
            Display display;
            int i = -1;
            if (C1394kc.m5243hG() && (display = view.getDisplay()) != null) {
                i = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.f1946XP.f1948XR = i;
            this.f1946XP.f1947XQ = windowToken;
            this.f1946XP.left = iArr[0];
            this.f1946XP.top = iArr[1];
            this.f1946XP.right = iArr[0] + width;
            this.f1946XP.bottom = iArr[1] + height;
            if (this.f1949Wn) {
                mo7049kJ();
                this.f1949Wn = false;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: dG */
        public void mo7048dG(int i) {
            this.f1946XP = new PopupLocationInfo(i, (IBinder) null);
        }

        /* renamed from: kJ */
        public void mo7049kJ() {
            if (this.f1946XP.f1947XQ != null) {
                PopupManager.super.mo7049kJ();
            } else {
                this.f1949Wn = this.f1950XS != null;
            }
        }

        /* renamed from: l */
        public void mo7052l(View view) {
            this.f1945XO.mo6729ku();
            if (this.f1950XS != null) {
                View view2 = (View) this.f1950XS.get();
                Context context = this.f1945XO.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (C1394kc.m5242hF()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.f1950XS = null;
            Context context2 = this.f1945XO.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View findViewById = ((Activity) context2).findViewById(16908290);
                if (findViewById == null) {
                    findViewById = ((Activity) context2).getWindow().getDecorView();
                }
                GamesLog.m2553p("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = findViewById;
            }
            if (view != null) {
                m3184m(view);
                this.f1950XS = new WeakReference<>(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.m2554q("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void onGlobalLayout() {
            View view;
            if (this.f1950XS != null && (view = (View) this.f1950XS.get()) != null) {
                m3184m(view);
            }
        }

        public void onViewAttachedToWindow(View v) {
            m3184m(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.f1945XO.mo6729ku();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.f1945XO = gamesClientImpl;
        mo7048dG(gravity);
    }

    /* renamed from: a */
    public static PopupManager m3177a(GamesClientImpl gamesClientImpl, int i) {
        return C1394kc.m5239hC() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: dG */
    public void mo7048dG(int i) {
        this.f1946XP = new PopupLocationInfo(i, new Binder());
    }

    /* renamed from: kJ */
    public void mo7049kJ() {
        this.f1945XO.mo6601a(this.f1946XP.f1947XQ, this.f1946XP.mo7054kM());
    }

    /* renamed from: kK */
    public Bundle mo7050kK() {
        return this.f1946XP.mo7054kM();
    }

    /* renamed from: kL */
    public IBinder mo7051kL() {
        return this.f1946XP.f1947XQ;
    }

    /* renamed from: l */
    public void mo7052l(View view) {
    }

    public void setGravity(int gravity) {
        this.f1946XP.gravity = gravity;
    }
}
