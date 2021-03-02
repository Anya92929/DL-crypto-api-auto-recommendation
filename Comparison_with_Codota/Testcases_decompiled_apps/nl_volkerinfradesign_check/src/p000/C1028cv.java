package p000;

import android.content.Context;
import android.support.p001v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: cv */
public class C1028cv {

    /* renamed from: cv$a */
    static class C1029a implements LayoutInflater.Factory {

        /* renamed from: a */
        final LayoutInflaterFactory f4051a;

        C1029a(LayoutInflaterFactory layoutInflaterFactory) {
            this.f4051a = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f4051a.onCreateView((View) null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f4051a + "}";
        }
    }

    /* renamed from: a */
    public static void m4605a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory(layoutInflaterFactory != null ? new C1029a(layoutInflaterFactory) : null);
    }
}
