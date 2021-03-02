package android.support.p009v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: android.support.v4.view.ai */
class C0204ai implements LayoutInflater.Factory {

    /* renamed from: a */
    final C0208am f339a;

    C0204ai(C0208am amVar) {
        this.f339a = amVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f339a.onCreateView((View) null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f339a + "}";
    }
}
