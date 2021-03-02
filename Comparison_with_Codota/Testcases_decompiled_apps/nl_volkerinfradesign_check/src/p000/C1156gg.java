package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.app.ActionBar;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.WindowCallbackWrapper;
import android.support.p004v7.view.menu.ListMenuPresenter;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.widget.DecorToolbar;
import android.support.p004v7.widget.Toolbar;
import android.support.p004v7.widget.ToolbarWidgetWrapper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

/* renamed from: gg */
public class C1156gg extends ActionBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DecorToolbar f4143a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f4144b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Window.Callback f4145c;

    /* renamed from: d */
    private boolean f4146d;

    /* renamed from: e */
    private boolean f4147e;

    /* renamed from: f */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f4148f = new ArrayList<>();

    /* renamed from: g */
    private ListMenuPresenter f4149g;

    /* renamed from: h */
    private final Runnable f4150h = new Runnable() {
        public void run() {
            C1156gg.this.mo8128b();
        }
    };

    /* renamed from: i */
    private final Toolbar.OnMenuItemClickListener f4151i = new Toolbar.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            return C1156gg.this.f4145c.onMenuItemSelected(0, menuItem);
        }
    };

    public C1156gg(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f4143a = new ToolbarWidgetWrapper(toolbar, false);
        this.f4145c = new C1162d(callback);
        this.f4143a.setWindowCallback(this.f4145c);
        toolbar.setOnMenuItemClickListener(this.f4151i);
        this.f4143a.setWindowTitle(charSequence);
    }

    /* renamed from: a */
    public Window.Callback mo8127a() {
        return this.f4145c;
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f4143a.setCustomView(view);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.f4143a.getContext()).inflate(i, this.f4143a.getViewGroup(), false));
    }

    public void setIcon(int i) {
        this.f4143a.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f4143a.setIcon(drawable);
    }

    public void setLogo(int i) {
        this.f4143a.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.f4143a.setLogo(drawable);
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.f4143a.getViewGroup(), f);
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f4143a.getViewGroup());
    }

    public Context getThemedContext() {
        return this.f4143a.getContext();
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f4143a.setNavigationIcon(drawable);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f4143a.setNavigationIcon(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f4143a.setNavigationContentDescription(charSequence);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setHomeActionContentDescription(int i) {
        this.f4143a.setNavigationContentDescription(i);
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f4143a.setDropdownParams(spinnerAdapter, new C1153gd(onNavigationListener));
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.f4143a.getNavigationMode()) {
            case 1:
                this.f4143a.setDropdownSelectedPosition(i);
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public void setTitle(CharSequence charSequence) {
        this.f4143a.setTitle(charSequence);
    }

    public void setTitle(int i) {
        this.f4143a.setTitle(i != 0 ? this.f4143a.getContext().getText(i) : null);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f4143a.setWindowTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4143a.setSubtitle(charSequence);
    }

    public void setSubtitle(int i) {
        this.f4143a.setSubtitle(i != 0 ? this.f4143a.getContext().getText(i) : null);
    }

    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    public void setDisplayOptions(int i, int i2) {
        this.f4143a.setDisplayOptions((this.f4143a.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
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

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f4143a.setBackgroundDrawable(drawable);
    }

    public View getCustomView() {
        return this.f4143a.getCustomView();
    }

    public CharSequence getTitle() {
        return this.f4143a.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.f4143a.getSubtitle();
    }

    public int getNavigationMode() {
        return 0;
    }

    public void setNavigationMode(int i) {
        if (i == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.f4143a.setNavigationMode(i);
    }

    public int getDisplayOptions() {
        return this.f4143a.getDisplayOptions();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public int getHeight() {
        return this.f4143a.getHeight();
    }

    public void show() {
        this.f4143a.setVisibility(0);
    }

    public void hide() {
        this.f4143a.setVisibility(8);
    }

    public boolean isShowing() {
        return this.f4143a.getVisibility() == 0;
    }

    public boolean openOptionsMenu() {
        return this.f4143a.showOverflowMenu();
    }

    public boolean invalidateOptionsMenu() {
        this.f4143a.getViewGroup().removeCallbacks(this.f4150h);
        ViewCompat.postOnAnimation(this.f4143a.getViewGroup(), this.f4150h);
        return true;
    }

    public boolean collapseActionView() {
        if (!this.f4143a.hasExpandedActionView()) {
            return false;
        }
        this.f4143a.collapseActionView();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8128b() {
        Menu c = m5180c();
        MenuBuilder menuBuilder = c instanceof MenuBuilder ? (MenuBuilder) c : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            c.clear();
            if (!this.f4145c.onCreatePanelMenu(0, c) || !this.f4145c.onPreparePanel(0, (View) null, c)) {
                c.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        boolean z;
        Menu c = m5180c();
        if (c != null) {
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            c.setQwertyMode(z);
            c.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f4148f.add(onMenuVisibilityListener);
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f4148f.remove(onMenuVisibilityListener);
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f4147e) {
            this.f4147e = z;
            int size = this.f4148f.size();
            for (int i = 0; i < size; i++) {
                this.f4148f.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m5173a(Menu menu) {
        m5177b(menu);
        if (menu == null || this.f4149g == null || this.f4149g.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.f4149g.getMenuView(this.f4143a.getViewGroup());
    }

    /* renamed from: b */
    private void m5177b(Menu menu) {
        if (this.f4149g == null && (menu instanceof MenuBuilder)) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            Context context = this.f4143a.getContext();
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
            this.f4149g = new ListMenuPresenter((Context) contextThemeWrapper, C0505R.layout.abc_list_menu_item_layout);
            this.f4149g.setCallback(new C1161c());
            menuBuilder.addMenuPresenter(this.f4149g);
        }
    }

    /* renamed from: gg$d */
    class C1162d extends WindowCallbackWrapper {
        public C1162d(Window.Callback callback) {
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !C1156gg.this.f4144b) {
                C1156gg.this.f4143a.setMenuPrepared();
                boolean unused = C1156gg.this.f4144b = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = C1156gg.this.f4143a.getMenu();
                    if (onPreparePanel(i, (View) null, menu) && onMenuOpened(i, menu)) {
                        return C1156gg.this.m5173a(menu);
                    }
            }
            return super.onCreatePanelView(i);
        }
    }

    /* renamed from: c */
    private Menu m5180c() {
        if (!this.f4146d) {
            this.f4143a.setMenuCallbacks(new C1159a(), new C1160b());
            this.f4146d = true;
        }
        return this.f4143a.getMenu();
    }

    /* renamed from: gg$a */
    final class C1159a implements MenuPresenter.Callback {

        /* renamed from: b */
        private boolean f4155b;

        private C1159a() {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (C1156gg.this.f4145c == null) {
                return false;
            }
            C1156gg.this.f4145c.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.f4155b) {
                this.f4155b = true;
                C1156gg.this.f4143a.dismissPopupMenus();
                if (C1156gg.this.f4145c != null) {
                    C1156gg.this.f4145c.onPanelClosed(108, menuBuilder);
                }
                this.f4155b = false;
            }
        }
    }

    /* renamed from: gg$c */
    final class C1161c implements MenuPresenter.Callback {
        private C1161c() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (C1156gg.this.f4145c != null) {
                C1156gg.this.f4145c.onPanelClosed(0, menuBuilder);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder != null || C1156gg.this.f4145c == null) {
                return true;
            }
            C1156gg.this.f4145c.onMenuOpened(0, menuBuilder);
            return true;
        }
    }

    /* renamed from: gg$b */
    final class C1160b implements MenuBuilder.Callback {
        private C1160b() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (C1156gg.this.f4145c == null) {
                return;
            }
            if (C1156gg.this.f4143a.isOverflowMenuShowing()) {
                C1156gg.this.f4145c.onPanelClosed(108, menuBuilder);
            } else if (C1156gg.this.f4145c.onPreparePanel(0, (View) null, menuBuilder)) {
                C1156gg.this.f4145c.onMenuOpened(108, menuBuilder);
            }
        }
    }
}
