package android.support.p004v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.view.MenuItemCompat;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.view.menu.MenuItemWrapperICS */
public class MenuItemWrapperICS extends C1163gh<SupportMenuItem> implements MenuItem {

    /* renamed from: c */
    private Method f1804c;

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    public int getItemId() {
        return ((SupportMenuItem) this.f4162b).getItemId();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.f4162b).getGroupId();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.f4162b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f4162b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f4162b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f4162b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f4162b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f4162b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f4162b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f4162b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.f4162b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f4162b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.f4162b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f4162b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f4162b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f4162b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f4162b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f4162b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f4162b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.f4162b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f4162b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.f4162b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f4162b).setVisible(z);
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.f4162b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f4162b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.f4162b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f4162b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return mo8131a(((SupportMenuItem) this.f4162b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f4162b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0517d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f4162b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f4162b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f4162b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0515b(view);
        }
        ((SupportMenuItem) this.f4162b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f4162b).setActionView(i);
        View actionView = ((SupportMenuItem) this.f4162b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.f4162b).setActionView((View) new C0515b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f4162b).getActionView();
        if (actionView instanceof C0515b) {
            return ((C0515b) actionView).mo3836a();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((SupportMenuItem) this.f4162b).setSupportActionProvider(actionProvider != null ? mo3793a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.p001v4.view.ActionProvider supportActionProvider = ((SupportMenuItem) this.f4162b).getSupportActionProvider();
        if (supportActionProvider instanceof C0514a) {
            return ((C0514a) supportActionProvider).f1805a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.f4162b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f4162b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f4162b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f4162b).setSupportOnActionExpandListener(onActionExpandListener != null ? new C0516c(onActionExpandListener) : null);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.f1804c == null) {
                this.f1804c = ((SupportMenuItem) this.f4162b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1804c.invoke(this.f4162b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* renamed from: a */
    public C0514a mo3793a(ActionProvider actionProvider) {
        return new C0514a(this.f4159a, actionProvider);
    }

    /* renamed from: android.support.v7.view.menu.MenuItemWrapperICS$d */
    class C0517d extends C1164gi<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        C0517d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f4162b).onMenuItemClick(MenuItemWrapperICS.this.mo8130a(menuItem));
        }
    }

    /* renamed from: android.support.v7.view.menu.MenuItemWrapperICS$c */
    class C0516c extends C1164gi<MenuItem.OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        C0516c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f4162b).onMenuItemActionExpand(MenuItemWrapperICS.this.mo8130a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f4162b).onMenuItemActionCollapse(MenuItemWrapperICS.this.mo8130a(menuItem));
        }
    }

    /* renamed from: android.support.v7.view.menu.MenuItemWrapperICS$a */
    public class C0514a extends android.support.p001v4.view.ActionProvider {

        /* renamed from: a */
        public final ActionProvider f1805a;

        public C0514a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1805a = actionProvider;
        }

        public View onCreateActionView() {
            return this.f1805a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f1805a.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.f1805a.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f1805a.onPrepareSubMenu(MenuItemWrapperICS.this.mo8131a(subMenu));
        }
    }

    /* renamed from: android.support.v7.view.menu.MenuItemWrapperICS$b */
    static class C0515b extends FrameLayout implements android.support.p004v7.view.CollapsibleActionView {

        /* renamed from: a */
        final CollapsibleActionView f1807a;

        C0515b(View view) {
            super(view.getContext());
            this.f1807a = (CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.f1807a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f1807a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo3836a() {
            return (View) this.f1807a;
        }
    }
}
