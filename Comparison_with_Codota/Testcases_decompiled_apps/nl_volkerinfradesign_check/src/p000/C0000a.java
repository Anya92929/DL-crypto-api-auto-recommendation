package p000;

import android.app.Fragment;

/* renamed from: a */
public class C0000a {
    /* renamed from: a */
    public static void m0a(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }

    /* renamed from: a */
    public static boolean m1a(Fragment fragment, String str) {
        return fragment.shouldShowRequestPermissionRationale(str);
    }
}
