package p000;

import android.content.Context;
import android.support.p004v7.app.AppCompatCallback;
import android.support.p004v7.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.Window;
import p000.C1139fy;

/* renamed from: ga */
public class C1147ga extends C1143fz {

    /* renamed from: r */
    private boolean f4131r = true;

    public C1147ga(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo8115a(Window.Callback callback) {
        return new C1148a(callback);
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.f4131r = z;
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.f4131r;
    }

    /* renamed from: ga$a */
    class C1148a extends C1139fy.C1142b {
        C1148a(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (C1147ga.this.isHandleNativeActionModesEnabled()) {
                return mo8122a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final ActionMode mo8122a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(C1147ga.this.f4105a, callback);
            android.support.p004v7.view.ActionMode startSupportActionMode = C1147ga.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
    }
}
