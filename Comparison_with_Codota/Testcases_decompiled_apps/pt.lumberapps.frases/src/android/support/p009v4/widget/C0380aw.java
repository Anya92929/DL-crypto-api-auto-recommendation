package android.support.p009v4.widget;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0347q;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.aw */
class C0380aw implements C0383az {
    C0380aw() {
    }

    /* renamed from: a */
    public void mo1803a(PopupWindow popupWindow, int i) {
    }

    /* renamed from: a */
    public void mo1804a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if ((C0347q.m1334a(i3, C0247by.m909d(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public void mo1802a(PopupWindow popupWindow, boolean z) {
    }
}
