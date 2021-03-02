package android.support.p003v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p003v7.internal.view.ActionModeWrapper;
import android.support.p003v7.internal.view.menu.MenuWrapperFactory;
import android.support.p003v7.view.ActionMode;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.app.ActionBarActivityDelegateICS */
class ActionBarActivityDelegateICS extends ActionBarActivityDelegate {
    Menu mMenu;

    ActionBarActivityDelegateICS(ActionBarActivity activity) {
        super(activity);
    }

    public ActionBar createSupportActionBar() {
        return new ActionBarImplICS(this.mActivity, this.mActivity);
    }

    public void onCreate(Bundle savedInstanceState) {
        if ("splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata())) {
            this.mActivity.getWindow().setUiOptions(1, 1);
        }
        super.onCreate(savedInstanceState);
        if (this.mHasActionBar) {
            this.mActivity.requestWindowFeature(8);
        }
        if (this.mOverlayActionBar) {
            this.mActivity.requestWindowFeature(9);
        }
        Window w = this.mActivity.getWindow();
        w.setCallback(createWindowCallbackWrapper(w.getCallback()));
    }

    /* access modifiers changed from: package-private */
    public Window.Callback createWindowCallbackWrapper(Window.Callback cb) {
        return new WindowCallbackWrapper(cb);
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onStop() {
    }

    public void onPostResume() {
    }

    public void setContentView(View v) {
        this.mActivity.superSetContentView(v);
    }

    public void setContentView(int resId) {
        this.mActivity.superSetContentView(resId);
    }

    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        this.mActivity.superSetContentView(v, lp);
    }

    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        this.mActivity.superAddContentView(v, lp);
    }

    public void onContentChanged() {
        this.mActivity.onSupportContentChanged();
    }

    public boolean supportRequestWindowFeature(int featureId) {
        return this.mActivity.requestWindowFeature(featureId);
    }

    public View onCreatePanelView(int featureId) {
        return null;
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId != 0 && featureId != 8) {
            return this.mActivity.superOnCreatePanelMenu(featureId, menu);
        }
        if (this.mMenu == null) {
            this.mMenu = MenuWrapperFactory.createMenuWrapper(menu);
        }
        return this.mActivity.superOnCreatePanelMenu(featureId, this.mMenu);
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId == 0 || featureId == 8) {
            return this.mActivity.superOnPreparePanel(featureId, view, this.mMenu);
        }
        return this.mActivity.superOnPreparePanel(featureId, view, menu);
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (featureId == 0) {
            item = MenuWrapperFactory.createMenuItemWrapper(item);
        }
        return this.mActivity.superOnMenuItemSelected(featureId, item);
    }

    public void onTitleChanged(CharSequence title) {
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Context context = getActionBarThemedContext();
        ActionModeWrapper.CallbackWrapper wrappedCallback = createActionModeCallbackWrapper(context, callback);
        android.view.ActionMode frameworkMode = this.mActivity.startActionMode(wrappedCallback);
        if (frameworkMode == null) {
            return null;
        }
        ActionModeWrapper wrappedMode = createActionModeWrapper(context, frameworkMode);
        wrappedCallback.setLastStartedActionMode(wrappedMode);
        return wrappedMode;
    }

    public void onActionModeStarted(android.view.ActionMode mode) {
        this.mActivity.onSupportActionModeStarted(createActionModeWrapper(getActionBarThemedContext(), mode));
    }

    /* access modifiers changed from: package-private */
    public void setSupportProgressBarVisibility(boolean visible) {
        this.mActivity.setProgressBarVisibility(visible);
    }

    /* access modifiers changed from: package-private */
    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        this.mActivity.setProgressBarIndeterminateVisibility(visible);
    }

    /* access modifiers changed from: package-private */
    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
        this.mActivity.setProgressBarIndeterminate(indeterminate);
    }

    /* access modifiers changed from: package-private */
    public void setSupportProgress(int progress) {
        this.mActivity.setProgress(progress);
    }

    public void onActionModeFinished(android.view.ActionMode mode) {
        this.mActivity.onSupportActionModeFinished(createActionModeWrapper(getActionBarThemedContext(), mode));
    }

    public void supportInvalidateOptionsMenu() {
        this.mMenu = null;
    }

    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getHomeAsUpIndicatorAttrId() {
        return 16843531;
    }

    /* access modifiers changed from: package-private */
    public ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context context, ActionMode.Callback callback) {
        return new ActionModeWrapper.CallbackWrapper(context, callback);
    }

    /* access modifiers changed from: package-private */
    public ActionModeWrapper createActionModeWrapper(Context context, android.view.ActionMode frameworkMode) {
        return new ActionModeWrapper(context, frameworkMode);
    }

    /* renamed from: android.support.v7.app.ActionBarActivityDelegateICS$WindowCallbackWrapper */
    class WindowCallbackWrapper implements Window.Callback {
        final Window.Callback mWrapped;

        public WindowCallbackWrapper(Window.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        public boolean dispatchKeyEvent(KeyEvent event) {
            return this.mWrapped.dispatchKeyEvent(event);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return this.mWrapped.dispatchKeyShortcutEvent(event);
        }

        public boolean dispatchTouchEvent(MotionEvent event) {
            return this.mWrapped.dispatchTouchEvent(event);
        }

        public boolean dispatchTrackballEvent(MotionEvent event) {
            return this.mWrapped.dispatchTrackballEvent(event);
        }

        public boolean dispatchGenericMotionEvent(MotionEvent event) {
            return this.mWrapped.dispatchGenericMotionEvent(event);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(event);
        }

        public View onCreatePanelView(int featureId) {
            return this.mWrapped.onCreatePanelView(featureId);
        }

        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            return this.mWrapped.onCreatePanelMenu(featureId, menu);
        }

        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            return this.mWrapped.onPreparePanel(featureId, view, menu);
        }

        public boolean onMenuOpened(int featureId, Menu menu) {
            return this.mWrapped.onMenuOpened(featureId, menu);
        }

        public boolean onMenuItemSelected(int featureId, MenuItem item) {
            return this.mWrapped.onMenuItemSelected(featureId, item);
        }

        public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
            this.mWrapped.onWindowAttributesChanged(attrs);
        }

        public void onContentChanged() {
            this.mWrapped.onContentChanged();
        }

        public void onWindowFocusChanged(boolean hasFocus) {
            this.mWrapped.onWindowFocusChanged(hasFocus);
        }

        public void onAttachedToWindow() {
            this.mWrapped.onAttachedToWindow();
        }

        public void onDetachedFromWindow() {
            this.mWrapped.onDetachedFromWindow();
        }

        public void onPanelClosed(int featureId, Menu menu) {
            this.mWrapped.onPanelClosed(featureId, menu);
        }

        public boolean onSearchRequested() {
            return this.mWrapped.onSearchRequested();
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.mWrapped.onWindowStartingActionMode(callback);
        }

        public void onActionModeStarted(android.view.ActionMode mode) {
            this.mWrapped.onActionModeStarted(mode);
            ActionBarActivityDelegateICS.this.onActionModeStarted(mode);
        }

        public void onActionModeFinished(android.view.ActionMode mode) {
            this.mWrapped.onActionModeFinished(mode);
            ActionBarActivityDelegateICS.this.onActionModeFinished(mode);
        }
    }
}