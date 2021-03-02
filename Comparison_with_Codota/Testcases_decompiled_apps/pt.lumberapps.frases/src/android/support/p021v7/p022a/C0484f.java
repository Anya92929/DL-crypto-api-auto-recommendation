package android.support.p021v7.p022a;

import android.view.View;

/* renamed from: android.support.v7.a.f */
class C0484f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0483e f763a;

    C0484f(C0483e eVar) {
        this.f763a = eVar;
    }

    public void onClick(View view) {
        if (this.f763a.f757e) {
            this.f763a.m2090c();
        } else if (this.f763a.f761i != null) {
            this.f763a.f761i.onClick(view);
        }
    }
}
