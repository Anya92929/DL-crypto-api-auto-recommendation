package android.support.p004v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.support.p001v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p001v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.p004v7.app.ActionBar;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionBarPolicy;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.SupportMenuInflater;
import android.support.p004v7.view.ViewPropertyAnimatorCompatSet;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPopupHelper;
import android.support.p004v7.view.menu.SubMenuBuilder;
import android.support.p004v7.widget.ActionBarContainer;
import android.support.p004v7.widget.ActionBarContextView;
import android.support.p004v7.widget.ActionBarOverlayLayout;
import android.support.p004v7.widget.DecorToolbar;
import android.support.p004v7.widget.ScrollingTabContainerView;
import android.support.p004v7.widget.TintManager;
import android.support.p004v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.WindowDecorActionBar */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: h */
    static final /* synthetic */ boolean f1560h = (!WindowDecorActionBar.class.desiredAssertionStatus());

    /* renamed from: i */
    private static final Interpolator f1561i = new AccelerateInterpolator();

    /* renamed from: j */
    private static final Interpolator f1562j = new DecelerateInterpolator();

    /* renamed from: k */
    private static final boolean f1563k;

    /* renamed from: A */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f1564A = new ArrayList<>();

    /* renamed from: B */
    private boolean f1565B;

    /* renamed from: C */
    private int f1566C = 0;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f1567D = true;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f1568E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f1569F;

    /* renamed from: G */
    private boolean f1570G;

    /* renamed from: H */
    private boolean f1571H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public ViewPropertyAnimatorCompatSet f1572I;

    /* renamed from: J */
    private boolean f1573J;

    /* renamed from: K */
    private TintManager f1574K;

    /* renamed from: a */
    ActionModeImpl f1575a;

    /* renamed from: b */
    ActionMode f1576b;

    /* renamed from: c */
    ActionMode.Callback f1577c;

    /* renamed from: d */
    boolean f1578d;

    /* renamed from: e */
    final ViewPropertyAnimatorListener f1579e = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (WindowDecorActionBar.this.f1567D && WindowDecorActionBar.this.f1590t != null) {
                ViewCompat.setTranslationY(WindowDecorActionBar.this.f1590t, BitmapDescriptorFactory.HUE_RED);
                ViewCompat.setTranslationY(WindowDecorActionBar.this.f1587q, BitmapDescriptorFactory.HUE_RED);
            }
            WindowDecorActionBar.this.f1587q.setVisibility(8);
            WindowDecorActionBar.this.f1587q.setTransitioning(false);
            ViewPropertyAnimatorCompatSet unused = WindowDecorActionBar.this.f1572I = null;
            WindowDecorActionBar.this.mo3386a();
            if (WindowDecorActionBar.this.f1586p != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.f1586p);
            }
        }
    };

    /* renamed from: f */
    final ViewPropertyAnimatorListener f1580f = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            ViewPropertyAnimatorCompatSet unused = WindowDecorActionBar.this.f1572I = null;
            WindowDecorActionBar.this.f1587q.requestLayout();
        }
    };

    /* renamed from: g */
    final ViewPropertyAnimatorUpdateListener f1581g = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.f1587q.getParent()).invalidate();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Context f1582l;

    /* renamed from: m */
    private Context f1583m;

    /* renamed from: n */
    private Activity f1584n;

    /* renamed from: o */
    private Dialog f1585o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ActionBarOverlayLayout f1586p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ActionBarContainer f1587q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public DecorToolbar f1588r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ActionBarContextView f1589s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public View f1590t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ScrollingTabContainerView f1591u;

    /* renamed from: v */
    private ArrayList<TabImpl> f1592v = new ArrayList<>();

    /* renamed from: w */
    private TabImpl f1593w;

    /* renamed from: x */
    private int f1594x = -1;

    /* renamed from: y */
    private boolean f1595y;

    /* renamed from: z */
    private boolean f1596z;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        f1563k = z;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f1584n = activity;
        View decorView = activity.getWindow().getDecorView();
        m2971a(decorView);
        if (!z) {
            this.f1590t = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f1585o = dialog;
        m2971a(dialog.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View view) {
        if (f1560h || view.isInEditMode()) {
            m2971a(view);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m2971a(View view) {
        boolean z;
        this.f1586p = (ActionBarOverlayLayout) view.findViewById(C0505R.C0507id.decor_content_parent);
        if (this.f1586p != null) {
            this.f1586p.setActionBarVisibilityCallback(this);
        }
        this.f1588r = m2975b(view.findViewById(C0505R.C0507id.action_bar));
        this.f1589s = (ActionBarContextView) view.findViewById(C0505R.C0507id.action_context_bar);
        this.f1587q = (ActionBarContainer) view.findViewById(C0505R.C0507id.action_bar_container);
        if (this.f1588r == null || this.f1589s == null || this.f1587q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1582l = this.f1588r.getContext();
        boolean z2 = (this.f1588r.getDisplayOptions() & 4) != 0;
        if (z2) {
            this.f1595y = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f1582l);
        if (actionBarPolicy.enableHomeButtonByDefault() || z2) {
            z = true;
        } else {
            z = false;
        }
        setHomeButtonEnabled(z);
        m2972a(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.f1582l.obtainStyledAttributes((AttributeSet) null, C0505R.styleable.ActionBar, C0505R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0505R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private DecorToolbar m2975b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.f1587q, f);
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f1587q);
    }

    public void onConfigurationChanged(Configuration configuration) {
        m2972a(ActionBarPolicy.get(this.f1582l).hasEmbeddedTabs());
    }

    /* renamed from: a */
    private void m2972a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f1565B = z;
        if (!this.f1565B) {
            this.f1588r.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.f1587q.setTabContainer(this.f1591u);
        } else {
            this.f1587q.setTabContainer((ScrollingTabContainerView) null);
            this.f1588r.setEmbeddedTabView(this.f1591u);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f1591u != null) {
            if (z2) {
                this.f1591u.setVisibility(0);
                if (this.f1586p != null) {
                    ViewCompat.requestApplyInsets(this.f1586p);
                }
            } else {
                this.f1591u.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f1588r;
        if (this.f1565B || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        decorToolbar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1586p;
        if (this.f1565B || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    /* renamed from: c */
    private void m2980c() {
        if (this.f1591u == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f1582l);
            if (this.f1565B) {
                scrollingTabContainerView.setVisibility(0);
                this.f1588r.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.f1586p != null) {
                        ViewCompat.requestApplyInsets(this.f1586p);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f1587q.setTabContainer(scrollingTabContainerView);
            }
            this.f1591u = scrollingTabContainerView;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3386a() {
        if (this.f1577c != null) {
            this.f1577c.onDestroyActionMode(this.f1576b);
            this.f1576b = null;
            this.f1577c = null;
        }
    }

    public void onWindowVisibilityChanged(int i) {
        this.f1566C = i;
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.f1573J = z;
        if (!z && this.f1572I != null) {
            this.f1572I.cancel();
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1564A.add(onMenuVisibilityListener);
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1564A.remove(onMenuVisibilityListener);
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f1596z) {
            this.f1596z = z;
            int size = this.f1564A.size();
            for (int i = 0; i < size; i++) {
                this.f1564A.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f1588r.getViewGroup(), false));
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.f1588r.setHomeButtonEnabled(z);
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f1582l.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f1582l.getString(i));
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.f1588r.getNavigationMode()) {
            case 1:
                this.f1588r.setDropdownSelectedPosition(i);
                return;
            case 2:
                selectTab(this.f1592v.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void removeAllTabs() {
        m2982d();
    }

    /* renamed from: d */
    private void m2982d() {
        if (this.f1593w != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.f1592v.clear();
        if (this.f1591u != null) {
            this.f1591u.removeAllTabs();
        }
        this.f1594x = -1;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1588r.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f1588r.setWindowTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1588r.setSubtitle(charSequence);
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f1595y = true;
        }
        this.f1588r.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f1588r.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f1595y = true;
        }
        this.f1588r.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f1587q.setPrimaryBackground(drawable);
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f1587q.setStackedBackground(drawable);
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public View getCustomView() {
        return this.f1588r.getCustomView();
    }

    public CharSequence getTitle() {
        return this.f1588r.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.f1588r.getSubtitle();
    }

    public int getNavigationMode() {
        return this.f1588r.getNavigationMode();
    }

    public int getDisplayOptions() {
        return this.f1588r.getDisplayOptions();
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.f1575a != null) {
            this.f1575a.finish();
        }
        this.f1586p.setHideOnContentScrollEnabled(false);
        this.f1589s.killMode();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.f1589s.getContext(), callback);
        if (!actionModeImpl.dispatchOnCreate()) {
            return null;
        }
        actionModeImpl.invalidate();
        this.f1589s.initForMode(actionModeImpl);
        animateToMode(true);
        this.f1589s.sendAccessibilityEvent(32);
        this.f1575a = actionModeImpl;
        return actionModeImpl;
    }

    /* renamed from: a */
    private void m2970a(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.f1592v.add(i, tabImpl);
        int size = this.f1592v.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f1592v.get(i2).setPosition(i2);
        }
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.f1592v.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.f1592v.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        m2980c();
        this.f1591u.addTab(tab, z);
        m2970a(tab, this.f1592v.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        m2980c();
        this.f1591u.addTab(tab, i, z);
        m2970a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.f1591u != null) {
            int position = this.f1593w != null ? this.f1593w.getPosition() : this.f1594x;
            this.f1591u.removeTabAt(i);
            TabImpl remove = this.f1592v.remove(i);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.f1592v.size();
            for (int i2 = i; i2 < size; i2++) {
                this.f1592v.get(i2).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.f1592v.isEmpty() ? null : this.f1592v.get(Math.max(0, i - 1)));
            }
        }
    }

    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        int i;
        int i2 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            } else {
                i = -1;
            }
            this.f1594x = i;
            return;
        }
        if (!(this.f1584n instanceof FragmentActivity) || this.f1588r.getViewGroup().isInEditMode()) {
            fragmentTransaction = null;
        } else {
            fragmentTransaction = ((FragmentActivity) this.f1584n).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        if (this.f1593w != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f1591u;
            if (tab != null) {
                i2 = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i2);
            if (this.f1593w != null) {
                this.f1593w.getCallback().onTabUnselected(this.f1593w, fragmentTransaction);
            }
            this.f1593w = (TabImpl) tab;
            if (this.f1593w != null) {
                this.f1593w.getCallback().onTabSelected(this.f1593w, fragmentTransaction);
            }
        } else if (this.f1593w != null) {
            this.f1593w.getCallback().onTabReselected(this.f1593w, fragmentTransaction);
            this.f1591u.animateToTab(tab.getPosition());
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    public ActionBar.Tab getSelectedTab() {
        return this.f1593w;
    }

    public int getHeight() {
        return this.f1587q.getHeight();
    }

    public void enableContentAnimations(boolean z) {
        this.f1567D = z;
    }

    public void show() {
        if (this.f1568E) {
            this.f1568E = false;
            m2977b(false);
        }
    }

    /* renamed from: e */
    private void m2983e() {
        if (!this.f1570G) {
            this.f1570G = true;
            if (this.f1586p != null) {
                this.f1586p.setShowingForActionMode(true);
            }
            m2977b(false);
        }
    }

    public void showForSystem() {
        if (this.f1569F) {
            this.f1569F = false;
            m2977b(true);
        }
    }

    public void hide() {
        if (!this.f1568E) {
            this.f1568E = true;
            m2977b(false);
        }
    }

    /* renamed from: f */
    private void m2985f() {
        if (this.f1570G) {
            this.f1570G = false;
            if (this.f1586p != null) {
                this.f1586p.setShowingForActionMode(false);
            }
            m2977b(false);
        }
    }

    public void hideForSystem() {
        if (!this.f1569F) {
            this.f1569F = true;
            m2977b(true);
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (!z || this.f1586p.isInOverlayMode()) {
            this.f1578d = z;
            this.f1586p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1586p.isHideOnContentScrollEnabled();
    }

    public int getHideOffset() {
        return this.f1586p.getActionBarHideOffset();
    }

    public void setHideOffset(int i) {
        if (i == 0 || this.f1586p.isInOverlayMode()) {
            this.f1586p.setActionBarHideOffset(i);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2978b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m2977b(boolean z) {
        if (m2978b(this.f1568E, this.f1569F, this.f1570G)) {
            if (!this.f1571H) {
                this.f1571H = true;
                doShow(z);
            }
        } else if (this.f1571H) {
            this.f1571H = false;
            doHide(z);
        }
    }

    public void doShow(boolean z) {
        if (this.f1572I != null) {
            this.f1572I.cancel();
        }
        this.f1587q.setVisibility(0);
        if (this.f1566C != 0 || !f1563k || (!this.f1573J && !z)) {
            ViewCompat.setAlpha(this.f1587q, 1.0f);
            ViewCompat.setTranslationY(this.f1587q, BitmapDescriptorFactory.HUE_RED);
            if (this.f1567D && this.f1590t != null) {
                ViewCompat.setTranslationY(this.f1590t, BitmapDescriptorFactory.HUE_RED);
            }
            this.f1580f.onAnimationEnd((View) null);
        } else {
            ViewCompat.setTranslationY(this.f1587q, BitmapDescriptorFactory.HUE_RED);
            float f = (float) (-this.f1587q.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f1587q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.setTranslationY(this.f1587q, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1587q).translationY(BitmapDescriptorFactory.HUE_RED);
            translationY.setUpdateListener(this.f1581g);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.f1567D && this.f1590t != null) {
                ViewCompat.setTranslationY(this.f1590t, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f1590t).translationY(BitmapDescriptorFactory.HUE_RED));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(f1562j);
            viewPropertyAnimatorCompatSet.setDuration(250);
            viewPropertyAnimatorCompatSet.setListener(this.f1580f);
            this.f1572I = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        }
        if (this.f1586p != null) {
            ViewCompat.requestApplyInsets(this.f1586p);
        }
    }

    public void doHide(boolean z) {
        if (this.f1572I != null) {
            this.f1572I.cancel();
        }
        if (this.f1566C != 0 || !f1563k || (!this.f1573J && !z)) {
            this.f1579e.onAnimationEnd((View) null);
            return;
        }
        ViewCompat.setAlpha(this.f1587q, 1.0f);
        this.f1587q.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        float f = (float) (-this.f1587q.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f1587q.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1587q).translationY(f);
        translationY.setUpdateListener(this.f1581g);
        viewPropertyAnimatorCompatSet.play(translationY);
        if (this.f1567D && this.f1590t != null) {
            viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f1590t).translationY(f));
        }
        viewPropertyAnimatorCompatSet.setInterpolator(f1561i);
        viewPropertyAnimatorCompatSet.setDuration(250);
        viewPropertyAnimatorCompatSet.setListener(this.f1579e);
        this.f1572I = viewPropertyAnimatorCompatSet;
        viewPropertyAnimatorCompatSet.start();
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.f1571H && (height == 0 || getHideOffset() < height);
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            m2983e();
        } else {
            m2985f();
        }
        if (z) {
            viewPropertyAnimatorCompat2 = this.f1588r.setupAnimatorToVisibility(4, 100);
            viewPropertyAnimatorCompat = this.f1589s.setupAnimatorToVisibility(0, 200);
        } else {
            viewPropertyAnimatorCompat = this.f1588r.setupAnimatorToVisibility(0, 200);
            viewPropertyAnimatorCompat2 = this.f1589s.setupAnimatorToVisibility(8, 100);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.start();
    }

    public Context getThemedContext() {
        if (this.f1583m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1582l.getTheme().resolveAttribute(C0505R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1583m = new ContextThemeWrapper(this.f1582l, i);
            } else {
                this.f1583m = this.f1582l;
            }
        }
        return this.f1583m;
    }

    public boolean isTitleTruncated() {
        return this.f1588r != null && this.f1588r.isTitleTruncated();
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f1588r.setNavigationIcon(drawable);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f1588r.setNavigationIcon(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f1588r.setNavigationContentDescription(charSequence);
    }

    public void setHomeActionContentDescription(int i) {
        this.f1588r.setNavigationContentDescription(i);
    }

    public void onContentScrollStarted() {
        if (this.f1572I != null) {
            this.f1572I.cancel();
            this.f1572I = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean collapseActionView() {
        if (this.f1588r == null || !this.f1588r.hasExpandedActionView()) {
            return false;
        }
        this.f1588r.collapseActionView();
        return true;
    }

    /* renamed from: android.support.v7.app.WindowDecorActionBar$ActionModeImpl */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: b */
        private final Context f1601b;

        /* renamed from: c */
        private final MenuBuilder f1602c;

        /* renamed from: d */
        private ActionMode.Callback f1603d;

        /* renamed from: e */
        private WeakReference<View> f1604e;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f1601b = context;
            this.f1603d = callback;
            this.f1602c = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f1602c.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f1601b);
        }

        public Menu getMenu() {
            return this.f1602c;
        }

        public void finish() {
            if (WindowDecorActionBar.this.f1575a == this) {
                if (!WindowDecorActionBar.m2978b(WindowDecorActionBar.this.f1568E, WindowDecorActionBar.this.f1569F, false)) {
                    WindowDecorActionBar.this.f1576b = this;
                    WindowDecorActionBar.this.f1577c = this.f1603d;
                } else {
                    this.f1603d.onDestroyActionMode(this);
                }
                this.f1603d = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.f1589s.closeMode();
                WindowDecorActionBar.this.f1588r.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.f1586p.setHideOnContentScrollEnabled(WindowDecorActionBar.this.f1578d);
                WindowDecorActionBar.this.f1575a = null;
            }
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.f1575a == this) {
                this.f1602c.stopDispatchingItemsChanged();
                try {
                    this.f1603d.onPrepareActionMode(this, this.f1602c);
                } finally {
                    this.f1602c.startDispatchingItemsChanged();
                }
            }
        }

        public boolean dispatchOnCreate() {
            this.f1602c.stopDispatchingItemsChanged();
            try {
                return this.f1603d.onCreateActionMode(this, this.f1602c);
            } finally {
                this.f1602c.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.f1589s.setCustomView(view);
            this.f1604e = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f1589s.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f1589s.setTitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle((CharSequence) WindowDecorActionBar.this.f1582l.getResources().getString(i));
        }

        public void setSubtitle(int i) {
            setSubtitle((CharSequence) WindowDecorActionBar.this.f1582l.getResources().getString(i));
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.f1589s.getTitle();
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.f1589s.getSubtitle();
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.f1589s.setTitleOptional(z);
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.f1589s.isTitleOptional();
        }

        public View getCustomView() {
            if (this.f1604e != null) {
                return (View) this.f1604e.get();
            }
            return null;
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f1603d != null) {
                return this.f1603d.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f1603d == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f1603d != null) {
                invalidate();
                WindowDecorActionBar.this.f1589s.showOverflowMenu();
            }
        }
    }

    /* renamed from: android.support.v7.app.WindowDecorActionBar$TabImpl */
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: b */
        private ActionBar.TabListener f1606b;

        /* renamed from: c */
        private Object f1607c;

        /* renamed from: d */
        private Drawable f1608d;

        /* renamed from: e */
        private CharSequence f1609e;

        /* renamed from: f */
        private CharSequence f1610f;

        /* renamed from: g */
        private int f1611g = -1;

        /* renamed from: h */
        private View f1612h;

        public TabImpl() {
        }

        public Object getTag() {
            return this.f1607c;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.f1607c = obj;
            return this;
        }

        public ActionBar.TabListener getCallback() {
            return this.f1606b;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f1606b = tabListener;
            return this;
        }

        public View getCustomView() {
            return this.f1612h;
        }

        public ActionBar.Tab setCustomView(View view) {
            this.f1612h = view;
            if (this.f1611g >= 0) {
                WindowDecorActionBar.this.f1591u.updateTab(this.f1611g);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        public Drawable getIcon() {
            return this.f1608d;
        }

        public int getPosition() {
            return this.f1611g;
        }

        public void setPosition(int i) {
            this.f1611g = i;
        }

        public CharSequence getText() {
            return this.f1609e;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f1608d = drawable;
            if (this.f1611g >= 0) {
                WindowDecorActionBar.this.f1591u.updateTab(this.f1611g);
            }
            return this;
        }

        public ActionBar.Tab setIcon(int i) {
            return setIcon(WindowDecorActionBar.this.mo3388b().getDrawable(i));
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f1609e = charSequence;
            if (this.f1611g >= 0) {
                WindowDecorActionBar.this.f1591u.updateTab(this.f1611g);
            }
            return this;
        }

        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.f1582l.getResources().getText(i));
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.f1582l.getResources().getText(i));
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f1610f = charSequence;
            if (this.f1611g >= 0) {
                WindowDecorActionBar.this.f1591u.updateTab(this.f1611g);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.f1610f;
        }
    }

    public void setCustomView(View view) {
        this.f1588r.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f1588r.setCustomView(view);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f1588r.setDropdownParams(spinnerAdapter, new C1153gd(onNavigationListener));
    }

    public int getSelectedNavigationIndex() {
        switch (this.f1588r.getNavigationMode()) {
            case 1:
                return this.f1588r.getDropdownSelectedPosition();
            case 2:
                if (this.f1593w != null) {
                    return this.f1593w.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.f1588r.getNavigationMode()) {
            case 1:
                return this.f1588r.getDropdownItemCount();
            case 2:
                return this.f1592v.size();
            default:
                return 0;
        }
    }

    public int getTabCount() {
        return this.f1592v.size();
    }

    public void setNavigationMode(int i) {
        boolean z;
        boolean z2 = true;
        int navigationMode = this.f1588r.getNavigationMode();
        switch (navigationMode) {
            case 2:
                this.f1594x = getSelectedNavigationIndex();
                selectTab((ActionBar.Tab) null);
                this.f1591u.setVisibility(8);
                break;
        }
        if (!(navigationMode == i || this.f1565B || this.f1586p == null)) {
            ViewCompat.requestApplyInsets(this.f1586p);
        }
        this.f1588r.setNavigationMode(i);
        switch (i) {
            case 2:
                m2980c();
                this.f1591u.setVisibility(0);
                if (this.f1594x != -1) {
                    setSelectedNavigationItem(this.f1594x);
                    this.f1594x = -1;
                    break;
                }
                break;
        }
        DecorToolbar decorToolbar = this.f1588r;
        if (i != 2 || this.f1565B) {
            z = false;
        } else {
            z = true;
        }
        decorToolbar.setCollapsible(z);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1586p;
        if (i != 2 || this.f1565B) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    public ActionBar.Tab getTabAt(int i) {
        return this.f1592v.get(i);
    }

    public void setIcon(int i) {
        this.f1588r.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1588r.setIcon(drawable);
    }

    public boolean hasIcon() {
        return this.f1588r.hasIcon();
    }

    public void setLogo(int i) {
        this.f1588r.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.f1588r.setLogo(drawable);
    }

    public boolean hasLogo() {
        return this.f1588r.hasLogo();
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.f1595y) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public TintManager mo3388b() {
        if (this.f1574K == null) {
            this.f1574K = TintManager.get(this.f1582l);
        }
        return this.f1574K;
    }
}
