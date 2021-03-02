package com.appbrain.p032a;

import android.database.DataSetObserver;

/* renamed from: com.appbrain.a.b */
final class C0811b extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ C0784a f2144a;

    C0811b(C0784a aVar) {
        this.f2144a = aVar;
    }

    public final void onChanged() {
        this.f2144a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.f2144a.notifyDataSetInvalidated();
    }
}
