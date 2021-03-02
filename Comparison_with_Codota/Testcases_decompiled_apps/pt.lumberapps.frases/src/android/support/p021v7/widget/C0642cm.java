package android.support.p021v7.widget;

import android.widget.AbsListView;

/* renamed from: android.support.v7.widget.cm */
class C0642cm implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1561a;

    private C0642cm(C0636cg cgVar) {
        this.f1561a = cgVar;
    }

    /* synthetic */ C0642cm(C0636cg cgVar, C0637ch chVar) {
        this(cgVar);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f1561a.mo3190n() && this.f1561a.f1534c.getContentView() != null) {
            this.f1561a.f1529E.removeCallbacks(this.f1561a.f1555z);
            this.f1561a.f1555z.run();
        }
    }
}
