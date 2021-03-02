package android.support.p003v7.app;

import android.support.p003v7.app.ActionBarActivityDelegateICS;
import android.view.Window;

/* renamed from: android.support.v7.app.ActionBarActivityDelegateApi20 */
class ActionBarActivityDelegateApi20 extends ActionBarActivityDelegateJBMR2 {
    ActionBarActivityDelegateApi20(ActionBarActivity activity) {
        super(activity);
    }

    /* access modifiers changed from: package-private */
    public Window.Callback createWindowCallbackWrapper(Window.Callback cb) {
        return new WindowCallbackWrapperApi20(cb);
    }

    /* renamed from: android.support.v7.app.ActionBarActivityDelegateApi20$WindowCallbackWrapperApi20 */
    class WindowCallbackWrapperApi20 extends ActionBarActivityDelegateICS.WindowCallbackWrapper {
        WindowCallbackWrapperApi20(Window.Callback wrapped) {
            super(wrapped);
        }
    }
}
