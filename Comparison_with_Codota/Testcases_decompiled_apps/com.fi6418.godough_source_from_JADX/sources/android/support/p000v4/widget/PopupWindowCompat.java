package android.support.p000v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompat */
public class PopupWindowCompat {

    /* renamed from: a */
    static final PopupWindowImpl f1577a;

    /* renamed from: android.support.v4.widget.PopupWindowCompat$Api21PopupWindowImpl */
    class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
        Api21PopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi21.m1127a(popupWindow);
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            PopupWindowCompatApi21.m1126a(popupWindow, z);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$Api23PopupWindowImpl */
    class Api23PopupWindowImpl extends Api21PopupWindowImpl {
        Api23PopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.m1130a(popupWindow);
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.m1131b(popupWindow);
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            PopupWindowCompatApi23.m1129a(popupWindow, z);
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            PopupWindowCompatApi23.m1128a(popupWindow, i);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$BasePopupWindowImpl */
    class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return false;
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return 0;
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$GingerbreadPopupWindowImpl */
    class GingerbreadPopupWindowImpl extends BasePopupWindowImpl {
        GingerbreadPopupWindowImpl() {
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatGingerbread.m1132a(popupWindow);
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            PopupWindowCompatGingerbread.m1133a(popupWindow, i);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$KitKatPopupWindowImpl */
    class KitKatPopupWindowImpl extends GingerbreadPopupWindowImpl {
        KitKatPopupWindowImpl() {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            PopupWindowCompatKitKat.showAsDropDown(popupWindow, view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$PopupWindowImpl */
    interface PopupWindowImpl {
        boolean getOverlapAnchor(PopupWindow popupWindow);

        int getWindowLayoutType(PopupWindow popupWindow);

        void setOverlapAnchor(PopupWindow popupWindow, boolean z);

        void setWindowLayoutType(PopupWindow popupWindow, int i);

        void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1577a = new Api23PopupWindowImpl();
        } else if (i >= 21) {
            f1577a = new Api21PopupWindowImpl();
        } else if (i >= 19) {
            f1577a = new KitKatPopupWindowImpl();
        } else if (i >= 9) {
            f1577a = new GingerbreadPopupWindowImpl();
        } else {
            f1577a = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return f1577a.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return f1577a.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        f1577a.setOverlapAnchor(popupWindow, z);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        f1577a.setWindowLayoutType(popupWindow, i);
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1577a.showAsDropDown(popupWindow, view, i, i2, i3);
    }
}
