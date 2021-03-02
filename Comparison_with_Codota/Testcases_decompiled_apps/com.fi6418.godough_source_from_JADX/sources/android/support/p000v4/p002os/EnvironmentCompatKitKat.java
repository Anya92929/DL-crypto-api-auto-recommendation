package android.support.p000v4.p002os;

import android.os.Environment;
import java.io.File;

/* renamed from: android.support.v4.os.EnvironmentCompatKitKat */
class EnvironmentCompatKitKat {
    EnvironmentCompatKitKat() {
    }

    public static String getStorageState(File file) {
        return Environment.getStorageState(file);
    }
}
