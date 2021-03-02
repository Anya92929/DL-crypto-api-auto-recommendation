package com.actionbarsherlock.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.Watson;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;

public class SherlockFragmentActivity extends Watson implements ActionBarSherlock.OnActionModeStartedListener, ActionBarSherlock.OnActionModeFinishedListener {
    private static final String TAG = "SherlockFragmentActivity";
    private boolean mIgnoreNativeCreate = false;
    private boolean mIgnoreNativePrepare = false;
    private boolean mIgnoreNativeSelected = false;
    private ActionBarSherlock mSherlock;

    /* access modifiers changed from: protected */
    public final ActionBarSherlock getSherlock() {
        if (this.mSherlock == null) {
            this.mSherlock = ActionBarSherlock.wrap(this, 1);
        }
        return this.mSherlock;
    }

    public ActionBar getSupportActionBar() {
        return getSherlock().getActionBar();
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return getSherlock().startActionMode(callback);
    }

    public void onActionModeStarted(ActionMode mode) {
    }

    public void onActionModeFinished(ActionMode mode) {
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getSherlock().dispatchConfigurationChanged(newConfig);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getSherlock().dispatchPostResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        getSherlock().dispatchPause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        getSherlock().dispatchStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getSherlock().dispatchDestroy();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        getSherlock().dispatchPostCreate(savedInstanceState);
        super.onPostCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence title, int color) {
        getSherlock().dispatchTitleChanged(title, color);
        super.onTitleChanged(title, color);
    }

    public final boolean onMenuOpened(int featureId, Menu menu) {
        if (getSherlock().dispatchMenuOpened(featureId, menu)) {
            return true;
        }
        return super.onMenuOpened(featureId, menu);
    }

    public void onPanelClosed(int featureId, Menu menu) {
        getSherlock().dispatchPanelClosed(featureId, menu);
        super.onPanelClosed(featureId, menu);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (getSherlock().dispatchKeyEvent(event)) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSherlock().dispatchSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getSherlock().dispatchRestoreInstanceState(savedInstanceState);
    }

    public MenuInflater getSupportMenuInflater() {
        Log.d(TAG, "[getSupportMenuInflater]");
        return getSherlock().getMenuInflater();
    }

    public void invalidateOptionsMenu() {
        Log.d(TAG, "[invalidateOptionsMenu]");
        getSherlock().dispatchInvalidateOptionsMenu();
    }

    public void supportInvalidateOptionsMenu() {
        Log.d(TAG, "[supportInvalidateOptionsMenu]");
        invalidateOptionsMenu();
    }

    public final boolean onCreatePanelMenu(int featureId, Menu menu) {
        Log.d(TAG, "[onCreatePanelMenu] featureId: " + featureId + ", menu: " + menu);
        if (featureId != 0 || this.mIgnoreNativeCreate) {
            return super.onCreatePanelMenu(featureId, menu);
        }
        this.mIgnoreNativeCreate = true;
        boolean result = getSherlock().dispatchCreateOptionsMenu(menu);
        this.mIgnoreNativeCreate = false;
        Log.d(TAG, "[onCreatePanelMenu] returning " + result);
        return result;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public final boolean onPreparePanel(int featureId, View view, Menu menu) {
        Log.d(TAG, "[onPreparePanel] featureId: " + featureId + ", view: " + view + ", menu: " + menu);
        if (featureId != 0 || this.mIgnoreNativePrepare) {
            return super.onPreparePanel(featureId, view, menu);
        }
        this.mIgnoreNativePrepare = true;
        boolean result = getSherlock().dispatchPrepareOptionsMenu(menu);
        this.mIgnoreNativePrepare = false;
        Log.d(TAG, "[onPreparePanel] returning " + result);
        return result;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        Log.d(TAG, "[onMenuItemSelected] featureId: " + featureId + ", item: " + item);
        if (featureId != 0 || this.mIgnoreNativeSelected) {
            return super.onMenuItemSelected(featureId, item);
        }
        this.mIgnoreNativeSelected = true;
        boolean result = getSherlock().dispatchOptionsItemSelected(item);
        this.mIgnoreNativeSelected = false;
        Log.d(TAG, "[onMenuItemSelected] returning " + result);
        return result;
    }

    public final boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void openOptionsMenu() {
        if (!getSherlock().dispatchOpenOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        if (!getSherlock().dispatchCloseOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        return true;
    }

    public boolean onPrepareOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        return false;
    }

    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getSherlock().addContentView(view, params);
    }

    public void setContentView(int layoutResId) {
        getSherlock().setContentView(layoutResId);
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getSherlock().setContentView(view, params);
    }

    public void setContentView(View view) {
        getSherlock().setContentView(view);
    }

    public void requestWindowFeature(long featureId) {
        getSherlock().requestFeature((int) featureId);
    }

    public View findViewById(int id) {
        getSherlock().ensureActionBar();
        return super.findViewById(id);
    }

    public void setSupportProgress(int progress) {
        getSherlock().setProgress(progress);
    }

    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
        getSherlock().setProgressBarIndeterminate(indeterminate);
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        getSherlock().setProgressBarIndeterminateVisibility(visible);
    }

    public void setSupportProgressBarVisibility(boolean visible) {
        getSherlock().setProgressBarVisibility(visible);
    }

    public void setSupportSecondaryProgress(int secondaryProgress) {
        getSherlock().setSecondaryProgress(secondaryProgress);
    }
}
