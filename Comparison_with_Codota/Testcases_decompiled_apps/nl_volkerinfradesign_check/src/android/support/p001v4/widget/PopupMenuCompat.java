package android.support.p001v4.widget;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.widget.PopupMenuCompat */
public class PopupMenuCompat {

    /* renamed from: a */
    static final C0426c f1279a;

    /* renamed from: android.support.v4.widget.PopupMenuCompat$c */
    interface C0426c {
        /* renamed from: a */
        View.OnTouchListener mo2877a(Object obj);
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$a */
    static class C0424a implements C0426c {
        C0424a() {
        }

        /* renamed from: a */
        public View.OnTouchListener mo2877a(Object obj) {
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$b */
    static class C0425b extends C0424a {
        C0425b() {
        }

        /* renamed from: a */
        public View.OnTouchListener mo2877a(Object obj) {
            return C1121fl.m5066a(obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1279a = new C0425b();
        } else {
            f1279a = new C0424a();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return f1279a.mo2877a(obj);
    }
}
