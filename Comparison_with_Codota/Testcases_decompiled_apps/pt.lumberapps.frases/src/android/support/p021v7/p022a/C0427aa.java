package android.support.p021v7.p022a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* renamed from: android.support.v7.a.aa */
class C0427aa implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ListView f577a;

    /* renamed from: b */
    final /* synthetic */ C0495q f578b;

    /* renamed from: c */
    final /* synthetic */ C0501w f579c;

    C0427aa(C0501w wVar, ListView listView, C0495q qVar) {
        this.f579c = wVar;
        this.f577a = listView;
        this.f578b = qVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f579c.f831C != null) {
            this.f579c.f831C[i] = this.f577a.isItemChecked(i);
        }
        this.f579c.f835G.onClick(this.f578b.f791b, i, this.f577a.isItemChecked(i));
    }
}
