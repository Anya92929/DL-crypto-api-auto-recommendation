package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.widget.ActionMenuPresenter;
import android.support.p003v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.internal.widget.AbsActionBarView */
abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a */
    protected final VisibilityAnimListener f2190a;

    /* renamed from: b */
    protected final Context f2191b;

    /* renamed from: c */
    protected ActionMenuView f2192c;

    /* renamed from: d */
    protected ActionMenuPresenter f2193d;

    /* renamed from: e */
    protected int f2194e;

    /* renamed from: f */
    protected ViewPropertyAnimatorCompat f2195f;

    /* renamed from: g */
    private boolean f2196g;

    /* renamed from: h */
    private boolean f2197h;

    /* renamed from: android.support.v7.internal.widget.AbsActionBarView$VisibilityAnimListener */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        int f2199a;

        /* renamed from: c */
        private boolean f2201c = false;

        protected VisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.f2201c = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.f2201c) {
                AbsActionBarView.this.f2195f = null;
                AbsActionBarView.super.setVisibility(this.f2199a);
            }
        }

        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f2201c = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.f2195f = viewPropertyAnimatorCompat;
            this.f2199a = i;
            return this;
        }
    }

    AbsActionBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2190a = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0235R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f2191b = context;
        } else {
            this.f2191b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* renamed from: a */
    protected static int m1447a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo4325a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo4326a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void animateToVisibility(int i) {
        setupAnimatorToVisibility(i, 200).start();
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        if (this.f2193d != null) {
            this.f2193d.dismissPopupMenus();
        }
    }

    public int getAnimatedVisibility() {
        return this.f2195f != null ? this.f2190a.f2199a : getVisibility();
    }

    public int getContentHeight() {
        return this.f2194e;
    }

    public boolean hideOverflowMenu() {
        if (this.f2193d != null) {
            return this.f2193d.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        if (this.f2193d != null) {
            return this.f2193d.isOverflowMenuShowPending();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        if (this.f2193d != null) {
            return this.f2193d.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        return this.f2193d != null && this.f2193d.isOverflowReserved();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, C0235R.styleable.ActionBar, C0235R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0235R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f2193d != null) {
            this.f2193d.onConfigurationChanged(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f2197h = false;
        }
        if (!this.f2197h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2197h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2197h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f2196g = false;
        }
        if (!this.f2196g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2196g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2196g = false;
        }
        return true;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() {
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int i) {
        this.f2194e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f2195f != null) {
                this.f2195f.cancel();
            }
            super.setVisibility(i);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        if (this.f2195f != null) {
            this.f2195f.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, BitmapDescriptorFactory.HUE_RED);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(j);
            alpha.setListener(this.f2190a.withFinalVisibility(alpha, i));
            return alpha;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(BitmapDescriptorFactory.HUE_RED);
        alpha2.setDuration(j);
        alpha2.setListener(this.f2190a.withFinalVisibility(alpha2, i));
        return alpha2;
    }

    public boolean showOverflowMenu() {
        if (this.f2193d != null) {
            return this.f2193d.showOverflowMenu();
        }
        return false;
    }
}
