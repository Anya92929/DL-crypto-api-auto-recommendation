package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;

@ActionBarSherlock.Implementation(api = 14)
public class ActionBarSherlockNative extends ActionBarSherlock {
    private ActionBarWrapper mActionBar;
    /* access modifiers changed from: private */
    public ActionModeWrapper mActionMode;
    private MenuWrapper mMenu;

    public ActionBarSherlockNative(Activity activity, int flags) {
        super(activity, flags);
    }

    public ActionBar getActionBar() {
        initActionBar();
        return this.mActionBar;
    }

    private void initActionBar() {
        if (this.mActionBar == null && this.mActivity.getActionBar() != null) {
            this.mActionBar = new ActionBarWrapper(this.mActivity);
        }
    }

    public void dispatchInvalidateOptionsMenu() {
        this.mActivity.getWindow().invalidatePanelMenu(0);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu) {
        if (this.mMenu == null || menu != this.mMenu.unwrap()) {
            this.mMenu = new MenuWrapper(menu);
        }
        return callbackCreateOptionsMenu(this.mMenu);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return callbackPrepareOptionsMenu(this.mMenu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem item) {
        return callbackOptionsItemSelected(this.mMenu.findItem(item));
    }

    public boolean hasFeature(int feature) {
        return this.mActivity.getWindow().hasFeature(feature);
    }

    public boolean requestFeature(int featureId) {
        return this.mActivity.getWindow().requestFeature(featureId);
    }

    public void setUiOptions(int uiOptions) {
        this.mActivity.getWindow().setUiOptions(uiOptions);
    }

    public void setUiOptions(int uiOptions, int mask) {
        this.mActivity.getWindow().setUiOptions(uiOptions, mask);
    }

    public void setContentView(int layoutResId) {
        this.mActivity.getWindow().setContentView(layoutResId);
        initActionBar();
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        this.mActivity.getWindow().setContentView(view, params);
        initActionBar();
    }

    public void addContentView(View view, ViewGroup.LayoutParams params) {
        this.mActivity.getWindow().addContentView(view, params);
        initActionBar();
    }

    public void setTitle(CharSequence title) {
        this.mActivity.getWindow().setTitle(title);
    }

    public void setProgressBarVisibility(boolean visible) {
        this.mActivity.setProgressBarVisibility(visible);
    }

    public void setProgressBarIndeterminateVisibility(boolean visible) {
        this.mActivity.setProgressBarIndeterminateVisibility(visible);
    }

    public void setProgressBarIndeterminate(boolean indeterminate) {
        this.mActivity.setProgressBarIndeterminate(indeterminate);
    }

    public void setProgress(int progress) {
        this.mActivity.setProgress(progress);
    }

    public void setSecondaryProgress(int secondaryProgress) {
        this.mActivity.setSecondaryProgress(secondaryProgress);
    }

    /* access modifiers changed from: protected */
    public Context getThemedContext() {
        Context context = this.mActivity;
        TypedValue outValue = new TypedValue();
        this.mActivity.getTheme().resolveAttribute(16843671, outValue, true);
        if (outValue.resourceId != 0) {
            return new ContextThemeWrapper(context, outValue.resourceId);
        }
        return context;
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionModeCallbackWrapper wrapped = null;
        if (callback != null) {
            wrapped = new ActionModeCallbackWrapper(callback);
        }
        this.mActivity.startActionMode(wrapped);
        return this.mActionMode;
    }

    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mCallback;

        public ActionModeCallbackWrapper(ActionMode.Callback callback) {
            this.mCallback = callback;
        }

        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
            ActionBarSherlockNative.this.mActionMode = new ActionModeWrapper(mode);
            return this.mCallback.onCreateActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
        }

        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
            return this.mCallback.onPrepareActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
        }

        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
            return this.mCallback.onActionItemClicked(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu().findItem(item));
        }

        public void onDestroyActionMode(android.view.ActionMode mode) {
            this.mCallback.onDestroyActionMode(ActionBarSherlockNative.this.mActionMode);
        }
    }

    private class ActionModeWrapper extends com.actionbarsherlock.view.ActionMode {
        private final android.view.ActionMode mActionMode;
        private MenuWrapper mMenu = null;

        ActionModeWrapper(android.view.ActionMode actionMode) {
            this.mActionMode = actionMode;
        }

        public void setTitle(CharSequence title) {
            this.mActionMode.setTitle(title);
        }

        public void setTitle(int resId) {
            this.mActionMode.setTitle(resId);
        }

        public void setSubtitle(CharSequence subtitle) {
            this.mActionMode.setSubtitle(subtitle);
        }

        public void setSubtitle(int resId) {
            this.mActionMode.setSubtitle(resId);
        }

        public void setCustomView(View view) {
            this.mActionMode.setCustomView(view);
        }

        public void invalidate() {
            this.mActionMode.invalidate();
        }

        public void finish() {
            this.mActionMode.finish();
        }

        public MenuWrapper getMenu() {
            if (this.mMenu == null) {
                this.mMenu = new MenuWrapper(this.mActionMode.getMenu());
            }
            return this.mMenu;
        }

        public CharSequence getTitle() {
            return this.mActionMode.getTitle();
        }

        public CharSequence getSubtitle() {
            return this.mActionMode.getSubtitle();
        }

        public View getCustomView() {
            return this.mActionMode.getCustomView();
        }

        public MenuInflater getMenuInflater() {
            return ActionBarSherlockNative.this.getMenuInflater();
        }

        public void setTag(Object tag) {
            this.mActionMode.setTag(tag);
        }

        public Object getTag() {
            return this.mActionMode.getTag();
        }
    }
}
