package android.support.p003v7.app;

import android.content.Context;
import android.support.p003v7.internal.view.ActionModeWrapper;
import android.support.p003v7.internal.view.ActionModeWrapperJB;
import android.support.p003v7.view.ActionMode;

/* renamed from: android.support.v7.app.ActionBarActivityDelegateJB */
class ActionBarActivityDelegateJB extends ActionBarActivityDelegateICS {
    ActionBarActivityDelegateJB(ActionBarActivity activity) {
        super(activity);
    }

    public ActionBar createSupportActionBar() {
        return new ActionBarImplJB(this.mActivity, this.mActivity);
    }

    /* access modifiers changed from: package-private */
    public ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context context, ActionMode.Callback callback) {
        return new ActionModeWrapperJB.CallbackWrapper(context, callback);
    }

    /* access modifiers changed from: package-private */
    public ActionModeWrapper createActionModeWrapper(Context context, android.view.ActionMode frameworkMode) {
        return new ActionModeWrapperJB(context, frameworkMode);
    }
}
