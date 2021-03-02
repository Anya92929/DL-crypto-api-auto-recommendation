package p000;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* renamed from: bm */
public final class C0621bm {
    /* renamed from: a */
    public static Object m3436a(Context context) {
        return context.getSystemService("display");
    }

    /* renamed from: a */
    public static Display m3435a(Object obj, int i) {
        return ((DisplayManager) obj).getDisplay(i);
    }

    /* renamed from: a */
    public static Display[] m3437a(Object obj) {
        return ((DisplayManager) obj).getDisplays();
    }

    /* renamed from: a */
    public static Display[] m3438a(Object obj, String str) {
        return ((DisplayManager) obj).getDisplays(str);
    }
}
