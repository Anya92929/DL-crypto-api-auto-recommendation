package android.support.p003v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.WindowCallbackWrapper;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatDelegateImplBase */
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {

    /* renamed from: a */
    final Context f1800a;

    /* renamed from: b */
    final Window f1801b;

    /* renamed from: c */
    final Window.Callback f1802c = this.f1801b.getCallback();

    /* renamed from: d */
    final Window.Callback f1803d;

    /* renamed from: e */
    final AppCompatCallback f1804e;

    /* renamed from: f */
    ActionBar f1805f;

    /* renamed from: g */
    MenuInflater f1806g;

    /* renamed from: h */
    boolean f1807h;

    /* renamed from: i */
    boolean f1808i;

    /* renamed from: j */
    boolean f1809j;

    /* renamed from: k */
    boolean f1810k;

    /* renamed from: l */
    boolean f1811l;

    /* renamed from: m */
    private CharSequence f1812m;

    /* renamed from: n */
    private boolean f1813n;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplBase$ActionBarDrawableToggleImpl */
    class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        private ActionBarDrawableToggleImpl() {
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImplBase.this.mo3759b();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{C0235R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplBase$AppCompatWindowCallbackBase */
    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        AppCompatWindowCallbackBase(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplBase.this.mo3758a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImplBase.this.mo3757a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            return super.onMenuOpened(i, menu) || AppCompatDelegateImplBase.this.mo3760b(i, menu);
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.mo3755a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder == null) {
                return onPreparePanel;
            }
            menuBuilder.setOverrideVisibleItems(false);
            return onPreparePanel;
        }
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f1800a = context;
        this.f1801b = window;
        this.f1804e = appCompatCallback;
        if (this.f1802c instanceof AppCompatWindowCallbackBase) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1803d = mo3754a(this.f1802c);
        this.f1801b.setCallback(this.f1803d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final ActionBar mo3752a() {
        return this.f1805f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract ActionMode mo3753a(ActionMode.Callback callback);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo3754a(Window.Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo3755a(int i, Menu menu);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo3756a(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo3757a(int i, KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo3758a(KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Context mo3759b() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        return context == null ? this.f1800a : context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo3760b(int i, Menu menu);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo3761c() {
        return this.f1813n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Window.Callback mo3762d() {
        return this.f1801b.getCallback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final CharSequence mo3763e() {
        return this.f1802c instanceof Activity ? ((Activity) this.f1802c).getTitle() : this.f1812m;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    public MenuInflater getMenuInflater() {
        if (this.f1806g == null) {
            initWindowDecorActionBar();
            this.f1806g = new SupportMenuInflater(this.f1805f != null ? this.f1805f.getThemedContext() : this.f1800a);
        }
        return this.f1806g;
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.f1805f;
    }

    /* access modifiers changed from: package-private */
    public abstract void initWindowDecorActionBar();

    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    public final void onDestroy() {
        this.f1813n = true;
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    public final void setTitle(CharSequence charSequence) {
        this.f1812m = charSequence;
        mo3756a(charSequence);
    }
}
