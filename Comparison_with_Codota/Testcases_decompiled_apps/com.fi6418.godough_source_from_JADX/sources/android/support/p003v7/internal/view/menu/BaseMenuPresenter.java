package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.BaseMenuPresenter */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a */
    protected Context f2060a;

    /* renamed from: b */
    protected Context f2061b;

    /* renamed from: c */
    protected MenuBuilder f2062c;

    /* renamed from: d */
    protected LayoutInflater f2063d;

    /* renamed from: e */
    protected LayoutInflater f2064e;

    /* renamed from: f */
    protected MenuView f2065f;

    /* renamed from: g */
    private MenuPresenter.Callback f2066g;

    /* renamed from: h */
    private int f2067h;

    /* renamed from: i */
    private int f2068i;

    /* renamed from: j */
    private int f2069j;

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f2060a = context;
        this.f2063d = LayoutInflater.from(context);
        this.f2067h = i;
        this.f2068i = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4033a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f2065f).addView(view, i);
    }

    public abstract void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f2063d.inflate(this.f2068i, viewGroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.f2066g;
    }

    public int getId() {
        return this.f2069j;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView createItemView = view instanceof MenuView.ItemView ? (MenuView.ItemView) view : createItemView(viewGroup);
        bindItemView(menuItemImpl, createItemView);
        return (View) createItemView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f2065f == null) {
            this.f2065f = (MenuView) this.f2063d.inflate(this.f2067h, viewGroup, false);
            this.f2065f.initialize(this.f2062c);
            updateMenuView(true);
        }
        return this.f2065f;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f2061b = context;
        this.f2064e = LayoutInflater.from(this.f2061b);
        this.f2062c = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f2066g != null) {
            this.f2066g.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (this.f2066g != null) {
            return this.f2066g.onOpenSubMenu(subMenuBuilder);
        }
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f2066g = callback;
    }

    public void setId(int i) {
        this.f2069j = i;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f2065f;
        if (viewGroup != null) {
            if (this.f2062c != null) {
                this.f2062c.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.f2062c.getVisibleItems();
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
                            mo4033a(itemView, i);
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
}
