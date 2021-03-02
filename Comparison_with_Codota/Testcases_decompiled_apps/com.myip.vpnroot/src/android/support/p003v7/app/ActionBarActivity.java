package android.support.p003v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.ActionBarDrawerToggle;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.NavUtils;
import android.support.p000v4.app.TaskStackBuilder;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.app.ActionBarActivity */
public class ActionBarActivity extends FragmentActivity implements ActionBar.Callback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    ActionBarActivityDelegate mImpl;

    public ActionBar getSupportActionBar() {
        return this.mImpl.getSupportActionBar();
    }

    public MenuInflater getMenuInflater() {
        return this.mImpl.getMenuInflater();
    }

    public void setContentView(int layoutResID) {
        this.mImpl.setContentView(layoutResID);
    }

    public void setContentView(View view) {
        this.mImpl.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        this.mImpl.setContentView(view, params);
    }

    public void addContentView(View view, ViewGroup.LayoutParams params) {
        this.mImpl.addContentView(view, params);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        this.mImpl = ActionBarActivityDelegate.createDelegate(this);
        super.onCreate(savedInstanceState);
        this.mImpl.onCreate(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mImpl.onConfigurationChanged(newConfig);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mImpl.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mImpl.onPostResume();
    }

    public View onCreatePanelView(int featureId) {
        if (featureId == 0) {
            return this.mImpl.onCreatePanelView(featureId);
        }
        return super.onCreatePanelView(featureId);
    }

    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (this.mImpl.onMenuItemSelected(featureId, item)) {
            return true;
        }
        ActionBar ab = getSupportActionBar();
        if (item.getItemId() != 16908332 || ab == null || (ab.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        this.mImpl.onTitleChanged(title);
    }

    public boolean supportRequestWindowFeature(int featureId) {
        return this.mImpl.supportRequestWindowFeature(featureId);
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 14) {
            super.supportInvalidateOptionsMenu();
        }
        this.mImpl.supportInvalidateOptionsMenu();
    }

    public void onSupportActionModeStarted(ActionMode mode) {
    }

    public void onSupportActionModeFinished(ActionMode mode) {
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return this.mImpl.startSupportActionMode(callback);
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return this.mImpl.onCreatePanelMenu(featureId, menu);
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return this.mImpl.onPreparePanel(featureId, view, menu);
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return this.mImpl.onPrepareOptionsPanel(view, menu);
    }

    /* access modifiers changed from: package-private */
    public void superSetContentView(int resId) {
        super.setContentView(resId);
    }

    /* access modifiers changed from: package-private */
    public void superSetContentView(View v) {
        super.setContentView(v);
    }

    /* access modifiers changed from: package-private */
    public void superSetContentView(View v, ViewGroup.LayoutParams lp) {
        super.setContentView(v, lp);
    }

    /* access modifiers changed from: package-private */
    public void superAddContentView(View v, ViewGroup.LayoutParams lp) {
        super.addContentView(v, lp);
    }

    /* access modifiers changed from: package-private */
    public boolean superOnCreatePanelMenu(int featureId, Menu frameworkMenu) {
        return super.onCreatePanelMenu(featureId, frameworkMenu);
    }

    /* access modifiers changed from: package-private */
    public boolean superOnPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    /* access modifiers changed from: package-private */
    public boolean superOnPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }

    /* access modifiers changed from: package-private */
    public boolean superOnMenuItemSelected(int featureId, MenuItem menuItem) {
        return super.onMenuItemSelected(featureId, menuItem);
    }

    public void onBackPressed() {
        if (!this.mImpl.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void setSupportProgressBarVisibility(boolean visible) {
        this.mImpl.setSupportProgressBarVisibility(visible);
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        this.mImpl.setSupportProgressBarIndeterminateVisibility(visible);
    }

    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
        this.mImpl.setSupportProgressBarIndeterminate(indeterminate);
    }

    public void setSupportProgress(int progress) {
        this.mImpl.setSupportProgress(progress);
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder builder) {
        builder.addParentStack((Activity) this);
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder builder) {
    }

    public boolean onSupportNavigateUp() {
        Intent upIntent = getSupportParentActivityIntent();
        if (upIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(upIntent)) {
            TaskStackBuilder b = TaskStackBuilder.create(this);
            onCreateSupportNavigateUpTaskStack(b);
            onPrepareSupportNavigateUpTaskStack(b);
            b.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(upIntent);
        }
        return true;
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public boolean supportShouldUpRecreateTask(Intent targetIntent) {
        return NavUtils.shouldUpRecreateTask(this, targetIntent);
    }

    public void supportNavigateUpTo(Intent upIntent) {
        NavUtils.navigateUpTo(this, upIntent);
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.mImpl.getDrawerToggleDelegate();
    }

    public final void onContentChanged() {
        this.mImpl.onContentChanged();
    }

    public void onSupportContentChanged() {
    }
}
