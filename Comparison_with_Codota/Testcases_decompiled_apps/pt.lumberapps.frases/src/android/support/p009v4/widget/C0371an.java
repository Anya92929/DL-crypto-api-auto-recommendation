package android.support.p009v4.widget;

import android.os.Build;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.an */
public final class C0371an {
    /* renamed from: a */
    public static void m1534a(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            C0373ap.m1536a(listView, i);
        } else {
            C0372ao.m1535a(listView, i);
        }
    }
}
