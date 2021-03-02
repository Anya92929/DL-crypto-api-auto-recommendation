package android.support.p021v7.widget;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: android.support.v7.widget.bl */
class C0614bl implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C0610bh f1467a;

    /* renamed from: b */
    final /* synthetic */ C0613bk f1468b;

    C0614bl(C0613bk bkVar, C0610bh bhVar) {
        this.f1468b = bkVar;
        this.f1467a = bhVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1468b.f1463a.setSelection(i);
        if (this.f1468b.f1463a.getOnItemClickListener() != null) {
            this.f1468b.f1463a.performItemClick(view, i, this.f1468b.f1465e.getItemId(i));
        }
        this.f1468b.mo2363c();
    }
}
