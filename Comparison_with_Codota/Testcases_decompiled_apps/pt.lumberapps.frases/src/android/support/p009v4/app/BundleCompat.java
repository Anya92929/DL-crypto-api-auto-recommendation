package android.support.p009v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompat */
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? BundleCompatJellybeanMR2.getBinder(bundle, str) : BundleCompatDonut.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(bundle, str, iBinder);
        } else {
            BundleCompatDonut.putBinder(bundle, str, iBinder);
        }
    }
}
