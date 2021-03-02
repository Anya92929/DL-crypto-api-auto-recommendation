package android.support.p021v7.p022a;

import android.view.View;
import android.widget.AbsListView;

/* renamed from: android.support.v7.a.u */
class C0499u implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ View f823a;

    /* renamed from: b */
    final /* synthetic */ View f824b;

    /* renamed from: c */
    final /* synthetic */ C0495q f825c;

    C0499u(C0495q qVar, View view, View view2) {
        this.f825c = qVar;
        this.f823a = view;
        this.f824b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        C0495q.m2138b(absListView, this.f823a, this.f824b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
