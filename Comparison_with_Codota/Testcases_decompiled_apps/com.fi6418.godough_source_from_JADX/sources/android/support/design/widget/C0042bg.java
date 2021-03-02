package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.design.widget.bg */
class C0042bg {

    /* renamed from: a */
    private static final C0044bi f181a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f181a = new C0046bk();
        } else {
            f181a = new C0045bj();
        }
    }

    /* renamed from: a */
    static void m282a(ViewGroup viewGroup, View view, Rect rect) {
        f181a.mo255a(viewGroup, view, rect);
    }

    /* renamed from: b */
    static void m283b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m282a(viewGroup, view, rect);
    }
}
