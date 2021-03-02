package com.appbrain.p032a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.appbrain.a.eg */
final class C0899eg {

    /* renamed from: a */
    private WeakHashMap f2373a;

    C0899eg() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3782a() {
        if (this.f2373a != null) {
            for (WeakReference weakReference : this.f2373a.values()) {
                DialogInterface dialogInterface = (DialogInterface) weakReference.get();
                if (dialogInterface != null) {
                    boolean z = true;
                    if (dialogInterface instanceof Dialog) {
                        z = ((Dialog) dialogInterface).isShowing();
                    }
                    if (z) {
                        try {
                            dialogInterface.dismiss();
                        } catch (Exception e) {
                        }
                    }
                }
            }
            this.f2373a.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3783a(Activity activity, Dialog dialog) {
        this.f2373a.put(activity, new WeakReference(dialog));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo3784a(Activity activity) {
        if (this.f2373a == null) {
            this.f2373a = new WeakHashMap();
        }
        WeakReference weakReference = (WeakReference) this.f2373a.get(activity);
        Dialog dialog = weakReference == null ? null : (Dialog) weakReference.get();
        return dialog != null && dialog.isShowing();
    }
}
