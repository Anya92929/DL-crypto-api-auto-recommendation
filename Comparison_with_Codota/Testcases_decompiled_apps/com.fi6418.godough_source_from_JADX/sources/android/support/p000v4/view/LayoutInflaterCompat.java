package android.support.p000v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompat */
public class LayoutInflaterCompat {

    /* renamed from: a */
    static final LayoutInflaterCompatImpl f1185a;

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImpl */
    interface LayoutInflaterCompatImpl {
        void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplBase */
    class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatBase.m859a(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV11 */
    class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatHC.m860a(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV21 */
    class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatLollipop.m862a(layoutInflater, layoutInflaterFactory);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1185a = new LayoutInflaterCompatImplV21();
        } else if (i >= 11) {
            f1185a = new LayoutInflaterCompatImplV11();
        } else {
            f1185a = new LayoutInflaterCompatImplBase();
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        f1185a.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
