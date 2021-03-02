package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.p001v4.view.NestedScrollingParent;
import android.support.p001v4.view.NestedScrollingParentHelper;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.support.p001v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p001v4.widget.ScrollerCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {

    /* renamed from: a */
    static final int[] f1862a = {C0505R.attr.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f1863A;

    /* renamed from: B */
    private final NestedScrollingParentHelper f1864B;

    /* renamed from: b */
    private int f1865b;

    /* renamed from: c */
    private int f1866c;

    /* renamed from: d */
    private ContentFrameLayout f1867d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ActionBarContainer f1868e;

    /* renamed from: f */
    private DecorToolbar f1869f;

    /* renamed from: g */
    private Drawable f1870g;

    /* renamed from: h */
    private boolean f1871h;

    /* renamed from: i */
    private boolean f1872i;

    /* renamed from: j */
    private boolean f1873j;

    /* renamed from: k */
    private boolean f1874k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1875l;

    /* renamed from: m */
    private int f1876m;

    /* renamed from: n */
    private int f1877n;

    /* renamed from: o */
    private final Rect f1878o;

    /* renamed from: p */
    private final Rect f1879p;

    /* renamed from: q */
    private final Rect f1880q;

    /* renamed from: r */
    private final Rect f1881r;

    /* renamed from: s */
    private final Rect f1882s;

    /* renamed from: t */
    private final Rect f1883t;

    /* renamed from: u */
    private ActionBarVisibilityCallback f1884u;

    /* renamed from: v */
    private final int f1885v;

    /* renamed from: w */
    private ScrollerCompat f1886w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewPropertyAnimatorCompat f1887x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final ViewPropertyAnimatorListener f1888y;

    /* renamed from: z */
    private final Runnable f1889z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1866c = 0;
        this.f1878o = new Rect();
        this.f1879p = new Rect();
        this.f1880q = new Rect();
        this.f1881r = new Rect();
        this.f1882s = new Rect();
        this.f1883t = new Rect();
        this.f1885v = 600;
        this.f1888y = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f1887x = null;
                boolean unused2 = ActionBarOverlayLayout.this.f1875l = false;
            }

            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f1887x = null;
                boolean unused2 = ActionBarOverlayLayout.this.f1875l = false;
            }
        };
        this.f1889z = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m3079b();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f1887x = ViewCompat.animate(ActionBarOverlayLayout.this.f1868e).translationY(BitmapDescriptorFactory.HUE_RED).setListener(ActionBarOverlayLayout.this.f1888y);
            }
        };
        this.f1863A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.m3079b();
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.f1887x = ViewCompat.animate(ActionBarOverlayLayout.this.f1868e).translationY((float) (-ActionBarOverlayLayout.this.f1868e.getHeight())).setListener(ActionBarOverlayLayout.this.f1888y);
            }
        };
        m3073a(context);
        this.f1864B = new NestedScrollingParentHelper(this);
    }

    /* renamed from: a */
    private void m3073a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1862a);
        this.f1865b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1870g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1870g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1871h = z;
        this.f1886w = ScrollerCompat.create(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3079b();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1884u = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1884u.onWindowVisibilityChanged(this.f1866c);
            if (this.f1877n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1877n);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1872i = z;
        this.f1871h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean isInOverlayMode() {
        return this.f1872i;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1873j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m3073a(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo3924a();
        int i2 = this.f1877n ^ i;
        this.f1877n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1884u != null) {
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1884u;
            if (z) {
                z2 = false;
            }
            actionBarVisibilityCallback.enableContentAnimations(z2);
            if (z3 || !z) {
                this.f1884u.showForSystem();
            } else {
                this.f1884u.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.f1884u != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1866c = i;
        if (this.f1884u != null) {
            this.f1884u.onWindowVisibilityChanged(i);
        }
    }

    /* renamed from: a */
    private boolean m3077a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
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

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo3924a();
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
        }
        boolean a = m3077a(this.f1868e, rect, true, true, false, true);
        this.f1881r.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.f1881r, this.f1878o);
        if (!this.f1879p.equals(this.f1878o)) {
            this.f1879p.set(this.f1878o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int measuredHeight;
        mo3924a();
        measureChildWithMargins(this.f1868e, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1868e.getLayoutParams();
        int max = Math.max(0, this.f1868e.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.f1868e.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.f1868e));
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            measuredHeight = this.f1865b;
            if (this.f1873j && this.f1868e.getTabContainer() != null) {
                measuredHeight += this.f1865b;
            }
        } else {
            measuredHeight = this.f1868e.getVisibility() != 8 ? this.f1868e.getMeasuredHeight() : 0;
        }
        this.f1880q.set(this.f1878o);
        this.f1882s.set(this.f1881r);
        if (this.f1872i || z) {
            Rect rect = this.f1882s;
            rect.top = measuredHeight + rect.top;
            this.f1882s.bottom += 0;
        } else {
            Rect rect2 = this.f1880q;
            rect2.top = measuredHeight + rect2.top;
            this.f1880q.bottom += 0;
        }
        m3077a(this.f1867d, this.f1880q, true, true, true, true);
        if (!this.f1883t.equals(this.f1882s)) {
            this.f1883t.set(this.f1882s);
            this.f1867d.dispatchFitSystemWindows(this.f1882s);
        }
        measureChildWithMargins(this.f1867d, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1867d.getLayoutParams();
        int max3 = Math.max(max, this.f1867d.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.f1867d.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.f1867d));
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
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

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1870g != null && !this.f1871h) {
            int bottom = this.f1868e.getVisibility() == 0 ? (int) (((float) this.f1868e.getBottom()) + ViewCompat.getTranslationY(this.f1868e) + 0.5f) : 0;
            this.f1870g.setBounds(0, bottom, getWidth(), this.f1870g.getIntrinsicHeight() + bottom);
            this.f1870g.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1868e.getVisibility() != 0) {
            return false;
        }
        return this.f1874k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1864B.onNestedScrollAccepted(view, view2, i);
        this.f1876m = getActionBarHideOffset();
        m3079b();
        if (this.f1884u != null) {
            this.f1884u.onContentScrollStarted();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1876m += i2;
        setActionBarHideOffset(this.f1876m);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1874k && !this.f1875l) {
            if (this.f1876m <= this.f1868e.getHeight()) {
                m3081c();
            } else {
                m3082d();
            }
        }
        if (this.f1884u != null) {
            this.f1884u.onContentScrollStopped();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1874k || !z) {
            return false;
        }
        if (m3075a(f, f2)) {
            m3084f();
        } else {
            m3083e();
        }
        this.f1875l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1864B.getNestedScrollAxes();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3924a() {
        if (this.f1867d == null) {
            this.f1867d = (ContentFrameLayout) findViewById(C0505R.C0507id.action_bar_activity_content);
            this.f1868e = (ActionBarContainer) findViewById(C0505R.C0507id.action_bar_container);
            this.f1869f = m3072a(findViewById(C0505R.C0507id.action_bar));
        }
    }

    /* renamed from: a */
    private DecorToolbar m3072a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1874k) {
            this.f1874k = z;
            if (!z) {
                m3079b();
                setActionBarHideOffset(0);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1874k;
    }

    public int getActionBarHideOffset() {
        if (this.f1868e != null) {
            return -((int) ViewCompat.getTranslationY(this.f1868e));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        m3079b();
        ViewCompat.setTranslationY(this.f1868e, (float) (-Math.max(0, Math.min(i, this.f1868e.getHeight()))));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3079b() {
        removeCallbacks(this.f1889z);
        removeCallbacks(this.f1863A);
        if (this.f1887x != null) {
            this.f1887x.cancel();
        }
    }

    /* renamed from: c */
    private void m3081c() {
        m3079b();
        postDelayed(this.f1889z, 600);
    }

    /* renamed from: d */
    private void m3082d() {
        m3079b();
        postDelayed(this.f1863A, 600);
    }

    /* renamed from: e */
    private void m3083e() {
        m3079b();
        this.f1889z.run();
    }

    /* renamed from: f */
    private void m3084f() {
        m3079b();
        this.f1863A.run();
    }

    /* renamed from: a */
    private boolean m3075a(float f, float f2) {
        this.f1886w.fling(0, 0, 0, (int) f2, 0, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE);
        if (this.f1886w.getFinalY() > this.f1868e.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Window.Callback callback) {
        mo3924a();
        this.f1869f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo3924a();
        this.f1869f.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        mo3924a();
        return this.f1869f.getTitle();
    }

    public void initFeature(int i) {
        mo3924a();
        switch (i) {
            case 2:
                this.f1869f.initProgress();
                return;
            case 5:
                this.f1869f.initIndeterminateProgress();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public boolean hasIcon() {
        mo3924a();
        return this.f1869f.hasIcon();
    }

    public boolean hasLogo() {
        mo3924a();
        return this.f1869f.hasLogo();
    }

    public void setIcon(int i) {
        mo3924a();
        this.f1869f.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        mo3924a();
        this.f1869f.setIcon(drawable);
    }

    public void setLogo(int i) {
        mo3924a();
        this.f1869f.setLogo(i);
    }

    public boolean canShowOverflowMenu() {
        mo3924a();
        return this.f1869f.canShowOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        mo3924a();
        return this.f1869f.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        mo3924a();
        return this.f1869f.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        mo3924a();
        return this.f1869f.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        mo3924a();
        return this.f1869f.hideOverflowMenu();
    }

    public void setMenuPrepared() {
        mo3924a();
        this.f1869f.setMenuPrepared();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        mo3924a();
        this.f1869f.setMenu(menu, callback);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo3924a();
        this.f1869f.saveHierarchyState(sparseArray);
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        mo3924a();
        this.f1869f.restoreHierarchyState(sparseArray);
    }

    public void dismissPopups() {
        mo3924a();
        this.f1869f.dismissPopupMenus();
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }
}
