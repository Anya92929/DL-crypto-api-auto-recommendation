package android.support.p001v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompat */
public class LayoutInflaterCompat {

    /* renamed from: a */
    static final C0276a f930a;

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$a */
    interface C0276a {
        /* renamed from: a */
        void mo1768a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$b */
    static class C0277b implements C0276a {
        C0277b() {
        }

        /* renamed from: a */
        public void mo1768a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            C1028cv.m4605a(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$c */
    static class C0278c extends C0277b {
        C0278c() {
        }

        /* renamed from: a */
        public void mo1768a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            C1030cw.m4606a(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$d */
    static class C0279d extends C0278c {
        C0279d() {
        }

        /* renamed from: a */
        public void mo1768a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            C1032cx.m4608a(layoutInflater, layoutInflaterFactory);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f930a = new C0279d();
        } else if (i >= 11) {
            f930a = new C0278c();
        } else {
            f930a = new C0277b();
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        f930a.mo1768a(layoutInflater, layoutInflaterFactory);
    }
}
