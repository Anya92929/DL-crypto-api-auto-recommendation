package com.jackhenry.godough.core.p034b.p035a;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: com.jackhenry.godough.core.b.a.d */
class C1513d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C1512c f6003a;

    C1513d(C1512c cVar) {
        this.f6003a = cVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f6003a.f6002ap != null) {
            this.f6003a.f6002ap.onClick(this.f6003a.getDialog(), i);
            this.f6003a.getDialog().dismiss();
        }
    }
}
