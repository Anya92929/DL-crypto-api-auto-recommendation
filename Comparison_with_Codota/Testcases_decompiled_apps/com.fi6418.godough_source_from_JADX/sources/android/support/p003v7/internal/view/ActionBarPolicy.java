package android.support.p003v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p003v7.appcompat.C0235R;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.internal.view.ActionBarPolicy */
public class ActionBarPolicy {

    /* renamed from: a */
    private Context f1972a;

    private ActionBarPolicy(Context context) {
        this.f1972a = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        return this.f1972a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.f1972a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        return this.f1972a.getResources().getInteger(C0235R.integer.abc_max_action_buttons);
    }

    public int getStackedTabMaxWidth() {
        return this.f1972a.getResources().getDimensionPixelSize(C0235R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.f1972a.obtainStyledAttributes((AttributeSet) null, C0235R.styleable.ActionBar, C0235R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0235R.styleable.ActionBar_height, 0);
        Resources resources = this.f1972a.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0235R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return this.f1972a.getApplicationInfo().targetSdkVersion >= 16 ? this.f1972a.getResources().getBoolean(C0235R.bool.abc_action_bar_embed_tabs) : this.f1972a.getResources().getBoolean(C0235R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public boolean showsOverflowMenuButton() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f1972a));
    }
}
