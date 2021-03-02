package android.support.p004v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p001v4.view.ViewConfigurationCompat;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.ActionBarPolicy */
public class ActionBarPolicy {

    /* renamed from: a */
    private Context f1629a;

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f1629a = context;
    }

    public int getMaxActionButtons() {
        return this.f1629a.getResources().getInteger(C0505R.integer.abc_max_action_buttons);
    }

    public boolean showsOverflowMenuButton() {
        if (Build.VERSION.SDK_INT < 19 && ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f1629a))) {
            return false;
        }
        return true;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.f1629a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean hasEmbeddedTabs() {
        if (this.f1629a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f1629a.getResources().getBoolean(C0505R.bool.abc_action_bar_embed_tabs);
        }
        return this.f1629a.getResources().getBoolean(C0505R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.f1629a.obtainStyledAttributes((AttributeSet) null, C0505R.styleable.ActionBar, C0505R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0505R.styleable.ActionBar_height, 0);
        Resources resources = this.f1629a.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0505R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean enableHomeButtonByDefault() {
        return this.f1629a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getStackedTabMaxWidth() {
        return this.f1629a.getResources().getDimensionPixelSize(C0505R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
