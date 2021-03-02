package android.support.p004v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.p001v4.app.NavUtils;
import android.support.p001v4.p003os.ParcelableCompat;
import android.support.p001v4.p003os.ParcelableCompatCreatorCallbacks;
import android.support.p001v4.view.LayoutInflaterCompat;
import android.support.p001v4.view.LayoutInflaterFactory;
import android.support.p001v4.view.OnApplyWindowInsetsListener;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewConfigurationCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.support.p001v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p001v4.view.WindowInsetsCompat;
import android.support.p001v4.widget.PopupWindowCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.ContextThemeWrapper;
import android.support.p004v7.view.StandaloneActionMode;
import android.support.p004v7.view.menu.ListMenuPresenter;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.widget.ActionBarContextView;
import android.support.p004v7.widget.ContentFrameLayout;
import android.support.p004v7.widget.DecorContentParent;
import android.support.p004v7.widget.FitWindowsViewGroup;
import android.support.p004v7.widget.TintManager;
import android.support.p004v7.widget.Toolbar;
import android.support.p004v7.widget.ViewStubCompat;
import android.support.p004v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV7 */
public class AppCompatDelegateImplV7 extends C1139fy implements LayoutInflaterFactory, MenuBuilder.Callback {

    /* renamed from: A */
    private boolean f1494A;

    /* renamed from: B */
    private boolean f1495B;

    /* renamed from: C */
    private PanelFeatureState[] f1496C;

    /* renamed from: D */
    private PanelFeatureState f1497D;

    /* renamed from: E */
    private boolean f1498E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f1499F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f1500G;

    /* renamed from: H */
    private final Runnable f1501H = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV7.this.f1500G & 1) != 0) {
                AppCompatDelegateImplV7.this.m2927c(0);
            }
            if ((AppCompatDelegateImplV7.this.f1500G & 4096) != 0) {
                AppCompatDelegateImplV7.this.m2927c(108);
            }
            boolean unused = AppCompatDelegateImplV7.this.f1499F = false;
            int unused2 = AppCompatDelegateImplV7.this.f1500G = 0;
        }
    };

    /* renamed from: I */
    private boolean f1502I;

    /* renamed from: J */
    private Rect f1503J;

    /* renamed from: K */
    private Rect f1504K;

    /* renamed from: L */
    private C1151gc f1505L;

    /* renamed from: m */
    ActionMode f1506m;

    /* renamed from: n */
    ActionBarContextView f1507n;

    /* renamed from: o */
    PopupWindow f1508o;

    /* renamed from: p */
    Runnable f1509p;

    /* renamed from: q */
    ViewPropertyAnimatorCompat f1510q = null;

    /* renamed from: r */
    private DecorContentParent f1511r;

    /* renamed from: s */
    private C0493a f1512s;

    /* renamed from: t */
    private C0497d f1513t;

    /* renamed from: u */
    private boolean f1514u;

    /* renamed from: v */
    private ViewGroup f1515v;

    /* renamed from: w */
    private ViewGroup f1516w;

    /* renamed from: x */
    private TextView f1517x;

    /* renamed from: y */
    private View f1518y;

    /* renamed from: z */
    private boolean f1519z;

    public AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public void onCreate(Bundle bundle) {
        this.f1515v = (ViewGroup) this.f4106b.getDecorView();
        if ((this.f4107c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.f4107c) != null) {
            ActionBar b = mo8116b();
            if (b == null) {
                this.f1502I = true;
            } else {
                b.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public void onPostCreate(Bundle bundle) {
        m2935h();
    }

    /* renamed from: a */
    public void mo3338a() {
        m2935h();
        if (this.f4112h && this.f4110f == null) {
            if (this.f4107c instanceof Activity) {
                this.f4110f = new WindowDecorActionBar((Activity) this.f4107c, this.f4113i);
            } else if (this.f4107c instanceof Dialog) {
                this.f4110f = new WindowDecorActionBar((Dialog) this.f4107c);
            }
            if (this.f4110f != null) {
                this.f4110f.setDefaultDisplayHomeAsUpEnabled(this.f1502I);
            }
        }
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f4107c instanceof Activity) {
            if (getSupportActionBar() instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f4111g = null;
            C1156gg ggVar = new C1156gg(toolbar, ((Activity) this.f4105a).getTitle(), this.f4108d);
            this.f4110f = ggVar;
            this.f4106b.setCallback(ggVar.mo8127a());
            ggVar.invalidateOptionsMenu();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.f4112h && this.f1514u && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void setContentView(View view) {
        m2935h();
        ViewGroup viewGroup = (ViewGroup) this.f1516w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f4107c.onContentChanged();
    }

    public void setContentView(int i) {
        m2935h();
        ViewGroup viewGroup = (ViewGroup) this.f1516w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4105a).inflate(i, viewGroup);
        this.f4107c.onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2935h();
        ViewGroup viewGroup = (ViewGroup) this.f1516w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f4107c.onContentChanged();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2935h();
        ((ViewGroup) this.f1516w.findViewById(16908290)).addView(view, layoutParams);
        this.f4107c.onContentChanged();
    }

    /* renamed from: h */
    private void m2935h() {
        if (!this.f1514u) {
            this.f1516w = m2936i();
            CharSequence f = mo8120f();
            if (!TextUtils.isEmpty(f)) {
                mo3341a(f);
            }
            m2937j();
            mo3340a(this.f1516w);
            this.f1514u = true;
            PanelFeatureState a = m2904a(0, false);
            if (mo8118d()) {
                return;
            }
            if (a == null || a.f1536j == null) {
                m2922b(108);
            }
        }
    }

    /* renamed from: i */
    private ViewGroup m2936i() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Context context;
        TypedArray obtainStyledAttributes = this.f4105a.obtainStyledAttributes(C0505R.styleable.Theme);
        if (!obtainStyledAttributes.hasValue(C0505R.styleable.Theme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(C0505R.styleable.Theme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(C0505R.styleable.Theme_windowActionBar, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(C0505R.styleable.Theme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(C0505R.styleable.Theme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.f4115k = obtainStyledAttributes.getBoolean(C0505R.styleable.Theme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(this.f4105a);
        if (this.f4116l) {
            if (this.f4114j) {
                viewGroup = (ViewGroup) from.inflate(C0505R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) from.inflate(C0505R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int c = AppCompatDelegateImplV7.this.m2930d(systemWindowInsetTop);
                        if (systemWindowInsetTop != c) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), c, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
                viewGroup2 = viewGroup;
            } else {
                ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                    public void onFitSystemWindows(Rect rect) {
                        rect.top = AppCompatDelegateImplV7.this.m2930d(rect.top);
                    }
                });
                viewGroup2 = viewGroup;
            }
        } else if (this.f4115k) {
            this.f4113i = false;
            this.f4112h = false;
            viewGroup2 = (ViewGroup) from.inflate(C0505R.layout.abc_dialog_title_material, (ViewGroup) null);
        } else if (this.f4112h) {
            TypedValue typedValue = new TypedValue();
            this.f4105a.getTheme().resolveAttribute(C0505R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                context = new ContextThemeWrapper(this.f4105a, typedValue.resourceId);
            } else {
                context = this.f4105a;
            }
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(C0505R.layout.abc_screen_toolbar, (ViewGroup) null);
            this.f1511r = (DecorContentParent) viewGroup3.findViewById(C0505R.C0507id.decor_content_parent);
            this.f1511r.setWindowCallback(mo8119e());
            if (this.f4113i) {
                this.f1511r.initFeature(109);
            }
            if (this.f1519z) {
                this.f1511r.initFeature(2);
            }
            if (this.f1494A) {
                this.f1511r.initFeature(5);
            }
            viewGroup2 = viewGroup3;
        } else {
            viewGroup2 = null;
        }
        if (viewGroup2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f4112h + ", windowActionBarOverlay: " + this.f4113i + ", android:windowIsFloating: " + this.f4115k + ", windowActionModeOverlay: " + this.f4114j + ", windowNoTitle: " + this.f4116l + " }");
        }
        if (this.f1511r == null) {
            this.f1517x = (TextView) viewGroup2.findViewById(C0505R.C0507id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup2);
        ViewGroup viewGroup4 = (ViewGroup) this.f4106b.findViewById(16908290);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(C0505R.C0507id.action_bar_activity_content);
        while (viewGroup4.getChildCount() > 0) {
            View childAt = viewGroup4.getChildAt(0);
            viewGroup4.removeViewAt(0);
            contentFrameLayout.addView(childAt);
        }
        this.f4106b.setContentView(viewGroup2);
        viewGroup4.setId(-1);
        contentFrameLayout.setId(16908290);
        if (viewGroup4 instanceof FrameLayout) {
            ((FrameLayout) viewGroup4).setForeground((Drawable) null);
        }
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
            public void onAttachedFromWindow() {
            }

            public void onDetachedFromWindow() {
                AppCompatDelegateImplV7.this.m2940m();
            }
        });
        return viewGroup2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3340a(ViewGroup viewGroup) {
    }

    /* renamed from: j */
    private void m2937j() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1516w.findViewById(16908290);
        contentFrameLayout.setDecorPadding(this.f1515v.getPaddingLeft(), this.f1515v.getPaddingTop(), this.f1515v.getPaddingRight(), this.f1515v.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f4105a.obtainStyledAttributes(C0505R.styleable.Theme);
        obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Theme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Theme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Theme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0505R.styleable.Theme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0505R.styleable.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean requestWindowFeature(int i) {
        int e = m2933e(i);
        if (this.f4116l && e == 108) {
            return false;
        }
        if (this.f4112h && e == 1) {
            this.f4112h = false;
        }
        switch (e) {
            case 1:
                m2939l();
                this.f4116l = true;
                return true;
            case 2:
                m2939l();
                this.f1519z = true;
                return true;
            case 5:
                m2939l();
                this.f1494A = true;
                return true;
            case 10:
                m2939l();
                this.f4114j = true;
                return true;
            case 108:
                m2939l();
                this.f4112h = true;
                return true;
            case 109:
                m2939l();
                this.f4113i = true;
                return true;
            default:
                return this.f4106b.requestFeature(e);
        }
    }

    public boolean hasWindowFeature(int i) {
        int e = m2933e(i);
        switch (e) {
            case 1:
                return this.f4116l;
            case 2:
                return this.f1519z;
            case 5:
                return this.f1494A;
            case 10:
                return this.f4114j;
            case 108:
                return this.f4112h;
            case 109:
                return this.f4113i;
            default:
                return this.f4106b.hasFeature(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3341a(CharSequence charSequence) {
        if (this.f1511r != null) {
            this.f1511r.setWindowTitle(charSequence);
        } else if (mo8116b() != null) {
            mo8116b().setWindowTitle(charSequence);
        } else if (this.f1517x != null) {
            this.f1517x.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3339a(int i, Menu menu) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState a = m2904a(i, true);
            if (a.f1541o) {
                m2910a(a, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3345b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
        return true;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a;
        Window.Callback e = mo8119e();
        if (e == null || mo8118d() || (a = m2906a((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return e.onMenuItemSelected(a.f1527a, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        m2916a(menuBuilder, true);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1506m != null) {
            this.f1506m.finish();
        }
        C0494b bVar = new C0494b(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.f1506m = supportActionBar.startActionMode(bVar);
            if (!(this.f1506m == null || this.f4109e == null)) {
                this.f4109e.onSupportActionModeStarted(this.f1506m);
            }
        }
        if (this.f1506m == null) {
            this.f1506m = mo3336a((ActionMode.Callback) bVar);
        }
        return this.f1506m;
    }

    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            m2922b(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ActionMode mo3336a(ActionMode.Callback callback) {
        ActionMode actionMode;
        boolean z;
        Context context;
        m2938k();
        if (this.f1506m != null) {
            this.f1506m.finish();
        }
        C0494b bVar = new C0494b(callback);
        if (this.f4109e == null || mo8118d()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.f4109e.onWindowStartingSupportActionMode(bVar);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.f1506m = actionMode;
        } else {
            if (this.f1507n == null) {
                if (this.f4115k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f4105a.getTheme();
                    theme.resolveAttribute(C0505R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.f4105a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        context = new ContextThemeWrapper(this.f4105a, 0);
                        context.getTheme().setTo(newTheme);
                    } else {
                        context = this.f4105a;
                    }
                    this.f1507n = new ActionBarContextView(context);
                    this.f1508o = new PopupWindow(context, (AttributeSet) null, C0505R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.f1508o, 2);
                    this.f1508o.setContentView(this.f1507n);
                    this.f1508o.setWidth(-1);
                    context.getTheme().resolveAttribute(C0505R.attr.actionBarSize, typedValue, true);
                    this.f1507n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.f1508o.setHeight(-2);
                    this.f1509p = new Runnable() {
                        public void run() {
                            AppCompatDelegateImplV7.this.f1508o.showAtLocation(AppCompatDelegateImplV7.this.f1507n, 55, 0, 0);
                            AppCompatDelegateImplV7.this.m2938k();
                            ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1507n, BitmapDescriptorFactory.HUE_RED);
                            AppCompatDelegateImplV7.this.f1510q = ViewCompat.animate(AppCompatDelegateImplV7.this.f1507n).alpha(1.0f);
                            AppCompatDelegateImplV7.this.f1510q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                                public void onAnimationEnd(View view) {
                                    ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1507n, 1.0f);
                                    AppCompatDelegateImplV7.this.f1510q.setListener((ViewPropertyAnimatorListener) null);
                                    AppCompatDelegateImplV7.this.f1510q = null;
                                }

                                public void onAnimationStart(View view) {
                                    AppCompatDelegateImplV7.this.f1507n.setVisibility(0);
                                }
                            });
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1516w.findViewById(C0505R.C0507id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(mo8117c()));
                        this.f1507n = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.f1507n != null) {
                m2938k();
                this.f1507n.killMode();
                Context context2 = this.f1507n.getContext();
                ActionBarContextView actionBarContextView = this.f1507n;
                if (this.f1508o == null) {
                    z = true;
                } else {
                    z = false;
                }
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(context2, actionBarContextView, bVar, z);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.f1507n.initForMode(standaloneActionMode);
                    this.f1506m = standaloneActionMode;
                    ViewCompat.setAlpha(this.f1507n, BitmapDescriptorFactory.HUE_RED);
                    this.f1510q = ViewCompat.animate(this.f1507n).alpha(1.0f);
                    this.f1510q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                        public void onAnimationEnd(View view) {
                            ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1507n, 1.0f);
                            AppCompatDelegateImplV7.this.f1510q.setListener((ViewPropertyAnimatorListener) null);
                            AppCompatDelegateImplV7.this.f1510q = null;
                        }

                        public void onAnimationStart(View view) {
                            AppCompatDelegateImplV7.this.f1507n.setVisibility(0);
                            AppCompatDelegateImplV7.this.f1507n.sendAccessibilityEvent(32);
                            if (AppCompatDelegateImplV7.this.f1507n.getParent() != null) {
                                ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.f1507n.getParent());
                            }
                        }
                    });
                    if (this.f1508o != null) {
                        this.f4106b.getDecorView().post(this.f1509p);
                    }
                } else {
                    this.f1506m = null;
                }
            }
        }
        if (!(this.f1506m == null || this.f4109e == null)) {
            this.f4109e.onSupportActionModeStarted(this.f1506m);
        }
        return this.f1506m;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m2938k() {
        if (this.f1510q != null) {
            this.f1510q.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo3347g() {
        if (this.f1506m != null) {
            this.f1506m.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.collapseActionView()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3342a(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.f1497D == null || !m2918a(this.f1497D, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1497D == null) {
                PanelFeatureState a = m2904a(0, true);
                m2925b(a, keyEvent);
                boolean a2 = m2918a(a, keyEvent.getKeyCode(), keyEvent, 1);
                a.f1539m = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        } else if (this.f1497D == null) {
            return true;
        } else {
            this.f1497D.f1540n = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3343a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.f4107c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo3346c(keyCode, keyEvent) : mo3344b(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3344b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f1498E;
                this.f1498E = false;
                PanelFeatureState a = m2904a(0, false);
                if (a == null || !a.f1541o) {
                    if (mo3347g()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2910a(a, true);
                    return true;
                }
                break;
            case 82:
                m2934e(0, keyEvent);
                return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo3346c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1498E = z;
                break;
            case 82:
                m2932d(0, keyEvent);
                return true;
        }
        if (Build.VERSION.SDK_INT < 11) {
            mo3342a(i, keyEvent);
        }
        return false;
    }

    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        boolean z2 = Build.VERSION.SDK_INT < 21;
        if (this.f1505L == null) {
            this.f1505L = new C1151gc();
        }
        if (!z2 || !this.f1514u || !m2920a((ViewParent) view)) {
            z = false;
        } else {
            z = true;
        }
        return this.f1505L.mo8123a(view, str, context, attributeSet, z, z2, true);
    }

    /* renamed from: a */
    private boolean m2920a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == this.f1515v || !(viewParent2 instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f4105a);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo3337a(view, str, context, attributeSet);
        return a != null ? a : createView(view, str, context, attributeSet);
    }

    /* renamed from: a */
    public View mo3337a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.f4107c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.f4107c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    /* renamed from: a */
    private void m2909a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        boolean z;
        int i = -1;
        if (!panelFeatureState.f1541o && !mo8118d()) {
            if (panelFeatureState.f1527a == 0) {
                Context context = this.f4105a;
                boolean z2 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                if (context.getApplicationInfo().targetSdkVersion >= 11) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    return;
                }
            }
            Window.Callback e = mo8119e();
            if (e == null || e.onMenuOpened(panelFeatureState.f1527a, panelFeatureState.f1536j)) {
                WindowManager windowManager = (WindowManager) this.f4105a.getSystemService("window");
                if (windowManager != null && m2925b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f1533g == null || panelFeatureState.f1543q) {
                        if (panelFeatureState.f1533g == null) {
                            if (!m2917a(panelFeatureState) || panelFeatureState.f1533g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f1543q && panelFeatureState.f1533g.getChildCount() > 0) {
                            panelFeatureState.f1533g.removeAllViews();
                        }
                        if (m2929c(panelFeatureState) && panelFeatureState.mo3358a()) {
                            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f1534h.getLayoutParams();
                            if (layoutParams3 == null) {
                                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                            } else {
                                layoutParams = layoutParams3;
                            }
                            panelFeatureState.f1533g.setBackgroundResource(panelFeatureState.f1528b);
                            ViewParent parent = panelFeatureState.f1534h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.f1534h);
                            }
                            panelFeatureState.f1533g.addView(panelFeatureState.f1534h, layoutParams);
                            if (!panelFeatureState.f1534h.hasFocus()) {
                                panelFeatureState.f1534h.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    } else if (panelFeatureState.f1535i == null || (layoutParams2 = panelFeatureState.f1535i.getLayoutParams()) == null || layoutParams2.width != -1) {
                        i = -2;
                    }
                    panelFeatureState.f1540n = false;
                    WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1530d, panelFeatureState.f1531e, 1002, 8519680, -3);
                    layoutParams4.gravity = panelFeatureState.f1529c;
                    layoutParams4.windowAnimations = panelFeatureState.f1532f;
                    windowManager.addView(panelFeatureState.f1533g, layoutParams4);
                    panelFeatureState.f1541o = true;
                    return;
                }
                return;
            }
            m2910a(panelFeatureState, true);
        }
    }

    /* renamed from: a */
    private boolean m2917a(PanelFeatureState panelFeatureState) {
        panelFeatureState.mo3356a(mo8117c());
        panelFeatureState.f1533g = new C0496c(panelFeatureState.f1538l);
        panelFeatureState.f1529c = 81;
        return true;
    }

    /* renamed from: a */
    private void m2916a(MenuBuilder menuBuilder, boolean z) {
        if (this.f1511r == null || !this.f1511r.canShowOverflowMenu() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f4105a)) && !this.f1511r.isOverflowMenuShowPending())) {
            PanelFeatureState a = m2904a(0, true);
            a.f1543q = true;
            m2910a(a, false);
            m2909a(a, (KeyEvent) null);
            return;
        }
        Window.Callback e = mo8119e();
        if (this.f1511r.isOverflowMenuShowing() && z) {
            this.f1511r.hideOverflowMenu();
            if (!mo8118d()) {
                e.onPanelClosed(108, m2904a(0, true).f1536j);
            }
        } else if (e != null && !mo8118d()) {
            if (this.f1499F && (this.f1500G & 1) != 0) {
                this.f1515v.removeCallbacks(this.f1501H);
                this.f1501H.run();
            }
            PanelFeatureState a2 = m2904a(0, true);
            if (a2.f1536j != null && !a2.f1544r && e.onPreparePanel(0, a2.f1535i, a2.f1536j)) {
                e.onMenuOpened(108, a2.f1536j);
                this.f1511r.showOverflowMenu();
            }
        }
    }

    /* renamed from: b */
    private boolean m2924b(PanelFeatureState panelFeatureState) {
        Context context;
        Context context2 = this.f4105a;
        if ((panelFeatureState.f1527a == 0 || panelFeatureState.f1527a == 108) && this.f1511r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context2.getTheme();
            theme.resolveAttribute(C0505R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context2.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0505R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0505R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context2.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme3 = theme2;
            if (theme3 != null) {
                context = new ContextThemeWrapper(context2, 0);
                context.getTheme().setTo(theme3);
                MenuBuilder menuBuilder = new MenuBuilder(context);
                menuBuilder.setCallback(this);
                panelFeatureState.mo3357a(menuBuilder);
                return true;
            }
        }
        context = context2;
        MenuBuilder menuBuilder2 = new MenuBuilder(context);
        menuBuilder2.setCallback(this);
        panelFeatureState.mo3357a(menuBuilder2);
        return true;
    }

    /* renamed from: c */
    private boolean m2929c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f1535i != null) {
            panelFeatureState.f1534h = panelFeatureState.f1535i;
            return true;
        } else if (panelFeatureState.f1536j == null) {
            return false;
        } else {
            if (this.f1513t == null) {
                this.f1513t = new C0497d();
            }
            panelFeatureState.f1534h = (View) panelFeatureState.mo3355a((MenuPresenter.Callback) this.f1513t);
            return panelFeatureState.f1534h != null;
        }
    }

    /* renamed from: b */
    private boolean m2925b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z;
        if (mo8118d()) {
            return false;
        }
        if (panelFeatureState.f1539m) {
            return true;
        }
        if (!(this.f1497D == null || this.f1497D == panelFeatureState)) {
            m2910a(this.f1497D, false);
        }
        Window.Callback e = mo8119e();
        if (e != null) {
            panelFeatureState.f1535i = e.onCreatePanelView(panelFeatureState.f1527a);
        }
        boolean z2 = panelFeatureState.f1527a == 0 || panelFeatureState.f1527a == 108;
        if (z2 && this.f1511r != null) {
            this.f1511r.setMenuPrepared();
        }
        if (panelFeatureState.f1535i == null && (!z2 || !(mo8116b() instanceof C1156gg))) {
            if (panelFeatureState.f1536j == null || panelFeatureState.f1544r) {
                if (panelFeatureState.f1536j == null && (!m2924b(panelFeatureState) || panelFeatureState.f1536j == null)) {
                    return false;
                }
                if (z2 && this.f1511r != null) {
                    if (this.f1512s == null) {
                        this.f1512s = new C0493a();
                    }
                    this.f1511r.setMenu(panelFeatureState.f1536j, this.f1512s);
                }
                panelFeatureState.f1536j.stopDispatchingItemsChanged();
                if (!e.onCreatePanelMenu(panelFeatureState.f1527a, panelFeatureState.f1536j)) {
                    panelFeatureState.mo3357a((MenuBuilder) null);
                    if (!z2 || this.f1511r == null) {
                        return false;
                    }
                    this.f1511r.setMenu((Menu) null, this.f1512s);
                    return false;
                }
                panelFeatureState.f1544r = false;
            }
            panelFeatureState.f1536j.stopDispatchingItemsChanged();
            if (panelFeatureState.f1545s != null) {
                panelFeatureState.f1536j.restoreActionViewStates(panelFeatureState.f1545s);
                panelFeatureState.f1545s = null;
            }
            if (!e.onPreparePanel(0, panelFeatureState.f1535i, panelFeatureState.f1536j)) {
                if (z2 && this.f1511r != null) {
                    this.f1511r.setMenu((Menu) null, this.f1512s);
                }
                panelFeatureState.f1536j.startDispatchingItemsChanged();
                return false;
            }
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            panelFeatureState.f1542p = z;
            panelFeatureState.f1536j.setQwertyMode(panelFeatureState.f1542p);
            panelFeatureState.f1536j.startDispatchingItemsChanged();
        }
        panelFeatureState.f1539m = true;
        panelFeatureState.f1540n = false;
        this.f1497D = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2915a(MenuBuilder menuBuilder) {
        if (!this.f1495B) {
            this.f1495B = true;
            this.f1511r.dismissPopups();
            Window.Callback e = mo8119e();
            if (e != null && !mo8118d()) {
                e.onPanelClosed(108, menuBuilder);
            }
            this.f1495B = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2907a(int i) {
        m2910a(m2904a(i, true), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2910a(PanelFeatureState panelFeatureState, boolean z) {
        if (!z || panelFeatureState.f1527a != 0 || this.f1511r == null || !this.f1511r.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.f4105a.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f1541o || panelFeatureState.f1533g == null)) {
                windowManager.removeView(panelFeatureState.f1533g);
                if (z) {
                    m2908a(panelFeatureState.f1527a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f1539m = false;
            panelFeatureState.f1540n = false;
            panelFeatureState.f1541o = false;
            panelFeatureState.f1534h = null;
            panelFeatureState.f1543q = true;
            if (this.f1497D == panelFeatureState) {
                this.f1497D = null;
                return;
            }
            return;
        }
        m2915a(panelFeatureState.f1536j);
    }

    /* renamed from: d */
    private boolean m2932d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a = m2904a(i, true);
            if (!a.f1541o) {
                return m2925b(a, keyEvent);
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m2934e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.f1506m != null) {
            return false;
        }
        PanelFeatureState a = m2904a(i, true);
        if (i != 0 || this.f1511r == null || !this.f1511r.canShowOverflowMenu() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f4105a))) {
            if (a.f1541o || a.f1540n) {
                boolean z3 = a.f1541o;
                m2910a(a, true);
                z2 = z3;
            } else {
                if (a.f1539m) {
                    if (a.f1544r) {
                        a.f1539m = false;
                        z = m2925b(a, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        m2909a(a, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (!this.f1511r.isOverflowMenuShowing()) {
            if (!mo8118d() && m2925b(a, keyEvent)) {
                z2 = this.f1511r.showOverflowMenu();
            }
            z2 = false;
        } else {
            z2 = this.f1511r.hideOverflowMenu();
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f4105a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2908a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f1496C.length) {
                panelFeatureState = this.f1496C[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1536j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1541o) && !mo8118d()) {
            this.f4107c.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PanelFeatureState m2906a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f1496C;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f1536j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* renamed from: a */
    private PanelFeatureState m2904a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f1496C;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f1496C = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* renamed from: a */
    private boolean m2918a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f1539m || m2925b(panelFeatureState, keyEvent)) && panelFeatureState.f1536j != null) {
                z = panelFeatureState.f1536j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1511r == null) {
                m2910a(panelFeatureState, true);
            }
        }
        return z;
    }

    /* renamed from: b */
    private void m2922b(int i) {
        this.f1500G |= 1 << i;
        if (!this.f1499F && this.f1515v != null) {
            ViewCompat.postOnAnimation(this.f1515v, this.f1501H);
            this.f1499F = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2927c(int i) {
        PanelFeatureState a;
        PanelFeatureState a2 = m2904a(i, true);
        if (a2.f1536j != null) {
            Bundle bundle = new Bundle();
            a2.f1536j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a2.f1545s = bundle;
            }
            a2.f1536j.stopDispatchingItemsChanged();
            a2.f1536j.clear();
        }
        a2.f1544r = true;
        a2.f1543q = true;
        if ((i == 108 || i == 0) && this.f1511r != null && (a = m2904a(0, false)) != null) {
            a.f1539m = false;
            m2925b(a, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public int m2930d(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.f1507n == null || !(this.f1507n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1507n.getLayoutParams();
            if (this.f1507n.isShown()) {
                if (this.f1503J == null) {
                    this.f1503J = new Rect();
                    this.f1504K = new Rect();
                }
                Rect rect = this.f1503J;
                Rect rect2 = this.f1504K;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.f1516w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1518y == null) {
                        this.f1518y = new View(this.f4105a);
                        this.f1518y.setBackgroundColor(this.f4105a.getResources().getColor(C0505R.color.abc_input_method_navigation_guard));
                        this.f1516w.addView(this.f1518y, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f1518y.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1518y.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                if (this.f1518y == null) {
                    z4 = false;
                }
                if (!this.f4114j && z4) {
                    i = 0;
                }
                boolean z5 = z3;
                z2 = z4;
                z4 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z4 = false;
                z2 = false;
            }
            if (z4) {
                this.f1507n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.f1518y != null) {
            View view = this.f1518y;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: l */
    private void m2939l() {
        if (this.f1514u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: e */
    private int m2933e(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m2940m() {
        if (this.f1511r != null) {
            this.f1511r.dismissPopups();
        }
        if (this.f1508o != null) {
            this.f1515v.removeCallbacks(this.f1509p);
            if (this.f1508o.isShowing()) {
                try {
                    this.f1508o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1508o = null;
        }
        m2938k();
        PanelFeatureState a = m2904a(0, false);
        if (a != null && a.f1536j != null) {
            a.f1536j.close();
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$b */
    class C0494b implements ActionMode.Callback {

        /* renamed from: b */
        private ActionMode.Callback f1551b;

        public C0494b(ActionMode.Callback callback) {
            this.f1551b = callback;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1551b.onCreateActionMode(actionMode, menu);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f1551b.onPrepareActionMode(actionMode, menu);
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1551b.onActionItemClicked(actionMode, menuItem);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1551b.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV7.this.f1508o != null) {
                AppCompatDelegateImplV7.this.f4106b.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.f1509p);
            }
            if (AppCompatDelegateImplV7.this.f1507n != null) {
                AppCompatDelegateImplV7.this.m2938k();
                AppCompatDelegateImplV7.this.f1510q = ViewCompat.animate(AppCompatDelegateImplV7.this.f1507n).alpha(BitmapDescriptorFactory.HUE_RED);
                AppCompatDelegateImplV7.this.f1510q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV7.this.f1507n.setVisibility(8);
                        if (AppCompatDelegateImplV7.this.f1508o != null) {
                            AppCompatDelegateImplV7.this.f1508o.dismiss();
                        } else if (AppCompatDelegateImplV7.this.f1507n.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.f1507n.getParent());
                        }
                        AppCompatDelegateImplV7.this.f1507n.removeAllViews();
                        AppCompatDelegateImplV7.this.f1510q.setListener((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImplV7.this.f1510q = null;
                    }
                });
            }
            if (AppCompatDelegateImplV7.this.f4109e != null) {
                AppCompatDelegateImplV7.this.f4109e.onSupportActionModeFinished(AppCompatDelegateImplV7.this.f1506m);
            }
            AppCompatDelegateImplV7.this.f1506m = null;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$d */
    final class C0497d implements MenuPresenter.Callback {
        private C0497d() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState a = appCompatDelegateImplV7.m2906a((Menu) menuBuilder);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.m2908a(a.f1527a, a, (Menu) rootMenu);
                AppCompatDelegateImplV7.this.m2910a(a, true);
                return;
            }
            AppCompatDelegateImplV7.this.m2910a(a, z);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback e;
            if (menuBuilder != null || !AppCompatDelegateImplV7.this.f4112h || (e = AppCompatDelegateImplV7.this.mo8119e()) == null || AppCompatDelegateImplV7.this.mo8118d()) {
                return true;
            }
            e.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$a */
    final class C0493a implements MenuPresenter.Callback {
        private C0493a() {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback e = AppCompatDelegateImplV7.this.mo8119e();
            if (e == null) {
                return true;
            }
            e.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV7.this.m2915a(menuBuilder);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState */
    static final class PanelFeatureState {

        /* renamed from: a */
        int f1527a;

        /* renamed from: b */
        int f1528b;

        /* renamed from: c */
        int f1529c;

        /* renamed from: d */
        int f1530d;

        /* renamed from: e */
        int f1531e;

        /* renamed from: f */
        int f1532f;

        /* renamed from: g */
        ViewGroup f1533g;

        /* renamed from: h */
        View f1534h;

        /* renamed from: i */
        View f1535i;

        /* renamed from: j */
        MenuBuilder f1536j;

        /* renamed from: k */
        ListMenuPresenter f1537k;

        /* renamed from: l */
        Context f1538l;

        /* renamed from: m */
        boolean f1539m;

        /* renamed from: n */
        boolean f1540n;

        /* renamed from: o */
        boolean f1541o;

        /* renamed from: p */
        public boolean f1542p;

        /* renamed from: q */
        boolean f1543q = false;

        /* renamed from: r */
        boolean f1544r;

        /* renamed from: s */
        Bundle f1545s;

        PanelFeatureState(int i) {
            this.f1527a = i;
        }

        /* renamed from: a */
        public boolean mo3358a() {
            if (this.f1534h == null) {
                return false;
            }
            if (this.f1535i != null || this.f1537k.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3356a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0505R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0505R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0505R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1538l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0505R.styleable.Theme);
            this.f1528b = obtainStyledAttributes.getResourceId(C0505R.styleable.Theme_panelBackground, 0);
            this.f1532f = obtainStyledAttributes.getResourceId(C0505R.styleable.Theme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3357a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f1536j) {
                if (this.f1536j != null) {
                    this.f1536j.removeMenuPresenter(this.f1537k);
                }
                this.f1536j = menuBuilder;
                if (menuBuilder != null && this.f1537k != null) {
                    menuBuilder.addMenuPresenter(this.f1537k);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public MenuView mo3355a(MenuPresenter.Callback callback) {
            if (this.f1536j == null) {
                return null;
            }
            if (this.f1537k == null) {
                this.f1537k = new ListMenuPresenter(this.f1538l, C0505R.layout.abc_list_menu_item_layout);
                this.f1537k.setCallback(callback);
                this.f1536j.addMenuPresenter(this.f1537k);
            }
            return this.f1537k.getMenuView(this.f1533g);
        }

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState */
        static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m2958b(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            });

            /* renamed from: a */
            int f1546a;

            /* renamed from: b */
            boolean f1547b;

            /* renamed from: c */
            Bundle f1548c;

            private SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1546a);
                parcel.writeInt(this.f1547b ? 1 : 0);
                if (this.f1547b) {
                    parcel.writeBundle(this.f1548c);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public static SavedState m2958b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.f1546a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f1547b = z;
                if (savedState.f1547b) {
                    savedState.f1548c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$c */
    class C0496c extends ContentFrameLayout {
        public C0496c(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.mo3343a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m2961a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV7.this.m2907a(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(TintManager.getDrawable(getContext(), i));
        }

        /* renamed from: a */
        private boolean m2961a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }
}
