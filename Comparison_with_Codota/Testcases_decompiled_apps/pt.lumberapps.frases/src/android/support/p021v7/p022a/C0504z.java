package android.support.p021v7.p022a;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: android.support.v7.a.z */
class C0504z implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C0495q f875a;

    /* renamed from: b */
    final /* synthetic */ C0501w f876b;

    C0504z(C0501w wVar, C0495q qVar) {
        this.f876b = wVar;
        this.f875a = qVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f876b.f862u.onClick(this.f875a.f791b, i);
        if (!this.f876b.f833E) {
            this.f875a.f791b.dismiss();
        }
    }
}
