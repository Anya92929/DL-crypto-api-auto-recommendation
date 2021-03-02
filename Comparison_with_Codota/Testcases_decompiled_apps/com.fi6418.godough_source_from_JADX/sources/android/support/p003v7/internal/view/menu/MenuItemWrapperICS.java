package android.support.p003v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS */
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {

    /* renamed from: c */
    private Method f2159c;

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS$ActionProviderWrapper */
    class ActionProviderWrapper extends ActionProvider {

        /* renamed from: a */
        final android.view.ActionProvider f2160a;

        public ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f2160a = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f2160a.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f2160a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f2160a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f2160a.onPrepareSubMenu(MenuItemWrapperICS.this.mo4052a(subMenu));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS$CollapsibleActionViewWrapper */
    class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* renamed from: a */
        final android.view.CollapsibleActionView f2162a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f2162a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo4258a() {
            return (View) this.f2162a;
        }

        public void onActionViewCollapsed() {
            this.f2162a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f2162a.onActionViewExpanded();
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS$OnActionExpandListenerWrapper */
    class OnActionExpandListenerWrapper extends BaseWrapper<MenuItem.OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f2073b).onMenuItemActionCollapse(MenuItemWrapperICS.this.mo4051a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f2073b).onMenuItemActionExpand(MenuItemWrapperICS.this.mo4051a(menuItem));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperICS$OnMenuItemClickListenerWrapper */
    class OnMenuItemClickListenerWrapper extends BaseWrapper<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f2073b).onMenuItemClick(MenuItemWrapperICS.this.mo4051a(menuItem));
        }
    }

    MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ActionProviderWrapper mo4215a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapper(this.f2070a, actionProvider);
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f2073b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.f2073b).expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider supportActionProvider = ((SupportMenuItem) this.f2073b).getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).f2160a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f2073b).getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).mo4258a() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f2073b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.f2073b).getGroupId();
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.f2073b).getIcon();
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.f2073b).getIntent();
    }

    public int getItemId() {
        return ((SupportMenuItem) this.f2073b).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f2073b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f2073b).getNumericShortcut();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.f2073b).getOrder();
    }

    public SubMenu getSubMenu() {
        return mo4052a(((SupportMenuItem) this.f2073b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f2073b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f2073b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f2073b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f2073b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.f2073b).isCheckable();
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.f2073b).isChecked();
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.f2073b).isEnabled();
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.f2073b).isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.f2073b).setSupportActionProvider(actionProvider != null ? mo4215a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f2073b).setActionView(i);
        View actionView = ((SupportMenuItem) this.f2073b).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((SupportMenuItem) this.f2073b).setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem) this.f2073b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f2073b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f2073b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f2073b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f2073b).setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.f2159c == null) {
                this.f2159c = ((SupportMenuItem) this.f2073b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f2159c.invoke(this.f2073b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f2073b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f2073b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f2073b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f2073b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f2073b).setSupportOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f2073b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f2073b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f2073b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f2073b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f2073b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f2073b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f2073b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f2073b).setVisible(z);
    }
}
