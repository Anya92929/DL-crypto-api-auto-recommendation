package p000;

import android.content.Context;
import java.io.File;

/* renamed from: ap */
public class C0597ap {
    /* renamed from: a */
    public static File[] m3395a(Context context) {
        return context.getExternalCacheDirs();
    }

    /* renamed from: a */
    public static File[] m3396a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    /* renamed from: b */
    public static File[] m3397b(Context context) {
        return context.getObbDirs();
    }
}
