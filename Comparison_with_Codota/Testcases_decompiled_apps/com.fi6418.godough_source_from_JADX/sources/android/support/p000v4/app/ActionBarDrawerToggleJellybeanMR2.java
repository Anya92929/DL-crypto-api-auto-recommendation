package android.support.p000v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* renamed from: android.support.v4.app.ActionBarDrawerToggleJellybeanMR2 */
class ActionBarDrawerToggleJellybeanMR2 {

    /* renamed from: a */
    private static final int[] f275a = {16843531};

    ActionBarDrawerToggleJellybeanMR2() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        Context context = activity;
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f275a, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static Object setActionBarDescription(Object obj, Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    public static Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }
}
