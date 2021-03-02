package android.support.p009v4.p010a;

import android.content.Context;
import java.io.File;

/* renamed from: android.support.v4.a.d */
public class C0038d {
    /* renamed from: a */
    public static File m148a(Context context) {
        return context.getDataDir();
    }

    /* renamed from: b */
    public static Context m149b(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    /* renamed from: c */
    public static boolean m150c(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
