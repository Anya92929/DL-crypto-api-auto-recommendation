package android.support.p009v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.dh */
public final class C0284dh {

    /* renamed from: a */
    static final C0287dk f365a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f365a = new C0289dm();
        } else if (i >= 18) {
            f365a = new C0288dl();
        } else if (i >= 14) {
            f365a = new C0286dj();
        } else if (i >= 11) {
            f365a = new C0285di();
        } else {
            f365a = new C0290dn();
        }
    }

    /* renamed from: a */
    public static void m1141a(ViewGroup viewGroup, boolean z) {
        f365a.mo1528a(viewGroup, z);
    }
}
