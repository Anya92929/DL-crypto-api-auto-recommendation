package android.support.p021v7.widget;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: android.support.v7.widget.cj */
class C0639cj implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1558a;

    C0639cj(C0636cg cgVar) {
        this.f1558a = cgVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        C0625bw a;
        if (i != -1 && (a = this.f1558a.f1537h) != null) {
            a.setListSelectionHidden(false);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
