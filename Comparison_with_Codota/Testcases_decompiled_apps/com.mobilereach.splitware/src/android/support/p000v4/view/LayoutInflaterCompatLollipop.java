package android.support.p000v4.view;

import android.support.p000v4.view.LayoutInflaterCompatHC;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompatLollipop */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void setFactory(LayoutInflater inflater, LayoutInflaterFactory factory) {
        inflater.setFactory2(factory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(factory) : null);
    }
}
