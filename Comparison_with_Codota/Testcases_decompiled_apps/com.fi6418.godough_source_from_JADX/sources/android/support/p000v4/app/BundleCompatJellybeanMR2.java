package android.support.p000v4.app;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompatJellybeanMR2 */
class BundleCompatJellybeanMR2 {
    BundleCompatJellybeanMR2() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
