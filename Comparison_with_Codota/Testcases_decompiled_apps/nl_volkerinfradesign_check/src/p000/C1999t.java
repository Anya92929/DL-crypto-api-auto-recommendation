package p000;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: t */
public class C1999t {
    /* renamed from: a */
    public static IBinder m7562a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    /* renamed from: a */
    public static void m7563a(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
