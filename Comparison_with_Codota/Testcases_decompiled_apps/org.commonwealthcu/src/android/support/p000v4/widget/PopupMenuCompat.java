package android.support.p000v4.widget;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.widget.PopupMenuCompat */
public class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

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
            IMPL = new KitKatPopupMenuImpl();
        } else {
            IMPL = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return IMPL.getDragToOpenListener(obj);
    }
}