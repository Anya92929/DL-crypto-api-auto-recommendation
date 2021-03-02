package android.support.p003v7.app;

import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0091R;
import android.support.p003v7.internal.widget.NativeActionModeAwareLayout;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: android.support.v7.app.ActionBarImplHC */
class ActionBarImplHC extends ActionBarImplBase implements NativeActionModeAwareLayout.OnActionModeForChildListener {
    /* access modifiers changed from: private */
    public ActionMode mCurActionMode;
    final NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    public ActionBarImplHC(ActionBarActivity activity, ActionBar.Callback callback) {
        super(activity, callback);
        this.mNativeActionModeAwareLayout = (NativeActionModeAwareLayout) activity.findViewById(C0091R.C0093id.action_bar_root);
        if (this.mNativeActionModeAwareLayout != null) {
            this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    public ActionMode.Callback onActionModeForChild(ActionMode.Callback callback) {
        return new CallbackWrapper(callback);
    }

    public void show() {
        super.show();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    public void hide() {
        super.hide();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isShowHideAnimationEnabled() {
        return this.mCurActionMode == null && super.isShowHideAnimationEnabled();
    }

    /* renamed from: android.support.v7.app.ActionBarImplHC$CallbackWrapper */
    private class CallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mWrappedCallback;

        CallbackWrapper(ActionMode.Callback callback) {
            this.mWrappedCallback = callback;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            boolean wrappedResult = this.mWrappedCallback.onCreateActionMode(mode, menu);
            if (wrappedResult) {
                ActionMode unused = ActionBarImplHC.this.mCurActionMode = mode;
                ActionBarImplHC.this.showForActionMode();
            }
            return wrappedResult;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrappedCallback.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.mWrappedCallback.onDestroyActionMode(mode);
            ActionBarImplHC.this.hideForActionMode();
            ActionMode unused = ActionBarImplHC.this.mCurActionMode = null;
        }
    }
}
