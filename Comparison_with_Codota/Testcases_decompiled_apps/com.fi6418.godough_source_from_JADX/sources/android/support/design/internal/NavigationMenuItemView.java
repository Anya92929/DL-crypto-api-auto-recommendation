package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0002c;
import android.support.design.C0003d;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.widget.TextViewCompat;
import android.support.p003v7.internal.view.menu.MenuItemImpl;
import android.support.p003v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class NavigationMenuItemView extends TextView implements MenuView.ItemView {

    /* renamed from: a */
    private static final int[] f2a = {16842912};

    /* renamed from: b */
    private int f3b;

    /* renamed from: c */
    private MenuItemImpl f4c;

    /* renamed from: d */
    private ColorStateList f5d;

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3b = context.getResources().getDimensionPixelSize(C0003d.design_navigation_icon_size);
    }

    /* renamed from: a */
    private StateListDrawable m0a() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0002c.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f2a, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public MenuItemImpl getItemData() {
        return this.f4c;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f4c = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m0a());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4c != null && this.f4c.isCheckable() && this.f4c.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f2a);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable.getConstantState().newDrawable()).mutate();
            drawable.setBounds(0, 0, this.f3b, this.f3b);
            DrawableCompat.setTintList(drawable, this.f5d);
        }
        TextViewCompat.setCompoundDrawablesRelative(this, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.f5d = colorStateList;
        if (this.f4c != null) {
            setIcon(this.f4c.getIcon());
        }
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
