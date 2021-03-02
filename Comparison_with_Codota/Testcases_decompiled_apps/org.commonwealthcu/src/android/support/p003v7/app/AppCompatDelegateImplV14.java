package android.support.p003v7.app;

import android.content.Context;
import android.support.p003v7.app.AppCompatDelegateImplBase;
import android.support.p003v7.internal.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV14 */
class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
    /* access modifiers changed from: private */
    public boolean mHandleNativeActionModes = true;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV14$AppCompatWindowCallbackV14 */
    class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.mHandleNativeActionModes ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, callback);
            android.support.p003v7.view.ActionMode startSupportActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
    }

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    /* access modifiers changed from: package-private */
    public Window.Callback wrapWindowCallback(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }
}
