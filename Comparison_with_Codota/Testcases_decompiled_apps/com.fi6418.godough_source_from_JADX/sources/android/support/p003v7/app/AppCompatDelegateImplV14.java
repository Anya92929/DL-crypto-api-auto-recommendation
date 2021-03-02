package android.support.p003v7.app;

import android.content.Context;
import android.support.p003v7.app.AppCompatDelegateImplBase;
import android.support.p003v7.internal.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV14 */
class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {

    /* renamed from: r */
    private boolean f1816r = true;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV14$AppCompatWindowCallbackV14 */
    class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final ActionMode mo3773a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.f1800a, callback);
            android.support.p003v7.view.ActionMode startSupportActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled() ? mo3773a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo3754a(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.f1816r;
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.f1816r = z;
    }
}
