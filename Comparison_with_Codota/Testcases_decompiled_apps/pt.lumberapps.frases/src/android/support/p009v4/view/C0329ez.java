package android.support.p009v4.view;

import android.view.View;

/* renamed from: android.support.v4.view.ez */
class C0329ez {
    /* renamed from: a */
    public static void m1259a(View view, C0334fd fdVar) {
        C0331fa faVar = null;
        if (fdVar != null) {
            faVar = new C0331fa(fdVar, view);
        }
        view.animate().setUpdateListener(faVar);
    }
}
