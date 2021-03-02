package android.support.p000v4.app;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompatJellybeanMR2 */
class BundleCompatJellybeanMR2 {
    BundleCompatJellybeanMR2() {
    }

    public static IBinder getBinder(Bundle bundle, String key) {
        return bundle.getBinder(key);
    }

    public static void putBinder(Bundle bundle, String key, IBinder binder) {
        bundle.putBinder(key, binder);
    }
}
