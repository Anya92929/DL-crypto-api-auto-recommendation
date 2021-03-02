package android.support.p009v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.an */
public final class C0209an {

    /* renamed from: a */
    static final C0210ao f342a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f342a = new C0212aq();
        } else {
            f342a = new C0211ap();
        }
    }

    /* renamed from: a */
    public static int m774a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f342a.mo1394a(marginLayoutParams);
    }

    /* renamed from: b */
    public static int m775b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f342a.mo1395b(marginLayoutParams);
    }
}
