package android.support.p021v7.widget;

import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.view.View;

/* renamed from: android.support.v7.widget.b */
public class C0602b implements C0332fb {

    /* renamed from: a */
    int f1423a;

    /* renamed from: b */
    final /* synthetic */ C0575a f1424b;

    /* renamed from: c */
    private boolean f1425c = false;

    protected C0602b(C0575a aVar) {
        this.f1424b = aVar;
    }

    /* renamed from: a */
    public C0602b mo3010a(C0314ek ekVar, int i) {
        this.f1424b.f1353f = ekVar;
        this.f1423a = i;
        return this;
    }

    public void onAnimationCancel(View view) {
        this.f1425c = true;
    }

    public void onAnimationEnd(View view) {
        if (!this.f1425c) {
            this.f1424b.f1353f = null;
            C0602b.super.setVisibility(this.f1423a);
        }
    }

    public void onAnimationStart(View view) {
        C0602b.super.setVisibility(0);
        this.f1425c = false;
    }
}
