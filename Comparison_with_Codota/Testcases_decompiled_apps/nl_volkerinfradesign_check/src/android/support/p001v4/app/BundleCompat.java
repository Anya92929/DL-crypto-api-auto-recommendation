package android.support.p001v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompat */
public class BundleCompat {
    public static IBinder getBinder(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return C1999t.m7562a(bundle, str);
        }
        return C1998s.m7560a(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            C1999t.m7563a(bundle, str, iBinder);
        } else {
            C1998s.m7561a(bundle, str, iBinder);
        }
    }
}
