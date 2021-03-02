package android.support.p001v4.widget;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.widget.ListPopupWindowCompat */
public class ListPopupWindowCompat {

    /* renamed from: a */
    static final C0417c f1206a;

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$c */
    interface C0417c {
        /* renamed from: a */
        View.OnTouchListener mo2771a(Object obj, View view);
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$a */
    static class C0415a implements C0417c {
        C0415a() {
        }

        /* renamed from: a */
        public View.OnTouchListener mo2771a(Object obj, View view) {
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$b */
    static class C0416b extends C0415a {
        C0416b() {
        }

        /* renamed from: a */
        public View.OnTouchListener mo2771a(Object obj, View view) {
            return C1120fk.m5065a(obj, view);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1206a = new C0416b();
        } else {
            f1206a = new C0415a();
        }
    }

    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        return f1206a.mo2771a(obj, view);
    }
}
