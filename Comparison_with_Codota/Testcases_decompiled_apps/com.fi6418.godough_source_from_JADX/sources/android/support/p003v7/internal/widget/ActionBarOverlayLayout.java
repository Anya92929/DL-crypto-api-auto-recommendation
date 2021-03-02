package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p000v4.widget.ScrollerCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.internal.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {

    /* renamed from: a */
    static final int[] f2226a = {C0235R.attr.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f2227A;

    /* renamed from: B */
    private final NestedScrollingParentHelper f2228B;

    /* renamed from: b */
    private int f2229b;

    /* renamed from: c */
    private int f2230c;

    /* renamed from: d */
    private ContentFrameLayout f2231d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ActionBarContainer f2232e;

    /* renamed from: f */
    private DecorToolbar f2233f;

    /* renamed from: g */
    private Drawable f2234g;

    /* renamed from: h */
    private boolean f2235h;

    /* renamed from: i */
    private boolean f2236i;

    /* renamed from: j */
    private boolean f2237j;

    /* renamed from: k */
    private boolean f2238k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2239l;

    /* renamed from: m */
    private int f2240m;

    /* renamed from: n */
    private int f2241n;

    /* renamed from: o */
    private final Rect f2242o;

    /* renamed from: p */
    private final Rect f2243p;

    /* renamed from: q */
    private final Rect f2244q;

    /* renamed from: r */
    private final Rect f2245r;

    /* renamed from: s */
    private final Rect f2246s;

    /* renamed from: t */
    private final Rect f2247t;

    /* renamed from: u */
    private ActionBarVisibilityCallback f2248u;

    /* renamed from: v */
    private final int f2249v;

    /* renamed from: w */
    private ScrollerCompat f2250w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewPropertyAnimatorCompat f2251x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final ViewPropertyAnimatorListener f2252y;

    /* renamed from: z */
    private final Runnable f2253z;

    /* renamed from: android.support.v7.internal.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    /* renamed from: android.support.v7.internal.widget.ActionBarOverlayLayout$LayoutParams */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2230c = 0;
        this.f2242o = new Rect();
        this.f2243p = new Rect();
        this.f2244q = new Rect();
        this.f2245r = new Rect();
        this.f2246s = new Rect();
        this.f2247t = new Rect();
        this.f2249v = 600;
        this.f2252y = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f2251x = null;
                boolean unused2 = ActionBarOverlayLayout.this.f2239l = false;
            }

            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f2251x = null;
                boolean unused2 = ActionBarOverlayLayout.this.f2239l = false;
            }
        };
        this.f2253z = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m1464c();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f2251x = ViewCompat.animate(ActionBarOverlayLayout.this.f2232e).translationY(BitmapDescriptorFactory.HUE_RED).setListener(ActionBarOverlayLayout.this.f2252y);
            }
        };
        this.f2227A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m1464c();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f2251x = ViewCompat.animate(ActionBarOverlayLayout.this.f2232e).translationY((float) (-ActionBarOverlayLayout.this.f2232e.getHeight())).setListener(ActionBarOverlayLayout.this.f2252y);
            }
        };
        m1457a(context);
        this.f2228B = new NestedScrollingParentHelper(this);
    }

    /* renamed from: a */
    private DecorToolbar m1456a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m1457a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2226a);
        this.f2229b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2234g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f2234g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f2235h = z;
        this.f2250w = ScrollerCompat.create(context);
    }

    /* renamed from: a */
    private boolean m1459a(float f, float f2) {
        this.f2250w.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f2250w.getFinalY() > this.f2232e.getHeight();
    }

    /* renamed from: a */
    private boolean m1461a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1464c() {
        removeCallbacks(this.f2253z);
        removeCallbacks(this.f2227A);
        if (this.f2251x != null) {
            this.f2251x.cancel();
        }
    }

    /* renamed from: d */
    private void m1465d() {
        m1464c();
        postDelayed(this.f2253z, 600);
    }

    /* renamed from: e */
    private void m1466e() {
        m1464c();
        postDelayed(this.f2227A, 600);
    }

    /* renamed from: f */
    private void m1467f() {
        m1464c();
        this.f2253z.run();
    }

    /* renamed from: g */
    private void m1468g() {
        m1464c();
        this.f2227A.run();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4387b() {
        if (this.f2231d == null) {
            this.f2231d = (ContentFrameLayout) findViewById(C0235R.C0237id.action_bar_activity_content);
            this.f2232e = (ActionBarContainer) findViewById(C0235R.C0237id.action_bar_container);
            this.f2233f = m1456a(findViewById(C0235R.C0237id.action_bar));
        }
    }

    public boolean canShowOverflowMenu() {
        mo4387b();
        return this.f2233f.canShowOverflowMenu();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopups() {
        mo4387b();
        this.f2233f.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2234g != null && !this.f2235h) {
            int bottom = this.f2232e.getVisibility() == 0 ? (int) (((float) this.f2232e.getBottom()) + ViewCompat.getTranslationY(this.f2232e) + 0.5f) : 0;
            this.f2234g.setBounds(0, bottom, getWidth(), this.f2234g.getIntrinsicHeight() + bottom);
            this.f2234g.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo4387b();
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
        }
        boolean a = m1461a(this.f2232e, rect, true, true, false, true);
        this.f2245r.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.f2245r, this.f2242o);
        if (!this.f2243p.equals(this.f2242o)) {
            this.f2243p.set(this.f2242o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.f2232e != null) {
            return -((int) ViewCompat.getTranslationY(this.f2232e));
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.f2228B.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        mo4387b();
        return this.f2233f.getTitle();
    }

    public boolean hasIcon() {
        mo4387b();
        return this.f2233f.hasIcon();
    }

    public boolean hasLogo() {
        mo4387b();
        return this.f2233f.hasLogo();
    }

    public boolean hideOverflowMenu() {
        mo4387b();
        return this.f2233f.hideOverflowMenu();
    }

    public void initFeature(int i) {
        mo4387b();
        switch (i) {
            case 2:
                this.f2233f.initProgress();
                return;
            case 5:
                this.f2233f.initIndeterminateProgress();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f2238k;
    }

    public boolean isInOverlayMode() {
        return this.f2236i;
    }

    public boolean isOverflowMenuShowPending() {
        mo4387b();
        return this.f2233f.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        mo4387b();
        return this.f2233f.isOverflowMenuShowing();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m1457a(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1464c();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        mo4387b();
        measureChildWithMargins(this.f2232e, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f2232e.getLayoutParams();
        int max = Math.max(0, this.f2232e.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.f2232e.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.f2232e));
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f2229b;
            if (this.f2237j && this.f2232e.getTabContainer() != null) {
                measuredHeight += this.f2229b;
            }
        } else {
            measuredHeight = this.f2232e.getVisibility() != 8 ? this.f2232e.getMeasuredHeight() : 0;
        }
        this.f2244q.set(this.f2242o);
        this.f2246s.set(this.f2245r);
        if (this.f2236i || z) {
            Rect rect = this.f2246s;
            rect.top = measuredHeight + rect.top;
            this.f2246s.bottom += 0;
        } else {
            Rect rect2 = this.f2244q;
            rect2.top = measuredHeight + rect2.top;
            this.f2244q.bottom += 0;
        }
        m1461a(this.f2231d, this.f2244q, true, true, true, true);
        if (!this.f2247t.equals(this.f2246s)) {
            this.f2247t.set(this.f2246s);
            this.f2231d.dispatchFitSystemWindows(this.f2246s);
        }
        measureChildWithMargins(this.f2231d, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f2231d.getLayoutParams();
        int max3 = Math.max(max, this.f2231d.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.f2231d.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.f2231d));
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f2238k || !z) {
            return false;
        }
        if (m1459a(f, f2)) {
            m1468g();
        } else {
            m1467f();
        }
        this.f2239l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f2240m += i2;
        setActionBarHideOffset(this.f2240m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f2228B.onNestedScrollAccepted(view, view2, i);
        this.f2240m = getActionBarHideOffset();
        m1464c();
        if (this.f2248u != null) {
            this.f2248u.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f2232e.getVisibility() != 0) {
            return false;
        }
        return this.f2238k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f2238k && !this.f2239l) {
            if (this.f2240m <= this.f2232e.getHeight()) {
                m1465d();
            } else {
                m1466e();
            }
        }
        if (this.f2248u != null) {
            this.f2248u.onContentScrollStopped();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo4387b();
        int i2 = this.f2241n ^ i;
        this.f2241n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f2248u != null) {
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.f2248u;
            if (z3) {
                z = false;
            }
            actionBarVisibilityCallback.enableContentAnimations(z);
            if (z2 || !z3) {
                this.f2248u.showForSystem();
            } else {
                this.f2248u.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.f2248u != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f2230c = i;
        if (this.f2248u != null) {
            this.f2248u.onWindowVisibilityChanged(i);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo4387b();
        this.f2233f.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo4387b();
        this.f2233f.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        m1464c();
        ViewCompat.setTranslationY(this.f2232e, (float) (-Math.max(0, Math.min(i, this.f2232e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f2248u = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f2248u.onWindowVisibilityChanged(this.f2230c);
            if (this.f2241n != 0) {
                onWindowSystemUiVisibilityChanged(this.f2241n);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2237j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f2238k) {
            this.f2238k = z;
            if (!z) {
                m1464c();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        mo4387b();
        this.f2233f.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        mo4387b();
        this.f2233f.setIcon(drawable);
    }

    public void setLogo(int i) {
        mo4387b();
        this.f2233f.setLogo(i);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        mo4387b();
        this.f2233f.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        mo4387b();
        this.f2233f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.f2236i = z;
        this.f2235h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        mo4387b();
        this.f2233f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo4387b();
        this.f2233f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        mo4387b();
        return this.f2233f.showOverflowMenu();
    }
}
