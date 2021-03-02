package android.support.p009v4.view;

import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.ah */
class C0203ah {
    /* renamed from: a */
    static C0208am m769a(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof C0204ai) {
            return ((C0204ai) factory).f339a;
        }
        return null;
    }

    /* renamed from: a */
    static void m770a(LayoutInflater layoutInflater, C0208am amVar) {
        layoutInflater.setFactory(amVar != null ? new C0204ai(amVar) : null);
    }
}
