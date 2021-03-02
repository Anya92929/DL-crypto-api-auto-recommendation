package p000;

import android.content.Context;
import java.io.File;

/* renamed from: am */
public class C0013am {
    /* renamed from: a */
    public static File m26a(Context context) {
        return context.getExternalCacheDir();
    }

    /* renamed from: a */
    public static File m27a(Context context, String str) {
        return context.getExternalFilesDir(str);
    }
}
