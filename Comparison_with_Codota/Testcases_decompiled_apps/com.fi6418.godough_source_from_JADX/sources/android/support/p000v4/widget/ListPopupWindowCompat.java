package android.support.p000v4.widget;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.widget.ListPopupWindowCompat */
public class ListPopupWindowCompat {

    /* renamed from: a */
    static final ListPopupWindowImpl f1505a;

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$BaseListPopupWindowImpl */
    class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        BaseListPopupWindowImpl() {
        }

        public View.OnTouchListener createDragToOpenListener(Object obj, View view) {
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$KitKatListPopupWindowImpl */
    class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
        }

        public View.OnTouchListener createDragToOpenListener(Object obj, View view) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(obj, view);
        }
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$ListPopupWindowImpl */
    interface ListPopupWindowImpl {
        View.OnTouchListener createDragToOpenListener(Object obj, View view);
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1505a = new KitKatListPopupWindowImpl();
        } else {
            f1505a = new BaseListPopupWindowImpl();
        }
    }

    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        return f1505a.createDragToOpenListener(obj, view);
    }
}
