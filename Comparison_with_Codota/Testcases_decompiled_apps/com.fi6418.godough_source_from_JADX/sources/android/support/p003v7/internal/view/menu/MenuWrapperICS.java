package android.support.p003v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.p000v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.internal.view.menu.MenuWrapperICS */
class MenuWrapperICS extends BaseMenuWrapper<SupportMenu> implements Menu {
    MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    public MenuItem add(int i) {
        return mo4051a(((SupportMenu) this.f2073b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo4051a(((SupportMenu) this.f2073b).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo4051a(((SupportMenu) this.f2073b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return mo4051a(((SupportMenu) this.f2073b).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((SupportMenu) this.f2073b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = mo4051a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return mo4052a(((SupportMenu) this.f2073b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo4052a(((SupportMenu) this.f2073b).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo4052a(((SupportMenu) this.f2073b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo4052a(((SupportMenu) this.f2073b).addSubMenu(charSequence));
    }

    public void clear() {
        mo4053a();
        ((SupportMenu) this.f2073b).clear();
    }

    public void close() {
        ((SupportMenu) this.f2073b).close();
    }

    public MenuItem findItem(int i) {
        return mo4051a(((SupportMenu) this.f2073b).findItem(i));
    }

    public MenuItem getItem(int i) {
        return mo4051a(((SupportMenu) this.f2073b).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((SupportMenu) this.f2073b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.f2073b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.f2073b).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.f2073b).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        mo4054a(i);
        ((SupportMenu) this.f2073b).removeGroup(i);
    }

    public void removeItem(int i) {
        mo4055b(i);
        ((SupportMenu) this.f2073b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.f2073b).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.f2073b).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.f2073b).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.f2073b).setQwertyMode(z);
    }

    public int size() {
        return ((SupportMenu) this.f2073b).size();
    }
}
