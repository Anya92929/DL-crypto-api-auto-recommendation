package android.support.p000v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.ViewConfigurationCompat */
public class ViewConfigurationCompat {

    /* renamed from: a */
    static final ViewConfigurationVersionImpl f1255a;

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$BaseViewConfigurationVersionImpl */
    class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$FroyoViewConfigurationVersionImpl */
    class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl */
    class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$IcsViewConfigurationVersionImpl */
    class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatICS.m888a(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl */
    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);

        boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration);
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1255a = new IcsViewConfigurationVersionImpl();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f1255a = new HoneycombViewConfigurationVersionImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f1255a = new FroyoViewConfigurationVersionImpl();
        } else {
            f1255a = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return f1255a.getScaledPagingTouchSlop(viewConfiguration);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return f1255a.hasPermanentMenuKey(viewConfiguration);
    }
}
