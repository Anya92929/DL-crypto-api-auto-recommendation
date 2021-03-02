package android.support.p003v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.WindowCallbackWrapper;
import android.support.p003v7.internal.view.menu.ListMenuPresenter;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.widget.DecorToolbar;
import android.support.p003v7.internal.widget.ToolbarWidgetWrapper;
import android.support.p003v7.widget.Toolbar;
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

/* renamed from: android.support.v7.internal.app.ToolbarActionBar */
public class ToolbarActionBar extends ActionBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DecorToolbar f1902a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f1903b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Window.Callback f1904c;

    /* renamed from: d */
    private boolean f1905d;

    /* renamed from: e */
    private boolean f1906e;

    /* renamed from: f */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f1907f = new ArrayList<>();

    /* renamed from: g */
    private ListMenuPresenter f1908g;

    /* renamed from: h */
    private final Runnable f1909h = new Runnable() {
        public void run() {
            ToolbarActionBar.this.mo3880a();
        }
    };

    /* renamed from: i */
    private final Toolbar.OnMenuItemClickListener f1910i = new Toolbar.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.f1904c.onMenuItemSelected(0, menuItem);
        }
    };

    /* renamed from: android.support.v7.internal.app.ToolbarActionBar$ActionMenuPresenterCallback */
    final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: b */
        private boolean f1914b;

        private ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.f1914b) {
                this.f1914b = true;
                ToolbarActionBar.this.f1902a.dismissPopupMenus();
                if (ToolbarActionBar.this.f1904c != null) {
                    ToolbarActionBar.this.f1904c.onPanelClosed(108, menuBuilder);
                }
                this.f1914b = false;
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f1904c == null) {
                return false;
            }
            ToolbarActionBar.this.f1904c.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: android.support.v7.internal.app.ToolbarActionBar$MenuBuilderCallback */
    final class MenuBuilderCallback implements MenuBuilder.Callback {
        private MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f1904c == null) {
                return;
            }
            if (ToolbarActionBar.this.f1902a.isOverflowMenuShowing()) {
                ToolbarActionBar.this.f1904c.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f1904c.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.f1904c.onMenuOpened(108, menuBuilder);
            }
        }
    }

    /* renamed from: android.support.v7.internal.app.ToolbarActionBar$PanelMenuPresenterCallback */
    final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (ToolbarActionBar.this.f1904c != null) {
                ToolbarActionBar.this.f1904c.onPanelClosed(0, menuBuilder);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder != null || ToolbarActionBar.this.f1904c == null) {
                return true;
            }
            ToolbarActionBar.this.f1904c.onMenuOpened(0, menuBuilder);
            return true;
        }
    }

    /* renamed from: android.support.v7.internal.app.ToolbarActionBar$ToolbarCallbackWrapper */
    class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = ToolbarActionBar.this.f1902a.getMenu();
                    if (onPreparePanel(i, (View) null, menu) && onMenuOpened(i, menu)) {
                        return ToolbarActionBar.this.m1339a(menu);
                    }
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !ToolbarActionBar.this.f1903b) {
                ToolbarActionBar.this.f1902a.setMenuPrepared();
                boolean unused = ToolbarActionBar.this.f1903b = true;
            }
            return onPreparePanel;
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f1902a = new ToolbarWidgetWrapper(toolbar, false);
        this.f1904c = new ToolbarCallbackWrapper(callback);
        this.f1902a.setWindowCallback(this.f1904c);
        toolbar.setOnMenuItemClickListener(this.f1910i);
        this.f1902a.setWindowTitle(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m1339a(Menu menu) {
        m1343b(menu);
        if (menu == null || this.f1908g == null || this.f1908g.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.f1908g.getMenuView(this.f1902a.getViewGroup());
    }

    /* renamed from: b */
    private Menu m1342b() {
        if (!this.f1905d) {
            this.f1902a.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f1905d = true;
        }
        return this.f1902a.getMenu();
    }

    /* renamed from: b */
    private void m1343b(Menu menu) {
        if (this.f1908g == null && (menu instanceof MenuBuilder)) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            Context context = this.f1902a.getContext();
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
            this.f1908g = new ListMenuPresenter((Context) contextThemeWrapper, C0235R.layout.abc_list_menu_item_layout);
            this.f1908g.setCallback(new PanelMenuPresenterCallback());
            menuBuilder.addMenuPresenter(this.f1908g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3880a() {
        Menu b = m1342b();
        MenuBuilder menuBuilder = b instanceof MenuBuilder ? (MenuBuilder) b : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            b.clear();
            if (!this.f1904c.onCreatePanelMenu(0, b) || !this.f1904c.onPreparePanel(0, (View) null, b)) {
                b.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1907f.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean collapseActionView() {
        if (!this.f1902a.hasExpandedActionView()) {
            return false;
        }
        this.f1902a.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f1906e) {
            this.f1906e = z;
            int size = this.f1907f.size();
            for (int i = 0; i < size; i++) {
                this.f1907f.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public View getCustomView() {
        return this.f1902a.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f1902a.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f1902a.getViewGroup());
    }

    public int getHeight() {
        return this.f1902a.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.f1902a.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.f1902a.getContext();
    }

    public CharSequence getTitle() {
        return this.f1902a.getTitle();
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.f1904c;
    }

    public void hide() {
        this.f1902a.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.f1902a.getViewGroup().removeCallbacks(this.f1909h);
        ViewCompat.postOnAnimation(this.f1902a.getViewGroup(), this.f1909h);
        return true;
    }

    public boolean isShowing() {
        return this.f1902a.getVisibility() == 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu b = m1342b();
        if (b != null) {
            b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            b.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.f1902a.showOverflowMenu();
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f1907f.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f1902a.setBackgroundDrawable(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.f1902a.getContext()).inflate(i, this.f1902a.getViewGroup(), false));
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f1902a.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    public void setDisplayOptions(int i, int i2) {
        this.f1902a.setDisplayOptions((this.f1902a.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
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
        ViewCompat.setElevation(this.f1902a.getViewGroup(), f);
    }

    public void setHomeActionContentDescription(int i) {
        this.f1902a.setNavigationContentDescription(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f1902a.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f1902a.setNavigationIcon(i);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f1902a.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        this.f1902a.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f1902a.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f1902a.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i) {
        this.f1902a.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.f1902a.setLogo(drawable);
    }

    public void setNavigationMode(int i) {
        if (i == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.f1902a.setNavigationMode(i);
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.f1902a.getNavigationMode()) {
            case 1:
                this.f1902a.setDropdownSelectedPosition(i);
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(int i) {
        this.f1902a.setSubtitle(i != 0 ? this.f1902a.getContext().getText(i) : null);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1902a.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        this.f1902a.setTitle(i != 0 ? this.f1902a.getContext().getText(i) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1902a.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f1902a.setWindowTitle(charSequence);
    }

    public void show() {
        this.f1902a.setVisibility(0);
    }
}
