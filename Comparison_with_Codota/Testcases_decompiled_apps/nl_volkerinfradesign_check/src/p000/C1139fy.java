package p000;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p004v7.app.ActionBar;
import android.support.p004v7.app.ActionBarDrawerToggle;
import android.support.p004v7.app.AppCompatCallback;
import android.support.p004v7.app.AppCompatDelegate;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.view.SupportMenuInflater;
import android.support.p004v7.view.WindowCallbackWrapper;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

/* renamed from: fy */
public abstract class C1139fy extends AppCompatDelegate {

    /* renamed from: a */
    public final Context f4105a;

    /* renamed from: b */
    public final Window f4106b;

    /* renamed from: c */
    public final Window.Callback f4107c = this.f4106b.getCallback();

    /* renamed from: d */
    public final Window.Callback f4108d;

    /* renamed from: e */
    public final AppCompatCallback f4109e;

    /* renamed from: f */
    public ActionBar f4110f;

    /* renamed from: g */
    public MenuInflater f4111g;

    /* renamed from: h */
    public boolean f4112h;

    /* renamed from: i */
    public boolean f4113i;

    /* renamed from: j */
    public boolean f4114j;

    /* renamed from: k */
    public boolean f4115k;

    /* renamed from: l */
    public boolean f4116l;

    /* renamed from: m */
    private CharSequence f4117m;

    /* renamed from: n */
    private boolean f4118n;

    /* renamed from: a */
    public abstract ActionMode mo3336a(ActionMode.Callback callback);

    /* renamed from: a */
    public abstract void mo3338a();

    /* renamed from: a */
    public abstract void mo3339a(int i, Menu menu);

    /* renamed from: a */
    public abstract void mo3341a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo3342a(int i, KeyEvent keyEvent);

    /* renamed from: a */
    public abstract boolean mo3343a(KeyEvent keyEvent);

    /* renamed from: b */
    public abstract boolean mo3345b(int i, Menu menu);

    public C1139fy(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f4105a = context;
        this.f4106b = window;
        this.f4109e = appCompatCallback;
        if (this.f4107c instanceof C1142b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f4108d = mo8115a(this.f4107c);
        this.f4106b.setCallback(this.f4108d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo8115a(Window.Callback callback) {
        return new C1142b(callback);
    }

    public ActionBar getSupportActionBar() {
        mo3338a();
        return this.f4110f;
    }

    /* renamed from: b */
    public final ActionBar mo8116b() {
        return this.f4110f;
    }

    public MenuInflater getMenuInflater() {
        if (this.f4111g == null) {
            mo3338a();
            this.f4111g = new SupportMenuInflater(this.f4110f != null ? this.f4110f.getThemedContext() : this.f4105a);
        }
        return this.f4111g;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new C1141a();
    }

    /* renamed from: c */
    public final Context mo8117c() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.f4105a;
        }
        return context;
    }

    /* renamed from: fy$a */
    class C1141a implements ActionBarDrawerToggle.Delegate {
        private C1141a() {
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{C0505R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context getActionBarThemedContext() {
            return C1139fy.this.mo8117c();
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = C1139fy.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = C1139fy.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = C1139fy.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public final void onDestroy() {
        this.f4118n = true;
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    /* renamed from: d */
    public final boolean mo8118d() {
        return this.f4118n;
    }

    /* renamed from: e */
    public final Window.Callback mo8119e() {
        return this.f4106b.getCallback();
    }

    public final void setTitle(CharSequence charSequence) {
        this.f4117m = charSequence;
        mo3341a(charSequence);
    }

    /* renamed from: f */
    public final CharSequence mo8120f() {
        if (this.f4107c instanceof Activity) {
            return ((Activity) this.f4107c).getTitle();
        }
        return this.f4117m;
    }

    /* renamed from: fy$b */
    class C1142b extends WindowCallbackWrapper {
        C1142b(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C1139fy.this.mo3343a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || C1139fy.this.mo3342a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
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

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            C1139fy.this.mo3345b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            C1139fy.this.mo3339a(i, menu);
        }
    }
}
