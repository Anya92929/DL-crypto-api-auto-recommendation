package android.support.p021v7.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.widget.bn */
class C0616bn implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1470a;

    /* renamed from: b */
    final /* synthetic */ C0613bk f1471b;

    C0616bn(C0613bk bkVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f1471b = bkVar;
        this.f1470a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f1471b.f1463a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1470a);
        }
    }
}
