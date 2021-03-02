package android.support.p021v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.cz */
class C0655cz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0652cw f1602a;

    private C0655cz(C0652cw cwVar) {
        this.f1602a = cwVar;
    }

    /* synthetic */ C0655cz(C0652cw cwVar, C0653cx cxVar) {
        this(cwVar);
    }

    public void onClick(View view) {
        ((C0657da) view).mo3294b().mo2107d();
        int childCount = this.f1602a.f1594e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f1602a.f1594e.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
