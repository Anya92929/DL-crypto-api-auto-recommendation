package android.support.p004v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.ListMenuPresenter */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a */
    Context f1740a;

    /* renamed from: b */
    LayoutInflater f1741b;

    /* renamed from: c */
    MenuBuilder f1742c;

    /* renamed from: d */
    ExpandedMenuView f1743d;

    /* renamed from: e */
    int f1744e;

    /* renamed from: f */
    int f1745f;

    /* renamed from: g */
    C0512a f1746g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f1747h;

    /* renamed from: i */
    private MenuPresenter.Callback f1748i;

    /* renamed from: j */
    private int f1749j;

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f1740a = context;
        this.f1741b = LayoutInflater.from(this.f1740a);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f1745f = i;
        this.f1744e = i2;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f1744e != 0) {
            this.f1740a = new ContextThemeWrapper(context, this.f1744e);
            this.f1741b = LayoutInflater.from(this.f1740a);
        } else if (this.f1740a != null) {
            this.f1740a = context;
            if (this.f1741b == null) {
                this.f1741b = LayoutInflater.from(this.f1740a);
            }
        }
        this.f1742c = menuBuilder;
        if (this.f1746g != null) {
            this.f1746g.notifyDataSetChanged();
        }
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f1743d == null) {
            this.f1743d = (ExpandedMenuView) this.f1741b.inflate(C0505R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1746g == null) {
                this.f1746g = new C0512a();
            }
            this.f1743d.setAdapter(this.f1746g);
            this.f1743d.setOnItemClickListener(this);
        }
        return this.f1743d;
    }

    public ListAdapter getAdapter() {
        if (this.f1746g == null) {
            this.f1746g = new C0512a();
        }
        return this.f1746g;
    }

    public void updateMenuView(boolean z) {
        if (this.f1746g != null) {
            this.f1746g.notifyDataSetChanged();
        }
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f1748i = callback;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new C1165gj(subMenuBuilder).mo8137a((IBinder) null);
        if (this.f1748i != null) {
            this.f1748i.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f1748i != null) {
            this.f1748i.onCloseMenu(menuBuilder, z);
        }
    }

    public void setItemIndexOffset(int i) {
        this.f1747h = i;
        if (this.f1743d != null) {
            updateMenuView(false);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1742c.performItemAction(this.f1746g.getItem(i), this, 0);
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f1743d != null) {
            this.f1743d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f1743d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void setId(int i) {
        this.f1749j = i;
    }

    public int getId() {
        return this.f1749j;
    }

    public Parcelable onSaveInstanceState() {
        if (this.f1743d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    /* renamed from: android.support.v7.view.menu.ListMenuPresenter$a */
    class C0512a extends BaseAdapter {

        /* renamed from: b */
        private int f1751b = -1;

        public C0512a() {
            mo3653a();
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f1742c.getNonActionItems().size() - ListMenuPresenter.this.f1747h;
            return this.f1751b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f1742c.getNonActionItems();
            int a = ListMenuPresenter.this.f1747h + i;
            if (this.f1751b >= 0 && a >= this.f1751b) {
                a++;
            }
            return nonActionItems.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = ListMenuPresenter.this.f1741b.inflate(ListMenuPresenter.this.f1745f, viewGroup, false);
            } else {
                view2 = view;
            }
            ((MenuView.ItemView) view2).initialize(getItem(i), 0);
            return view2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3653a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f1742c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f1742c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f1751b = i;
                        return;
                    }
                }
            }
            this.f1751b = -1;
        }

        public void notifyDataSetChanged() {
            mo3653a();
            super.notifyDataSetChanged();
        }
    }
}
