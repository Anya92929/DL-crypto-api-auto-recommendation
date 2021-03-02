package android.support.p003v7.internal.view;

import android.content.Context;
import android.support.p003v7.internal.view.ActionModeWrapper;
import android.support.p003v7.view.ActionMode;
import android.view.ActionMode;

/* renamed from: android.support.v7.internal.view.ActionModeWrapperJB */
public class ActionModeWrapperJB extends ActionModeWrapper {
    public ActionModeWrapperJB(Context context, ActionMode frameworkActionMode) {
        super(context, frameworkActionMode);
    }

    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    public void setTitleOptionalHint(boolean titleOptional) {
        this.mWrappedObject.setTitleOptionalHint(titleOptional);
    }

    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    /* renamed from: android.support.v7.internal.view.ActionModeWrapperJB$CallbackWrapper */
    public static class CallbackWrapper extends ActionModeWrapper.CallbackWrapper {
        public CallbackWrapper(Context context, ActionMode.Callback supportCallback) {
            super(context, supportCallback);
        }

        /* access modifiers changed from: protected */
        public ActionModeWrapper createActionModeWrapper(Context context, android.view.ActionMode mode) {
            return new ActionModeWrapperJB(context, mode);
        }
    }
}
