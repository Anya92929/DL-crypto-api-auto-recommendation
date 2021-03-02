package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* renamed from: ak */
public class C0011ak {
    /* renamed from: a */
    public static Drawable m21a(Context context, int i) {
        return context.getDrawable(i);
    }

    /* renamed from: a */
    public static File m22a(Context context) {
        return context.getNoBackupFilesDir();
    }

    /* renamed from: b */
    public static File m23b(Context context) {
        return context.getCodeCacheDir();
    }
}
