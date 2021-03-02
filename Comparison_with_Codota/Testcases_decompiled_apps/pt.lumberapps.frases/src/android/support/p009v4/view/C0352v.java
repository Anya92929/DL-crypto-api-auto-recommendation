package android.support.p009v4.view;

import android.os.Build;
import android.view.KeyEvent;

/* renamed from: android.support.v4.view.v */
public final class C0352v {

    /* renamed from: a */
    static final C0356z f410a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f410a = new C0355y();
        } else {
            f410a = new C0353w();
        }
    }

    /* renamed from: a */
    public static boolean m1339a(KeyEvent keyEvent) {
        return f410a.mo1632b(keyEvent.getMetaState());
    }

    /* renamed from: a */
    public static boolean m1340a(KeyEvent keyEvent, int i) {
        return f410a.mo1631a(keyEvent.getMetaState(), i);
    }

    /* renamed from: b */
    public static void m1341b(KeyEvent keyEvent) {
        f410a.mo1630a(keyEvent);
    }

    /* renamed from: c */
    public static boolean m1342c(KeyEvent keyEvent) {
        return f410a.mo1633b(keyEvent);
    }
}
