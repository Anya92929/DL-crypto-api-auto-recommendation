package android.support.p000v4.view;

import android.os.Build;

/* renamed from: android.support.v4.view.ScaleGestureDetectorCompat */
public class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl IMPL;

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl */
    class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        private BaseScaleGestureDetectorImpl() {
        }

        public boolean isQuickScaleEnabled(Object obj) {
            return false;
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
        }
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl */
    class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        private ScaleGestureDetectorCompatKitKatImpl() {
        }

        public boolean isQuickScaleEnabled(Object obj) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(obj);
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorImpl */
    interface ScaleGestureDetectorImpl {
        boolean isQuickScaleEnabled(Object obj);

        void setQuickScaleEnabled(Object obj, boolean z);
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new ScaleGestureDetectorCompatKitKatImpl();
        } else {
            IMPL = new BaseScaleGestureDetectorImpl();
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(Object obj) {
        return IMPL.isQuickScaleEnabled(obj);
    }

    public static void setQuickScaleEnabled(Object obj, boolean z) {
        IMPL.setQuickScaleEnabled(obj, z);
    }
}
