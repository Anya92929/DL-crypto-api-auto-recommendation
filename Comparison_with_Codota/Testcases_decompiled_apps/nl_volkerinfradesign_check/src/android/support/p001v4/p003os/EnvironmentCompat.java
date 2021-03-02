package android.support.p001v4.p003os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* renamed from: android.support.v4.os.EnvironmentCompat */
public class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";

    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0657cg.m3582a(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                return Environment.getExternalStorageState();
            }
        } catch (IOException e) {
            Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + e);
        }
        return MEDIA_UNKNOWN;
    }
}
