package android.support.p003v7.app;

import android.content.Context;
import android.support.p003v7.app.AppCompatDelegateImplV14;
import android.view.ActionMode;
import android.view.Window;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV23 */
class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV23$AppCompatWindowCallbackV23 */
    class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
        AppCompatWindowCallbackV23(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImplV23.this.isHandleNativeActionModesEnabled()) {
                switch (i) {
                    case 0:
                        return mo3773a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    AppCompatDelegateImplV23(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo3754a(Window.Callback callback) {
        return new AppCompatWindowCallbackV23(callback);
    }
}
