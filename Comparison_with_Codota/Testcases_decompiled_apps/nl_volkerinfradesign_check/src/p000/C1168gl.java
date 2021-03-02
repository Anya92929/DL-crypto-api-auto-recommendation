package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.p001v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: gl */
public class C1168gl extends C1163gh<SupportMenu> implements Menu {
    public C1168gl(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo8130a(((SupportMenu) this.f4162b).add(charSequence));
    }

    public MenuItem add(int i) {
        return mo8130a(((SupportMenu) this.f4162b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo8130a(((SupportMenu) this.f4162b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo8130a(((SupportMenu) this.f4162b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo8131a(((SupportMenu) this.f4162b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return mo8131a(((SupportMenu) this.f4162b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo8131a(((SupportMenu) this.f4162b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo8131a(((SupportMenu) this.f4162b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((SupportMenu) this.f4162b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = mo8130a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        mo8134b(i);
        ((SupportMenu) this.f4162b).removeItem(i);
    }

    public void removeGroup(int i) {
        mo8133a(i);
        ((SupportMenu) this.f4162b).removeGroup(i);
    }

    public void clear() {
        mo8132a();
        ((SupportMenu) this.f4162b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.f4162b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.f4162b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.f4162b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((SupportMenu) this.f4162b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return mo8130a(((SupportMenu) this.f4162b).findItem(i));
    }

    public int size() {
        return ((SupportMenu) this.f4162b).size();
    }

    public MenuItem getItem(int i) {
        return mo8130a(((SupportMenu) this.f4162b).getItem(i));
    }

    public void close() {
        ((SupportMenu) this.f4162b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.f4162b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.f4162b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.f4162b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.f4162b).setQwertyMode(z);
    }
}
