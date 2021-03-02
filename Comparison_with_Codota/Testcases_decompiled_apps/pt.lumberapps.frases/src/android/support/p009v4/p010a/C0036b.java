package android.support.p009v4.p010a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* renamed from: android.support.v4.a.b */
class C0036b {
    /* renamed from: a */
    public static Drawable m143a(Context context, int i) {
        return context.getDrawable(i);
    }

    /* renamed from: a */
    public static File m144a(Context context) {
        return context.getNoBackupFilesDir();
    }

    /* renamed from: b */
    public static File m145b(Context context) {
        return context.getCodeCacheDir();
    }
}
