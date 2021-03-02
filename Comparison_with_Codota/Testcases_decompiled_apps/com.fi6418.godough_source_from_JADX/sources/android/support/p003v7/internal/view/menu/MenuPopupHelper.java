package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.MenuPopupHelper */
public class MenuPopupHelper implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    static final int f2167a = C0235R.layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    boolean f2168b;

    /* renamed from: c */
    private final Context f2169c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LayoutInflater f2170d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MenuBuilder f2171e;

    /* renamed from: f */
    private final MenuAdapter f2172f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final boolean f2173g;

    /* renamed from: h */
    private final int f2174h;

    /* renamed from: i */
    private final int f2175i;

    /* renamed from: j */
    private final int f2176j;

    /* renamed from: k */
    private View f2177k;

    /* renamed from: l */
    private ListPopupWindow f2178l;

    /* renamed from: m */
    private ViewTreeObserver f2179m;

    /* renamed from: n */
    private MenuPresenter.Callback f2180n;

    /* renamed from: o */
    private ViewGroup f2181o;

    /* renamed from: p */
    private boolean f2182p;

    /* renamed from: q */
    private int f2183q;

    /* renamed from: r */
    private int f2184r;

    /* renamed from: android.support.v7.internal.view.menu.MenuPopupHelper$MenuAdapter */
    class MenuAdapter extends BaseAdapter {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public MenuBuilder f2186b;

        /* renamed from: c */
        private int f2187c = -1;

        public MenuAdapter(MenuBuilder menuBuilder) {
            this.f2186b = menuBuilder;
            mo4276a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4276a() {
            MenuItemImpl expandedItem = MenuPopupHelper.this.f2171e.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f2171e.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f2187c = i;
                        return;
                    }
                }
            }
            this.f2187c = -1;
        }

        public int getCount() {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f2173g ? this.f2186b.getNonActionItems() : this.f2186b.getVisibleItems();
            return this.f2187c < 0 ? nonActionItems.size() : nonActionItems.size() - 1;
        }

        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f2173g ? this.f2186b.getNonActionItems() : this.f2186b.getVisibleItems();
            if (this.f2187c >= 0 && i >= this.f2187c) {
                i++;
            }
            return nonActionItems.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? MenuPopupHelper.this.f2170d.inflate(MenuPopupHelper.f2167a, viewGroup, false) : view;
            MenuView.ItemView itemView = (MenuView.ItemView) inflate;
            if (MenuPopupHelper.this.f2168b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            itemView.initialize(getItem(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            mo4276a();
            super.notifyDataSetChanged();
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, C0235R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, C0235R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f2184r = 0;
        this.f2169c = context;
        this.f2170d = LayoutInflater.from(context);
        this.f2171e = menuBuilder;
        this.f2172f = new MenuAdapter(this.f2171e);
        this.f2173g = z;
        this.f2175i = i;
        this.f2176j = i2;
        Resources resources = context.getResources();
        this.f2174h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0235R.dimen.abc_config_prefDialogWidth));
        this.f2177k = view;
        menuBuilder.addMenuPresenter(this, context);
    }

    /* renamed from: a */
    private int m1440a() {
        View view;
        MenuAdapter menuAdapter = this.f2172f;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = menuAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view2 = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = menuAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view = null;
            } else {
                view = view2;
            }
            if (this.f2181o == null) {
                this.f2181o = new FrameLayout(this.f2169c);
            }
            view2 = menuAdapter.getView(i, view, this.f2181o);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= this.f2174h) {
                return this.f2174h;
            }
            if (measuredWidth <= i3) {
                measuredWidth = i3;
            }
            i++;
            i3 = measuredWidth;
        }
        return i3;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dismiss() {
        if (isShowing()) {
            this.f2178l.dismiss();
        }
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getGravity() {
        return this.f2184r;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public ListPopupWindow getPopup() {
        return this.f2178l;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public boolean isShowing() {
        return this.f2178l != null && this.f2178l.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f2171e) {
            dismiss();
            if (this.f2180n != null) {
                this.f2180n.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.f2178l = null;
        this.f2171e.close();
        if (this.f2179m != null) {
            if (!this.f2179m.isAlive()) {
                this.f2179m = this.f2177k.getViewTreeObserver();
            }
            this.f2179m.removeGlobalOnLayoutListener(this);
            this.f2179m = null;
        }
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.f2177k;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.f2178l.show();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuAdapter menuAdapter = this.f2172f;
        menuAdapter.f2186b.performItemAction(menuAdapter.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f2169c, subMenuBuilder, this.f2177k);
            menuPopupHelper.setCallback(this.f2180n);
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            menuPopupHelper.setForceShowIcon(z);
            if (menuPopupHelper.tryShow()) {
                if (this.f2180n == null) {
                    return true;
                }
                this.f2180n.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void setAnchorView(View view) {
        this.f2177k = view;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f2180n = callback;
    }

    public void setForceShowIcon(boolean z) {
        this.f2168b = z;
    }

    public void setGravity(int i) {
        this.f2184r = i;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        boolean z = false;
        this.f2178l = new ListPopupWindow(this.f2169c, (AttributeSet) null, this.f2175i, this.f2176j);
        this.f2178l.setOnDismissListener(this);
        this.f2178l.setOnItemClickListener(this);
        this.f2178l.setAdapter(this.f2172f);
        this.f2178l.setModal(true);
        View view = this.f2177k;
        if (view == null) {
            return false;
        }
        if (this.f2179m == null) {
            z = true;
        }
        this.f2179m = view.getViewTreeObserver();
        if (z) {
            this.f2179m.addOnGlobalLayoutListener(this);
        }
        this.f2178l.setAnchorView(view);
        this.f2178l.setDropDownGravity(this.f2184r);
        if (!this.f2182p) {
            this.f2183q = m1440a();
            this.f2182p = true;
        }
        this.f2178l.setContentWidth(this.f2183q);
        this.f2178l.setInputMethodMode(2);
        this.f2178l.show();
        this.f2178l.getListView().setOnKeyListener(this);
        return true;
    }

    public void updateMenuView(boolean z) {
        this.f2182p = false;
        if (this.f2172f != null) {
            this.f2172f.notifyDataSetChanged();
        }
    }
}
