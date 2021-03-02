package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.ListMenuPresenter */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a */
    Context f2091a;

    /* renamed from: b */
    LayoutInflater f2092b;

    /* renamed from: c */
    MenuBuilder f2093c;

    /* renamed from: d */
    ExpandedMenuView f2094d;

    /* renamed from: e */
    int f2095e;

    /* renamed from: f */
    int f2096f;

    /* renamed from: g */
    MenuAdapter f2097g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f2098h;

    /* renamed from: i */
    private MenuPresenter.Callback f2099i;

    /* renamed from: j */
    private int f2100j;

    /* renamed from: android.support.v7.internal.view.menu.ListMenuPresenter$MenuAdapter */
    class MenuAdapter extends BaseAdapter {

        /* renamed from: b */
        private int f2102b = -1;

        public MenuAdapter() {
            mo4071a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4071a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f2093c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f2093c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f2102b = i;
                        return;
                    }
                }
            }
            this.f2102b = -1;
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f2093c.getNonActionItems().size() - ListMenuPresenter.this.f2098h;
            return this.f2102b < 0 ? size : size - 1;
        }

        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f2093c.getNonActionItems();
            int a = ListMenuPresenter.this.f2098h + i;
            if (this.f2102b >= 0 && a >= this.f2102b) {
                a++;
            }
            return nonActionItems.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? ListMenuPresenter.this.f2092b.inflate(ListMenuPresenter.this.f2096f, viewGroup, false) : view;
            ((MenuView.ItemView) inflate).initialize(getItem(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            mo4071a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i, int i2) {
        this.f2096f = i;
        this.f2095e = i2;
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f2091a = context;
        this.f2092b = LayoutInflater.from(this.f2091a);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f2097g == null) {
            this.f2097g = new MenuAdapter();
        }
        return this.f2097g;
    }

    public int getId() {
        return this.f2100j;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f2094d == null) {
            this.f2094d = (ExpandedMenuView) this.f2092b.inflate(C0235R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f2097g == null) {
                this.f2097g = new MenuAdapter();
            }
            this.f2094d.setAdapter(this.f2097g);
            this.f2094d.setOnItemClickListener(this);
        }
        return this.f2094d;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f2095e != 0) {
            this.f2091a = new ContextThemeWrapper(context, this.f2095e);
            this.f2092b = LayoutInflater.from(this.f2091a);
        } else if (this.f2091a != null) {
            this.f2091a = context;
            if (this.f2092b == null) {
                this.f2092b = LayoutInflater.from(this.f2091a);
            }
        }
        this.f2093c = menuBuilder;
        if (this.f2097g != null) {
            this.f2097g.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f2099i != null) {
            this.f2099i.onCloseMenu(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2093c.performItemAction(this.f2097g.getItem(i), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f2094d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).show((IBinder) null);
        if (this.f2099i != null) {
            this.f2099i.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f2094d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f2094d != null) {
            this.f2094d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f2099i = callback;
    }

    public void setId(int i) {
        this.f2100j = i;
    }

    public void setItemIndexOffset(int i) {
        this.f2098h = i;
        if (this.f2094d != null) {
            updateMenuView(false);
        }
    }

    public void updateMenuView(boolean z) {
        if (this.f2097g != null) {
            this.f2097g.notifyDataSetChanged();
        }
    }
}
