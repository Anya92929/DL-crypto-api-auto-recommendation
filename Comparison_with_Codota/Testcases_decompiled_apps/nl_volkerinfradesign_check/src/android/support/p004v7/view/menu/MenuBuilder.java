package android.support.p004v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.view.ActionProvider;
import android.support.p001v4.view.MenuItemCompat;
import android.support.p004v7.appcompat.C0505R;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.MenuBuilder */
public class MenuBuilder implements SupportMenu {

    /* renamed from: d */
    private static final int[] f1752d = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    CharSequence f1753a;

    /* renamed from: b */
    Drawable f1754b;

    /* renamed from: c */
    View f1755c;

    /* renamed from: e */
    private final Context f1756e;

    /* renamed from: f */
    private final Resources f1757f;

    /* renamed from: g */
    private boolean f1758g;

    /* renamed from: h */
    private boolean f1759h;

    /* renamed from: i */
    private Callback f1760i;

    /* renamed from: j */
    private ArrayList<MenuItemImpl> f1761j;

    /* renamed from: k */
    private ArrayList<MenuItemImpl> f1762k;

    /* renamed from: l */
    private boolean f1763l;

    /* renamed from: m */
    private ArrayList<MenuItemImpl> f1764m;

    /* renamed from: n */
    private ArrayList<MenuItemImpl> f1765n;

    /* renamed from: o */
    private boolean f1766o;

    /* renamed from: p */
    private int f1767p = 0;

    /* renamed from: q */
    private ContextMenu.ContextMenuInfo f1768q;

    /* renamed from: r */
    private boolean f1769r = false;

    /* renamed from: s */
    private boolean f1770s = false;

    /* renamed from: t */
    private boolean f1771t = false;

    /* renamed from: u */
    private boolean f1772u = false;

    /* renamed from: v */
    private ArrayList<MenuItemImpl> f1773v = new ArrayList<>();

    /* renamed from: w */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f1774w = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    private MenuItemImpl f1775x;

    /* renamed from: y */
    private boolean f1776y;

    /* renamed from: android.support.v7.view.menu.MenuBuilder$Callback */
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    /* renamed from: android.support.v7.view.menu.MenuBuilder$ItemInvoker */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f1756e = context;
        this.f1757f = context.getResources();
        this.f1761j = new ArrayList<>();
        this.f1762k = new ArrayList<>();
        this.f1763l = true;
        this.f1764m = new ArrayList<>();
        this.f1765n = new ArrayList<>();
        this.f1766o = true;
        m3039b(true);
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.f1767p = i;
        return this;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.f1756e);
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.f1774w.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.f1766o = true;
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f1774w.remove(next);
            }
        }
    }

    /* renamed from: a */
    private void m3036a(boolean z) {
        if (!this.f1774w.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                } else {
                    menuPresenter.updateMenuView(z);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    /* renamed from: a */
    private boolean m3037a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z = false;
        if (this.f1774w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.f1774w.remove(next);
            } else if (!z2) {
                z2 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
            z = z2;
        }
    }

    /* renamed from: a */
    private void m3035a(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.f1774w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    /* renamed from: b */
    private void m3038b(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f1774w.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void savePresenterStates(Bundle bundle) {
        m3035a(bundle);
    }

    public void restorePresenterStates(Bundle bundle) {
        m3038b(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = MenuItemCompat.getActionView(item);
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                MenuItemCompat.expandActionView(findItem);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public void setCallback(Callback callback) {
        this.f1760i = callback;
    }

    /* access modifiers changed from: protected */
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int a = m3030a(i3);
        MenuItemImpl a2 = m3032a(i, i2, i3, a, charSequence, this.f1767p);
        if (this.f1768q != null) {
            a2.mo3739a(this.f1768q);
        }
        this.f1761j.add(m3031a(this.f1761j, a), a2);
        onItemsChanged(true);
        return a2;
    }

    /* renamed from: a */
    private MenuItemImpl m3032a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.f1757f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.f1757f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f1757f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f1756e, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f1757f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        Intent intent2;
        PackageManager packageManager = this.f1756e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m3034a(findItemIndex(i), true);
    }

    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.f1761j.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f1761j.get(findGroupIndex).getGroupId() != i) {
                    onItemsChanged(true);
                } else {
                    m3034a(findGroupIndex, false);
                    i2 = i3;
                }
            }
            onItemsChanged(true);
        }
    }

    /* renamed from: a */
    private void m3034a(int i, boolean z) {
        if (i >= 0 && i < this.f1761j.size()) {
            this.f1761j.remove(i);
            if (z) {
                onItemsChanged(true);
            }
        }
    }

    public void removeItemAt(int i) {
        m3034a(i, true);
    }

    public void clearAll() {
        this.f1769r = true;
        clear();
        clearHeader();
        this.f1769r = false;
        this.f1770s = false;
        onItemsChanged(true);
    }

    public void clear() {
        if (this.f1775x != null) {
            collapseItemActionView(this.f1775x);
        }
        this.f1761j.clear();
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3662a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1761j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.mo3740a(menuItemImpl == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1761j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        boolean z2;
        int size = this.f1761j.size();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < size) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i2);
            if (menuItemImpl.getGroupId() != i || !menuItemImpl.mo3743b(z)) {
                z2 = z3;
            } else {
                z2 = true;
            }
            i2++;
            z3 = z2;
        }
        if (z3) {
            onItemsChanged(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1761j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1776y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1761j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1761j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f1761j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f1761j.size();
    }

    public MenuItem getItem(int i) {
        return this.f1761j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo3660a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f1758g = z;
        onItemsChanged(false);
    }

    /* renamed from: a */
    private static int m3030a(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1752d.length) {
            return (f1752d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.f1758g;
    }

    public void setShortcutsVisible(boolean z) {
        if (this.f1759h != z) {
            m3039b(z);
            onItemsChanged(false);
        }
    }

    /* renamed from: b */
    private void m3039b(boolean z) {
        boolean z2 = true;
        if (!z || this.f1757f.getConfiguration().keyboard == 1 || !this.f1757f.getBoolean(C0505R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z2 = false;
        }
        this.f1759h = z2;
    }

    public boolean isShortcutsVisible() {
        return this.f1759h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Resources mo3659a() {
        return this.f1757f;
    }

    public Context getContext() {
        return this.f1756e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3664a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1760i != null && this.f1760i.onMenuItemSelected(menuBuilder, menuItem);
    }

    public void changeMenuMode() {
        if (this.f1760i != null) {
            this.f1760i.onMenuModeChange(this);
        }
    }

    /* renamed from: a */
    private static int m3031a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl a = mo3660a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = performItemAction(a, i2);
        }
        if ((i2 & 2) != 0) {
            close(true);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3663a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1761j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f1761j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).mo3663a(list, i, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (isQwertyMode && alphabeticShortcut == 8 && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemImpl mo3660a(int i, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.f1773v;
        arrayList.clear();
        mo3663a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (isQwertyMode && alphabeticShortcut == 8 && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, (MenuPresenter) null, i);
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        boolean z;
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        if (supportActionProvider == null || !supportActionProvider.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        if (menuItemImpl.hasCollapsibleActionView()) {
            boolean expandActionView = menuItemImpl.expandActionView() | invoke;
            if (!expandActionView) {
                return expandActionView;
            }
            close(true);
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z) {
            close(false);
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            boolean a = m3037a(subMenuBuilder, menuPresenter) | invoke;
            if (a) {
                return a;
            }
            close(true);
            return a;
        } else {
            if ((i & 1) == 0) {
                close(true);
            }
            return invoke;
        }
    }

    public final void close(boolean z) {
        if (!this.f1772u) {
            this.f1772u = true;
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.f1772u = false;
        }
    }

    public void close() {
        close(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.f1769r) {
            if (z) {
                this.f1763l = true;
                this.f1766o = true;
            }
            m3036a(z);
            return;
        }
        this.f1770s = true;
    }

    public void stopDispatchingItemsChanged() {
        if (!this.f1769r) {
            this.f1769r = true;
            this.f1770s = false;
        }
    }

    public void startDispatchingItemsChanged() {
        this.f1769r = false;
        if (this.f1770s) {
            this.f1770s = false;
            onItemsChanged(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3661a(MenuItemImpl menuItemImpl) {
        this.f1763l = true;
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3677b(MenuItemImpl menuItemImpl) {
        this.f1766o = true;
        onItemsChanged(true);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.f1763l) {
            return this.f1762k;
        }
        this.f1762k.clear();
        int size = this.f1761j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f1761j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f1762k.add(menuItemImpl);
            }
        }
        this.f1763l = false;
        this.f1766o = true;
        return this.f1762k;
    }

    public void flagActionItems() {
        boolean flagActionItems;
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.f1766o) {
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                    flagActionItems = z;
                } else {
                    flagActionItems = menuPresenter.flagActionItems() | z;
                }
                z = flagActionItems;
            }
            if (z) {
                this.f1764m.clear();
                this.f1765n.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i);
                    if (menuItemImpl.isActionButton()) {
                        this.f1764m.add(menuItemImpl);
                    } else {
                        this.f1765n.add(menuItemImpl);
                    }
                }
            } else {
                this.f1764m.clear();
                this.f1765n.clear();
                this.f1765n.addAll(getVisibleItems());
            }
            this.f1766o = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.f1764m;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.f1765n;
    }

    public void clearHeader() {
        this.f1754b = null;
        this.f1753a = null;
        this.f1755c = null;
        onItemsChanged(false);
    }

    /* renamed from: a */
    private void m3033a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources a = mo3659a();
        if (view != null) {
            this.f1755c = view;
            this.f1753a = null;
            this.f1754b = null;
        } else {
            if (i > 0) {
                this.f1753a = a.getText(i);
            } else if (charSequence != null) {
                this.f1753a = charSequence;
            }
            if (i2 > 0) {
                this.f1754b = ContextCompat.getDrawable(getContext(), i2);
            } else if (drawable != null) {
                this.f1754b = drawable;
            }
            this.f1755c = null;
        }
        onItemsChanged(false);
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        m3033a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i) {
        m3033a(i, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        m3033a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i) {
        m3033a(0, (CharSequence) null, i, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        m3033a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public CharSequence getHeaderTitle() {
        return this.f1753a;
    }

    public Drawable getHeaderIcon() {
        return this.f1754b;
    }

    public View getHeaderView() {
        return this.f1755c;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1768q = contextMenuInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3678b() {
        return this.f1771t;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f1774w.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                    z = z2;
                } else {
                    z = menuPresenter.expandItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.f1775x = menuItemImpl;
            }
        }
        return z;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f1774w.isEmpty() && this.f1775x == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f1774w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f1774w.remove(next);
                    z = z2;
                } else {
                    z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.f1775x = null;
            }
        }
        return z;
    }

    public MenuItemImpl getExpandedItem() {
        return this.f1775x;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.f1776y = z;
    }
}
