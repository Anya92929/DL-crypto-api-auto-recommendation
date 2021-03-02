package android.support.p009v4.p010a;

import android.content.Context;
import java.io.File;

/* renamed from: android.support.v4.a.h */
class C0042h {
    /* renamed from: a */
    public static File[] m156a(Context context) {
        return context.getExternalCacheDirs();
    }

    /* renamed from: a */
    public static File[] m157a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    /* renamed from: b */
    public static File[] m158b(Context context) {
        return context.getObbDirs();
    }
}
