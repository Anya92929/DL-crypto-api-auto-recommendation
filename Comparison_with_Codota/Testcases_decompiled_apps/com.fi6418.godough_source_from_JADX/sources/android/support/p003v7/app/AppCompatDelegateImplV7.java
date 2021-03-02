package android.support.p003v7.app;

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
import android.support.p000v4.app.NavUtils;
import android.support.p000v4.view.LayoutInflaterCompat;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p000v4.view.OnApplyWindowInsetsListener;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p000v4.view.WindowInsetsCompat;
import android.support.p000v4.widget.PopupWindowCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.app.AppCompatViewInflater;
import android.support.p003v7.internal.app.ToolbarActionBar;
import android.support.p003v7.internal.app.WindowDecorActionBar;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.support.p003v7.internal.view.StandaloneActionMode;
import android.support.p003v7.internal.view.menu.ListMenuPresenter;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.internal.widget.ContentFrameLayout;
import android.support.p003v7.internal.widget.DecorContentParent;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.ViewStubCompat;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
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
class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements LayoutInflaterFactory, MenuBuilder.Callback {

    /* renamed from: A */
    private boolean f1819A;

    /* renamed from: B */
    private boolean f1820B;

    /* renamed from: C */
    private PanelFeatureState[] f1821C;

    /* renamed from: D */
    private PanelFeatureState f1822D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f1823E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f1824F;

    /* renamed from: G */
    private final Runnable f1825G = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV7.this.f1824F & 1) != 0) {
                AppCompatDelegateImplV7.this.m1292c(0);
            }
            if ((AppCompatDelegateImplV7.this.f1824F & 4096) != 0) {
                AppCompatDelegateImplV7.this.m1292c(108);
            }
            boolean unused = AppCompatDelegateImplV7.this.f1823E = false;
            int unused2 = AppCompatDelegateImplV7.this.f1824F = 0;
        }
    };

    /* renamed from: H */
    private boolean f1826H;

    /* renamed from: I */
    private Rect f1827I;

    /* renamed from: J */
    private Rect f1828J;

    /* renamed from: K */
    private AppCompatViewInflater f1829K;

    /* renamed from: m */
    ActionMode f1830m;

    /* renamed from: n */
    ActionBarContextView f1831n;

    /* renamed from: o */
    PopupWindow f1832o;

    /* renamed from: p */
    Runnable f1833p;

    /* renamed from: q */
    ViewPropertyAnimatorCompat f1834q = null;

    /* renamed from: r */
    private DecorContentParent f1835r;

    /* renamed from: s */
    private ActionMenuPresenterCallback f1836s;

    /* renamed from: t */
    private PanelMenuPresenterCallback f1837t;

    /* renamed from: u */
    private boolean f1838u;

    /* renamed from: v */
    private ViewGroup f1839v;

    /* renamed from: w */
    private ViewGroup f1840w;

    /* renamed from: x */
    private TextView f1841x;

    /* renamed from: y */
    private View f1842y;

    /* renamed from: z */
    private boolean f1843z;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionMenuPresenterCallback */
    final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV7.this.m1280a(menuBuilder);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback d = AppCompatDelegateImplV7.this.mo3762d();
            if (d == null) {
                return true;
            }
            d.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 */
    class ActionModeCallbackWrapperV7 implements ActionMode.Callback {

        /* renamed from: b */
        private ActionMode.Callback f1852b;

        public ActionModeCallbackWrapperV7(ActionMode.Callback callback) {
            this.f1852b = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1852b.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1852b.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1852b.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV7.this.f1832o != null) {
                AppCompatDelegateImplV7.this.f1801b.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.f1833p);
            }
            if (AppCompatDelegateImplV7.this.f1831n != null) {
                AppCompatDelegateImplV7.this.m1302j();
                AppCompatDelegateImplV7.this.f1834q = ViewCompat.animate(AppCompatDelegateImplV7.this.f1831n).alpha(BitmapDescriptorFactory.HUE_RED);
                AppCompatDelegateImplV7.this.f1834q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV7.this.f1831n.setVisibility(8);
                        if (AppCompatDelegateImplV7.this.f1832o != null) {
                            AppCompatDelegateImplV7.this.f1832o.dismiss();
                        } else if (AppCompatDelegateImplV7.this.f1831n.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.f1831n.getParent());
                        }
                        AppCompatDelegateImplV7.this.f1831n.removeAllViews();
                        AppCompatDelegateImplV7.this.f1834q.setListener((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImplV7.this.f1834q = null;
                    }
                });
            }
            if (AppCompatDelegateImplV7.this.f1804e != null) {
                AppCompatDelegateImplV7.this.f1804e.onSupportActionModeFinished(AppCompatDelegateImplV7.this.f1830m);
            }
            AppCompatDelegateImplV7.this.f1830m = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f1852b.onPrepareActionMode(actionMode, menu);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ListMenuDecorView */
    class ListMenuDecorView extends FrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        /* renamed from: a */
        private boolean m1315a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.mo3758a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m1315a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV7.this.m1272a(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(TintManager.getDrawable(getContext(), i));
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState */
    final class PanelFeatureState {

        /* renamed from: a */
        int f1855a;

        /* renamed from: b */
        int f1856b;

        /* renamed from: c */
        int f1857c;

        /* renamed from: d */
        int f1858d;

        /* renamed from: e */
        int f1859e;

        /* renamed from: f */
        int f1860f;

        /* renamed from: g */
        ViewGroup f1861g;

        /* renamed from: h */
        View f1862h;

        /* renamed from: i */
        View f1863i;

        /* renamed from: j */
        MenuBuilder f1864j;

        /* renamed from: k */
        ListMenuPresenter f1865k;

        /* renamed from: l */
        Context f1866l;

        /* renamed from: m */
        boolean f1867m;

        /* renamed from: n */
        boolean f1868n;

        /* renamed from: o */
        boolean f1869o;

        /* renamed from: p */
        boolean f1870p = false;

        /* renamed from: q */
        boolean f1871q;
        public boolean qwertyMode;

        /* renamed from: r */
        Bundle f1872r;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState */
        class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.m1320b(parcel);
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* renamed from: a */
            int f1873a;

            /* renamed from: b */
            boolean f1874b;

            /* renamed from: c */
            Bundle f1875c;

            private SavedState() {
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public static SavedState m1320b(Parcel parcel) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.f1873a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f1874b = z;
                if (savedState.f1874b) {
                    savedState.f1875c = parcel.readBundle();
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1873a);
                parcel.writeInt(this.f1874b ? 1 : 0);
                if (this.f1874b) {
                    parcel.writeBundle(this.f1875c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f1855a = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public MenuView mo3794a(MenuPresenter.Callback callback) {
            if (this.f1864j == null) {
                return null;
            }
            if (this.f1865k == null) {
                this.f1865k = new ListMenuPresenter(this.f1866l, C0235R.layout.abc_list_menu_item_layout);
                this.f1865k.setCallback(callback);
                this.f1864j.addMenuPresenter(this.f1865k);
            }
            return this.f1865k.getMenuView(this.f1861g);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3795a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0235R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0235R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0235R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1866l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0235R.styleable.Theme);
            this.f1856b = obtainStyledAttributes.getResourceId(C0235R.styleable.Theme_panelBackground, 0);
            this.f1860f = obtainStyledAttributes.getResourceId(C0235R.styleable.Theme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3796a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f1864j) {
                if (this.f1864j != null) {
                    this.f1864j.removeMenuPresenter(this.f1865k);
                }
                this.f1864j = menuBuilder;
                if (menuBuilder != null && this.f1865k != null) {
                    menuBuilder.addMenuPresenter(this.f1865k);
                }
            }
        }

        public void clearMenuPresenters() {
            if (this.f1864j != null) {
                this.f1864j.removeMenuPresenter(this.f1865k);
            }
            this.f1865k = null;
        }

        public boolean hasPanelItems() {
            if (this.f1862h == null) {
                return false;
            }
            return this.f1863i != null || this.f1865k.getAdapter().getCount() > 0;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelMenuPresenterCallback */
    final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState a = appCompatDelegateImplV7.m1271a((Menu) menuBuilder);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.m1273a(a.f1855a, a, (Menu) rootMenu);
                AppCompatDelegateImplV7.this.m1275a(a, true);
                return;
            }
            AppCompatDelegateImplV7.this.m1275a(a, z);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback d;
            if (menuBuilder != null || !AppCompatDelegateImplV7.this.f1807h || (d = AppCompatDelegateImplV7.this.mo3762d()) == null || AppCompatDelegateImplV7.this.mo3761c()) {
                return true;
            }
            d.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* renamed from: a */
    private PanelFeatureState m1269a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f1821C;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f1821C = panelFeatureStateArr2;
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PanelFeatureState m1271a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f1821C;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f1864j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1272a(int i) {
        m1275a(m1269a(i, true), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1273a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f1821C.length) {
                panelFeatureState = this.f1821C[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1864j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1869o) && !mo3761c()) {
            this.f1802c.onPanelClosed(i, menu);
        }
    }

    /* renamed from: a */
    private void m1274a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.f1869o && !mo3761c()) {
            if (panelFeatureState.f1855a == 0) {
                Context context = this.f1800a;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback d = mo3762d();
            if (d == null || d.onMenuOpened(panelFeatureState.f1855a, panelFeatureState.f1864j)) {
                WindowManager windowManager = (WindowManager) this.f1800a.getSystemService("window");
                if (windowManager != null && m1290b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f1861g == null || panelFeatureState.f1870p) {
                        if (panelFeatureState.f1861g == null) {
                            if (!m1282a(panelFeatureState) || panelFeatureState.f1861g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f1870p && panelFeatureState.f1861g.getChildCount() > 0) {
                            panelFeatureState.f1861g.removeAllViews();
                        }
                        if (m1293c(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                            ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f1862h.getLayoutParams();
                            ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                            panelFeatureState.f1861g.setBackgroundResource(panelFeatureState.f1856b);
                            ViewParent parent = panelFeatureState.f1862h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.f1862h);
                            }
                            panelFeatureState.f1861g.addView(panelFeatureState.f1862h, layoutParams3);
                            if (!panelFeatureState.f1862h.hasFocus()) {
                                panelFeatureState.f1862h.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    } else if (panelFeatureState.f1863i == null || (layoutParams = panelFeatureState.f1863i.getLayoutParams()) == null || layoutParams.width != -1) {
                        i = -2;
                    }
                    panelFeatureState.f1868n = false;
                    WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1858d, panelFeatureState.f1859e, 1002, 8519680, -3);
                    layoutParams4.gravity = panelFeatureState.f1857c;
                    layoutParams4.windowAnimations = panelFeatureState.f1860f;
                    windowManager.addView(panelFeatureState.f1861g, layoutParams4);
                    panelFeatureState.f1869o = true;
                    return;
                }
                return;
            }
            m1275a(panelFeatureState, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1275a(PanelFeatureState panelFeatureState, boolean z) {
        if (!z || panelFeatureState.f1855a != 0 || this.f1835r == null || !this.f1835r.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.f1800a.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f1869o || panelFeatureState.f1861g == null)) {
                windowManager.removeView(panelFeatureState.f1861g);
                if (z) {
                    m1273a(panelFeatureState.f1855a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f1867m = false;
            panelFeatureState.f1868n = false;
            panelFeatureState.f1869o = false;
            panelFeatureState.f1862h = null;
            panelFeatureState.f1870p = true;
            if (this.f1822D == panelFeatureState) {
                this.f1822D = null;
                return;
            }
            return;
        }
        m1280a(panelFeatureState.f1864j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1280a(MenuBuilder menuBuilder) {
        if (!this.f1820B) {
            this.f1820B = true;
            this.f1835r.dismissPopups();
            Window.Callback d = mo3762d();
            if (d != null && !mo3761c()) {
                d.onPanelClosed(108, menuBuilder);
            }
            this.f1820B = false;
        }
    }

    /* renamed from: a */
    private void m1281a(MenuBuilder menuBuilder, boolean z) {
        if (this.f1835r == null || !this.f1835r.canShowOverflowMenu() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f1800a)) && !this.f1835r.isOverflowMenuShowPending())) {
            PanelFeatureState a = m1269a(0, true);
            a.f1870p = true;
            m1275a(a, false);
            m1274a(a, (KeyEvent) null);
            return;
        }
        Window.Callback d = mo3762d();
        if (this.f1835r.isOverflowMenuShowing() && z) {
            this.f1835r.hideOverflowMenu();
            if (!mo3761c()) {
                d.onPanelClosed(108, m1269a(0, true).f1864j);
            }
        } else if (d != null && !mo3761c()) {
            if (this.f1823E && (this.f1824F & 1) != 0) {
                this.f1839v.removeCallbacks(this.f1825G);
                this.f1825G.run();
            }
            PanelFeatureState a2 = m1269a(0, true);
            if (a2.f1864j != null && !a2.f1871q && d.onPreparePanel(0, a2.f1863i, a2.f1864j)) {
                d.onMenuOpened(108, a2.f1864j);
                this.f1835r.showOverflowMenu();
            }
        }
    }

    /* renamed from: a */
    private boolean m1282a(PanelFeatureState panelFeatureState) {
        panelFeatureState.mo3795a(mo3759b());
        panelFeatureState.f1861g = new ListMenuDecorView(panelFeatureState.f1866l);
        panelFeatureState.f1857c = 81;
        return true;
    }

    /* renamed from: a */
    private boolean m1283a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f1867m || m1290b(panelFeatureState, keyEvent)) && panelFeatureState.f1864j != null) {
                z = panelFeatureState.f1864j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1835r == null) {
                m1275a(panelFeatureState, true);
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m1285a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == this.f1839v || !(viewParent2 instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m1287b(int i) {
        this.f1824F |= 1 << i;
        if (!this.f1823E && this.f1839v != null) {
            ViewCompat.postOnAnimation(this.f1839v, this.f1825G);
            this.f1823E = true;
        }
    }

    /* renamed from: b */
    private boolean m1289b(PanelFeatureState panelFeatureState) {
        Context context;
        Context context2 = this.f1800a;
        if ((panelFeatureState.f1855a == 0 || panelFeatureState.f1855a == 108) && this.f1835r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context2.getTheme();
            theme.resolveAttribute(C0235R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context2.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0235R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0235R.attr.actionBarWidgetTheme, typedValue, true);
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
                panelFeatureState.mo3796a(menuBuilder);
                return true;
            }
        }
        context = context2;
        MenuBuilder menuBuilder2 = new MenuBuilder(context);
        menuBuilder2.setCallback(this);
        panelFeatureState.mo3796a(menuBuilder2);
        return true;
    }

    /* renamed from: b */
    private boolean m1290b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (mo3761c()) {
            return false;
        }
        if (panelFeatureState.f1867m) {
            return true;
        }
        if (!(this.f1822D == null || this.f1822D == panelFeatureState)) {
            m1275a(this.f1822D, false);
        }
        Window.Callback d = mo3762d();
        if (d != null) {
            panelFeatureState.f1863i = d.onCreatePanelView(panelFeatureState.f1855a);
        }
        boolean z = panelFeatureState.f1855a == 0 || panelFeatureState.f1855a == 108;
        if (z && this.f1835r != null) {
            this.f1835r.setMenuPrepared();
        }
        if (panelFeatureState.f1863i == null && (!z || !(mo3752a() instanceof ToolbarActionBar))) {
            if (panelFeatureState.f1864j == null || panelFeatureState.f1871q) {
                if (panelFeatureState.f1864j == null && (!m1289b(panelFeatureState) || panelFeatureState.f1864j == null)) {
                    return false;
                }
                if (z && this.f1835r != null) {
                    if (this.f1836s == null) {
                        this.f1836s = new ActionMenuPresenterCallback();
                    }
                    this.f1835r.setMenu(panelFeatureState.f1864j, this.f1836s);
                }
                panelFeatureState.f1864j.stopDispatchingItemsChanged();
                if (!d.onCreatePanelMenu(panelFeatureState.f1855a, panelFeatureState.f1864j)) {
                    panelFeatureState.mo3796a((MenuBuilder) null);
                    if (!z || this.f1835r == null) {
                        return false;
                    }
                    this.f1835r.setMenu((Menu) null, this.f1836s);
                    return false;
                }
                panelFeatureState.f1871q = false;
            }
            panelFeatureState.f1864j.stopDispatchingItemsChanged();
            if (panelFeatureState.f1872r != null) {
                panelFeatureState.f1864j.restoreActionViewStates(panelFeatureState.f1872r);
                panelFeatureState.f1872r = null;
            }
            if (!d.onPreparePanel(0, panelFeatureState.f1863i, panelFeatureState.f1864j)) {
                if (z && this.f1835r != null) {
                    this.f1835r.setMenu((Menu) null, this.f1836s);
                }
                panelFeatureState.f1864j.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f1864j.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.f1864j.startDispatchingItemsChanged();
        }
        panelFeatureState.f1867m = true;
        panelFeatureState.f1868n = false;
        this.f1822D = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1292c(int i) {
        PanelFeatureState a;
        PanelFeatureState a2 = m1269a(i, true);
        if (a2.f1864j != null) {
            Bundle bundle = new Bundle();
            a2.f1864j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a2.f1872r = bundle;
            }
            a2.f1864j.stopDispatchingItemsChanged();
            a2.f1864j.clear();
        }
        a2.f1871q = true;
        a2.f1870p = true;
        if ((i == 108 || i == 0) && this.f1835r != null && (a = m1269a(0, false)) != null) {
            a.f1867m = false;
            m1290b(a, (KeyEvent) null);
        }
    }

    /* renamed from: c */
    private boolean m1293c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f1863i != null) {
            panelFeatureState.f1862h = panelFeatureState.f1863i;
            return true;
        } else if (panelFeatureState.f1864j == null) {
            return false;
        } else {
            if (this.f1837t == null) {
                this.f1837t = new PanelMenuPresenterCallback();
            }
            panelFeatureState.f1862h = (View) panelFeatureState.mo3794a((MenuPresenter.Callback) this.f1837t);
            return panelFeatureState.f1862h != null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public int m1294d(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.f1831n == null || !(this.f1831n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1831n.getLayoutParams();
            if (this.f1831n.isShown()) {
                if (this.f1827I == null) {
                    this.f1827I = new Rect();
                    this.f1828J = new Rect();
                }
                Rect rect = this.f1827I;
                Rect rect2 = this.f1828J;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.f1840w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1842y == null) {
                        this.f1842y = new View(this.f1800a);
                        this.f1842y.setBackgroundColor(this.f1800a.getResources().getColor(C0235R.color.abc_input_method_navigation_guard));
                        this.f1840w.addView(this.f1842y, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f1842y.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1842y.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                if (this.f1842y == null) {
                    z4 = false;
                }
                if (!this.f1809j && z4) {
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
                this.f1831n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.f1842y != null) {
            View view = this.f1842y;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: d */
    private boolean m1296d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a = m1269a(i, true);
            if (!a.f1869o) {
                return m1290b(a, keyEvent);
            }
        }
        return false;
    }

    /* renamed from: e */
    private int m1297e(int i) {
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

    /* renamed from: e */
    private boolean m1298e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.f1830m != null) {
            return false;
        }
        PanelFeatureState a = m1269a(i, true);
        if (i != 0 || this.f1835r == null || !this.f1835r.canShowOverflowMenu() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f1800a))) {
            if (a.f1869o || a.f1868n) {
                boolean z3 = a.f1869o;
                m1275a(a, true);
                z2 = z3;
            } else {
                if (a.f1867m) {
                    if (a.f1871q) {
                        a.f1867m = false;
                        z = m1290b(a, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        m1274a(a, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (!this.f1835r.isOverflowMenuShowing()) {
            if (!mo3761c() && m1290b(a, keyEvent)) {
                z2 = this.f1835r.showOverflowMenu();
            }
            z2 = false;
        } else {
            z2 = this.f1835r.hideOverflowMenu();
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f1800a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    /* renamed from: g */
    private void m1299g() {
        if (!this.f1838u) {
            this.f1840w = m1300h();
            CharSequence e = mo3763e();
            if (!TextUtils.isEmpty(e)) {
                mo3756a(e);
            }
            m1301i();
            mo3776a(this.f1840w);
            this.f1838u = true;
            PanelFeatureState a = m1269a(0, false);
            if (mo3761c()) {
                return;
            }
            if (a == null || a.f1864j == null) {
                m1287b(108);
            }
        }
    }

    /* renamed from: h */
    private ViewGroup m1300h() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f1800a.obtainStyledAttributes(C0235R.styleable.Theme);
        if (!obtainStyledAttributes.hasValue(C0235R.styleable.Theme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(C0235R.styleable.Theme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(C0235R.styleable.Theme_windowActionBar, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(C0235R.styleable.Theme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(C0235R.styleable.Theme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.f1810k = obtainStyledAttributes.getBoolean(C0235R.styleable.Theme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(this.f1800a);
        if (this.f1811l) {
            ViewGroup viewGroup2 = this.f1809j ? (ViewGroup) from.inflate(C0235R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(C0235R.layout.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup2, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int c = AppCompatDelegateImplV7.this.m1294d(systemWindowInsetTop);
                        if (systemWindowInsetTop != c) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), c, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
                viewGroup = viewGroup2;
            } else {
                ((FitWindowsViewGroup) viewGroup2).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                    public void onFitSystemWindows(Rect rect) {
                        rect.top = AppCompatDelegateImplV7.this.m1294d(rect.top);
                    }
                });
                viewGroup = viewGroup2;
            }
        } else if (this.f1810k) {
            this.f1808i = false;
            this.f1807h = false;
            viewGroup = (ViewGroup) from.inflate(C0235R.layout.abc_dialog_title_material, (ViewGroup) null);
        } else if (this.f1807h) {
            TypedValue typedValue = new TypedValue();
            this.f1800a.getTheme().resolveAttribute(C0235R.attr.actionBarTheme, typedValue, true);
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.f1800a, typedValue.resourceId) : this.f1800a).inflate(C0235R.layout.abc_screen_toolbar, (ViewGroup) null);
            this.f1835r = (DecorContentParent) viewGroup3.findViewById(C0235R.C0237id.decor_content_parent);
            this.f1835r.setWindowCallback(mo3762d());
            if (this.f1808i) {
                this.f1835r.initFeature(109);
            }
            if (this.f1843z) {
                this.f1835r.initFeature(2);
            }
            if (this.f1819A) {
                this.f1835r.initFeature(5);
            }
            viewGroup = viewGroup3;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1807h + ", windowActionBarOverlay: " + this.f1808i + ", android:windowIsFloating: " + this.f1810k + ", windowActionModeOverlay: " + this.f1809j + ", windowNoTitle: " + this.f1811l + " }");
        }
        if (this.f1835r == null) {
            this.f1841x = (TextView) viewGroup.findViewById(C0235R.C0237id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        ViewGroup viewGroup4 = (ViewGroup) this.f1801b.findViewById(16908290);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0235R.C0237id.action_bar_activity_content);
        while (viewGroup4.getChildCount() > 0) {
            View childAt = viewGroup4.getChildAt(0);
            viewGroup4.removeViewAt(0);
            contentFrameLayout.addView(childAt);
        }
        this.f1801b.setContentView(viewGroup);
        viewGroup4.setId(-1);
        contentFrameLayout.setId(16908290);
        if (viewGroup4 instanceof FrameLayout) {
            ((FrameLayout) viewGroup4).setForeground((Drawable) null);
        }
        return viewGroup;
    }

    /* renamed from: i */
    private void m1301i() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1840w.findViewById(16908290);
        contentFrameLayout.setDecorPadding(this.f1839v.getPaddingLeft(), this.f1839v.getPaddingTop(), this.f1839v.getPaddingRight(), this.f1839v.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1800a.obtainStyledAttributes(C0235R.styleable.Theme);
        obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Theme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Theme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Theme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0235R.styleable.Theme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0235R.styleable.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m1302j() {
        if (this.f1834q != null) {
            this.f1834q.cancel();
        }
    }

    /* renamed from: k */
    private void m1303k() {
        if (this.f1838u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ActionMode mo3753a(ActionMode.Callback callback) {
        ActionMode actionMode;
        Context context;
        m1302j();
        if (this.f1830m != null) {
            this.f1830m.finish();
        }
        ActionModeCallbackWrapperV7 actionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(callback);
        if (this.f1804e == null || mo3761c()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.f1804e.onWindowStartingSupportActionMode(actionModeCallbackWrapperV7);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.f1830m = actionMode;
        } else {
            if (this.f1831n == null) {
                if (this.f1810k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1800a.getTheme();
                    theme.resolveAttribute(C0235R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.f1800a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        context = new ContextThemeWrapper(this.f1800a, 0);
                        context.getTheme().setTo(newTheme);
                    } else {
                        context = this.f1800a;
                    }
                    this.f1831n = new ActionBarContextView(context);
                    this.f1832o = new PopupWindow(context, (AttributeSet) null, C0235R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.f1832o, 2);
                    this.f1832o.setContentView(this.f1831n);
                    this.f1832o.setWidth(-1);
                    context.getTheme().resolveAttribute(C0235R.attr.actionBarSize, typedValue, true);
                    this.f1831n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.f1832o.setHeight(-2);
                    this.f1833p = new Runnable() {
                        public void run() {
                            AppCompatDelegateImplV7.this.f1832o.showAtLocation(AppCompatDelegateImplV7.this.f1831n, 55, 0, 0);
                            AppCompatDelegateImplV7.this.m1302j();
                            ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1831n, BitmapDescriptorFactory.HUE_RED);
                            AppCompatDelegateImplV7.this.f1834q = ViewCompat.animate(AppCompatDelegateImplV7.this.f1831n).alpha(1.0f);
                            AppCompatDelegateImplV7.this.f1834q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                                public void onAnimationEnd(View view) {
                                    ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1831n, 1.0f);
                                    AppCompatDelegateImplV7.this.f1834q.setListener((ViewPropertyAnimatorListener) null);
                                    AppCompatDelegateImplV7.this.f1834q = null;
                                }

                                public void onAnimationStart(View view) {
                                    AppCompatDelegateImplV7.this.f1831n.setVisibility(0);
                                }
                            });
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1840w.findViewById(C0235R.C0237id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(mo3759b()));
                        this.f1831n = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.f1831n != null) {
                m1302j();
                this.f1831n.killMode();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.f1831n.getContext(), this.f1831n, actionModeCallbackWrapperV7, this.f1832o == null);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.f1831n.initForMode(standaloneActionMode);
                    this.f1830m = standaloneActionMode;
                    ViewCompat.setAlpha(this.f1831n, BitmapDescriptorFactory.HUE_RED);
                    this.f1834q = ViewCompat.animate(this.f1831n).alpha(1.0f);
                    this.f1834q.setListener(new ViewPropertyAnimatorListenerAdapter() {
                        public void onAnimationEnd(View view) {
                            ViewCompat.setAlpha(AppCompatDelegateImplV7.this.f1831n, 1.0f);
                            AppCompatDelegateImplV7.this.f1834q.setListener((ViewPropertyAnimatorListener) null);
                            AppCompatDelegateImplV7.this.f1834q = null;
                        }

                        public void onAnimationStart(View view) {
                            AppCompatDelegateImplV7.this.f1831n.setVisibility(0);
                            AppCompatDelegateImplV7.this.f1831n.sendAccessibilityEvent(32);
                            if (AppCompatDelegateImplV7.this.f1831n.getParent() != null) {
                                ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.f1831n.getParent());
                            }
                        }
                    });
                    if (this.f1832o != null) {
                        this.f1801b.getDecorView().post(this.f1833p);
                    }
                } else {
                    this.f1830m = null;
                }
            }
        }
        if (!(this.f1830m == null || this.f1804e == null)) {
            this.f1804e.onSupportActionModeStarted(this.f1830m);
        }
        return this.f1830m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo3772a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.f1802c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.f1802c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3755a(int i, Menu menu) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState a = m1269a(i, true);
            if (a.f1869o) {
                m1275a(a, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3776a(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3756a(CharSequence charSequence) {
        if (this.f1835r != null) {
            this.f1835r.setWindowTitle(charSequence);
        } else if (mo3752a() != null) {
            mo3752a().setWindowTitle(charSequence);
        } else if (this.f1841x != null) {
            this.f1841x.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3757a(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.f1822D == null || !m1283a(this.f1822D, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1822D == null) {
                PanelFeatureState a = m1269a(0, true);
                m1290b(a, keyEvent);
                boolean a2 = m1283a(a, keyEvent.getKeyCode(), keyEvent, 1);
                a.f1867m = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        } else if (this.f1822D == null) {
            return true;
        } else {
            this.f1822D.f1868n = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3758a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.f1802c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo3778c(keyCode, keyEvent) : mo3777b(keyCode, keyEvent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1299g();
        ((ViewGroup) this.f1840w.findViewById(16908290)).addView(view, layoutParams);
        this.f1802c.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3777b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                PanelFeatureState a = m1269a(0, false);
                if (a != null && a.f1869o) {
                    m1275a(a, true);
                    return true;
                } else if (mo3779f()) {
                    return true;
                }
                break;
            case 82:
                m1298e(0, keyEvent);
                return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3760b(int i, Menu menu) {
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

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo3778c(int i, KeyEvent keyEvent) {
        switch (i) {
            case 82:
                m1296d(0, keyEvent);
                break;
        }
        if (Build.VERSION.SDK_INT < 11) {
            mo3757a(i, keyEvent);
        }
        return false;
    }

    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.f1829K == null) {
            this.f1829K = new AppCompatViewInflater();
        }
        return this.f1829K.createView(view, str, context, attributeSet, z && this.f1838u && m1285a((ViewParent) view), z, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo3779f() {
        if (this.f1830m != null) {
            this.f1830m.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    public boolean hasWindowFeature(int i) {
        int e = m1297e(i);
        switch (e) {
            case 1:
                return this.f1811l;
            case 2:
                return this.f1843z;
            case 5:
                return this.f1819A;
            case 10:
                return this.f1809j;
            case 108:
                return this.f1807h;
            case 109:
                return this.f1808i;
            default:
                return this.f1801b.hasFeature(e);
        }
    }

    public void initWindowDecorActionBar() {
        m1299g();
        if (this.f1807h && this.f1805f == null) {
            if (this.f1802c instanceof Activity) {
                this.f1805f = new WindowDecorActionBar((Activity) this.f1802c, this.f1808i);
            } else if (this.f1802c instanceof Dialog) {
                this.f1805f = new WindowDecorActionBar((Dialog) this.f1802c);
            }
            if (this.f1805f != null) {
                this.f1805f.setDefaultDisplayHomeAsUpEnabled(this.f1826H);
            }
        }
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f1800a);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            m1287b(0);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.f1807h && this.f1838u && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        this.f1839v = (ViewGroup) this.f1801b.getDecorView();
        if ((this.f1802c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.f1802c) != null) {
            ActionBar a = mo3752a();
            if (a == null) {
                this.f1826H = true;
            } else {
                a.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo3772a(view, str, context, attributeSet);
        return a != null ? a : createView(view, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a;
        Window.Callback d = mo3762d();
        if (d == null || mo3761c() || (a = m1271a((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return d.onMenuItemSelected(a.f1855a, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        m1281a(menuBuilder, true);
    }

    public void onPostCreate(Bundle bundle) {
        m1299g();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public boolean requestWindowFeature(int i) {
        int e = m1297e(i);
        if (this.f1811l && e == 108) {
            return false;
        }
        if (this.f1807h && e == 1) {
            this.f1807h = false;
        }
        switch (e) {
            case 1:
                m1303k();
                this.f1811l = true;
                return true;
            case 2:
                m1303k();
                this.f1843z = true;
                return true;
            case 5:
                m1303k();
                this.f1819A = true;
                return true;
            case 10:
                m1303k();
                this.f1809j = true;
                return true;
            case 108:
                m1303k();
                this.f1807h = true;
                return true;
            case 109:
                m1303k();
                this.f1808i = true;
                return true;
            default:
                return this.f1801b.requestFeature(e);
        }
    }

    public void setContentView(int i) {
        m1299g();
        ViewGroup viewGroup = (ViewGroup) this.f1840w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1800a).inflate(i, viewGroup);
        this.f1802c.onContentChanged();
    }

    public void setContentView(View view) {
        m1299g();
        ViewGroup viewGroup = (ViewGroup) this.f1840w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1802c.onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1299g();
        ViewGroup viewGroup = (ViewGroup) this.f1840w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1802c.onContentChanged();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f1802c instanceof Activity) {
            if (getSupportActionBar() instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f1806g = null;
            ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, ((Activity) this.f1800a).getTitle(), this.f1803d);
            this.f1805f = toolbarActionBar;
            this.f1801b.setCallback(toolbarActionBar.getWrappedWindowCallback());
            toolbarActionBar.invalidateOptionsMenu();
        }
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1830m != null) {
            this.f1830m.finish();
        }
        ActionModeCallbackWrapperV7 actionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.f1830m = supportActionBar.startActionMode(actionModeCallbackWrapperV7);
            if (!(this.f1830m == null || this.f1804e == null)) {
                this.f1804e.onSupportActionModeStarted(this.f1830m);
            }
        }
        if (this.f1830m == null) {
            this.f1830m = mo3753a((ActionMode.Callback) actionModeCallbackWrapperV7);
        }
        return this.f1830m;
    }
}
