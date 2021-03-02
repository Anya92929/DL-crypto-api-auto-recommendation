package com.p004a.p005a.p006a;

import android.database.DataSetObserver;

/* renamed from: com.a.a.a.b */
class C0343b extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ C0342a f3351a;

    C0343b(C0342a aVar) {
        this.f3351a = aVar;
    }

    public void onChanged() {
        this.f3351a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f3351a.notifyDataSetInvalidated();
    }
}
