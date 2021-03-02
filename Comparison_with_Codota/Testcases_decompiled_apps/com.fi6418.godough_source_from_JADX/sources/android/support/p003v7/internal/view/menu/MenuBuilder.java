package android.support.p003v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.appcompat.C0235R;
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

/* renamed from: android.support.v7.internal.view.menu.MenuBuilder */
public class MenuBuilder implements SupportMenu {

    /* renamed from: d */
    private static final int[] f2103d = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    CharSequence f2104a;

    /* renamed from: b */
    Drawable f2105b;

    /* renamed from: c */
    View f2106c;

    /* renamed from: e */
    private final Context f2107e;

    /* renamed from: f */
    private final Resources f2108f;

    /* renamed from: g */
    private boolean f2109g;

    /* renamed from: h */
    private boolean f2110h;

    /* renamed from: i */
    private Callback f2111i;

    /* renamed from: j */
    private ArrayList<MenuItemImpl> f2112j;

    /* renamed from: k */
    private ArrayList<MenuItemImpl> f2113k;

    /* renamed from: l */
    private boolean f2114l;

    /* renamed from: m */
    private ArrayList<MenuItemImpl> f2115m;

    /* renamed from: n */
    private ArrayList<MenuItemImpl> f2116n;

    /* renamed from: o */
    private boolean f2117o;

    /* renamed from: p */
    private int f2118p = 0;

    /* renamed from: q */
    private ContextMenu.ContextMenuInfo f2119q;

    /* renamed from: r */
    private boolean f2120r = false;

    /* renamed from: s */
    private boolean f2121s = false;

    /* renamed from: t */
    private boolean f2122t = false;

    /* renamed from: u */
    private boolean f2123u = false;

    /* renamed from: v */
    private ArrayList<MenuItemImpl> f2124v = new ArrayList<>();

    /* renamed from: w */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f2125w = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    private MenuItemImpl f2126x;

    /* renamed from: y */
    private boolean f2127y;

    /* renamed from: android.support.v7.internal.view.menu.MenuBuilder$Callback */
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    /* renamed from: android.support.v7.internal.view.menu.MenuBuilder$ItemInvoker */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f2107e = context;
        this.f2108f = context.getResources();
        this.f2112j = new ArrayList<>();
        this.f2113k = new ArrayList<>();
        this.f2114l = true;
        this.f2115m = new ArrayList<>();
        this.f2116n = new ArrayList<>();
        this.f2117o = true;
        m1416b(true);
    }

    /* renamed from: a */
    private static int m1407a(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f2103d.length) {
            return (f2103d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: a */
    private static int m1408a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private MenuItemImpl m1409a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: a */
    private void m1410a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources a = mo4077a();
        if (view != null) {
            this.f2106c = view;
            this.f2104a = null;
            this.f2105b = null;
        } else {
            if (i > 0) {
                this.f2104a = a.getText(i);
            } else if (charSequence != null) {
                this.f2104a = charSequence;
            }
            if (i2 > 0) {
                this.f2105b = ContextCompat.getDrawable(getContext(), i2);
            } else if (drawable != null) {
                this.f2105b = drawable;
            }
            this.f2106c = null;
        }
        onItemsChanged(false);
    }

    /* renamed from: a */
    private void m1411a(int i, boolean z) {
        if (i >= 0 && i < this.f2112j.size()) {
            this.f2112j.remove(i);
            if (z) {
                onItemsChanged(true);
            }
        }
    }

    /* renamed from: a */
    private void m1412a(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.f2125w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
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

    /* renamed from: a */
    private void m1413a(boolean z) {
        if (!this.f2125w.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
                } else {
                    menuPresenter.updateMenuView(z);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    /* renamed from: a */
    private boolean m1414a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z = false;
        if (this.f2125w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.f2125w.remove(next);
            } else if (!z2) {
                z2 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
            z = z2;
        }
    }

    /* renamed from: b */
    private void m1415b(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f2125w.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m1416b(boolean z) {
        boolean z2 = true;
        if (!z || this.f2108f.getConfiguration().keyboard == 1 || !this.f2108f.getBoolean(C0235R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z2 = false;
        }
        this.f2110h = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Resources mo4077a() {
        return this.f2108f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo4078a(Drawable drawable) {
        m1410a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo4079a(View view) {
        m1410a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuBuilder mo4080a(CharSequence charSequence) {
        m1410a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemImpl mo4081a(int i, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.f2124v;
        arrayList.clear();
        mo4085a(arrayList, i, keyEvent);
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo4082a(int i, int i2, int i3, CharSequence charSequence) {
        int a = m1407a(i3);
        MenuItemImpl a2 = m1409a(i, i2, i3, a, charSequence, this.f2118p);
        if (this.f2119q != null) {
            a2.mo4161a(this.f2119q);
        }
        this.f2112j.add(m1408a(this.f2112j, a), a2);
        onItemsChanged(true);
        return a2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4083a(MenuItemImpl menuItemImpl) {
        this.f2114l = true;
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4084a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f2112j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.mo4162a(menuItemImpl == menuItem);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4085a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f2112j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f2112j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).mo4085a(list, i, keyEvent);
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
    public boolean mo4086a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2111i != null && this.f2111i.onMenuItemSelected(menuBuilder, menuItem);
    }

    public MenuItem add(int i) {
        return mo4082a(0, 0, 0, this.f2108f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo4082a(i, i2, i3, this.f2108f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo4082a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo4082a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f2107e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.f2107e);
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.f2125w.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.f2117o = true;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f2108f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f2108f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo4082a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f2107e, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4098b(MenuItemImpl menuItemImpl) {
        this.f2117o = true;
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4099b() {
        return this.f2122t;
    }

    public void changeMenuMode() {
        if (this.f2111i != null) {
            this.f2111i.onMenuModeChange(this);
        }
    }

    public void clear() {
        if (this.f2126x != null) {
            collapseItemActionView(this.f2126x);
        }
        this.f2112j.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.f2120r = true;
        clear();
        clearHeader();
        this.f2120r = false;
        this.f2121s = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.f2105b = null;
        this.f2104a = null;
        this.f2106c = null;
        onItemsChanged(false);
    }

    public void close() {
        close(true);
    }

    public final void close(boolean z) {
        if (!this.f2123u) {
            this.f2123u = true;
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.f2123u = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f2125w.isEmpty() && this.f2126x == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
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
                this.f2126x = null;
            }
        }
        return z;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f2125w.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
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
                this.f2126x = menuItemImpl;
            }
        }
        return z;
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
            if (this.f2112j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i2);
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
            if (this.f2112j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        boolean flagActionItems;
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.f2117o) {
            Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f2125w.remove(next);
                    flagActionItems = z;
                } else {
                    flagActionItems = menuPresenter.flagActionItems() | z;
                }
                z = flagActionItems;
            }
            if (z) {
                this.f2115m.clear();
                this.f2116n.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i);
                    if (menuItemImpl.isActionButton()) {
                        this.f2115m.add(menuItemImpl);
                    } else {
                        this.f2116n.add(menuItemImpl);
                    }
                }
            } else {
                this.f2115m.clear();
                this.f2116n.clear();
                this.f2116n.addAll(getVisibleItems());
            }
            this.f2117o = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.f2115m;
    }

    /* access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.f2107e;
    }

    public MenuItemImpl getExpandedItem() {
        return this.f2126x;
    }

    public Drawable getHeaderIcon() {
        return this.f2105b;
    }

    public CharSequence getHeaderTitle() {
        return this.f2104a;
    }

    public View getHeaderView() {
        return this.f2106c;
    }

    public MenuItem getItem(int i) {
        return this.f2112j.get(i);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.f2116n;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.f2114l) {
            return this.f2113k;
        }
        this.f2113k.clear();
        int size = this.f2112j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f2113k.add(menuItemImpl);
            }
        }
        this.f2114l = false;
        this.f2117o = true;
        return this.f2113k;
    }

    public boolean hasVisibleItems() {
        if (this.f2127y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f2112j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.f2109g;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo4081a(i, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.f2110h;
    }

    public void onItemsChanged(boolean z) {
        if (!this.f2120r) {
            if (z) {
                this.f2114l = true;
                this.f2117o = true;
            }
            m1413a(z);
            return;
        }
        this.f2121s = true;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, (MenuPresenter) null, i);
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
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
            boolean a = m1414a(subMenuBuilder, menuPresenter) | invoke;
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

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl a = mo4081a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = performItemAction(a, i2);
        }
        if ((i2 & 2) != 0) {
            close(true);
        }
        return z;
    }

    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.f2112j.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f2112j.get(findGroupIndex).getGroupId() != i) {
                    onItemsChanged(true);
                } else {
                    m1411a(findGroupIndex, false);
                    i2 = i3;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i) {
        m1411a(findItemIndex(i), true);
    }

    public void removeItemAt(int i) {
        m1411a(i, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.f2125w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f2125w.remove(next);
            }
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

    public void restorePresenterStates(Bundle bundle) {
        m1415b(bundle);
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

    public void savePresenterStates(Bundle bundle) {
        m1412a(bundle);
    }

    public void setCallback(Callback callback) {
        this.f2111i = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f2119q = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.f2118p = i;
        return this;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f2112j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f2112j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f2112j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemImpl menuItemImpl = this.f2112j.get(i2);
            i2++;
            z2 = (menuItemImpl.getGroupId() != i || !menuItemImpl.mo4165b(z)) ? z2 : true;
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public void setOverrideVisibleItems(boolean z) {
        this.f2127y = z;
    }

    public void setQwertyMode(boolean z) {
        this.f2109g = z;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z) {
        if (this.f2110h != z) {
            m1416b(z);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.f2112j.size();
    }

    public void startDispatchingItemsChanged() {
        this.f2120r = false;
        if (this.f2121s) {
            this.f2121s = false;
            onItemsChanged(true);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.f2120r) {
            this.f2120r = true;
            this.f2121s = false;
        }
    }
}
