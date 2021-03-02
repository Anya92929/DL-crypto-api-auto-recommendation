package android.support.p004v7.view.menu;

import android.content.Context;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.BaseMenuPresenter */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a */
    private MenuPresenter.Callback f1719a;

    /* renamed from: b */
    private int f1720b;

    /* renamed from: c */
    private int f1721c;

    /* renamed from: d */
    private int f1722d;
    public Context mContext;
    protected LayoutInflater mInflater;
    public MenuBuilder mMenu;
    public MenuView mMenuView;
    public Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public abstract void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.f1720b = i;
        this.f1721c = i2;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMenu = menuBuilder;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (MenuView) this.mSystemInflater.inflate(this.f1720b, viewGroup, false);
            this.mMenuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            if (this.mMenu != null) {
                this.mMenu.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
                int size = visibleItems.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i3);
                    if (shouldIncludeItem(i, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                        View itemView = getItemView(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            itemView.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(itemView);
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i3++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f1719a = callback;
    }

    public MenuPresenter.Callback getCallback() {
        return this.f1719a;
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.f1721c, viewGroup, false);
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView createItemView;
        if (view instanceof MenuView.ItemView) {
            createItemView = (MenuView.ItemView) view;
        } else {
            createItemView = createItemView(viewGroup);
        }
        bindItemView(menuItemImpl, createItemView);
        return (View) createItemView;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f1719a != null) {
            this.f1719a.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (this.f1719a != null) {
            return this.f1719a.onOpenSubMenu(subMenuBuilder);
        }
        return false;
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

    public int getId() {
        return this.f1722d;
    }

    public void setId(int i) {
        this.f1722d = i;
    }
}
