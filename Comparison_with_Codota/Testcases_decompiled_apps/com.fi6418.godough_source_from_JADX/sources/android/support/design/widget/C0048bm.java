package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.design.widget.bm */
class C0048bm<V extends View> extends C0059g<V> {

    /* renamed from: a */
    private C0049bn f185a;

    /* renamed from: b */
    private int f186b = 0;

    /* renamed from: c */
    private int f187c = 0;

    public C0048bm() {
    }

    public C0048bm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo48a(int i) {
        if (this.f185a != null) {
            return this.f185a.mo257a(i);
        }
        this.f186b = i;
        return false;
    }

    /* renamed from: a */
    public boolean mo53a(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.mo69a((View) v, i);
        if (this.f185a == null) {
            this.f185a = new C0049bn(v);
        }
        this.f185a.mo256a();
        if (this.f186b != 0) {
            this.f185a.mo257a(this.f186b);
            this.f186b = 0;
        }
        if (this.f187c == 0) {
            return true;
        }
        this.f185a.mo259b(this.f187c);
        this.f187c = 0;
        return true;
    }

    /* renamed from: b */
    public int mo57b() {
        if (this.f185a != null) {
            return this.f185a.mo258b();
        }
        return 0;
    }
}
