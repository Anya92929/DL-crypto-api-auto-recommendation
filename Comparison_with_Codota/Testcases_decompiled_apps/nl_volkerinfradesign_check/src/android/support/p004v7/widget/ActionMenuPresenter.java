package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.view.ActionProvider;
import android.support.p001v4.view.GravityCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.transition.ActionBarTransition;
import android.support.p004v7.view.ActionBarPolicy;
import android.support.p004v7.view.menu.ActionMenuItemView;
import android.support.p004v7.view.menu.BaseMenuPresenter;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuItemImpl;
import android.support.p004v7.view.menu.MenuPopupHelper;
import android.support.p004v7.view.menu.MenuPresenter;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.view.menu.SubMenuBuilder;
import android.support.p004v7.widget.ActionMenuView;
import android.support.p004v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.ActionMenuPresenter */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: a */
    final C0532f f1893a = new C0532f();

    /* renamed from: b */
    int f1894b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0529d f1895c;

    /* renamed from: d */
    private Drawable f1896d;

    /* renamed from: e */
    private boolean f1897e;

    /* renamed from: f */
    private boolean f1898f;

    /* renamed from: g */
    private boolean f1899g;

    /* renamed from: h */
    private int f1900h;

    /* renamed from: i */
    private int f1901i;

    /* renamed from: j */
    private int f1902j;

    /* renamed from: k */
    private boolean f1903k;

    /* renamed from: l */
    private boolean f1904l;

    /* renamed from: m */
    private boolean f1905m;

    /* renamed from: n */
    private boolean f1906n;

    /* renamed from: o */
    private int f1907o;

    /* renamed from: p */
    private final SparseBooleanArray f1908p = new SparseBooleanArray();

    /* renamed from: q */
    private View f1909q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C0531e f1910r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C0526a f1911s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C0528c f1912t;

    /* renamed from: u */
    private C0527b f1913u;

    public ActionMenuPresenter(Context context) {
        super(context, C0505R.layout.abc_action_menu_layout, C0505R.layout.abc_action_menu_item_layout);
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.f1899g) {
            this.f1898f = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.f1905m) {
            this.f1900h = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.f1903k) {
            this.f1902j = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.f1900h;
        if (this.f1898f) {
            if (this.f1895c == null) {
                this.f1895c = new C0529d(this.mSystemContext);
                if (this.f1897e) {
                    this.f1895c.setImageDrawable(this.f1896d);
                    this.f1896d = null;
                    this.f1897e = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1895c.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1895c.getMeasuredWidth();
        } else {
            this.f1895c = null;
        }
        this.f1901i = i;
        this.f1907o = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1909q = null;
    }

    /* renamed from: a */
    public void mo3970a(Configuration configuration) {
        if (!this.f1903k) {
            this.f1902j = this.mContext.getResources().getInteger(C0505R.integer.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    /* renamed from: a */
    public void mo3973a(boolean z) {
        this.f1898f = z;
        this.f1899g = true;
    }

    /* renamed from: b */
    public void mo3974b(boolean z) {
        this.f1906n = z;
    }

    /* renamed from: a */
    public void mo3971a(Drawable drawable) {
        if (this.f1895c != null) {
            this.f1895c.setImageDrawable(drawable);
            return;
        }
        this.f1897e = true;
        this.f1896d = drawable;
    }

    /* renamed from: a */
    public Drawable mo3969a() {
        if (this.f1895c != null) {
            return this.f1895c.getDrawable();
        }
        if (this.f1897e) {
            return this.f1896d;
        }
        return null;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.f1913u == null) {
            this.f1913u = new C0527b();
        }
        actionMenuItemView.setPopupCallback(this.f1913u);
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public void updateMenuView(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.mMenuView).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            ArrayList<MenuItemImpl> actionItems = this.mMenu.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        if (this.f1898f && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                if (!nonActionItems.get(0).isActionViewExpanded()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z4 = z2;
            } else {
                if (size2 <= 0) {
                    z3 = false;
                }
                z4 = z3;
            }
        }
        if (z4) {
            if (this.f1895c == null) {
                this.f1895c = new C0529d(this.mSystemContext);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f1895c.getParent();
            if (viewGroup2 != this.mMenuView) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f1895c);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f1895c, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.f1895c != null && this.f1895c.getParent() == this.mMenuView) {
            ((ViewGroup) this.mMenuView).removeView(this.f1895c);
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f1898f);
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1895c) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View a = m3090a(subMenuBuilder2.getItem());
        if (a == null) {
            if (this.f1895c == null) {
                return false;
            }
            a = this.f1895c;
        }
        this.f1894b = subMenuBuilder.getItem().getItemId();
        this.f1911s = new C0526a(this, this.mContext, subMenuBuilder);
        this.f1911s.setAnchorView(a);
        this.f1911s.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    /* renamed from: a */
    private View m3090a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: b */
    public boolean mo3975b() {
        if (!this.f1898f || mo3979f() || this.mMenu == null || this.mMenuView == null || this.f1912t != null || this.mMenu.getNonActionItems().isEmpty()) {
            return false;
        }
        this.f1912t = new C0528c(new C0531e(this.mContext, this.mMenu, this.f1895c, true));
        ((View) this.mMenuView).post(this.f1912t);
        super.onSubMenuSelected((SubMenuBuilder) null);
        return true;
    }

    /* renamed from: c */
    public boolean mo3976c() {
        if (this.f1912t == null || this.mMenuView == null) {
            C0531e eVar = this.f1910r;
            if (eVar == null) {
                return false;
            }
            eVar.dismiss();
            return true;
        }
        ((View) this.mMenuView).removeCallbacks(this.f1912t);
        this.f1912t = null;
        return true;
    }

    /* renamed from: d */
    public boolean mo3977d() {
        return mo3976c() | mo3978e();
    }

    /* renamed from: e */
    public boolean mo3978e() {
        if (this.f1911s == null) {
            return false;
        }
        this.f1911s.dismiss();
        return true;
    }

    /* renamed from: f */
    public boolean mo3979f() {
        return this.f1910r != null && this.f1910r.isShowing();
    }

    /* renamed from: g */
    public boolean mo3980g() {
        return this.f1912t != null || mo3979f();
    }

    /* renamed from: h */
    public boolean mo3981h() {
        return this.f1898f;
    }

    public boolean flagActionItems() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        int size = visibleItems.size();
        int i10 = this.f1902j;
        int i11 = this.f1901i;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i12 = 0;
        int i13 = 0;
        boolean z3 = false;
        int i14 = 0;
        while (i14 < size) {
            MenuItemImpl menuItemImpl = visibleItems.get(i14);
            if (menuItemImpl.requiresActionButton()) {
                i12++;
            } else if (menuItemImpl.requestsActionButton()) {
                i13++;
            } else {
                z3 = true;
            }
            if (!this.f1906n || !menuItemImpl.isActionViewExpanded()) {
                i9 = i10;
            } else {
                i9 = 0;
            }
            i14++;
            i10 = i9;
        }
        if (this.f1898f && (z3 || i12 + i13 > i10)) {
            i10--;
        }
        int i15 = i10 - i12;
        SparseBooleanArray sparseBooleanArray = this.f1908p;
        sparseBooleanArray.clear();
        int i16 = 0;
        if (this.f1904l) {
            i16 = i11 / this.f1907o;
            i = ((i11 % this.f1907o) / i16) + this.f1907o;
        } else {
            i = 0;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = i16;
        while (i17 < size) {
            MenuItemImpl menuItemImpl2 = visibleItems.get(i17);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = getItemView(menuItemImpl2, this.f1909q, viewGroup);
                if (this.f1909q == null) {
                    this.f1909q = itemView;
                }
                if (this.f1904l) {
                    i19 -= ActionMenuView.m3114a(itemView, i, i19, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i2 = itemView.getMeasuredWidth();
                int i20 = i11 - i2;
                if (i18 != 0) {
                    i2 = i18;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i3 = i20;
                i4 = i15;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i15 > 0 || z4) && i11 > 0 && (!this.f1904l || i19 > 0);
                if (z5) {
                    View itemView2 = getItemView(menuItemImpl2, this.f1909q, viewGroup);
                    if (this.f1909q == null) {
                        this.f1909q = itemView2;
                    }
                    if (this.f1904l) {
                        int a = ActionMenuView.m3114a(itemView2, i, i19, makeMeasureSpec, 0);
                        int i21 = i19 - a;
                        if (a == 0) {
                            z2 = false;
                        } else {
                            z2 = z5;
                        }
                        i8 = i21;
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z6 = z5;
                        i8 = i19;
                        z2 = z6;
                    }
                    int measuredWidth = itemView2.getMeasuredWidth();
                    i11 -= measuredWidth;
                    if (i18 == 0) {
                        i18 = measuredWidth;
                    }
                    if (this.f1904l) {
                        z = z2 & (i11 >= 0);
                        i5 = i18;
                        i6 = i8;
                    } else {
                        z = z2 & (i11 + i18 > 0);
                        i5 = i18;
                        i6 = i8;
                    }
                } else {
                    z = z5;
                    i5 = i18;
                    i6 = i19;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i7 = i15;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i22 = i15;
                    for (int i23 = 0; i23 < i17; i23++) {
                        MenuItemImpl menuItemImpl3 = visibleItems.get(i23);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i22++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                    i7 = i22;
                } else {
                    i7 = i15;
                }
                if (z) {
                    i7--;
                }
                menuItemImpl2.setIsActionButton(z);
                i2 = i5;
                i3 = i11;
                int i24 = i6;
                i4 = i7;
                i19 = i24;
            } else {
                menuItemImpl2.setIsActionButton(false);
                i2 = i18;
                i3 = i11;
                i4 = i15;
            }
            i17++;
            i11 = i3;
            i15 = i4;
            i18 = i2;
        }
        return true;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        mo3977d();
        super.onCloseMenu(menuBuilder, z);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f1914a = this.f1894b;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        SavedState savedState = (SavedState) parcelable;
        if (savedState.f1914a > 0 && (findItem = this.mMenu.findItem(savedState.f1914a)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected((SubMenuBuilder) null);
        } else {
            this.mMenu.close(false);
        }
    }

    /* renamed from: a */
    public void mo3972a(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState */
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        public int f1914a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1914a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1914a);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$d */
    class C0529d extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        /* renamed from: b */
        private final float[] f1921b = new float[2];

        public C0529d(Context context) {
            super(context, (AttributeSet) null, C0505R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ListPopupWindow.ForwardingListener(this, ActionMenuPresenter.this) {
                public ListPopupWindow getPopup() {
                    if (ActionMenuPresenter.this.f1910r == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f1910r.getPopup();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.mo3975b();
                    return true;
                }

                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.f1912t != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.mo3976c();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.mo3975b();
            }
            return true;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean needsDividerAfter() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$e */
    class C0531e extends MenuPopupHelper {
        public C0531e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0505R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setCallback(ActionMenuPresenter.this.f1893a);
        }

        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            C0531e unused = ActionMenuPresenter.this.f1910r = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$a */
    class C0526a extends MenuPopupHelper {

        /* renamed from: c */
        final /* synthetic */ ActionMenuPresenter f1915c;

        /* renamed from: d */
        private SubMenuBuilder f1916d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0526a(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder) {
            super(context, subMenuBuilder, (View) null, false, C0505R.attr.actionOverflowMenuStyle);
            boolean z = false;
            this.f1915c = actionMenuPresenter;
            this.f1916d = subMenuBuilder;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                setAnchorView(actionMenuPresenter.f1895c == null ? (View) actionMenuPresenter.mMenuView : actionMenuPresenter.f1895c);
            }
            setCallback(actionMenuPresenter.f1893a);
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            setForceShowIcon(z);
        }

        public void onDismiss() {
            super.onDismiss();
            C0526a unused = this.f1915c.f1911s = null;
            this.f1915c.f1894b = 0;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$f */
    class C0532f implements MenuPresenter.Callback {
        private C0532f() {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f1894b = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(menuBuilder) : false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menuBuilder).getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$c */
    class C0528c implements Runnable {

        /* renamed from: b */
        private C0531e f1919b;

        public C0528c(C0531e eVar) {
            this.f1919b = eVar;
        }

        public void run() {
            ActionMenuPresenter.this.mMenu.changeMenuMode();
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.f1919b.tryShow())) {
                C0531e unused = ActionMenuPresenter.this.f1910r = this.f1919b;
            }
            C0528c unused2 = ActionMenuPresenter.this.f1912t = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$b */
    class C0527b extends ActionMenuItemView.PopupCallback {
        private C0527b() {
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuPresenter.this.f1911s != null) {
                return ActionMenuPresenter.this.f1911s.getPopup();
            }
            return null;
        }
    }
}
