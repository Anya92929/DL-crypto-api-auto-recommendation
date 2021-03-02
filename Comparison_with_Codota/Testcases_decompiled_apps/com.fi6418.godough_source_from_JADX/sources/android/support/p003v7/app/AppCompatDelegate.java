package android.support.p003v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatDelegate */
public abstract class AppCompatDelegate {
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    AppCompatDelegate() {
    }

    /* renamed from: a */
    private static AppCompatDelegate m1251a(Context context, Window window, AppCompatCallback appCompatCallback) {
        int i = Build.VERSION.SDK_INT;
        return i >= 23 ? new AppCompatDelegateImplV23(context, window, appCompatCallback) : i >= 14 ? new AppCompatDelegateImplV14(context, window, appCompatCallback) : i >= 11 ? new AppCompatDelegateImplV11(context, window, appCompatCallback) : new AppCompatDelegateImplV7(context, window, appCompatCallback);
    }

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return m1251a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return m1251a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract View createView(View view, String str, Context context, AttributeSet attributeSet);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);
}
