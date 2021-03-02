package p000;

import android.content.Context;
import android.support.p004v7.app.AppCompatCallback;
import android.view.ActionMode;
import android.view.Window;
import p000.C1147ga;

/* renamed from: gb */
public class C1149gb extends C1147ga {
    public C1149gb(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo8115a(Window.Callback callback) {
        return new C1150a(callback);
    }

    /* renamed from: gb$a */
    class C1150a extends C1147ga.C1148a {
        C1150a(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (C1149gb.this.isHandleNativeActionModesEnabled()) {
                switch (i) {
                    case 0:
                        return mo8122a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }
}
