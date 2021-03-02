package android.support.p021v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.view.C0219ax;
import android.support.p009v4.view.C0344n;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.view.menu.u */
public class C0568u extends C0552e implements MenuItem {

    /* renamed from: c */
    private Method f1160c;

    C0568u(Context context, C0124b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0569v mo2565a(ActionProvider actionProvider) {
        return new C0569v(this, this.f1050a, actionProvider);
    }

    /* renamed from: a */
    public void mo2566a(boolean z) {
        try {
            if (this.f1160c == null) {
                this.f1160c = ((C0124b) this.f1053b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1160c.invoke(this.f1053b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0124b) this.f1053b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0124b) this.f1053b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0344n a = ((C0124b) this.f1053b).mo1018a();
        if (a instanceof C0569v) {
            return ((C0569v) a).f1161a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = ((C0124b) this.f1053b).getActionView();
        return actionView instanceof C0570w ? ((C0570w) actionView).mo2608c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0124b) this.f1053b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0124b) this.f1053b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0124b) this.f1053b).getIcon();
    }

    public Intent getIntent() {
        return ((C0124b) this.f1053b).getIntent();
    }

    public int getItemId() {
        return ((C0124b) this.f1053b).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((C0124b) this.f1053b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0124b) this.f1053b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0124b) this.f1053b).getOrder();
    }

    public SubMenu getSubMenu() {
        return mo2410a(((C0124b) this.f1053b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0124b) this.f1053b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0124b) this.f1053b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0124b) this.f1053b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0124b) this.f1053b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0124b) this.f1053b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0124b) this.f1053b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0124b) this.f1053b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0124b) this.f1053b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0124b) this.f1053b).mo1017a((C0344n) actionProvider != null ? mo2565a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0124b) this.f1053b).setActionView(i);
        View actionView = ((C0124b) this.f1053b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0124b) this.f1053b).setActionView((View) new C0570w(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0570w(view);
        }
        ((C0124b) this.f1053b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0124b) this.f1053b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0124b) this.f1053b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0124b) this.f1053b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0124b) this.f1053b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0124b) this.f1053b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0124b) this.f1053b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0124b) this.f1053b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0124b) this.f1053b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((C0124b) this.f1053b).mo1016a((C0219ax) onActionExpandListener != null ? new C0571x(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((C0124b) this.f1053b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0572y(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0124b) this.f1053b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0124b) this.f1053b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0124b) this.f1053b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0124b) this.f1053b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0124b) this.f1053b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0124b) this.f1053b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0124b) this.f1053b).setVisible(z);
    }
}
