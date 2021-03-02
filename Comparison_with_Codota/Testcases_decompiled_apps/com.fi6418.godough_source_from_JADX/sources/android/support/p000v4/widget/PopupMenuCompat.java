package android.support.p000v4.widget;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.widget.PopupMenuCompat */
public class PopupMenuCompat {

    /* renamed from: a */
    static final PopupMenuImpl f1576a;

    /* renamed from: android.support.v4.widget.PopupMenuCompat$BasePopupMenuImpl */
    class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }

        public View.OnTouchListener getDragToOpenListener(Object obj) {
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$KitKatPopupMenuImpl */
    class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }

        public View.OnTouchListener getDragToOpenListener(Object obj) {
            return PopupMenuCompatKitKat.getDragToOpenListener(obj);
        }
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$PopupMenuImpl */
    interface PopupMenuImpl {
        View.OnTouchListener getDragToOpenListener(Object obj);
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1576a = new KitKatPopupMenuImpl();
        } else {
            f1576a = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return f1576a.getDragToOpenListener(obj);
    }
}
