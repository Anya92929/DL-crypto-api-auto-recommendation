package android.support.p009v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.ac */
public final class C0198ac {

    /* renamed from: a */
    static final C0199ad f338a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f338a = new C0202ag();
        } else if (i >= 11) {
            f338a = new C0201af();
        } else {
            f338a = new C0200ae();
        }
    }

    /* renamed from: a */
    public static C0208am m761a(LayoutInflater layoutInflater) {
        return f338a.mo1389a(layoutInflater);
    }

    /* renamed from: a */
    public static void m762a(LayoutInflater layoutInflater, C0208am amVar) {
        f338a.mo1390a(layoutInflater, amVar);
    }
}
