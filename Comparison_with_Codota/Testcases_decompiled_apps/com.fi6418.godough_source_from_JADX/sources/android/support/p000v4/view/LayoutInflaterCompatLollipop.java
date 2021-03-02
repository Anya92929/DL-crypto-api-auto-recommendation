package android.support.p000v4.view;

import android.support.p000v4.view.LayoutInflaterCompatHC;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompatLollipop */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    /* renamed from: a */
    static void m862a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(layoutInflaterFactory) : null);
    }
}
