package android.support.p021v7.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.bb */
final class C0604bb implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    final /* synthetic */ Field f1428a;

    /* renamed from: b */
    final /* synthetic */ PopupWindow f1429b;

    /* renamed from: c */
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f1430c;

    C0604bb(Field field, PopupWindow popupWindow, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f1428a = field;
        this.f1429b = popupWindow;
        this.f1430c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f1428a.get(this.f1429b);
            if (weakReference != null && weakReference.get() != null) {
                this.f1430c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
