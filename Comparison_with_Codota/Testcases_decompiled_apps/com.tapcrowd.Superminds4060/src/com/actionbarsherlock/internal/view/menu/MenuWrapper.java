package com.actionbarsherlock.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.SubMenu;
import java.util.WeakHashMap;

public class MenuWrapper implements Menu {
    private final WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem> mNativeMap = new WeakHashMap<>();
    private final android.view.Menu mNativeMenu;

    public MenuWrapper(android.view.Menu nativeMenu) {
        this.mNativeMenu = nativeMenu;
    }

    public android.view.Menu unwrap() {
        return this.mNativeMenu;
    }

    private com.actionbarsherlock.view.MenuItem addInternal(MenuItem nativeItem) {
        com.actionbarsherlock.view.MenuItem item = new MenuItemWrapper(nativeItem);
        this.mNativeMap.put(nativeItem, item);
        return item;
    }

    public com.actionbarsherlock.view.MenuItem add(CharSequence title) {
        return addInternal(this.mNativeMenu.add(title));
    }

    public com.actionbarsherlock.view.MenuItem add(int titleRes) {
        return addInternal(this.mNativeMenu.add(titleRes));
    }

    public com.actionbarsherlock.view.MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return addInternal(this.mNativeMenu.add(groupId, itemId, order, title));
    }

    public com.actionbarsherlock.view.MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return addInternal(this.mNativeMenu.add(groupId, itemId, order, titleRes));
    }

    private SubMenu addInternal(android.view.SubMenu nativeSubMenu) {
        SubMenu subMenu = new SubMenuWrapper(nativeSubMenu);
        this.mNativeMap.put(nativeSubMenu.getItem(), subMenu.getItem());
        return subMenu;
    }

    public SubMenu addSubMenu(CharSequence title) {
        return addInternal(this.mNativeMenu.addSubMenu(title));
    }

    public SubMenu addSubMenu(int titleRes) {
        return addInternal(this.mNativeMenu.addSubMenu(titleRes));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return addInternal(this.mNativeMenu.addSubMenu(groupId, itemId, order, title));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return addInternal(this.mNativeMenu.addSubMenu(groupId, itemId, order, titleRes));
    }

    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, com.actionbarsherlock.view.MenuItem[] outSpecificItems) {
        MenuItem[] nativeOutItems = new MenuItem[outSpecificItems.length];
        int result = this.mNativeMenu.addIntentOptions(groupId, itemId, order, caller, specifics, intent, flags, nativeOutItems);
        int length = outSpecificItems.length;
        for (int i = 0; i < length; i++) {
            outSpecificItems[i] = new MenuItemWrapper(nativeOutItems[i]);
        }
        return result;
    }

    public void removeItem(int id) {
        this.mNativeMenu.removeItem(id);
    }

    public void removeGroup(int groupId) {
        this.mNativeMenu.removeGroup(groupId);
    }

    public void clear() {
        this.mNativeMap.clear();
        this.mNativeMenu.clear();
    }

    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        this.mNativeMenu.setGroupCheckable(group, checkable, exclusive);
    }

    public void setGroupVisible(int group, boolean visible) {
        this.mNativeMenu.setGroupVisible(group, visible);
    }

    public void setGroupEnabled(int group, boolean enabled) {
        this.mNativeMenu.setGroupEnabled(group, enabled);
    }

    public boolean hasVisibleItems() {
        return this.mNativeMenu.hasVisibleItems();
    }

    public com.actionbarsherlock.view.MenuItem findItem(int id) {
        return findItem(this.mNativeMenu.findItem(id));
    }

    public com.actionbarsherlock.view.MenuItem findItem(MenuItem nativeItem) {
        if (nativeItem == null) {
            return null;
        }
        com.actionbarsherlock.view.MenuItem wrapped = this.mNativeMap.get(nativeItem);
        return wrapped == null ? addInternal(nativeItem) : wrapped;
    }

    public int size() {
        return this.mNativeMenu.size();
    }

    public com.actionbarsherlock.view.MenuItem getItem(int index) {
        return findItem(this.mNativeMenu.getItem(index));
    }

    public void close() {
        this.mNativeMenu.close();
    }

    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return this.mNativeMenu.performShortcut(keyCode, event, flags);
    }

    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return this.mNativeMenu.isShortcutKey(keyCode, event);
    }

    public boolean performIdentifierAction(int id, int flags) {
        return this.mNativeMenu.performIdentifierAction(id, flags);
    }

    public void setQwertyMode(boolean isQwerty) {
        this.mNativeMenu.setQwertyMode(isQwerty);
    }
}
