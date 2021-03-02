package android.support.p004v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.p004v7.app.ActionBarDrawerToggle;
import android.support.p004v7.view.ActionMode;
import android.support.p004v7.widget.Toolbar;
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

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

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

    public abstract void setContentView(@LayoutRes int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return m2902a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return m2902a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    /* renamed from: a */
    private static AppCompatDelegate m2902a(Context context, Window window, AppCompatCallback appCompatCallback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return new C1149gb(context, window, appCompatCallback);
        }
        if (i >= 14) {
            return new C1147ga(context, window, appCompatCallback);
        }
        if (i >= 11) {
            return new C1143fz(context, window, appCompatCallback);
        }
        return new AppCompatDelegateImplV7(context, window, appCompatCallback);
    }
}
