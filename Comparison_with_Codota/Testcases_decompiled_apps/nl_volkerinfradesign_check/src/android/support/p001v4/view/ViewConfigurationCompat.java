package android.support.p001v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.ViewConfigurationCompat */
public class ViewConfigurationCompat {

    /* renamed from: a */
    static final C0324e f989a;

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$e */
    interface C0324e {
        /* renamed from: a */
        int mo1999a(ViewConfiguration viewConfiguration);

        /* renamed from: b */
        boolean mo2000b(ViewConfiguration viewConfiguration);
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$a */
    static class C0320a implements C0324e {
        C0320a() {
        }

        /* renamed from: a */
        public int mo1999a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        /* renamed from: b */
        public boolean mo2000b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$b */
    static class C0321b extends C0320a {
        C0321b() {
        }

        /* renamed from: a */
        public int mo1999a(ViewConfiguration viewConfiguration) {
            return C1059dt.m4759a(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$c */
    static class C0322c extends C0321b {
        C0322c() {
        }

        /* renamed from: b */
        public boolean mo2000b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$d */
    static class C0323d extends C0322c {
        C0323d() {
        }

        /* renamed from: b */
        public boolean mo2000b(ViewConfiguration viewConfiguration) {
            return C1060du.m4760a(viewConfiguration);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f989a = new C0323d();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f989a = new C0322c();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f989a = new C0321b();
        } else {
            f989a = new C0320a();
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return f989a.mo1999a(viewConfiguration);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return f989a.mo2000b(viewConfiguration);
    }
}
