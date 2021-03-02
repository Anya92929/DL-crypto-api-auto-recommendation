package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.GravityCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.transition.ActionBarTransition;
import android.support.p003v7.internal.view.ActionBarPolicy;
import android.support.p003v7.internal.view.menu.ActionMenuItemView;
import android.support.p003v7.internal.view.menu.BaseMenuPresenter;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuItemImpl;
import android.support.p003v7.internal.view.menu.MenuPopupHelper;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.internal.widget.TintImageView;
import android.support.p003v7.widget.ActionMenuView;
import android.support.p003v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.ActionMenuPresenter */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: A */
    private ActionMenuPopupCallback f2592A;

    /* renamed from: g */
    final PopupPresenterCallback f2593g = new PopupPresenterCallback();

    /* renamed from: h */
    int f2594h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OverflowMenuButton f2595i;

    /* renamed from: j */
    private Drawable f2596j;

    /* renamed from: k */
    private boolean f2597k;

    /* renamed from: l */
    private boolean f2598l;

    /* renamed from: m */
    private boolean f2599m;

    /* renamed from: n */
    private int f2600n;

    /* renamed from: o */
    private int f2601o;

    /* renamed from: p */
    private int f2602p;

    /* renamed from: q */
    private boolean f2603q;

    /* renamed from: r */
    private boolean f2604r;

    /* renamed from: s */
    private boolean f2605s;

    /* renamed from: t */
    private boolean f2606t;

    /* renamed from: u */
    private int f2607u;

    /* renamed from: v */
    private final SparseBooleanArray f2608v = new SparseBooleanArray();

    /* renamed from: w */
    private View f2609w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public OverflowPopup f2610x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ActionButtonSubmenu f2611y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public OpenOverflowRunnable f2612z;

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$ActionButtonSubmenu */
    class ActionButtonSubmenu extends MenuPopupHelper {

        /* renamed from: c */
        final /* synthetic */ ActionMenuPresenter f2613c;

        /* renamed from: d */
        private SubMenuBuilder f2614d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder) {
            super(context, subMenuBuilder, (View) null, false, C0235R.attr.actionOverflowMenuStyle);
            boolean z = false;
            this.f2613c = actionMenuPresenter;
            this.f2614d = subMenuBuilder;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                setAnchorView(actionMenuPresenter.f2595i == null ? (View) actionMenuPresenter.f2065f : actionMenuPresenter.f2595i);
            }
            setCallback(actionMenuPresenter.f2593g);
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
            ActionButtonSubmenu unused = this.f2613c.f2611y = null;
            this.f2613c.f2594h = 0;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$ActionMenuPopupCallback */
    class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        private ActionMenuPopupCallback() {
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuPresenter.this.f2611y != null) {
                return ActionMenuPresenter.this.f2611y.getPopup();
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$OpenOverflowRunnable */
    class OpenOverflowRunnable implements Runnable {

        /* renamed from: b */
        private OverflowPopup f2617b;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f2617b = overflowPopup;
        }

        public void run() {
            ActionMenuPresenter.this.f2062c.changeMenuMode();
            View view = (View) ActionMenuPresenter.this.f2065f;
            if (!(view == null || view.getWindowToken() == null || !this.f2617b.tryShow())) {
                OverflowPopup unused = ActionMenuPresenter.this.f2610x = this.f2617b;
            }
            OpenOverflowRunnable unused2 = ActionMenuPresenter.this.f2612z = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$OverflowMenuButton */
    class OverflowMenuButton extends TintImageView implements ActionMenuView.ActionMenuChildView {

        /* renamed from: b */
        private final float[] f2619b = new float[2];

        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, C0235R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ListPopupWindow.ForwardingListener(this, ActionMenuPresenter.this) {
                public ListPopupWindow getPopup() {
                    if (ActionMenuPresenter.this.f2610x == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f2610x.getPopup();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.f2612z != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
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

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$OverflowPopup */
    class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0235R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setCallback(ActionMenuPresenter.this.f2593g);
        }

        public void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter.this.f2062c.close();
            OverflowPopup unused = ActionMenuPresenter.this.f2610x = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$PopupPresenterCallback */
    class PopupPresenterCallback implements MenuPresenter.Callback {
        private PopupPresenterCallback() {
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

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f2594h = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(menuBuilder) : false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState */
    class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0235R.layout.abc_action_menu_layout, C0235R.layout.abc_action_menu_item_layout);
    }

    /* renamed from: a */
    private View m1696a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f2065f;
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

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f2065f);
        if (this.f2592A == null) {
            this.f2592A = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.f2592A);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2595i) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
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
        ArrayList<MenuItemImpl> visibleItems = this.f2062c.getVisibleItems();
        int size = visibleItems.size();
        int i9 = this.f2602p;
        int i10 = this.f2601o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f2065f;
        int i11 = 0;
        int i12 = 0;
        boolean z3 = false;
        int i13 = 0;
        while (i13 < size) {
            MenuItemImpl menuItemImpl = visibleItems.get(i13);
            if (menuItemImpl.requiresActionButton()) {
                i11++;
            } else if (menuItemImpl.requestsActionButton()) {
                i12++;
            } else {
                z3 = true;
            }
            i13++;
            i9 = (!this.f2606t || !menuItemImpl.isActionViewExpanded()) ? i9 : 0;
        }
        if (this.f2598l && (z3 || i11 + i12 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = this.f2608v;
        sparseBooleanArray.clear();
        int i15 = 0;
        if (this.f2604r) {
            i15 = i10 / this.f2607u;
            i = ((i10 % this.f2607u) / i15) + this.f2607u;
        } else {
            i = 0;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = i15;
        while (i16 < size) {
            MenuItemImpl menuItemImpl2 = visibleItems.get(i16);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = getItemView(menuItemImpl2, this.f2609w, viewGroup);
                if (this.f2609w == null) {
                    this.f2609w = itemView;
                }
                if (this.f2604r) {
                    i18 -= ActionMenuView.m1704a(itemView, i, i18, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i2 = itemView.getMeasuredWidth();
                int i19 = i10 - i2;
                if (i17 != 0) {
                    i2 = i17;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i3 = i19;
                i4 = i14;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i14 > 0 || z4) && i10 > 0 && (!this.f2604r || i18 > 0);
                if (z5) {
                    View itemView2 = getItemView(menuItemImpl2, this.f2609w, viewGroup);
                    if (this.f2609w == null) {
                        this.f2609w = itemView2;
                    }
                    if (this.f2604r) {
                        int a = ActionMenuView.m1704a(itemView2, i, i18, makeMeasureSpec, 0);
                        int i20 = i18 - a;
                        z2 = a == 0 ? false : z5;
                        i8 = i20;
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z6 = z5;
                        i8 = i18;
                        z2 = z6;
                    }
                    int measuredWidth = itemView2.getMeasuredWidth();
                    i10 -= measuredWidth;
                    if (i17 == 0) {
                        i17 = measuredWidth;
                    }
                    if (this.f2604r) {
                        z = z2 & (i10 >= 0);
                        i5 = i17;
                        i6 = i8;
                    } else {
                        z = z2 & (i10 + i17 > 0);
                        i5 = i17;
                        i6 = i8;
                    }
                } else {
                    z = z5;
                    i5 = i17;
                    i6 = i18;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i7 = i14;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i21 = i14;
                    for (int i22 = 0; i22 < i16; i22++) {
                        MenuItemImpl menuItemImpl3 = visibleItems.get(i22);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i21++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                    i7 = i21;
                } else {
                    i7 = i14;
                }
                if (z) {
                    i7--;
                }
                menuItemImpl2.setIsActionButton(z);
                i2 = i5;
                i3 = i10;
                int i23 = i6;
                i4 = i7;
                i18 = i23;
            } else {
                menuItemImpl2.setIsActionButton(false);
                i2 = i17;
                i3 = i10;
                i4 = i14;
            }
            i16++;
            i10 = i3;
            i14 = i4;
            i17 = i2;
        }
        return true;
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

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public Drawable getOverflowIcon() {
        if (this.f2595i != null) {
            return this.f2595i.getDrawable();
        }
        if (this.f2597k) {
            return this.f2596j;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        if (this.f2612z == null || this.f2065f == null) {
            OverflowPopup overflowPopup = this.f2610x;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.dismiss();
            return true;
        }
        ((View) this.f2065f).removeCallbacks(this.f2612z);
        this.f2612z = null;
        return true;
    }

    public boolean hideSubMenus() {
        if (this.f2611y == null) {
            return false;
        }
        this.f2611y.dismiss();
        return true;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.f2599m) {
            this.f2598l = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.f2605s) {
            this.f2600n = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.f2603q) {
            this.f2602p = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.f2600n;
        if (this.f2598l) {
            if (this.f2595i == null) {
                this.f2595i = new OverflowMenuButton(this.f2060a);
                if (this.f2597k) {
                    this.f2595i.setImageDrawable(this.f2596j);
                    this.f2596j = null;
                    this.f2597k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2595i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2595i.getMeasuredWidth();
        } else {
            this.f2595i = null;
        }
        this.f2601o = i;
        this.f2607u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2609w = null;
    }

    public boolean isOverflowMenuShowPending() {
        return this.f2612z != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        return this.f2610x != null && this.f2610x.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.f2598l;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f2603q) {
            this.f2602p = this.f2061b.getResources().getInteger(C0235R.integer.abc_max_action_buttons);
        }
        if (this.f2062c != null) {
            this.f2062c.onItemsChanged(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        SavedState savedState = (SavedState) parcelable;
        if (savedState.openSubMenuId > 0 && (findItem = this.f2062c.findItem(savedState.openSubMenuId)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.f2594h;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.f2062c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View a = m1696a(subMenuBuilder2.getItem());
        if (a == null) {
            if (this.f2595i == null) {
                return false;
            }
            a = this.f2595i;
        }
        this.f2594h = subMenuBuilder.getItem().getItemId();
        this.f2611y = new ActionButtonSubmenu(this, this.f2061b, subMenuBuilder);
        this.f2611y.setAnchorView(a);
        this.f2611y.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected((SubMenuBuilder) null);
        } else {
            this.f2062c.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2606t = z;
    }

    public void setItemLimit(int i) {
        this.f2602p = i;
        this.f2603q = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.f2065f = actionMenuView;
        actionMenuView.initialize(this.f2062c);
    }

    public void setOverflowIcon(Drawable drawable) {
        if (this.f2595i != null) {
            this.f2595i.setImageDrawable(drawable);
            return;
        }
        this.f2597k = true;
        this.f2596j = drawable;
    }

    public void setReserveOverflow(boolean z) {
        this.f2598l = z;
        this.f2599m = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.f2600n = i;
        this.f2604r = z;
        this.f2605s = true;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (!this.f2598l || isOverflowMenuShowing() || this.f2062c == null || this.f2065f == null || this.f2612z != null || this.f2062c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.f2612z = new OpenOverflowRunnable(new OverflowPopup(this.f2061b, this.f2062c, this.f2595i, true));
        ((View) this.f2065f).post(this.f2612z);
        super.onSubMenuSelected((SubMenuBuilder) null);
        return true;
    }

    public void updateMenuView(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f2065f).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(z);
        ((View) this.f2065f).requestLayout();
        if (this.f2062c != null) {
            ArrayList<MenuItemImpl> actionItems = this.f2062c.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems = this.f2062c != null ? this.f2062c.getNonActionItems() : null;
        if (this.f2598l && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z3 = !nonActionItems.get(0).isActionViewExpanded();
            } else {
                if (size2 <= 0) {
                    z2 = false;
                }
                z3 = z2;
            }
        }
        if (z3) {
            if (this.f2595i == null) {
                this.f2595i = new OverflowMenuButton(this.f2060a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f2595i.getParent();
            if (viewGroup2 != this.f2065f) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f2595i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f2065f;
                actionMenuView.addView(this.f2595i, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.f2595i != null && this.f2595i.getParent() == this.f2065f) {
            ((ViewGroup) this.f2065f).removeView(this.f2595i);
        }
        ((ActionMenuView) this.f2065f).setOverflowReserved(this.f2598l);
    }
}
