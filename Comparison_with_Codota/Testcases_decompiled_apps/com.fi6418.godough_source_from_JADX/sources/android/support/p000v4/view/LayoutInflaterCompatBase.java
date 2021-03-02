package android.support.p000v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: android.support.v4.view.LayoutInflaterCompatBase */
class LayoutInflaterCompatBase {

    /* renamed from: android.support.v4.view.LayoutInflaterCompatBase$FactoryWrapper */
    class FactoryWrapper implements LayoutInflater.Factory {

        /* renamed from: a */
        final LayoutInflaterFactory f1186a;

        FactoryWrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.f1186a = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f1186a.onCreateView((View) null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f1186a + "}";
        }
    }

    LayoutInflaterCompatBase() {
    }

    /* renamed from: a */
    static void m859a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory(layoutInflaterFactory != null ? new FactoryWrapper(layoutInflaterFactory) : null);
    }
}
