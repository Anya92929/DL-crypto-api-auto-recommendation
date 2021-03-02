package android.support.p003v7.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.ActionBarDrawerToggle;
import android.support.p000v4.app.NavUtils;
import android.support.p003v7.appcompat.C0091R;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.app.ActionBarActivityDelegate */
abstract class ActionBarActivityDelegate {
    static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
    private static final String TAG = "ActionBarActivityDelegate";
    static final String UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = "splitActionBarWhenNarrow";
    private ActionBar mActionBar;
    final ActionBarActivity mActivity;
    private boolean mEnableDefaultActionBarUp;
    boolean mHasActionBar;
    private MenuInflater mMenuInflater;
    boolean mOverlayActionBar;

    /* access modifiers changed from: package-private */
    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    /* access modifiers changed from: package-private */
    public abstract ActionBar createSupportActionBar();

    /* access modifiers changed from: package-private */
    public abstract int getHomeAsUpIndicatorAttrId();

    /* access modifiers changed from: package-private */
    public abstract boolean onBackPressed();

    /* access modifiers changed from: package-private */
    public abstract void onConfigurationChanged(Configuration configuration);

    /* access modifiers changed from: package-private */
    public abstract void onContentChanged();

    /* access modifiers changed from: package-private */
    public abstract boolean onCreatePanelMenu(int i, Menu menu);

    /* access modifiers changed from: package-private */
    public abstract View onCreatePanelView(int i);

    /* access modifiers changed from: package-private */
    public abstract boolean onMenuItemSelected(int i, MenuItem menuItem);

    /* access modifiers changed from: package-private */
    public abstract void onPostResume();

    /* access modifiers changed from: package-private */
    public abstract boolean onPreparePanel(int i, View view, Menu menu);

    /* access modifiers changed from: package-private */
    public abstract void onStop();

    /* access modifiers changed from: package-private */
    public abstract void onTitleChanged(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    public abstract void setContentView(int i);

    /* access modifiers changed from: package-private */
    public abstract void setContentView(View view);

    /* access modifiers changed from: package-private */
    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    /* access modifiers changed from: package-private */
    public abstract void setSupportProgress(int i);

    /* access modifiers changed from: package-private */
    public abstract void setSupportProgressBarIndeterminate(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setSupportProgressBarIndeterminateVisibility(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setSupportProgressBarVisibility(boolean z);

    /* access modifiers changed from: package-private */
    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    /* access modifiers changed from: package-private */
    public abstract void supportInvalidateOptionsMenu();

    /* access modifiers changed from: package-private */
    public abstract boolean supportRequestWindowFeature(int i);

    static ActionBarActivityDelegate createDelegate(ActionBarActivity activity) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ActionBarActivityDelegateApi20(activity);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new ActionBarActivityDelegateJBMR2(activity);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActionBarActivityDelegateJB(activity);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new ActionBarActivityDelegateICS(activity);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new ActionBarActivityDelegateHC(activity);
        }
        return new ActionBarActivityDelegateBase(activity);
    }

    ActionBarActivityDelegate(ActionBarActivity activity) {
        this.mActivity = activity;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar getSupportActionBar() {
        if (!this.mHasActionBar && !this.mOverlayActionBar) {
            this.mActionBar = null;
        } else if (this.mActionBar == null) {
            this.mActionBar = createSupportActionBar();
            if (this.mEnableDefaultActionBarUp) {
                this.mActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
        return this.mActionBar;
    }

    /* access modifiers changed from: package-private */
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            this.mMenuInflater = new SupportMenuInflater(getActionBarThemedContext());
        }
        return this.mMenuInflater;
    }

    /* access modifiers changed from: package-private */
    public void onCreate(Bundle savedInstanceState) {
        TypedArray a = this.mActivity.obtainStyledAttributes(C0091R.styleable.ActionBarWindow);
        if (!a.hasValue(0)) {
            a.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        this.mHasActionBar = a.getBoolean(0, false);
        this.mOverlayActionBar = a.getBoolean(1, false);
        a.recycle();
        if (NavUtils.getParentActivityName(this.mActivity) == null) {
            return;
        }
        if (this.mActionBar == null) {
            this.mEnableDefaultActionBarUp = true;
        } else {
            this.mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (Build.VERSION.SDK_INT < 16) {
            return this.mActivity.onPrepareOptionsMenu(menu);
        }
        return this.mActivity.superOnPrepareOptionsPanel(view, menu);
    }

    /* access modifiers changed from: package-private */
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    /* access modifiers changed from: protected */
    public final String getUiOptionsFromMetadata() {
        try {
            ActivityInfo info = this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
            if (info.metaData != null) {
                return info.metaData.getString(METADATA_UI_OPTIONS);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getUiOptionsFromMetadata: Activity '" + this.mActivity.getClass().getSimpleName() + "' not in manifest");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final Context getActionBarThemedContext() {
        Context context = this.mActivity;
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            return ab.getThemedContext();
        }
        return context;
    }

    /* renamed from: android.support.v7.app.ActionBarActivityDelegate$ActionBarDrawableToggleImpl */
    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        private ActionBarDrawableToggleImpl() {
        }

        public Drawable getThemeUpIndicator() {
            TypedArray a = ActionBarActivityDelegate.this.mActivity.obtainStyledAttributes(new int[]{ActionBarActivityDelegate.this.getHomeAsUpIndicatorAttrId()});
            Drawable result = a.getDrawable(0);
            a.recycle();
            return result;
        }

        public void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
            ActionBar ab = ActionBarActivityDelegate.this.getSupportActionBar();
            if (ab != null) {
                ab.setHomeAsUpIndicator(upDrawable);
                ab.setHomeActionContentDescription(contentDescRes);
            }
        }

        public void setActionBarDescription(int contentDescRes) {
            ActionBar ab = ActionBarActivityDelegate.this.getSupportActionBar();
            if (ab != null) {
                ab.setHomeActionContentDescription(contentDescRes);
            }
        }
    }
}
