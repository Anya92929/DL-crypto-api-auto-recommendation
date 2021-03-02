package android.support.p003v7.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p000v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.ActionBarPolicy;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPopupHelper;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.internal.widget.ActionBarContainer;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.internal.widget.ActionBarOverlayLayout;
import android.support.p003v7.internal.widget.DecorToolbar;
import android.support.p003v7.internal.widget.ScrollingTabContainerView;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
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

/* renamed from: android.support.v7.internal.app.WindowDecorActionBar */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: h */
    static final /* synthetic */ boolean f1918h = (!WindowDecorActionBar.class.desiredAssertionStatus());

    /* renamed from: i */
    private static final Interpolator f1919i = new AccelerateInterpolator();

    /* renamed from: j */
    private static final Interpolator f1920j = new DecelerateInterpolator();

    /* renamed from: k */
    private static final boolean f1921k;

    /* renamed from: A */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f1922A = new ArrayList<>();

    /* renamed from: B */
    private boolean f1923B;

    /* renamed from: C */
    private int f1924C = 0;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f1925D = true;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f1926E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f1927F;

    /* renamed from: G */
    private boolean f1928G;

    /* renamed from: H */
    private boolean f1929H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public ViewPropertyAnimatorCompatSet f1930I;

    /* renamed from: J */
    private boolean f1931J;

    /* renamed from: K */
    private TintManager f1932K;

    /* renamed from: a */
    ActionModeImpl f1933a;

    /* renamed from: b */
    ActionMode f1934b;

    /* renamed from: c */
    ActionMode.Callback f1935c;

    /* renamed from: d */
    boolean f1936d;

    /* renamed from: e */
    final ViewPropertyAnimatorListener f1937e = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (WindowDecorActionBar.this.f1925D && WindowDecorActionBar.this.f1948t != null) {
                ViewCompat.setTranslationY(WindowDecorActionBar.this.f1948t, BitmapDescriptorFactory.HUE_RED);
                ViewCompat.setTranslationY(WindowDecorActionBar.this.f1945q, BitmapDescriptorFactory.HUE_RED);
            }
            WindowDecorActionBar.this.f1945q.setVisibility(8);
            WindowDecorActionBar.this.f1945q.setTransitioning(false);
            ViewPropertyAnimatorCompatSet unused = WindowDecorActionBar.this.f1930I = null;
            WindowDecorActionBar.this.mo3885a();
            if (WindowDecorActionBar.this.f1944p != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.f1944p);
            }
        }
    };

    /* renamed from: f */
    final ViewPropertyAnimatorListener f1938f = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            ViewPropertyAnimatorCompatSet unused = WindowDecorActionBar.this.f1930I = null;
            WindowDecorActionBar.this.f1945q.requestLayout();
        }
    };

    /* renamed from: g */
    final ViewPropertyAnimatorUpdateListener f1939g = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.f1945q.getParent()).invalidate();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Context f1940l;

    /* renamed from: m */
    private Context f1941m;

    /* renamed from: n */
    private Activity f1942n;

    /* renamed from: o */
    private Dialog f1943o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ActionBarOverlayLayout f1944p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ActionBarContainer f1945q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public DecorToolbar f1946r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ActionBarContextView f1947s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public View f1948t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ScrollingTabContainerView f1949u;

    /* renamed from: v */
    private ArrayList<TabImpl> f1950v = new ArrayList<>();

    /* renamed from: w */
    private TabImpl f1951w;

    /* renamed from: x */
    private int f1952x = -1;

    /* renamed from: y */
    private boolean f1953y;

    /* renamed from: z */
    private boolean f1954z;

    /* renamed from: android.support.v7.internal.app.WindowDecorActionBar$ActionModeImpl */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: b */
        private final Context f1959b;

        /* renamed from: c */
        private final MenuBuilder f1960c;

        /* renamed from: d */
        private ActionMode.Callback f1961d;

        /* renamed from: e */
        private WeakReference<View> f1962e;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f1959b = context;
            this.f1961d = callback;
            this.f1960c = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f1960c.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.f1960c.stopDispatchingItemsChanged();
            try {
                return this.f1961d.onCreateActionMode(this, this.f1960c);
            } finally {
                this.f1960c.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            if (WindowDecorActionBar.this.f1933a == this) {
                if (!WindowDecorActionBar.m1356b(WindowDecorActionBar.this.f1926E, WindowDecorActionBar.this.f1927F, false)) {
                    WindowDecorActionBar.this.f1934b = this;
                    WindowDecorActionBar.this.f1935c = this.f1961d;
                } else {
                    this.f1961d.onDestroyActionMode(this);
                }
                this.f1961d = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.f1947s.closeMode();
                WindowDecorActionBar.this.f1946r.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.f1944p.setHideOnContentScrollEnabled(WindowDecorActionBar.this.f1936d);
                WindowDecorActionBar.this.f1933a = null;
            }
        }

        public View getCustomView() {
            if (this.f1962e != null) {
                return (View) this.f1962e.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.f1960c;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f1959b);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.f1947s.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.f1947s.getTitle();
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.f1933a == this) {
                this.f1960c.stopDispatchingItemsChanged();
                try {
                    this.f1961d.onPrepareActionMode(this, this.f1960c);
                } finally {
                    this.f1960c.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.f1947s.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f1961d != null) {
                return this.f1961d.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f1961d != null) {
                invalidate();
                WindowDecorActionBar.this.f1947s.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f1961d == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.f1947s.setCustomView(view);
            this.f1962e = new WeakReference<>(view);
        }

        public void setSubtitle(int i) {
            setSubtitle((CharSequence) WindowDecorActionBar.this.f1940l.getResources().getString(i));
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f1947s.setSubtitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle((CharSequence) WindowDecorActionBar.this.f1940l.getResources().getString(i));
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f1947s.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.f1947s.setTitleOptional(z);
        }
    }

    /* renamed from: android.support.v7.internal.app.WindowDecorActionBar$TabImpl */
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: b */
        private ActionBar.TabListener f1964b;

        /* renamed from: c */
        private Object f1965c;

        /* renamed from: d */
        private Drawable f1966d;

        /* renamed from: e */
        private CharSequence f1967e;

        /* renamed from: f */
        private CharSequence f1968f;

        /* renamed from: g */
        private int f1969g = -1;

        /* renamed from: h */
        private View f1970h;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.f1964b;
        }

        public CharSequence getContentDescription() {
            return this.f1968f;
        }

        public View getCustomView() {
            return this.f1970h;
        }

        public Drawable getIcon() {
            return this.f1966d;
        }

        public int getPosition() {
            return this.f1969g;
        }

        public Object getTag() {
            return this.f1965c;
        }

        public CharSequence getText() {
            return this.f1967e;
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.f1940l.getResources().getText(i));
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f1968f = charSequence;
            if (this.f1969g >= 0) {
                WindowDecorActionBar.this.f1949u.updateTab(this.f1969g);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.f1970h = view;
            if (this.f1969g >= 0) {
                WindowDecorActionBar.this.f1949u.updateTab(this.f1969g);
            }
            return this;
        }

        public ActionBar.Tab setIcon(int i) {
            return setIcon(WindowDecorActionBar.this.mo3887b().getDrawable(i));
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f1966d = drawable;
            if (this.f1969g >= 0) {
                WindowDecorActionBar.this.f1949u.updateTab(this.f1969g);
            }
            return this;
        }

        public void setPosition(int i) {
            this.f1969g = i;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f1964b = tabListener;
            return this;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.f1965c = obj;
            return this;
        }

        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.f1940l.getResources().getText(i));
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f1967e = charSequence;
            if (this.f1969g >= 0) {
                WindowDecorActionBar.this.f1949u.updateTab(this.f1969g);
            }
            return this;
        }
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        f1921k = z;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f1942n = activity;
        View decorView = activity.getWindow().getDecorView();
        m1349a(decorView);
        if (!z) {
            this.f1948t = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f1943o = dialog;
        m1349a(dialog.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View view) {
        if (f1918h || view.isInEditMode()) {
            m1349a(view);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m1348a(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.f1950v.add(i, tabImpl);
        int size = this.f1950v.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f1950v.get(i2).setPosition(i2);
        }
    }

    /* renamed from: a */
    private void m1349a(View view) {
        this.f1944p = (ActionBarOverlayLayout) view.findViewById(C0235R.C0237id.decor_content_parent);
        if (this.f1944p != null) {
            this.f1944p.setActionBarVisibilityCallback(this);
        }
        this.f1946r = m1353b(view.findViewById(C0235R.C0237id.action_bar));
        this.f1947s = (ActionBarContextView) view.findViewById(C0235R.C0237id.action_context_bar);
        this.f1945q = (ActionBarContainer) view.findViewById(C0235R.C0237id.action_bar_container);
        if (this.f1946r == null || this.f1947s == null || this.f1945q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1940l = this.f1946r.getContext();
        boolean z = (this.f1946r.getDisplayOptions() & 4) != 0;
        if (z) {
            this.f1953y = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f1940l);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
        m1350a(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.f1940l.obtainStyledAttributes((AttributeSet) null, C0235R.styleable.ActionBar, C0235R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0235R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m1350a(boolean z) {
        boolean z2 = true;
        this.f1923B = z;
        if (!this.f1923B) {
            this.f1946r.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.f1945q.setTabContainer(this.f1949u);
        } else {
            this.f1945q.setTabContainer((ScrollingTabContainerView) null);
            this.f1946r.setEmbeddedTabView(this.f1949u);
        }
        boolean z3 = getNavigationMode() == 2;
        if (this.f1949u != null) {
            if (z3) {
                this.f1949u.setVisibility(0);
                if (this.f1944p != null) {
                    ViewCompat.requestApplyInsets(this.f1944p);
                }
            } else {
                this.f1949u.setVisibility(8);
            }
        }
        this.f1946r.setCollapsible(!this.f1923B && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1944p;
        if (this.f1923B || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* renamed from: b */
    private DecorToolbar m1353b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* renamed from: b */
    private void m1355b(boolean z) {
        if (m1356b(this.f1926E, this.f1927F, this.f1928G)) {
            if (!this.f1929H) {
                this.f1929H = true;
                doShow(z);
            }
        } else if (this.f1929H) {
            this.f1929H = false;
            doHide(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m1356b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: c */
    private void m1358c() {
        if (this.f1949u == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f1940l);
            if (this.f1923B) {
                scrollingTabContainerView.setVisibility(0);
                this.f1946r.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.f1944p != null) {
                        ViewCompat.requestApplyInsets(this.f1944p);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f1945q.setTabContainer(scrollingTabContainerView);
            }
            this.f1949u = scrollingTabContainerView;
        }
    }

    /* renamed from: d */
    private void m1360d() {
        if (this.f1951w != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.f1950v.clear();
        if (this.f1949u != null) {
            this.f1949u.removeAllTabs();
        }
        this.f1952x = -1;
    }

    /* renamed from: e */
    private void m1361e() {
        if (!this.f1928G) {
            this.f1928G = true;
            if (this.f1944p != null) {
                this.f1944p.setShowingForActionMode(true);
            }
            m1355b(false);
        }
    }

    /* renamed from: f */
    private void m1363f() {
        if (this.f1928G) {
            this.f1928G = false;
            if (this.f1944p != null) {
                this.f1944p.setShowingForActionMode(false);
            }
            m1355b(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3885a() {
        if (this.f1935c != null) {
            this.f1935c.onDestroyActionMode(this.f1934b);
            this.f1934b = null;
            this.f1935c = null;
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1922A.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.f1950v.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.f1950v.isEmpty());
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        m1358c();
        this.f1949u.addTab(tab, i, z);
        m1348a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        m1358c();
        this.f1949u.addTab(tab, z);
        m1348a(tab, this.f1950v.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            m1361e();
        } else {
            m1363f();
        }
        if (z) {
            viewPropertyAnimatorCompat2 = this.f1946r.setupAnimatorToVisibility(8, 100);
            viewPropertyAnimatorCompat = this.f1947s.setupAnimatorToVisibility(0, 200);
        } else {
            viewPropertyAnimatorCompat = this.f1946r.setupAnimatorToVisibility(0, 200);
            viewPropertyAnimatorCompat2 = this.f1947s.setupAnimatorToVisibility(8, 100);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public TintManager mo3887b() {
        if (this.f1932K == null) {
            this.f1932K = TintManager.get(this.f1940l);
        }
        return this.f1932K;
    }

    public boolean collapseActionView() {
        if (this.f1946r == null || !this.f1946r.hasExpandedActionView()) {
            return false;
        }
        this.f1946r.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f1954z) {
            this.f1954z = z;
            int size = this.f1922A.size();
            for (int i = 0; i < size; i++) {
                this.f1922A.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public void doHide(boolean z) {
        if (this.f1930I != null) {
            this.f1930I.cancel();
        }
        if (this.f1924C != 0 || !f1921k || (!this.f1931J && !z)) {
            this.f1937e.onAnimationEnd((View) null);
            return;
        }
        ViewCompat.setAlpha(this.f1945q, 1.0f);
        this.f1945q.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        float f = (float) (-this.f1945q.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f1945q.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1945q).translationY(f);
        translationY.setUpdateListener(this.f1939g);
        viewPropertyAnimatorCompatSet.play(translationY);
        if (this.f1925D && this.f1948t != null) {
            viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f1948t).translationY(f));
        }
        viewPropertyAnimatorCompatSet.setInterpolator(f1919i);
        viewPropertyAnimatorCompatSet.setDuration(250);
        viewPropertyAnimatorCompatSet.setListener(this.f1937e);
        this.f1930I = viewPropertyAnimatorCompatSet;
        viewPropertyAnimatorCompatSet.start();
    }

    public void doShow(boolean z) {
        if (this.f1930I != null) {
            this.f1930I.cancel();
        }
        this.f1945q.setVisibility(0);
        if (this.f1924C != 0 || !f1921k || (!this.f1931J && !z)) {
            ViewCompat.setAlpha(this.f1945q, 1.0f);
            ViewCompat.setTranslationY(this.f1945q, BitmapDescriptorFactory.HUE_RED);
            if (this.f1925D && this.f1948t != null) {
                ViewCompat.setTranslationY(this.f1948t, BitmapDescriptorFactory.HUE_RED);
            }
            this.f1938f.onAnimationEnd((View) null);
        } else {
            ViewCompat.setTranslationY(this.f1945q, BitmapDescriptorFactory.HUE_RED);
            float f = (float) (-this.f1945q.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f1945q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.setTranslationY(this.f1945q, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1945q).translationY(BitmapDescriptorFactory.HUE_RED);
            translationY.setUpdateListener(this.f1939g);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.f1925D && this.f1948t != null) {
                ViewCompat.setTranslationY(this.f1948t, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f1948t).translationY(BitmapDescriptorFactory.HUE_RED));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(f1920j);
            viewPropertyAnimatorCompatSet.setDuration(250);
            viewPropertyAnimatorCompatSet.setListener(this.f1938f);
            this.f1930I = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        }
        if (this.f1944p != null) {
            ViewCompat.requestApplyInsets(this.f1944p);
        }
    }

    public void enableContentAnimations(boolean z) {
        this.f1925D = z;
    }

    public View getCustomView() {
        return this.f1946r.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f1946r.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f1945q);
    }

    public int getHeight() {
        return this.f1945q.getHeight();
    }

    public int getHideOffset() {
        return this.f1944p.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        switch (this.f1946r.getNavigationMode()) {
            case 1:
                return this.f1946r.getDropdownItemCount();
            case 2:
                return this.f1950v.size();
            default:
                return 0;
        }
    }

    public int getNavigationMode() {
        return this.f1946r.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        switch (this.f1946r.getNavigationMode()) {
            case 1:
                return this.f1946r.getDropdownSelectedPosition();
            case 2:
                if (this.f1951w != null) {
                    return this.f1951w.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public ActionBar.Tab getSelectedTab() {
        return this.f1951w;
    }

    public CharSequence getSubtitle() {
        return this.f1946r.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i) {
        return this.f1950v.get(i);
    }

    public int getTabCount() {
        return this.f1950v.size();
    }

    public Context getThemedContext() {
        if (this.f1941m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1940l.getTheme().resolveAttribute(C0235R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1941m = new ContextThemeWrapper(this.f1940l, i);
            } else {
                this.f1941m = this.f1940l;
            }
        }
        return this.f1941m;
    }

    public CharSequence getTitle() {
        return this.f1946r.getTitle();
    }

    public boolean hasIcon() {
        return this.f1946r.hasIcon();
    }

    public boolean hasLogo() {
        return this.f1946r.hasLogo();
    }

    public void hide() {
        if (!this.f1926E) {
            this.f1926E = true;
            m1355b(false);
        }
    }

    public void hideForSystem() {
        if (!this.f1927F) {
            this.f1927F = true;
            m1355b(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1944p.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.f1929H && (height == 0 || getHideOffset() < height);
    }

    public boolean isTitleTruncated() {
        return this.f1946r != null && this.f1946r.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        m1350a(ActionBarPolicy.get(this.f1940l).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        if (this.f1930I != null) {
            this.f1930I.cancel();
            this.f1930I = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public void onWindowVisibilityChanged(int i) {
        this.f1924C = i;
    }

    public void removeAllTabs() {
        m1360d();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1922A.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.f1949u != null) {
            int position = this.f1951w != null ? this.f1951w.getPosition() : this.f1952x;
            this.f1949u.removeTabAt(i);
            TabImpl remove = this.f1950v.remove(i);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.f1950v.size();
            for (int i2 = i; i2 < size; i2++) {
                this.f1950v.get(i2).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.f1950v.isEmpty() ? null : this.f1950v.get(Math.max(0, i - 1)));
            }
        }
    }

    public void selectTab(ActionBar.Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            this.f1952x = tab != null ? tab.getPosition() : -1;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.f1942n instanceof FragmentActivity) || this.f1946r.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.f1942n).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (this.f1951w != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f1949u;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.f1951w != null) {
                this.f1951w.getCallback().onTabUnselected(this.f1951w, disallowAddToBackStack);
            }
            this.f1951w = (TabImpl) tab;
            if (this.f1951w != null) {
                this.f1951w.getCallback().onTabSelected(this.f1951w, disallowAddToBackStack);
            }
        } else if (this.f1951w != null) {
            this.f1951w.getCallback().onTabReselected(this.f1951w, disallowAddToBackStack);
            this.f1949u.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
            disallowAddToBackStack.commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f1945q.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f1946r.getViewGroup(), false));
    }

    public void setCustomView(View view) {
        this.f1946r.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f1946r.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.f1953y) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f1953y = true;
        }
        this.f1946r.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f1946r.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f1953y = true;
        }
        this.f1946r.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.f1945q, f);
    }

    public void setHideOffset(int i) {
        if (i == 0 || this.f1944p.isInOverlayMode()) {
            this.f1944p.setActionBarHideOffset(i);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (!z || this.f1944p.isInOverlayMode()) {
            this.f1936d = z;
            this.f1944p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void setHomeActionContentDescription(int i) {
        this.f1946r.setNavigationContentDescription(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f1946r.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f1946r.setNavigationIcon(i);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f1946r.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.f1946r.setHomeButtonEnabled(z);
    }

    public void setIcon(int i) {
        this.f1946r.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1946r.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f1946r.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i) {
        this.f1946r.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.f1946r.setLogo(drawable);
    }

    public void setNavigationMode(int i) {
        boolean z = true;
        int navigationMode = this.f1946r.getNavigationMode();
        switch (navigationMode) {
            case 2:
                this.f1952x = getSelectedNavigationIndex();
                selectTab((ActionBar.Tab) null);
                this.f1949u.setVisibility(8);
                break;
        }
        if (!(navigationMode == i || this.f1923B || this.f1944p == null)) {
            ViewCompat.requestApplyInsets(this.f1944p);
        }
        this.f1946r.setNavigationMode(i);
        switch (i) {
            case 2:
                m1358c();
                this.f1949u.setVisibility(0);
                if (this.f1952x != -1) {
                    setSelectedNavigationItem(this.f1952x);
                    this.f1952x = -1;
                    break;
                }
                break;
        }
        this.f1946r.setCollapsible(i == 2 && !this.f1923B);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1944p;
        if (i != 2 || this.f1923B) {
            z = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z);
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.f1946r.getNavigationMode()) {
            case 1:
                this.f1946r.setDropdownSelectedPosition(i);
                return;
            case 2:
                selectTab(this.f1950v.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.f1931J = z;
        if (!z && this.f1930I != null) {
            this.f1930I.cancel();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f1945q.setStackedBackground(drawable);
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f1940l.getString(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1946r.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f1940l.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f1946r.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f1946r.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.f1926E) {
            this.f1926E = false;
            m1355b(false);
        }
    }

    public void showForSystem() {
        if (this.f1927F) {
            this.f1927F = false;
            m1355b(true);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.f1933a != null) {
            this.f1933a.finish();
        }
        this.f1944p.setHideOnContentScrollEnabled(false);
        this.f1947s.killMode();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.f1947s.getContext(), callback);
        if (!actionModeImpl.dispatchOnCreate()) {
            return null;
        }
        actionModeImpl.invalidate();
        this.f1947s.initForMode(actionModeImpl);
        animateToMode(true);
        this.f1947s.sendAccessibilityEvent(32);
        this.f1933a = actionModeImpl;
        return actionModeImpl;
    }
}
