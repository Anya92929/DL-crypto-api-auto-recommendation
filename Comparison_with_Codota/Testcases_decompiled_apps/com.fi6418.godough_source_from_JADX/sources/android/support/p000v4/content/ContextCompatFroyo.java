package android.support.p000v4.content;

import android.content.Context;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompatFroyo */
class ContextCompatFroyo {
    ContextCompatFroyo() {
    }

    public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    public static File getExternalFilesDir(Context context, String str) {
        return context.getExternalFilesDir(str);
    }
}
