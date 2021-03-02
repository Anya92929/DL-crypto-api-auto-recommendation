package android.support.p021v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.p009v4.p014c.p015a.C0123a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.aj */
class C0543aj extends C0552e implements Menu {
    C0543aj(Context context, C0123a aVar) {
        super(context, aVar);
    }

    public MenuItem add(int i) {
        return mo2409a(((C0123a) this.f1053b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo2409a(((C0123a) this.f1053b).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo2409a(((C0123a) this.f1053b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return mo2409a(((C0123a) this.f1053b).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0123a) this.f1053b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = mo2409a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return mo2410a(((C0123a) this.f1053b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo2410a(((C0123a) this.f1053b).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo2410a(((C0123a) this.f1053b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo2410a(((C0123a) this.f1053b).addSubMenu(charSequence));
    }

    public void clear() {
        mo2411a();
        ((C0123a) this.f1053b).clear();
    }

    public void close() {
        ((C0123a) this.f1053b).close();
    }

    public MenuItem findItem(int i) {
        return mo2409a(((C0123a) this.f1053b).findItem(i));
    }

    public MenuItem getItem(int i) {
        return mo2409a(((C0123a) this.f1053b).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((C0123a) this.f1053b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0123a) this.f1053b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0123a) this.f1053b).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0123a) this.f1053b).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        mo2412a(i);
        ((C0123a) this.f1053b).removeGroup(i);
    }

    public void removeItem(int i) {
        mo2413b(i);
        ((C0123a) this.f1053b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0123a) this.f1053b).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0123a) this.f1053b).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0123a) this.f1053b).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((C0123a) this.f1053b).setQwertyMode(z);
    }

    public int size() {
        return ((C0123a) this.f1053b).size();
    }
}
