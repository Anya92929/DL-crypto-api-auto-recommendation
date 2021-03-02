package android.support.p004v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.widget.ListPopupWindow;
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

/* renamed from: android.support.v7.view.menu.MenuPopupHelper */
public class MenuPopupHelper implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    static final int f1810a = C0505R.layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    boolean f1811b;

    /* renamed from: c */
    private final Context f1812c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LayoutInflater f1813d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MenuBuilder f1814e;

    /* renamed from: f */
    private final C0518a f1815f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final boolean f1816g;

    /* renamed from: h */
    private final int f1817h;

    /* renamed from: i */
    private final int f1818i;

    /* renamed from: j */
    private final int f1819j;

    /* renamed from: k */
    private View f1820k;

    /* renamed from: l */
    private ListPopupWindow f1821l;

    /* renamed from: m */
    private ViewTreeObserver f1822m;

    /* renamed from: n */
    private MenuPresenter.Callback f1823n;

    /* renamed from: o */
    private ViewGroup f1824o;

    /* renamed from: p */
    private boolean f1825p;

    /* renamed from: q */
    private int f1826q;

    /* renamed from: r */
    private int f1827r;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, C0505R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, C0505R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f1827r = 0;
        this.f1812c = context;
        this.f1813d = LayoutInflater.from(context);
        this.f1814e = menuBuilder;
        this.f1815f = new C0518a(this.f1814e);
        this.f1816g = z;
        this.f1818i = i;
        this.f1819j = i2;
        Resources resources = context.getResources();
        this.f1817h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0505R.dimen.abc_config_prefDialogWidth));
        this.f1820k = view;
        menuBuilder.addMenuPresenter(this, context);
    }

    public void setAnchorView(View view) {
        this.f1820k = view;
    }

    public void setForceShowIcon(boolean z) {
        this.f1811b = z;
    }

    public void setGravity(int i) {
        this.f1827r = i;
    }

    public int getGravity() {
        return this.f1827r;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ListPopupWindow getPopup() {
        return this.f1821l;
    }

    public boolean tryShow() {
        boolean z = false;
        this.f1821l = new ListPopupWindow(this.f1812c, (AttributeSet) null, this.f1818i, this.f1819j);
        this.f1821l.setOnDismissListener(this);
        this.f1821l.setOnItemClickListener(this);
        this.f1821l.setAdapter(this.f1815f);
        this.f1821l.setModal(true);
        View view = this.f1820k;
        if (view == null) {
            return false;
        }
        if (this.f1822m == null) {
            z = true;
        }
        this.f1822m = view.getViewTreeObserver();
        if (z) {
            this.f1822m.addOnGlobalLayoutListener(this);
        }
        this.f1821l.setAnchorView(view);
        this.f1821l.setDropDownGravity(this.f1827r);
        if (!this.f1825p) {
            this.f1826q = m3058a();
            this.f1825p = true;
        }
        this.f1821l.setContentWidth(this.f1826q);
        this.f1821l.setInputMethodMode(2);
        this.f1821l.show();
        this.f1821l.getListView().setOnKeyListener(this);
        return true;
    }

    public void dismiss() {
        if (isShowing()) {
            this.f1821l.dismiss();
        }
    }

    public void onDismiss() {
        this.f1821l = null;
        this.f1814e.close();
        if (this.f1822m != null) {
            if (!this.f1822m.isAlive()) {
                this.f1822m = this.f1820k.getViewTreeObserver();
            }
            this.f1822m.removeGlobalOnLayoutListener(this);
            this.f1822m = null;
        }
    }

    public boolean isShowing() {
        return this.f1821l != null && this.f1821l.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0518a aVar = this.f1815f;
        aVar.f1829b.performItemAction(aVar.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* renamed from: a */
    private int m3058a() {
        View view;
        C0518a aVar = this.f1815f;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = aVar.getCount();
        int i = 0;
        int i2 = 0;
        View view2 = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = aVar.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view = null;
            } else {
                view = view2;
            }
            if (this.f1824o == null) {
                this.f1824o = new FrameLayout(this.f1812c);
            }
            view2 = aVar.getView(i, view, this.f1824o);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= this.f1817h) {
                return this.f1817h;
            }
            if (measuredWidth <= i3) {
                measuredWidth = i3;
            }
            i++;
            i3 = measuredWidth;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.f1820k;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.f1821l.show();
            }
        }
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void updateMenuView(boolean z) {
        this.f1825p = false;
        if (this.f1815f != null) {
            this.f1815f.notifyDataSetChanged();
        }
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f1823n = callback;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f1812c, subMenuBuilder, this.f1820k);
            menuPopupHelper.setCallback(this.f1823n);
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
                if (this.f1823n == null) {
                    return true;
                }
                this.f1823n.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f1814e) {
            dismiss();
            if (this.f1823n != null) {
                this.f1823n.onCloseMenu(menuBuilder, z);
            }
        }
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
        return 0;
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    /* renamed from: android.support.v7.view.menu.MenuPopupHelper$a */
    class C0518a extends BaseAdapter {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public MenuBuilder f1829b;

        /* renamed from: c */
        private int f1830c = -1;

        public C0518a(MenuBuilder menuBuilder) {
            this.f1829b = menuBuilder;
            mo3852a();
        }

        public int getCount() {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f1816g ? this.f1829b.getNonActionItems() : this.f1829b.getVisibleItems();
            if (this.f1830c < 0) {
                return nonActionItems.size();
            }
            return nonActionItems.size() - 1;
        }

        /* renamed from: a */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f1816g ? this.f1829b.getNonActionItems() : this.f1829b.getVisibleItems();
            if (this.f1830c >= 0 && i >= this.f1830c) {
                i++;
            }
            return nonActionItems.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = MenuPopupHelper.this.f1813d.inflate(MenuPopupHelper.f1810a, viewGroup, false);
            } else {
                view2 = view;
            }
            MenuView.ItemView itemView = (MenuView.ItemView) view2;
            if (MenuPopupHelper.this.f1811b) {
                ((ListMenuItemView) view2).setForceShowIcon(true);
            }
            itemView.initialize(getItem(i), 0);
            return view2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3852a() {
            MenuItemImpl expandedItem = MenuPopupHelper.this.f1814e.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.this.f1814e.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f1830c = i;
                        return;
                    }
                }
            }
            this.f1830c = -1;
        }

        public void notifyDataSetChanged() {
            mo3852a();
            super.notifyDataSetChanged();
        }
    }
}
