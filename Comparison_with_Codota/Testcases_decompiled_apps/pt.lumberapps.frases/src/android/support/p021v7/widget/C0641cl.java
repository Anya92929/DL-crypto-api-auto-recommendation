package android.support.p021v7.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v7.widget.cl */
class C0641cl extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1560a;

    private C0641cl(C0636cg cgVar) {
        this.f1560a = cgVar;
    }

    /* synthetic */ C0641cl(C0636cg cgVar, C0637ch chVar) {
        this(cgVar);
    }

    public void onChanged() {
        if (this.f1560a.mo2364d()) {
            this.f1560a.mo2362a();
        }
    }

    public void onInvalidated() {
        this.f1560a.mo2363c();
    }
}
