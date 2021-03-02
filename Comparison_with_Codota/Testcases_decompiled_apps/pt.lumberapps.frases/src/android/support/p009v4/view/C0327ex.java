package android.support.p009v4.view;

import android.animation.Animator;
import android.view.View;

/* renamed from: android.support.v4.view.ex */
class C0327ex {
    /* renamed from: a */
    public static void m1258a(View view, C0332fb fbVar) {
        if (fbVar != null) {
            view.animate().setListener(new C0328ey(fbVar, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public static void withLayer(View view) {
        view.animate().withLayer();
    }
}
