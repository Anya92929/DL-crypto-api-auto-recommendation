package android.support.p001v4.view;

import android.os.Build;

/* renamed from: android.support.v4.view.ScaleGestureDetectorCompat */
public class ScaleGestureDetectorCompat {

    /* renamed from: a */
    static final C0303c f980a;

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$c */
    interface C0303c {
        /* renamed from: a */
        void mo1876a(Object obj, boolean z);

        /* renamed from: a */
        boolean mo1877a(Object obj);
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$a */
    static class C0301a implements C0303c {
        private C0301a() {
        }

        /* renamed from: a */
        public void mo1876a(Object obj, boolean z) {
        }

        /* renamed from: a */
        public boolean mo1877a(Object obj) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$b */
    static class C0302b implements C0303c {
        private C0302b() {
        }

        /* renamed from: a */
        public void mo1876a(Object obj, boolean z) {
            C1044df.m4641a(obj, z);
        }

        /* renamed from: a */
        public boolean mo1877a(Object obj) {
            return C1044df.m4642a(obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f980a = new C0302b();
        } else {
            f980a = new C0301a();
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static void setQuickScaleEnabled(Object obj, boolean z) {
        f980a.mo1876a(obj, z);
    }

    public static boolean isQuickScaleEnabled(Object obj) {
        return f980a.mo1877a(obj);
    }
}
